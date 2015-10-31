package scan;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.Test;

/** A unit test based on the input.txt file. It iterates through its tokens and
 * asserts the values for token, token type, and lexeme.
 * @author Juan Carlos Hernandez Puebla*/

public class ScannerTest {

	@Test
	public void test() {
		// Tests the following 'foo bar = < # 7' from input.txt
		Scanner test = new Scanner(new File("input.txt"));
		
		// This should be foo token
		boolean hasToken = test.nextToken();
		TokenType token = test.getToken();
		String lexeme = test.getLexeme();
		
		// Test to make sure the values above are correct
		assert hasToken == true : "No token for foo";
		assert token == TokenType.ID : "No token type for foo";
		assert lexeme.equals("foo") : "No lexeme for foo";
		
		// This should be bar token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the values above are correct
		assert hasToken == true : "No token for bar";
		assert token == TokenType.ID : "No token type for bar";
		assert lexeme.equals("bar") : "No lexeme for bar";
		
		// This should be = token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the values above are correct
		assert hasToken : "No token for =";
		assert token == TokenType.EQUALS : "No token type for =";
		assert lexeme.equals("=") : "No lexeme for =";
		
		// This should be < token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the values above are correct
		assert hasToken : "No token for =";
        assert token == TokenType.LESS_THAN : "No token type for <";
        assert lexeme.equals("<") : "No lexeme for <";
        
        // This should be # token
        hasToken = test.nextToken();
        token = test.getToken();
        lexeme = test.getLexeme();
        
        // Test to make sure the above values are correct
        assert hasToken == false : "No token for #";
        assert token == null : "No token type for #";
        assert lexeme.equals("#") : "No lexeme for #";
        
        // This should be 7 token
        hasToken = test.nextToken();
        token = test.getToken();
        lexeme = test.getLexeme();
        
        // Test to make sure the above values are correct
        assert hasToken : "No token for 7";
        assert token == TokenType.NUM : "No token type for 7";
        assert lexeme.equals("7") : "No lexeme for 7";
        
        // Test end of file
        hasToken = test.nextToken();
        token = test.getToken();
        lexeme = test.getLexeme();
        
        // Test to make sure the above values are correct
        assert hasToken == false : "No more tokens";
        assert token == null : "No token";
        assert lexeme == null : "No lexeme";
       
	}

}
