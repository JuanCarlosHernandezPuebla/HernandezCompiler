package parser;

import static org.junit.Assert.*;

import org.junit.Test;

public class SampleParserTest {

	@Test
	public void test() {
		// Tests for well written Pascal programs
				System.out.println("=========Test for sample.pas=========");
				String filename = "sample.pas";
				Parser sample = new Parser(filename);
				System.out.println(sample.program().indentedToString(0));
				String syntaxTree = "Program: sample\n|-- Declarations: \n"
						+ "|-- --- Variable: dollars\n|-- --- Variable: yen\n"
						+ "|-- --- Variable: bitcoins\n|-- Subprogram declarations: null\n"
						+ "|-- Compound statement: \n|-- --- Assignment statement: \n"
						+ "|-- --- --- Variable: dollars\n|-- --- --- Value: 1000000\n"
						+ "|-- --- Assignment statement: \n|-- --- --- Variable: yen\n"
						+ "|-- --- --- Operation: MULTIPLICATION\n|-- --- --- --- Variable: dollars\n"
						+ "|-- --- --- --- Value: 102\n|-- --- Assignment statement: \n"
						+ "|-- --- --- Variable: bitcoins\n|-- --- --- Operation: DIVISION\n"
						+ "|-- --- --- --- Variable: dollars\n|-- --- --- --- Value: 400\n";
				
				//assertEquals(syntaxTree, sample.program().indentedToString(0));
				
/*
Program: sample.pas
|-- Declarations: 
|-- --- Variable: dollars
|-- --- Variable: yen
|-- --- Variable: bitcoins
|-- Subprogram declarations: 
|-- Compound statement: 
|-- --- Assignment statement: 
|-- --- --- Variable: dollars
|-- --- --- Value: 1000000
|-- --- Assignment statement: 
|-- --- --- Variable: yen
|-- --- --- Operation: MULTIPLICATION
|-- --- --- --- Variable: dollars
|-- --- --- --- Value: 102
|-- --- Assignment statement: 
|-- --- --- Variable: bitcoins
|-- --- --- Operation: DIVISION
|-- --- --- --- Variable: dollars
|-- --- --- --- Value: 400 */
				
	}

}
