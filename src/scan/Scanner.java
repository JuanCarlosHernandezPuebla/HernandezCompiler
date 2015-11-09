package scan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;

/**Recognizes lexemes for the mini-Pascal language by implementation of a state
 * machine. Makes each lexeme available one at a time. It uses a lookup table to
 * assign each lexeme a token type.
 * @author Juan Carlos Hernandez Puebla*/
public class Scanner {

	// Instance variables
	private PushbackReader input;
	private String lexeme;
	private TokenType type;
	private LookupTable lookup = new LookupTable();

	// Constant variables
	private final int START = 0;
	private final int IN_ID_OR_KEYWORD = 1;
	private final int ERROR = 11;
	private final int ID_COMPLETE = 12;
	private final int SYMBOL_COMPLETE = 13;
	private final int SHORT_SYMBOL_COMPLETE = 14;
	private final int NUM_COMPLETE = 15;

	// Constructor
	/**Creates a Scanner that takes in an input file to scan from.
	 * @param inputFile the file scanned by the Scanner.*/
	public Scanner(File inputFile) {
		try {
			this.input = new PushbackReader(new FileReader(inputFile));
		} catch (FileNotFoundException e) {
			System.out.println("File " + inputFile + " does not exist.");
			System.exit(1);
		}

	}

	/**Reads a single character at a time from the input stream. It identifies
	 * each lexeme's token type once it reaches a complete state. If it reaches
	 * the ERROR state then its token type is set to null and its lexeme is set
	 * to its most recently constructed lexeme. Once it reaches the end of the
	 * file it will return false and set both token type and lexeme to null.
	 * @return true if a valid token was recognize else false*/
	public boolean nextToken() {
		int stateNumber = 0;
		String currentLexeme = "";
		int currentCharacter = 0;

		while (stateNumber < ERROR) {
			try {
				currentCharacter = this.input.read();
			} catch (IOException e) {
				//
			}
			switch (stateNumber) {
			case START:
				if (currentCharacter == -1) {
					/* Has reached the end of the file, so it sets both lexeme
					 * and token to null*/
					this.lexeme = null;
					this.type = null;
					return false;
				} else if (Character.isLetter(currentCharacter)) {
					stateNumber = IN_ID_OR_KEYWORD;
					currentLexeme += (char) currentCharacter;
				} else if (Character.isWhitespace(currentCharacter)) {
					// Ignore whitespace 
				} else if (currentCharacter == '+' || currentCharacter == '-' || currentCharacter == '*'
						|| currentCharacter == '/' || currentCharacter == ';' || currentCharacter == ','
						|| currentCharacter == '[' || currentCharacter == ']' || currentCharacter == '('
						|| currentCharacter == ')' || currentCharacter == '=') {
					stateNumber = SYMBOL_COMPLETE;
					currentLexeme += (char) currentCharacter;
				} else if (currentCharacter == ':') {
					stateNumber = 2;
					currentLexeme += (char) currentCharacter;
				} else if (currentCharacter == '<') {
					stateNumber = 3;
					currentLexeme += (char) currentCharacter;
				} else if (currentCharacter == '>') {
					stateNumber = 4;
					currentLexeme += (char) currentCharacter;
				} else if (currentCharacter == '{') {
					stateNumber = 5;
				} else if (Character.isDigit(currentCharacter)) {
					stateNumber = 6;
					currentLexeme += (char) currentCharacter;
				} else {
					stateNumber = ERROR;
					currentLexeme += (char) currentCharacter;
				}
				break;
			case IN_ID_OR_KEYWORD:
				if (currentCharacter == -1) {
					stateNumber = ID_COMPLETE;
				} else if (Character.isLetterOrDigit(currentCharacter)) {
					currentLexeme += (char) currentCharacter;
				} else {
					try {
						this.input.unread(currentCharacter);
					} catch (IOException e) {
						//
					}
					stateNumber = ID_COMPLETE;
				}
				break;
			case 2:
				if (currentCharacter == '=') {
					stateNumber = SYMBOL_COMPLETE;
					currentLexeme += (char) currentCharacter;
				} else {
					try {
						this.input.unread(currentCharacter);
					} catch (IOException e) {
						//
					}
					stateNumber = SHORT_SYMBOL_COMPLETE;
				}
				break;
			case 3:
				if (currentCharacter == '=') {
					stateNumber = SYMBOL_COMPLETE;
					currentLexeme += (char) currentCharacter;
				} else if (currentCharacter == '>') {
					stateNumber = SYMBOL_COMPLETE;
					currentLexeme += (char) currentCharacter;
				} else {
					try {
						this.input.unread(currentCharacter);
					} catch (IOException e) {
						//
					}
					stateNumber = SHORT_SYMBOL_COMPLETE;
				}
				break;
			case 4:
				if (currentCharacter == '=') {
					stateNumber = SYMBOL_COMPLETE;
					currentLexeme += (char) currentCharacter;
				} else {
					try {
						this.input.unread(currentCharacter);
					} catch (IOException e) {
						//
					}
					stateNumber = SHORT_SYMBOL_COMPLETE;
				}
				break;
			case 5:
				if (currentCharacter == '{') {
					stateNumber = ERROR;
					currentLexeme += (char) currentCharacter;
				} else if (currentCharacter == '}') {
					stateNumber = START;
				} else {
					// Stay in state 5(comment state)
				}
				break;
			case 6:
				if (Character.isDigit(currentCharacter)) {
					// Stay in state 6 and append
					currentLexeme += (char) currentCharacter;
				} 
				else if (currentCharacter == '.') {
					stateNumber = 7;
					currentLexeme += (char) currentCharacter;
				}
				else if (currentCharacter == 'E') {
					stateNumber = 9;
					currentLexeme += (char) currentCharacter;
				}
				else if(Character.isLetter(currentCharacter)) {
					stateNumber = ERROR;
					currentLexeme += (char) currentCharacter;
				}
				else {
					try {
						this.input.unread(currentCharacter);
					} catch (IOException e) {
						//
					}
					stateNumber = NUM_COMPLETE;
				}
				break;
			case 7:
				if (Character.isDigit(currentCharacter)) {
					stateNumber = 8;
					currentLexeme += (char) currentCharacter;
				} else {
					stateNumber = ERROR;
					currentLexeme += (char) currentCharacter;
				}
				break;
			case 8:
				if (Character.isDigit(currentCharacter)) {
					// Stay in state 8 and append
					currentLexeme += (char) currentCharacter;
				} else if (currentCharacter == 'E') {
					stateNumber = 9;
					currentLexeme += (char) currentCharacter;
				} else {
					try {
						this.input.unread(currentCharacter);
					} catch (IOException e) {
						//
					}
					stateNumber = NUM_COMPLETE;
				}
				break;
			case 9:
				if (Character.isDigit(currentCharacter)) {
					stateNumber = 10;
					currentLexeme += (char) currentCharacter;
				} else if (currentCharacter == '+') {
					stateNumber = 10;
					currentLexeme += (char) currentCharacter;
				} else if (currentCharacter == '-') {
					stateNumber = 10;
					currentLexeme += (char) currentCharacter;
				} else {
					try {
						this.input.read();
					} catch (IOException e) {
						//
					}
					stateNumber = ERROR;
				}
				break;
			case 10:
				if (Character.isDigit(currentCharacter)) {
					// Stay in state 10 and append
					currentLexeme += (char) currentCharacter;
				} else {
					try {
						this.input.unread(currentCharacter);
					} catch (IOException e) {
						//
					}
					stateNumber = NUM_COMPLETE;
				}
				break;

			} // End of switch
		} // End of while
		this.lexeme = currentLexeme;
		if (stateNumber == ERROR) {
			this.type = null;
			return false;
		} else if (stateNumber == ID_COMPLETE) {
			this.type = lookup.get(this.lexeme);
			if (this.type == null) {
				this.type = TokenType.ID;
			}
			return true;
		} else if (stateNumber == SYMBOL_COMPLETE) {
			this.type = lookup.get(this.lexeme);
			return true;
		} else if (stateNumber == SHORT_SYMBOL_COMPLETE) {
			this.type = lookup.get(this.lexeme);
			return true;
		} else if (stateNumber == NUM_COMPLETE) {
			this.type = lookup.get(lexeme);
			if (this.type == null) {
				this.type = TokenType.NUM;
			}
			return true;
		}
		return false;
	}

	/**Retrieves the most recent lexeme that was read.
	 * @return the lexeme*/
	public String getLexeme() {
		return this.lexeme;
	}

	/**Retrieves the most recent token type.
	 * @return the token type*/
	public TokenType getToken() {
		return this.type;
	}

}
