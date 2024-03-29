package parser;

import scan.Scanner;
import scan.TokenType;
import symboltable.SymbolTable;
import syntaxtree.*;
import java.io.File;
import java.util.ArrayList;


/** The start of a parser for the mini-Pascal language. Currently recognizes
 * whether a Pascal program is valid or invalid.
 * @author Juan Carlos Hernandez Puebla */
public class Parser { 
	
	// The scanner that provides tokens from the input file. 
	private Scanner pascalScanner;
	
	// The current token for one token look ahead.
	private TokenType currentToken;
	
	// The type of expression
	private TokenType expressionType;
	
	// The information table for identifiers
	private SymbolTable inform = new SymbolTable(); 
	
	/** Creates a Pascal parser to parse the named file.
	 * @param inputFile the name of the file to be parsed*/
	public Parser(String inputFile) {
		pascalScanner = new Scanner(new File (inputFile));
		
		// Retrieves the first token as the lookahead token:
		pascalScanner.nextToken();
		currentToken = pascalScanner.getToken();
	}
	
	/** Default constructor for a Parser. */
	public Parser() {
		
	}
	
	/** Retrieves the SymbolTable of this Parser
	 * @return inform the symbol table of this parser
	 */
	public SymbolTable getInform() {
		return this.inform;
	}
	
	/** Matches a given token against the current token. If they match it loads
	 *  the next token from the input file into the current token. Else it calls
	 *  the error function.
	 * @param expectedToken the token to match. */
	public void match(TokenType expectedToken) {
		/*System.out.println("match " + expectedToken + " with current " + currentToken + ":" +
	pascalScanner.getLexeme());*/
		if(currentToken == expectedToken) {
			boolean scanResult = pascalScanner.nextToken();
			if(scanResult) {
				currentToken = pascalScanner.getToken();
			}
			else {
				System.out.println("No token available");
				String lexeme = pascalScanner.getLexeme();
				if(lexeme == null) {
					System.out.println("End of file");
				}
				else {
					System.out.println("Scanner barfed on " + lexeme);
				}
			}
		}
		else {
			error();
		}
		
	}
	
	/** Handles an error by throwing an Error that prints the line where it
	 *  occurred.*/
	public void error() {
		throw new Error("Error on line: " + pascalScanner.getLine());
	}
	
	/** Implements program -> program id ;
	 * 						  declarations
	 * 						  subprogram_declarations
	 * 						  compound_statement
	 * 						  .
	 */
	public ProgramNode program() {
		//System.out.println("program");
		ProgramNode program = new ProgramNode();
		match(TokenType.PROGRAM);
		inform.addProgramName(pascalScanner.getLexeme());
		match(TokenType.ID);
		match(TokenType.SEMICOLON);
		program.setName("sample.pas");
		program.setVariables(declarations());
		program.setFunctions(subprogram_declarations());
		program.setMain(compound_statement());
		match(TokenType.DOT);
		return program;
	}
	
	/** Implements declarations -> var identifier_list: type ; declarations | 
	 * 							   lambda
	 */
	public DeclarationsNode declarations() {	
		//System.out.println("declarations");
		DeclarationsNode declarations = new DeclarationsNode();
		ArrayList <String> variableList = new ArrayList<String>();
		ArrayList <VariableNode> additionalVariables = new ArrayList<VariableNode>();
		
		if(currentToken == TokenType.VAR) {
			match(TokenType.VAR);
			variableList = identifier_list();
			for(String varName:variableList) {
				declarations.addVariable(new VariableNode(varName));
			}
			match(TokenType.COLON);
			expressionType = type();
			this.inform.addExpressionType(expressionType);
			for(VariableNode element:declarations.getVariables()) {
				element.setExpressionType(expressionType);
			}
			match(TokenType.SEMICOLON);
			DeclarationsNode moreDeclarations = declarations();
			additionalVariables = moreDeclarations.getVariables();
			for(VariableNode varName:additionalVariables) {
				declarations.addVariable(varName);
			}
		}
		return declarations;
	}
	
