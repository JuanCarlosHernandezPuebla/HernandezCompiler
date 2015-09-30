import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;

public class Scanner {

	//class constants
	private final int ERROR = 100;
	private final int ID_COMPLETE = 101;	
	
	//instance variables
	
	private TokenType type;
	private String lexeme;
	private PushbackReader input;
	private LookUpTable lookup;
	
	//Constructor
	
	public Scanner(File inputFile) {
		FileReader fr = null;
		try {
			fr = new FileReader(inputFile);
			
		}
		catch(FileNotFoundException fnfe){
			System.out.println("Can not find file: " + inputFile + ".");
			
		}
		this.input = new PushbackReader(fr);
	}
	
	
	//Methods
	
	public boolean nextToken() {
		int statenumber = 0;
		String currentLexeme = "";
		int currentCharacter = 0;
		
		while(statenumber< ERROR) {
			try {
				currentCharacter = input.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			switch(statenumber){
				case 0:
					if(currentCharacter == -1) {
						this.lexeme = "'";
						this.type = null;
						return false;
					}
					else if(Character.isLetter(currentCharacter)) {
						statenumber = 1;
						currentLexeme += (char)currentCharacter;
						
					}
					else if(Character.isWhitespace(currentCharacter)) {
						
					}
					else{
						statenumber = ERROR;
					}
					break;
				case 1:
					if(Character.isLetterOrDigit(currentCharacter)) {
						statenumber= ID_COMPLETE;
					}
					else {
						input.unread(currentCharacter);
						statenumber = ID_COMPLETE;
					}
					break;
			}
		}
		this.lexeme = currentLexeme;
		if(statenumber == ERROR) {
			this.type = null;
			return false;
		}
		else if(statenumber == ID_COMPLETE) {
			this.type = lookup.get(this.lexeme);
			if(this.type = null) {
				this.type = TokenType.ID;
			}
			return true;
		}
	}
	
	public TokenType getToken() {
		return this.type;
		
	}
	
	public String getLexeme() {
		return this.lexeme;
	}
}


