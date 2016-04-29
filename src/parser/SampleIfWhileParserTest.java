package parser;

import static org.junit.Assert.*;

import org.junit.Test;

public class SampleIfWhileParserTest {

	@Test
	public void test() {
		// Tests for well written Pascal programs
		System.out.println("=========Test for sampleifwhile.pas=========");
		String filename = "sampleifwhile.pas";
		Parser sample = new Parser(filename);
		System.out.println(sample.program().indentedToString(0));
	
	}

}