	/** Implements identifier_list ->  id | 
	 * 								   id , identifier_list
	 */
	public ArrayList<String> identifier_list() {	
		//System.out.println("identifier_list");
		ArrayList<String> variables = new ArrayList<String>();
		inform.addVariableName(pascalScanner.getLexeme());
		variables.add(pascalScanner.getLexeme());
		match(TokenType.ID);
		while(currentToken == TokenType.COMMA) {
			match(TokenType.COMMA);
			inform.addVariableName(pascalScanner.getLexeme());
			variables.add(pascalScanner.getLexeme());
			match(TokenType.ID);
		}
		return variables;
	}
	
	/** Implements type -> standard_type | 
	 * 					   array [ num : num ] of standard_type
	 */
	public TokenType type() {
		//System.out.println("type");
		if(currentToken == TokenType.ARRAY) {
			match(TokenType.ARRAY);
			match(TokenType.OPEN_BRACKET);
			match(TokenType.NUM);
			match(TokenType.COLON);
			match(TokenType.NUM);
			match(TokenType.CLOSE_BRACKET);
			match(TokenType.OF);
			return standard_type();
		}
		else {
			return standard_type();
		}
	}
	
	/** Implements standard_type -> integer | 
	 * 								real
	 */
	public TokenType standard_type() {	
		//System.out.println("standard_type");
		if(currentToken == TokenType.INTEGER) {
			match(TokenType.INTEGER);
			return TokenType.INTEGER;
		}
		else if (currentToken == TokenType.REAL) {
			match(TokenType.REAL);
			return TokenType.REAL;
		}
		else {
			System.out.println("Error in standard_type. Read: " + currentToken);
			error();
		}
		return null;
	}
	
	/** Implements subprogram_declarations -> subprogram_declarration ; 
	 * 										  subprograms_declarations |
	 * 										  lambda
	 */
	public SubProgramDeclarationsNode subprogram_declarations() {
		//System.out.println("subprogram_declarations");
		SubProgramDeclarationsNode subprogram = new SubProgramDeclarationsNode();
		if(currentToken == TokenType.FUNCTION || currentToken == TokenType.PROCEDURE) {
			subprogram_declaration();
			match(TokenType.SEMICOLON);
			subprogram_declarations();
		}
		return subprogram;
	}
	
	/** Implements subprogram_declaration -> subprogram_head
	 * 										 declarations
	 * 										 subprogram_declarations
	 * 										 compound_statement
	 */
	public void subprogram_declaration() {	
		//System.out.println("subprogram_declaration");
		subprogram_head();
		declarations();
		subprogram_declarations();
		compound_statement();
	}
	
	/** Implements subprogram_head -> function id arguments : standard_type ; | 
	 * 								  procedure id arguments ;
	 */
	public void subprogram_head() {	
		//System.out.println("subprogram_head");
		if(currentToken == TokenType.FUNCTION) {
			match(TokenType.FUNCTION);
			inform.addFunctionName(pascalScanner.getLexeme());
			match(TokenType.ID);
			arguments();
			match(TokenType.COLON);
			standard_type();
			match(TokenType.SEMICOLON);
		}
		else if(currentToken == TokenType.PROCEDURE) {
			match(TokenType.PROCEDURE);
			inform.addProcedureName(pascalScanner.getLexeme());
			match(TokenType.ID);
			arguments();
			match(TokenType.SEMICOLON);
		}
	}
	
	/** Implements arguments -> (parameter_list) | 
	 * 							lambda
	 */
	public void arguments() {	
		//System.out.println("arguments");
		if(currentToken == TokenType.OPEN_PARENTHESE) {
			match(TokenType.OPEN_PARENTHESE);
			parameter_list();
			match(TokenType.CLOSE_PARENTHESE);
		}
	}
	
