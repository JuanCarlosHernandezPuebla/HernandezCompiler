package parser;

import scan.Scanner;
import scan.TokenType;
import java.io.File;
import symbolTable.SymbolTable;

/** The start of a parser for the mini-Pascal language. Currently recognizes
 * whether a Pascal program is valid or invalid.
 * @author Juan Carlos Hernandez Puebla */
public class Parser { 
	
	// The scanner that provides tokens from the input file. 
	private Scanner pascalScanner;
	
	// The current token for one token look ahead.
	private TokenType currentToken;
	
	private SymbolTable inform = new SymbolTable(); 
	
	/** Creates a Pascal parser to parse the named file.
	 * @param inputFile the name of the file to be parsed*/
	public Parser(String inputFile) {
		pascalScanner = new Scanner(new File (inputFile));
		
		// Retrieves the first token as the lookahead token:
		pascalScanner.nextToken();
		currentToken = pascalScanner.getToken();
	}

	/** Matches a given token against the current token. If they match it loads
	 *  the next token from the input file into the current token. Else it calls
	 *  the error function.
	 * @param expectedToken the token to match. */
	public void match(TokenType expectedToken) {
		System.out.println("match " + expectedToken + " with current " + currentToken + ":" +
	pascalScanner.getLexeme());
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
	public void program() {
		System.out.println("program");
		match(TokenType.PROGRAM);
		inform.addProgramName(pascalScanner.getLexeme());
		match(TokenType.ID);
		match(TokenType.SEMICOLON);
		declarations();
		subprogram_declarations();
		compound_statement();
		match(TokenType.DOT);
	}
	
	/** Implements declarations -> var identifier_list: type ; declarations | 
	 * 							   lambda
	 */
	public void declarations() {	
		System.out.println("declarations");
		if(currentToken == TokenType.VAR) {
			match(TokenType.VAR);
			identifier_list();
			match(TokenType.COLON);
			type();
			match(TokenType.SEMICOLON);
			declarations();
		}
	}
	
	/** Implements identifier_list ->  id | 
	 * 								   id , identifier_list
	 */
	public void identifier_list() {	
		System.out.println("identifier_list");
		inform.addVariableName(pascalScanner.getLexeme());
		match(TokenType.ID);
		if(currentToken == TokenType.COMMA) {
			match(TokenType.COMMA);
			identifier_list();
		}
	}
	
	/** Implements type -> standard_type | 
	 * 					   array [ num : num ] of standard_type
	 */
	public void type() {
		System.out.println("type");
		if(currentToken == TokenType.ARRAY) {
			match(TokenType.ARRAY);
			match(TokenType.OPEN_BRACKET);
			match(TokenType.NUM);
			match(TokenType.COLON);
			match(TokenType.NUM);
			match(TokenType.CLOSE_BRACKET);
			match(TokenType.OF);
			standard_type();
		}
		else {
			standard_type();
		}
	}
	
	/** Implements standard_type -> integer | 
	 * 								real
	 */
	public void standard_type() {	
		System.out.println("standard_type");
		if(currentToken == TokenType.INTEGER) {
			match(TokenType.INTEGER);
		}
		else if (currentToken == TokenType.REAL) {
			match(TokenType.REAL);
		}
		else {
			System.out.println("Error in standard_type. Read: " + currentToken);
			error();
		}
	}
	
	/** Implements subprogram_declarations -> subprogram_declarration ; 
	 * 										  subprograms_declarations |
	 * 										  lambda
	 */
	public void subprogram_declarations() {
		System.out.println("subprogram_declarations");
		if(currentToken == TokenType.FUNCTION || currentToken == TokenType.PROCEDURE) {
			subprogram_declaration();
			match(TokenType.SEMICOLON);
			subprogram_declarations();
		}
	}
	
	/** Implements subprogram_declaration -> subprogram_head
	 * 										 declarations
	 * 										 subprogram_declarations
	 * 										 compound_statement
	 */
	public void subprogram_declaration() {	
		System.out.println("subprogram_declaration");
		subprogram_head();
		declarations();
		subprogram_declarations();
		compound_statement();
	}
	
	/** Implements subprogram_head -> function id arguments : standard_type ; | 
	 * 								  procedure id arguments ;
	 */
	public void subprogram_head() {	
		System.out.println("subprogram_head");
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
		System.out.println("arguments");
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
		System.out.println("parameter_list");
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
	public void compound_statement() {
		System.out.println("compound_statement");
		match(TokenType.BEGIN);
		optional_statements();
		match(TokenType.END);
	}
	
	/** Implements optional_statements -> statement_list | 
	 * 									  lambda
	 */
	public void optional_statements() {	
		System.out.println("optional_statements");
		if(currentToken == TokenType.ID || currentToken == TokenType.BEGIN ||
		   currentToken == TokenType.IF || currentToken == TokenType.WHILE) {
			statement_list();
		}
	}
	
	/** Implements statement_list -> statement | 
	 * 			   					 statement ; statement_list
	 */
	public void statement_list() {	
		System.out.println("statement_list");
		statement();
		if(currentToken == TokenType.SEMICOLON) {
			match(TokenType.SEMICOLON);
			statement_list();
		}
	}
	
	/** Implements statement -> variable assignop expression |
	 * 							procedure_statement | 
	 * 							compound_statement |
	 * 							if expression then statement else statement | 
	 * 							while expression do statement |
	 */
	public void statement() {
		System.out.println("statement");
		if(currentToken == TokenType.ID) {
			variable();
			match(TokenType.COLON_EQUALS);
			expression();
		}
		else if(currentToken == TokenType.BEGIN) {
			compound_statement();
		}
		else if(currentToken == TokenType.IF) {
			match(TokenType.IF);
			expression();
			match(TokenType.THEN);
			statement();
			match(TokenType.ELSE);
			statement();
		}
		else if(currentToken == TokenType.WHILE) {
			match(TokenType.WHILE);
			expression();
			match(TokenType.DO);
			statement();
		}
	}
	
	/** Implements variable -> id |
	 * 						   id[ expression ]
	 */
	public void variable() {	
		System.out.println("variable");
		if(inform.isVariableName(pascalScanner.getLexeme())) {
			match(TokenType.ID);
			if(currentToken == TokenType.OPEN_BRACKET) {
				match(TokenType.OPEN_BRACKET);
				expression();
				match(TokenType.CLOSE_BRACKET);
			}
		}
	}
	
	/** Implements procedure_statement -> id | 
	 * 									  id ( expression_list )
	 */
	public void procedure_statement() {	
		System.out.println("procedure_statement");
		if(inform.isProcedureName(pascalScanner.getLexeme())) {
			match(TokenType.ID);
			if(currentToken == TokenType.OPEN_PARENTHESE) {
				match(TokenType.OPEN_PARENTHESE);
				expression_list();
				match(TokenType.CLOSE_PARENTHESE);
			}
		}
	}
	
	/** Implements expression_list -> expression | 
	 * 								  expression , expression_list
	 */
	public void expression_list() {	
		System.out.println("expression_list");
		expression();
		if(currentToken == TokenType.COMMA) {
			match(TokenType.COMMA);
			expression_list();
		}
	}
	
	/** Implements expression -> simple_expression |
	 * 							 simple_expression relop simple_expression
	 */
	public void expression() {
		System.out.println("expression");
		simple_expression();
		if(currentToken == TokenType.EQUALS) {
			match(TokenType.EQUALS);
			simple_expression();
		}
		else if(currentToken == TokenType.LESS_THAN_GREATER_THAN) {
			match(TokenType.LESS_THAN_GREATER_THAN);
			simple_expression();
		}
		else if(currentToken == TokenType.LESS_THAN) {
			match(TokenType.LESS_THAN);
			simple_expression();
		}
		else if(currentToken == TokenType.LESS_THAN_EQUALS) {
			match(TokenType.LESS_THAN_EQUALS);
			simple_expression();
		}
		else if(currentToken == TokenType.GREATER_THAN_EQUALS) {
			match(TokenType.GREATER_THAN_EQUALS);
			simple_expression();
		}
		else if(currentToken == TokenType.GREATER_THAN) {
			match(TokenType.GREATER_THAN);
			simple_expression();
		}
	}
	
	/** Implements simple_expression -> term simple_part | 
	 * 									sign term simple_part
	 */
	public void simple_expression() {	
		System.out.println("simple_expression");
		if(currentToken == TokenType.ID || currentToken == TokenType.NUM ||
		   currentToken == TokenType.OPEN_PARENTHESE || 
		   currentToken == TokenType.NOT) {
			term();
			simple_part();
		}
		else if(currentToken == TokenType.PLUS || currentToken == TokenType.MINUS) {
			sign();
			term();
			simple_part();
		}
	}
	
	/** Implements simple_part -> addop term simple_part |
	 * 							  lambda
	 */
	public void simple_part() {	
		System.out.println("simple_part");
		if(currentToken == TokenType.PLUS) {
			match(TokenType.PLUS);
			term();
			simple_part();
		}
		else if(currentToken == TokenType.MINUS) {
			match(TokenType.MINUS);
			term();
			simple_part();
		}
		else if(currentToken == TokenType.OR) {
			match(TokenType.OR);
			term();
			simple_part();
		}
	}
	
	/** Implements term -> factor term_part
	 */
	public void term() {	
		System.out.println("term");
		factor();
		term_part();
	}
	
	/** Implements term_part -> mulop factor term_part | 
	 * 							lambda
	 */
	public void term_part() {
		System.out.println("term_part");
		if(currentToken == TokenType.MULTIPLICATION) {
			match(TokenType.MULTIPLICATION);
			factor();
			term_part();
		}
		else if (currentToken == TokenType.SLASH) {
			match(TokenType.SLASH);
			factor();
			term_part();
		}
		else if(currentToken == TokenType.DIV) {
			match(TokenType.DIV);
			factor();
			term_part();
		}
		else if(currentToken == TokenType.MOD) {
			match(TokenType.MOD);
			factor();
			term_part();
		}
		else if(currentToken == TokenType.AND) {
			match(TokenType.AND);
			factor();
			term_part();
		}
	}
	
	/** Implements factor -> id | 
	 * 						 id [ expression ] | 
	 * 						 id ( expression_list ) |
	 * 						 num | 
	 * 						 ( expression ) | 
	 * 						 not factor
	 */
	public void factor() {	
		System.out.println("factor");
		if(inform.isVariableName(pascalScanner.getLexeme())) {
			match(TokenType.ID);
			if(currentToken == TokenType.OPEN_BRACKET) {
				match(TokenType.OPEN_BRACKET);
				expression();
				match(TokenType.CLOSE_BRACKET);
			}
			else if(currentToken == TokenType.OPEN_PARENTHESE) {
				match(TokenType.OPEN_PARENTHESE);
				expression_list();
				match(TokenType.CLOSE_PARENTHESE);
			}
		}
		else if(currentToken == TokenType.NUM) {
			match(TokenType.NUM);
		}
		else if(currentToken == TokenType.OPEN_PARENTHESE) {
			match(TokenType.OPEN_PARENTHESE);
			expression();
			match(TokenType.CLOSE_PARENTHESE);
		}
		else if(currentToken == TokenType.NOT) {
			match(TokenType.NOT);
			factor();
		}
		else {
			error();
		}
	}
	
	/** Implements sign -> + | 			   -
	 */
	public void sign() {
		System.out.println("sign");
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
