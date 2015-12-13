package scan;

import java.util.Hashtable;

/** Provides a lookup table for all keywords and symbols in the mini-Pascal 
 * language.
 * @author Juan Carlos Hernandez Puebla*/
public class LookupTable extends Hashtable<String,TokenType> {
	
	/** Creates a table that contains all the keywords and symbols that are 
	 *part of the mini-Pascal language.*/
	public LookupTable() {
		
		// Keywords 
		this.put("program", TokenType.PROGRAM);
		this.put("if", TokenType.IF);
		this.put("var", TokenType.VAR);
		this.put("array", TokenType.ARRAY);
		this.put("of", TokenType.OF);
		this.put("integer", TokenType.INTEGER);
		this.put("real", TokenType.REAL);
		this.put("function", TokenType.FUNCTION);
		this.put("procedure", TokenType.PROCEDURE);
		this.put("begin", TokenType.BEGIN);
		this.put("end", TokenType.END);
		this.put("then", TokenType.THEN);
		this.put("else", TokenType.ELSE);
		this.put("while", TokenType.WHILE);
		this.put("do", TokenType.DO);
		this.put("or", TokenType.OR);
		this.put("div", TokenType.DIV);
		this.put("mod", TokenType.MOD);
		this.put("and", TokenType.AND);
		this.put("not", TokenType.NOT);
		
		// Symbols
		this.put("{", TokenType.OPEN_BRACE);
		this.put("}", TokenType.CLOSE_BRACE);
		this.put("+", TokenType.PLUS);
		this.put("-", TokenType.MINUS);
		this.put("*", TokenType.MULTIPLICATION);
		this.put("/", TokenType.SLASH);
		this.put(":=", TokenType.COLON_EQUALS);
		this.put(";", TokenType.SEMICOLON);
		this.put(",", TokenType.COMMA);
		this.put(".", TokenType.DOT);
		this.put(":", TokenType.COLON);
		this.put("[", TokenType.OPEN_BRACKET);
		this.put("]", TokenType.CLOSE_BRACKET);
		this.put("(", TokenType.OPEN_PARENTHESE);
		this.put(")", TokenType.CLOSE_PARENTHESE);
		this.put("=", TokenType.EQUALS);
		this.put("<>", TokenType.LESS_THAN_GREATER_THAN);
		this.put("<",TokenType.LESS_THAN);
		this.put("<=", TokenType.LESS_THAN_EQUALS);
		this.put(">=", TokenType.GREATER_THAN_EQUALS);
		this.put(">", TokenType.GREATER_THAN);
		
	}

}