	/** Implements identifier_list : type | 
	 * 			   identifier_list : type ; parameter_list 
	 */
	public void parameter_list() {	
		//System.out.println("parameter_list");
		identifier_list();
		match(TokenType.COLON);
		type();
		if(currentToken == TokenType.SEMICOLON) {
			match(TokenType.SEMICOLON);
			parameter_list();
		}
	}
	
	/** Implements compound_statement -> begin optional_statements end
	 */
	public CompoundStatementNode compound_statement() {
		//System.out.println("compound_statement");
		CompoundStatementNode compound = new CompoundStatementNode();
		match(TokenType.BEGIN);
		ArrayList<StatementNode> statements = optional_statements();
		for(StatementNode statement: statements) {
			compound.addStatement(statement);
		}
		match(TokenType.END);
		return compound;
	}
	
	/** Implements optional_statements -> statement_list | 
	 * 									  lambda
	 */
	public ArrayList<StatementNode> optional_statements() {	
		//System.out.println("optional_statements");
		ArrayList<StatementNode> statements = new ArrayList<StatementNode>();
		if(currentToken == TokenType.ID || currentToken == TokenType.BEGIN ||
		   currentToken == TokenType.IF || currentToken == TokenType.WHILE) {
			statements = statement_list();
		}
		return statements;
	}
	
	/** Implements statement_list -> statement | 
	 * 			   					 statement ; statement_list
	 */
	public ArrayList<StatementNode> statement_list() {	
		//System.out.println("statement_list");
		ArrayList<StatementNode> statements = new ArrayList<StatementNode>();
		statements.add(statement());
		while(currentToken == TokenType.SEMICOLON) {
			match(TokenType.SEMICOLON);
			statements.add(statement());
		}
		return statements;
	}
	
	/** Implements statement -> variable assignop expression |
	 * 							procedure_statement | 
	 * 							compound_statement |
	 * 							if expression then statement else statement | 
	 * 							while expression do statement |
	 */
	public StatementNode statement() {
		//System.out.println("statement");
		StatementNode statement = null;
		if(currentToken == TokenType.ID) {
			if(inform.isVariableName(pascalScanner.getLexeme())) {
				VariableNode variable = variable();
				variable.setExpressionType(expressionType);
				match(TokenType.COLON_EQUALS);
				ExpressionNode expression = expression();
				statement = new AssignmentStatementNode(variable, expression);
			}
			else if(inform.isProcedureName(pascalScanner.getLexeme())) {
				statement = procedure_statement();
			}
			else {
				System.out.println("Error in statement. Read: " + currentToken);
				error();
			}
		}
		else if(currentToken == TokenType.BEGIN) {
			statement = compound_statement();
		}
		else if(currentToken == TokenType.IF) {
			IfNode ifNode = new IfNode();
			match(TokenType.IF);
			ifNode.setTest(expression());
			match(TokenType.THEN);
			ifNode.setThenStatement(statement());
			match(TokenType.ELSE);
			ifNode.setElseStatement(statement());
			statement = ifNode;
			return statement;
			
		}
		else if(currentToken == TokenType.WHILE) {
			match(TokenType.WHILE);
			WhileNode whileNode = new WhileNode();
			whileNode.setTest(expression());
			match(TokenType.DO);
			whileNode.setDoStatement(statement());
			statement = whileNode;
		}
		return statement;
	}
	
	/** Implements variable -> id |
	 * 						   id[ expression ]
	 */
	public VariableNode variable() {	
		//System.out.println("variable");
		VariableNode variable = new VariableNode(pascalScanner.getLexeme());
		match(TokenType.ID);
		if(currentToken == TokenType.OPEN_BRACKET) {
			match(TokenType.OPEN_BRACKET);
			ExpressionNode expression = expression();
			match(TokenType.CLOSE_BRACKET);
		}
		return variable;
	}
	
