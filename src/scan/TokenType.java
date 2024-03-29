package scan;

/** Represents the different types of Token in the mini-Pascal language.
 * @author Juan Carlos Hernandez Puebla*/
public enum TokenType {
	ID,
	NUM,
	// Keywords
	PROGRAM,
	IF,
	VAR,
	ARRAY,
	OF,
	INTEGER,
	REAL,
	FUNCTION,
	PROCEDURE,
	BEGIN,
	END,
	THEN,
	ELSE,
	WHILE,
	DO,
	OR,
	DIVISION,
	MOD,
	AND,
	NOT,
	// Symbols
	OPEN_BRACE,
	CLOSE_BRACE,
	PLUS,
	MINUS,
	MULTIPLICATION,
	SLASH,
	COLON_EQUALS,
	SEMICOLON,
	COMMA,
	DOT,
	COLON,
	OPEN_BRACKET,
	CLOSE_BRACKET,
	OPEN_PARENTHESE,
	CLOSE_PARENTHESE,
	EQUALS,
	LESS_THAN_GREATER_THAN,
	LESS_THAN,
	LESS_THAN_EQUALS,
	GREATER_THAN_EQUALS,
	GREATER_THAN
}