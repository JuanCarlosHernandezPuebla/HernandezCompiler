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
		assertEquals(true, hasToken);
		assertEquals(TokenType.ID, token);
		assertEquals("foo", lexeme);
		
		// This should be bar token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the values above are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.ID, token);
		assertEquals("bar", lexeme);
		
		// This should be = token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the values above are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.EQUALS, token);
		assertEquals("=", lexeme);
		
		// This should be < token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the values above are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.LESS_THAN, token);
		assertEquals("<", lexeme);
        
        // This should be # token
        hasToken = test.nextToken();
        token = test.getToken();
        lexeme = test.getLexeme();
        
        // Test to make sure the above values are correct
		assertEquals(false, hasToken);
		assertEquals(null, token);
		assertEquals("#", lexeme);
        
        // This should be 7 token
        hasToken = test.nextToken();
        token = test.getToken();
        lexeme = test.getLexeme();
        
        // Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.NUM, token);
		assertEquals("7", lexeme);
        
        // Test end of input.txt
        hasToken = test.nextToken();
        token = test.getToken();
        lexeme = test.getLexeme();
        
        // Test to make sure the above values are correct
		assertEquals(false, hasToken);
		assertEquals(null, token);
		assertEquals(null, lexeme);
        
		
		
		
		// Test badComment.txt
		test = new Scanner(new File("badComment.txt"));
		
		// Should go to error state due to the second {
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(false, hasToken);
		assertEquals(null, token);
		assertEquals("{", lexeme);
		
		
		
		
		// Test goodComment.txt
		test = new Scanner(new File("goodComment.txt"));
		
		// Should ignore the comment and be at end of file
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(false, hasToken);
		assertEquals(null, token);
		assertEquals(null, lexeme);
		
		
		
		
		// Test validSymbols.txt
		test = new Scanner(new File("validSymbols.txt"));
		
		// This should be the Valid token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.ID, token);
		assertEquals("Valid", lexeme);
		
		// This should be the symbols token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.ID, token);
		assertEquals("symbols", lexeme);
		
		// This should be the + token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.PLUS, token);
		assertEquals("+", lexeme);
		
		// This should be the - token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.MINUS, token);
		assertEquals("-", lexeme);
		
		// This should be the * token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.MULTIPLICATION, token);
		assertEquals("*", lexeme);
		
		// This should be the / token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.SLASH, token);
		assertEquals("/", lexeme);
		
		// This should be the ; token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.SEMICOLON, token);
		assertEquals(";", lexeme);
		
		// This should be the , token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.COMMA, token);
		assertEquals(",", lexeme);
		
		// This should be the [ token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.OPEN_BRACKET, token);
		assertEquals("[", lexeme);
		
		// This should be the ] token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.CLOSE_BRACKET, token);
		assertEquals("]", lexeme);
		
		// This should be the ( token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.OPEN_PARENTHESE, token);
		assertEquals("(", lexeme);
		
		// This should be the ) token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.CLOSE_PARENTHESE, token);
		assertEquals(")", lexeme);
		
		// This should be the = token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.EQUALS, token);
		assertEquals("=", lexeme);
		
		// This should be the := token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.COLON_EQUALS, token);
		assertEquals(":=", lexeme);
		
		// This should be the <= token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.LESS_THAN_EQUALS, token);
		assertEquals("<=", lexeme);
		
		// This should be the <> token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.LESS_THAN_GREATER_THAN, token);
		assertEquals("<>", lexeme);
		
		// This should be the >= token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.GREATER_THAN_EQUALS, token);
		assertEquals(">=", lexeme);
		
		//Test end of validSymbols.txt
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(false,hasToken);
		assertEquals(null,token);
		assertEquals(null,lexeme);
		
		
		
		
		// Test validShortSymbols.txt
		test = new Scanner(new File("validShortSymbols.txt"));
		
		// This should be the Valid token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.ID, token);
		assertEquals("Valid", lexeme);
		
		// This should be the short token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.ID, token);
		assertEquals("short", lexeme);
		
		// This should be the symbols token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.ID, token);
		assertEquals("symbols", lexeme);
		
		// This should be the : token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.COLON, token);
		assertEquals(":", lexeme);
		
		// This should be the < token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.LESS_THAN, token);
		assertEquals("<", lexeme);
		
		// This should be the > token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.GREATER_THAN, token);
		assertEquals(">", lexeme);
		
		// Test end of validShortSymbols.txt
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(false, hasToken);
		assertEquals(null,token);
		assertEquals(null,lexeme);
		
		
		
		
		// Test invalidSymbols.txt
		test = new Scanner(new File("invalidSymbols.txt"));
		
		// This should be the These token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.ID, token);
		assertEquals("These", lexeme);
		
		// This should be the are token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.ID, token);
		assertEquals("are", lexeme);
		
		// This should be the a token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.ID, token);
		assertEquals("a", lexeme);
		
		// This should be the few token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.ID, token);
		assertEquals("few", lexeme);
		
		// This should be the invalid token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.ID, token);
		assertEquals("invalid", lexeme);
		
		// This should be the symbols token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.ID, token);
		assertEquals("symbols", lexeme);
		
		// This should be the % token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(false, hasToken);
		assertEquals(null, token);
		assertEquals("%", lexeme);
		
		// This should be the $ token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(false, hasToken);
		assertEquals(null, token);
		assertEquals("$", lexeme);
		
		// This should be the @ token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(false, hasToken);
		assertEquals(null, token);
		assertEquals("@", lexeme);
		
		// Test end of invalidSymbols.txt
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(false,hasToken);
		assertEquals(null,token);
		assertEquals(null,lexeme);
		
		
		
		
		// Test validNumbers.txt
		test = new Scanner(new File("validNumbers.txt"));
		
		// This should be the Valid token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.ID, token);
		assertEquals("Valid", lexeme);
		
		// This should be the numbers token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.ID, token);
		assertEquals("numbers", lexeme);
		
		// This should be the 3 token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.NUM, token);
		assertEquals("3", lexeme);
		
		// This should be the 5468204486 token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.NUM, token);
		assertEquals("5468204486", lexeme);
		
		// This should be the 1.3 token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.NUM, token);
		assertEquals("1.3", lexeme);
		
		// This should be the 9430.97986 token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.NUM, token);
		assertEquals("9430.97986", lexeme);
		
		// This should be the 845.589E43 token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.NUM, token);
		assertEquals("845.589E43", lexeme);
		
		// This should be the 4353.09E+855 token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.NUM, token);
		assertEquals("4353.09E+855", lexeme);
		
		// This should be the 3656.332E-7895 token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.NUM, token);
		assertEquals("3656.332E-7895", lexeme);
		
		// This should be the 5.29E+6835 token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.NUM, token);
		assertEquals("5.29E+6835", lexeme);
		
		// This should be the 9.67E-324854 token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.NUM, token);
		assertEquals("9.67E-324854", lexeme);
		
		// This should be the 4.54E54974 token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.NUM, token);
		assertEquals("4.54E54974", lexeme);
		
		// This should be the 789E435668564 token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.NUM, token);
		assertEquals("789E435668564", lexeme);
		
		// This should be the 438E+05098 token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.NUM, token);
		assertEquals("438E+05098", lexeme);
		
		// This should be the 927E-35959 token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.NUM, token);
		assertEquals("927E-35959", lexeme);
		
		// Test end of validNumbers.txt
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(false, hasToken);
		assertEquals(null, token);
		assertEquals(null, lexeme);
		
		
		
		
		// Test invalidNumbers.txt
		test = new Scanner(new File("invalidNumbers.txt"));
		
		// This should be the . token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(false, hasToken);
		assertEquals(null, token);
		assertEquals(".", lexeme);
		
		// This should be the 5 token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
				
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.NUM, token);
		assertEquals("5", lexeme);
		
		// This should be the 34775. token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(false, hasToken);
		assertEquals(null, token);
		assertEquals("34775.",lexeme);
		
		/*// This should be the 623.634.287 token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(false, hasToken);
		assertEquals(null, token);
		assertEquals("623.634.287", lexeme);
		
		// This should be the 9533.E+764 token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
				
		// Test to make sure the above values are correct
		assertEquals(false, hasToken);
		assertEquals(null, token);
		assertEquals("9533.E", lexeme);
		
		// This should be the 745.E-84547 token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
				
		// Test to make sure the above values are correct
		assertEquals(false, hasToken);
		assertEquals(null, token);
		assertEquals("745.E-84547", lexeme);
		
		// This should be the 8973.E7983475 token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
				
		// Test to make sure the above values are correct
		assertEquals(false, hasToken);
		assertEquals(null, token);
		assertEquals("8973.E7983475", lexeme);
		
		// This should be the 6872.E.783 token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
				
		// Test to make sure the above values are correct
		assertEquals(false, hasToken);
		assertEquals(null, token);
		assertEquals("6872.E.783", lexeme);
		
		// This should be the 765436E token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
				
		// Test to make sure the above values are correct
		assertEquals(false, hasToken);
		assertEquals(null, token);
		assertEquals("765436E", lexeme);
		
		// This should be the 856.E37298. token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
				
		// Test to make sure the above values are correct
		assertEquals(false, hasToken);
		assertEquals(null, token);
		assertEquals("856.E37298.", lexeme);
		
		// Test end of invalidNumbers.txt
		hasToken =  test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(false, hasToken);
		assertEquals(null, token);
		assertEquals(null, lexeme);*/
		
		
		
		
		// Test invalidID.txt
		test = new Scanner(new File("invalidID.txt"));
		
		// This should be the 2myBank token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(false, hasToken);
		assertEquals(null, token);
		assertEquals("2myBank", lexeme);
		
		// This should be the 2invalid token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
				
		// Test to make sure the above values are correct
		assertEquals(false, hasToken);
		assertEquals(null, token);
		assertEquals("2invalid", lexeme);
		
		// Test end of invalidID.txt
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// This should be end of file
		//assertEquals(false, hasToken);
		//assertEquals(null, token);
		//assertEquals(null, lexeme);
		
		
	}

}