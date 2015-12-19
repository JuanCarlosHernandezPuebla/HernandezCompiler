package scan;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.Test;

/** A unit test based on various test files. It iterates through its tokens and
 * asserts the values for token, token type, and lexeme.
 * @author Juan Carlos Hernandez Puebla*/

public class ScannerTest {

	/** Tests for valid and invalid token, as well as correct identification of lexemes and 
	 * token types.*/
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
		
		// This should be the .5 token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(false, hasToken);
		assertEquals(null, token);
		assertEquals(".5", lexeme);
		
		// This should be the 34775. token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
				
		// Test to make sure the above values are correct
		assertEquals(false, hasToken);
		assertEquals(null, token);
		assertEquals("34775.", lexeme);
		
		// This should be the + token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.PLUS, token);
		assertEquals("+",lexeme);
		
		// This should be the 55 token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.NUM, token);
		assertEquals("55", lexeme);
		
		// This should be the 623.634 token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
				
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.NUM, token);
		assertEquals("623.634", lexeme);
		
		// This should be the .287 token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
				
		// Test to make sure the above values are correct
		assertEquals(false, hasToken);
		assertEquals(null, token);
		assertEquals(".287", lexeme);
		
		// This should be the + token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
				
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.PLUS, token);
		assertEquals("+", lexeme);
		
		// This should be the 8932 token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
				
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.NUM, token);
		assertEquals("8932", lexeme);
		
		// This should be the 9533.E token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
				
		// Test to make sure the above values are correct
		assertEquals(false, hasToken);
		assertEquals(null, token);
		assertEquals("9533.E", lexeme);
		
		// This should be the + token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
				
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.PLUS, token);
		assertEquals("+", lexeme);
		
		// This should be the 764 token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
				
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.NUM, token);
		assertEquals("764", lexeme);
		
		// This should be the 745.E token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
				
		// Test to make sure the above values are correct
		assertEquals(false, hasToken);
		assertEquals(null, token);
		assertEquals("745.E", lexeme);
		
		// This should be the - token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
				
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.MINUS, token);
		assertEquals("-", lexeme);
		
		// This should be the 84547 token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
				
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.NUM, token);
		assertEquals("84547", lexeme);
		
		// This should be the 8973.E token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
				
		// Test to make sure the above values are correct
		assertEquals(false, hasToken);
		assertEquals(null, token);
		assertEquals("8973.E", lexeme);
		
		// This should be the 7983475 token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
				
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.NUM, token);
		assertEquals("7983475", lexeme);
		
		// This should be the 6872.E token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
				
		// Test to make sure the above values are correct
		assertEquals(false, hasToken);
		assertEquals(null, token);
		assertEquals("6872.E", lexeme);
		
		// This should be the .783 token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
				
		// Test to make sure the above values are correct
		assertEquals(false, hasToken);
		assertEquals(null, token);
		assertEquals(".783", lexeme);
		
		// This should be the 765436E token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
				
		// Test to make sure the above values are correct
		assertEquals(false, hasToken);
		assertEquals(null, token);
		assertEquals("765436E", lexeme);
		
		// This should be the 856.E token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
				
		// Test to make sure the above values are correct
		assertEquals(false, hasToken);
		assertEquals(null, token);
		assertEquals("856.E", lexeme);
		
		// This should be the 37298. token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
				
		// Test to make sure the above values are correct
		assertEquals(false, hasToken);
		assertEquals(null, token);
		assertEquals("37298.", lexeme);
		
		// Test end of invalidNumbers.txt
		hasToken =  test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(false, hasToken);
		assertEquals(null, token);
		assertEquals(null, lexeme);
		
		
		
		
		// Test keywords.txt
		test = new Scanner(new File("keywords.txt"));
		
		// This should be the program token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.PROGRAM, token);
		assertEquals("program", lexeme);
		
		// This should be the if token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.IF, token);
		assertEquals("if", lexeme);
		
		// This should be the var token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.VAR, token);
		assertEquals("var", lexeme);
		
		// This should be the array token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.ARRAY, token);
		assertEquals("array", lexeme);
		
		// This should be the of token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.OF, token);
		assertEquals("of", lexeme);
		
		// This should be the integer token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.INTEGER, token);
		assertEquals("integer", lexeme);
		
		// This should be the real token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.REAL, token);
		assertEquals("real", lexeme);
		
		// This should be the function token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.FUNCTION, token);
		assertEquals("function", lexeme);
		
		// This should be the procedure token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.PROCEDURE, token);
		assertEquals("procedure", lexeme);
		
		// This should be the begin token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.BEGIN, token);
		assertEquals("begin", lexeme);
		
		// This should be the end token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.END, token);
		assertEquals("end", lexeme);
		
		// This should be the then token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.THEN, token);
		assertEquals("then", lexeme);
		
		// This should be the else token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.ELSE, token);
		assertEquals("else", lexeme);
		
		// This should be the while token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.WHILE, token);
		assertEquals("while", lexeme);
		
		// This should be the do token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.DO, token);
		assertEquals("do", lexeme);
		
		// This should be the or token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.OR, token);
		assertEquals("or", lexeme);
		
		// This should be the div token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.DIV, token);
		assertEquals("div", lexeme);
		
		// This should be the mod token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.MOD, token);
		assertEquals("mod", lexeme);
		
		// This should be the and token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.AND, token);
		assertEquals("and", lexeme);
		
		// This should be the not token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.NOT, token);
		assertEquals("not", lexeme);
		
		// Test end of keywords.txt
		hasToken =  test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
				
		// Test to make sure the above values are correct
		assertEquals(false, hasToken);
		assertEquals(null, token);
		assertEquals(null, lexeme);
		
		
		
		
		// Test validID.txt
		test = new Scanner(new File("validID.txt"));
		
		// This should be the a token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
				
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.ID, token);
		assertEquals("a", lexeme);
		
		// This should be the B token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
				
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.ID, token);
		assertEquals("B", lexeme);
		
		// This should be the a1 token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
				
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.ID, token);
		assertEquals("a1", lexeme);
		
		// This should be the B2 token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
				
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.ID, token);
		assertEquals("B2", lexeme);
		
		// This should be the angle token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
				
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.ID, token);
		assertEquals("angle", lexeme);
		
		// This should be the myBank token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
				
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.ID, token);
		assertEquals("myBank", lexeme);
		
		// This should be the Counter token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
				
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.ID, token);
		assertEquals("Counter", lexeme);
		
		// This should be the VALUE token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
				
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.ID, token);
		assertEquals("VALUE", lexeme);
		
		// This should be the AMOUNT100 token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
				
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.ID, token);
		assertEquals("AMOUNT100", lexeme);
		
		// This should be the RADIUSofCircle token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
				
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.ID, token);
		assertEquals("RADIUSofCircle", lexeme);
		
		// This should be the R00ML0CATI0N token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
				
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.ID, token);
		assertEquals("R00ML0CATI0N", lexeme);
		
		// This should be the degree90 token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
				
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.ID, token);
		assertEquals("degree90", lexeme);
		
		// This should be the array1234List token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
				
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.ID, token);
		assertEquals("array1234List", lexeme);
		
		// This should be the ARRAY5378LIST token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
				
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.ID, token);
		assertEquals("ARRAY5378LIST", lexeme);
		
		// This should be the scann3rPascal token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
				
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.ID, token);
		assertEquals("scann3rPascal", lexeme);
		
		// Test end of validID.txt
		hasToken =  test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
				
		// Test to make sure the above values are correct
		assertEquals(false, hasToken);
		assertEquals(null, token);
		assertEquals(null, lexeme);
		
		
		
		
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
		
		// This should be the 1dir2home token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
				
		// Test to make sure the above values are correct
		assertEquals(false, hasToken);
		assertEquals(null, token);
		assertEquals("1dir2home", lexeme);
		
		// This should be the * token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
				
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.MULTIPLICATION, token);
		assertEquals("*", lexeme);
		
		// This should be the 45 token
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
				
		// Test to make sure the above values are correct
		assertEquals(true, hasToken);
		assertEquals(TokenType.NUM, token);
		assertEquals("45", lexeme);
		
		// Test end of invalidID.txt
		hasToken = test.nextToken();
		token = test.getToken();
		lexeme = test.getLexeme();
		
		// This should be end of file
		assertEquals(false, hasToken);
		assertEquals(null, token);
		assertEquals(null, lexeme);
		
		
	}

}