	/** Implements procedure_statement -> id | 
	 * 									  id ( expression_list )
	 */
	public StatementNode procedure_statement() {	
		//System.out.println("procedure_statement");
		StatementNode statement = null;
		match(TokenType.ID);
		if(currentToken == TokenType.OPEN_PARENTHESE) {
			match(TokenType.OPEN_PARENTHESE);
			expression_list();
			match(TokenType.CLOSE_PARENTHESE);
		}
		return statement;
	}
	
	/** Implements expression_list -> expression | 
	 * 								  expression , expression_list
	 */
	public ArrayList<ExpressionNode> expression_list() {	
		//System.out.println("expression_list");
		ArrayList<ExpressionNode> expressions = new ArrayList<ExpressionNode>();
		expressions.add(expression());
		while(currentToken == TokenType.COMMA) {
			match(TokenType.COMMA);
			expressions.add(expression());
		}
		return expressions;
	}
	
	/** Implements expression -> simple_expression |
	 * 							 simple_expression relop simple_expression
	 */
	public ExpressionNode expression() {
		//System.out.println("expression");
		ExpressionNode expression = simple_expression();
		if(currentToken == TokenType.EQUALS) {
			OperationNode operation = new OperationNode(currentToken);
			operation.setLeft(expression);
			match(TokenType.EQUALS);
			operation.setRight(simple_expression());
			return operation;
		}
		else if(currentToken == TokenType.LESS_THAN_GREATER_THAN) {
			OperationNode operation = new OperationNode(currentToken);
			operation.setLeft(expression);
			match(TokenType.LESS_THAN_GREATER_THAN);
			operation.setRight(simple_expression());
			return operation;
		}
		else if(currentToken == TokenType.LESS_THAN) {
			OperationNode operation = new OperationNode(currentToken);
			operation.setLeft(expression);
			match(TokenType.LESS_THAN);
			operation.setRight(simple_expression());
			return operation;
		}
		else if(currentToken == TokenType.LESS_THAN_EQUALS) {
			OperationNode operation = new OperationNode(currentToken);
			operation.setLeft(expression);
			match(TokenType.LESS_THAN_EQUALS);
			operation.setRight(simple_expression());
			return operation;
		}
		else if(currentToken == TokenType.GREATER_THAN_EQUALS) {
			OperationNode operation = new OperationNode(currentToken);
			operation.setLeft(expression);
			match(TokenType.GREATER_THAN_EQUALS);
			operation.setRight(simple_expression());
			return operation;
		}
		else if(currentToken == TokenType.GREATER_THAN) {
			OperationNode operation = new OperationNode(currentToken);
			operation.setLeft(expression);
			match(TokenType.GREATER_THAN);
			operation.setRight(simple_expression());
			return operation;
		}
		return expression;
	}
	
	/** Implements simple_expression -> term simple_part | 
	 * 									sign term simple_part
	 */
	public ExpressionNode simple_expression() {	
		//System.out.println("simple_expression");
		ExpressionNode expression = null;
		if(currentToken == TokenType.ID || currentToken == TokenType.NUM ||
		   currentToken == TokenType.OPEN_PARENTHESE || 
		   currentToken == TokenType.NOT) {
			expression = term();
			OperationNode operation = simple_part();
			if(operation == null) {
				return expression;
			}
			operation.attachBottomLeft(expression);
			expression = operation;
		}
		/*else if(currentToken == TokenType.PLUS || currentToken == TokenType.MINUS) {
			sign();
			expression = term();
			OperationNode operation = simple_part();
			if(operation == null ) {
				return expression;
			}
			
		}*/
		return expression;
	}
	
	/** Parses an addup.
	 * Implements addop -> + | - | or
	 * @return An OperationNode built from the add or subtract operation.
	 */
	public OperationNode addop() {
		//System.out.println("addop");
		OperationNode operation = null;
		if(currentToken == TokenType.PLUS || currentToken == TokenType.MINUS
				|| currentToken == TokenType.OR) {
			operation = new OperationNode(currentToken);
			match(currentToken);
		}
		return operation;
	}
	
