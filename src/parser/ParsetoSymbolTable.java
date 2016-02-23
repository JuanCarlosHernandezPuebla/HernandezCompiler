package parser;

import static org.junit.Assert.*;

import org.junit.Test;

public class ParsetoSymbolTable {

	@Test
	public void test() {
		// Tests for well written Pascal programs
		System.out.println("=========Test for varTest.pas=========");
		
		String filename = "varTest.pas";
		Parser pp = new Parser(filename);
		pp.program();
		System.out.println("Parse of " + filename + " Successful");
		
		
		
	}

}
