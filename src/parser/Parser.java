package parser;

import scan.Scanner;
import scan.TokenType;
import java.io.File;

public class Parser {
	
	/** The scanner that provides tokens from the input file. */
	private Scanner expressionScanner;
	
	/** The current token for one token look ahead.  */
	private TokenType currentToken;
	
	public Parser(String inputFile) {
		expressionScanner = new Scanner(new File (inputFile));
		
		// Retrieves the first token as the lookahead token:
		expressionScanner.nextToken();
		currentToken = expressionScanner.getToken();
	}

	public void match(TokenType expectedToken) {
		System.out.println("match " + expectedToken + " with current " + currentToken + ":" +
	expressionScanner.getLexeme());
		if(currentToken == expectedToken) {
			boolean scanResult = expressionScanner.nextToken();
			if(scanResult) {
				currentToken = expressionScanner.getToken();
			}
			else {
				System.out.println("No token available");
				String lexeme = expressionScanner.getLexeme();
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
	
	public void error() {
		System.out.println("Error");
		System.exit(1);
	}
	
	public void program() {	// Finished
		System.out.println("program");
		match(TokenType.PROGRAM);
		match(TokenType.ID);
		match(TokenType.SEMICOLON);
		declarations();
		subprogram_declarations();
		compound_statement();
		match(TokenType.DOT);
	}
	
	public void declarations() {	// Finished
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
	
	public void identifier_list() {	// Finished
		System.out.println("identifier_list");
		match(TokenType.ID);
		if(currentToken == TokenType.COMMA) {
			match(TokenType.COMMA);
			identifier_list();
		}
	}
	
	public void type() {	// Finished
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
	
	public void standard_type() {	// Finished
		System.out.println("standard_type");
		if(currentToken == TokenType.INTEGER) {
			match(TokenType.INTEGER);
		}
		else if (currentToken == TokenType.REAL) {
			match(TokenType.REAL);
		}
		else {
			//System.out.println("Error in standard_type. Read: " + currentToken);
			error();
		}
	}
	
	public void subprogram_declarations() {	// Finished
		System.out.println("subprogram_declarations");
		if(currentToken == TokenType.FUNCTION || currentToken == TokenType.PROCEDURE) {
			subprogram_declaration();
			match(TokenType.SEMICOLON);
			subprogram_declarations();
		}
	}
	
	public void subprogram_declaration() {	// Finished
		System.out.println("subprogram_declaration");
		subprogram_head();
		declarations();
		subprogram_declarations();
		compound_statement();
	}
	
	public void subprogram_head() {	// Finished
		System.out.println("subprogram_head");
		if(currentToken == TokenType.FUNCTION) {
			match(TokenType.FUNCTION);
			match(TokenType.ID);
			arguments();
			match(TokenType.COLON);
			standard_type();
			match(TokenType.SEMICOLON);
		}
		else if(currentToken == TokenType.PROCEDURE) {
			match(TokenType.PROCEDURE);
			match(TokenType.ID);
			arguments();
			match(TokenType.SEMICOLON);
		}
	}
	
	public void arguments() {	// Finished
		System.out.println("arguments");
		if(currentToken == TokenType.OPEN_PARENTHESE) {
			match(TokenType.OPEN_PARENTHESE);
			parameter_list();
			match(TokenType.CLOSE_PARENTHESE);
		}
	}
	
	public void parameter_list() {	// Finished
		System.out.println("parameter_list");
		identifier_list();
		match(TokenType.COLON);
		type();
		if(currentToken == TokenType.SEMICOLON) {
			match(TokenType.SEMICOLON);
			parameter_list();
		}
	}
	
	public void compound_statement() {	// Finished
		System.out.println("compound_statement");
		match(TokenType.BEGIN);
		optional_statements();
		match(TokenType.END);
	}
	
	public void optional_statements() {	// Finished
		System.out.println("optional_statements");
		if(currentToken == TokenType.ID || currentToken == TokenType.BEGIN ||
		   currentToken == TokenType.IF || currentToken == TokenType.WHILE) {
			statement_list();
		}
	}
	
	public void statement_list() {	// Finished
		System.out.println("statement_list");
		statement();
		if(currentToken == TokenType.SEMICOLON) {
			match(TokenType.SEMICOLON);
			statement_list();
		}
	}
	
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
	
	public void variable() {	// Finished 
		System.out.println("variable");
		match(TokenType.ID);
		if(currentToken == TokenType.OPEN_BRACKET) {
			match(TokenType.OPEN_BRACKET);
			expression();
			match(TokenType.CLOSE_BRACKET);
		}
	}
	
	public void procedure_statement() {	// Finished
		System.out.println("procedure_statement");
		match(TokenType.ID);
		if(currentToken == TokenType.OPEN_PARENTHESE) {
			match(TokenType.OPEN_PARENTHESE);
			expression_list();
			match(TokenType.CLOSE_PARENTHESE);
		}
	}
	
	public void expression_list() {	// Finished
		System.out.println("expression_list");
		expression();
		if(currentToken == TokenType.COMMA) {
			match(TokenType.COMMA);
			expression_list();
		}
	}
	
	public void expression() {	// Finished
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
	
	public void simple_expression() {	// Finished
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
	
	public void simple_part() {	// Finished
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
	
	public void term() {	// Finished
		System.out.println("term");
		factor();
		term_part();
	}
	
	public void term_part() {	// Finished
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
	
	public void factor() {	// Finished
		System.out.println("factor");
		if(currentToken == TokenType.ID) {
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
	
	public void sign() {	// Finished
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