	/** Implements simple_part -> addop term simple_part |
	 * 							  lambda
	 */
	public OperationNode simple_part() {	
		//System.out.println("simple_part");
		OperationNode operation = addop();
		if(operation == null) {
			return null;
		}
		ExpressionNode expression = term();
		operation.setRight(expression);
		OperationNode temp = simple_part();
		if(temp == null) {
			return operation;
		}
		temp.attachBottomLeft(operation);
		operation = temp;
		return operation;
	}
	
	/** Implements term -> factor term_part
	 */
	public ExpressionNode term() {	
		//System.out.println("term");
		ExpressionNode expression = factor();
		OperationNode operation = term_part();
		if(operation == null) {
			return expression;
		}
		operation.attachBottomLeft(expression);
		expression = operation;
		return expression;
	}
	
	/** Parses an mulop.
	 * IMplements mulop -> * | / | slash | mod | and
	 * @return An OperationNode built from the multiply or divide operation.
	 */
	public OperationNode mulop() {
		//System.out.println("mulop");
		OperationNode operation = null;
		if(currentToken == TokenType.MULTIPLICATION
				|| currentToken == TokenType.SLASH 
				|| currentToken == TokenType.DIVISION
				|| currentToken == TokenType.MOD
				|| currentToken == TokenType.AND) {
			operation = new OperationNode(currentToken);
			match(currentToken);			
		}
		return operation;
	}
	
	/** Implements term_part -> mulop factor term_part | 
	 * 							lambda
	 */
	public OperationNode term_part() {
		//System.out.println("term_part");
		OperationNode operation = mulop();
		if(operation == null) {
			return null;
		}
		ExpressionNode right = factor();
		operation.setRight(right);
		OperationNode temp = term_part();
		if(temp == null) {
			return operation;			
		}
		temp.attachBottomLeft(operation);
		operation = temp;
		return operation;
	}
	
	/** Implements factor -> id | 
	 * 						 id [ expression ] | 
	 * 						 id ( expression_list ) |
	 * 						 num | 
	 * 						 ( expression ) | 
	 * 						 not factor
	 */
	public ExpressionNode factor() {	
		//System.out.println("factor");
		ExpressionNode expression = null;
		if(inform.isVariableName(pascalScanner.getLexeme())) {
			expression = new VariableNode(pascalScanner.getLexeme());
			expression.setExpressionType(expressionType);
			match(TokenType.ID);
			if(currentToken == TokenType.OPEN_BRACKET) {
				match(TokenType.OPEN_BRACKET);
				expression = expression();
				match(TokenType.CLOSE_BRACKET);
			}
			else if(currentToken == TokenType.OPEN_PARENTHESE) {
				match(TokenType.OPEN_PARENTHESE);
				expression_list();
				match(TokenType.CLOSE_PARENTHESE);
			}
		}
		else if(currentToken == TokenType.NUM) {
			expression = new ValueNode(pascalScanner.getLexeme());
			match(TokenType.NUM);
		}
		else if(currentToken == TokenType.OPEN_PARENTHESE) {
			match(TokenType.OPEN_PARENTHESE);
			expression = expression();
			match(TokenType.CLOSE_PARENTHESE);
		}
		else if(currentToken == TokenType.NOT) {
			match(TokenType.NOT);
			factor();
		}
		else {
			error();
		}
		return expression;
	}
	
	/** Implements sign -> + | -
	 */
	public void sign() {
		//System.out.println("sign");
		if(currentToken == TokenType.PLUS) {
			match(TokenType.PLUS);
		}
		else if(currentToken == TokenType.MINUS) {
			match(TokenType.MINUS);
		}
		else {
			error();
		}
	}
}