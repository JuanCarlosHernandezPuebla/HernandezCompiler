package symboltable;

import static org.junit.Assert.*;

import org.junit.Test;

/** A unit test based on the addition of various identifiers types to a Symbol
 * Table. It asserts whether the identifier name trying to be added to the
 * Symbol Table is allowed. It also test for recognition of identifier names
 * for the different types. 
 * @author Juan Carlos Hernandez Puebla */

public class SymbolTableTest {
	/** A test for valid placement of different types of identifiers to a
	 * Symbol Table. It also test for recognition of identifier names for the 
	 * different types. */
	@Test
	public void test() {
		
		// Test for valid identifier names of type program
		SymbolTable s1 = new SymbolTable();
		
		boolean allowedName = s1.addProgramName("Point");
		assertEquals(true, allowedName);
		
		allowedName = s1.addProgramName("Card");
		assertEquals(true, allowedName);
		
		allowedName = s1.addProgramName("Simple");
		assertEquals(true, allowedName);
		
		// Should be false due to previous addition of Card above
		allowedName = s1.addProgramName("Card");
		assertEquals(false, allowedName);
		
		
		
		
		
		// Test for valid identifier names of type function
		allowedName = s1.addFunctionName("distance");
		assertEquals(true, allowedName);
		
		allowedName = s1.addFunctionName("shuffle");
		assertEquals(true, allowedName);
		
		allowedName = s1.addFunctionName("funct");
		assertEquals(true, allowedName);
		
		// Should be false due to earlier addition of Point above
		allowedName = s1.addFunctionName("Point");
		assertEquals(false, allowedName);
		
		// Should be false due to previous addition of shuffle above
		allowedName = s1.addFunctionName("shuffle");
		assertEquals(false, allowedName);
		
		
		
		
		
		// Test for valid identifier names of type procedure
		allowedName = s1.addProcedureName("placement");
		assertEquals(true, allowedName);
		
		allowedName = s1.addProcedureName("subtraction");
		assertEquals(true, allowedName);
		
		// Should be false due to earlier addition of distance above
		allowedName = s1.addProcedureName("distance");
		assertEquals(false, allowedName);
		
		// Should be false due to earlier addition of Simple above
		allowedName = s1.addProcedureName("Simple");
		assertEquals(false, allowedName);
		
		// Should be false due to previous addition of placement above
		allowedName = s1.addProcedureName("placement");
		assertEquals(false, allowedName);
		
		
		
		
		
		// Test for valid identifier names of type variable
		allowedName = s1.addVariableName("location1");
		assertEquals(true, allowedName);
		
		allowedName = s1.addVariableName("location2");
		assertEquals(true, allowedName);
		
		allowedName = s1.addVariableName("rank");
		assertEquals(true, allowedName);
		
		allowedName = s1.addVariableName("result");
		assertEquals(true, allowedName);
		
		// Should be false due to earlier addition of subtraction above
		allowedName = s1.addVariableName("subtraction");
		assertEquals(false, allowedName);
		
		// Should be false due to earlier addition of shuffle above
		allowedName = s1.addVariableName("shuffle");
		assertEquals(false, allowedName);
		
		// Should be false due to earlier Card of Simple above
		allowedName = s1.addVariableName("Card");
		assertEquals(false, allowedName);
		
		// Should be false due to previous addition of location1 above
		allowedName = s1.addVariableName("location1");
		assertEquals(false, allowedName);
		
		
		
		
		
		// Test for recognition of identifier names for type program 
		
		// Should be true since Point was added earlier as type program 
		boolean recognizedType = s1.isProgramName("Point");
		assertEquals(true, recognizedType);
		
		recognizedType = s1.isProgramName("Card");
		assertEquals(true, recognizedType);
		
		recognizedType = s1.isProgramName("Simple");
		assertEquals(true, recognizedType);
		
		// Should be false since distance was added earlier as type function
		recognizedType = s1.isProgramName("distance");
		assertEquals(false, recognizedType);
		
		// Should be false since placement was added earlier as type procedure
		recognizedType = s1.isProgramName("placement");
		assertEquals(false, recognizedType);
		
		// Should be false since location1 was added earlier as type variable
		recognizedType = s1.isProgramName("location1");
		assertEquals(false, recognizedType);
		
		// Should be false since Math was never added to the table
		recognizedType = s1.isProgramName("Math");
		assertEquals(false, recognizedType);
		
		
		
		
		
		// Test for recognition of identifier names for type function
		
		// Should be true since distance was added earlier as type function
		recognizedType = s1.isFunctionName("distance");
		assertEquals(true, recognizedType);
		
		recognizedType = s1.isFunctionName("shuffle");
		assertEquals(true, recognizedType);
		
		recognizedType = s1.isFunctionName("funct");
		assertEquals(true, recognizedType);
		
		// Should be false since Point was added earlier as type program
		recognizedType = s1.isFunctionName("Point");
		assertEquals(false, recognizedType);
		
		// Should be false since placement was added earlier as type procedure
		recognizedType = s1.isFunctionName("placement");
		assertEquals(false, recognizedType);
		
		// Should be false since location1 was added earlier as type variable
		recognizedType = s1.isFunctionName("location1");
		assertEquals(false, recognizedType);
		
		// Should be false since sqrt was never added to the table
		recognizedType = s1.isFunctionName("sqrt");
		assertEquals(false, recognizedType);
		
		
		
		
		
		// Test for recognition of identifier names for type procedure
		
		// Should be true since placement was added earlier as type procedure
		recognizedType = s1.isProcedureName("placement");
		assertEquals(true, recognizedType);
		
		recognizedType = s1.isProcedureName("subtraction");
		assertEquals(true, recognizedType);
		
		// Should be false since Card was added earlier as type program
		recognizedType = s1.isProcedureName("Card");
		assertEquals(false, recognizedType);
		
		// Should be false since shuffle was added earlier as type function
		recognizedType = s1.isProcedureName("shuffle");
		assertEquals(false, recognizedType);
		
		// Should be false since location2 was added earlier as type variable
		recognizedType = s1.isProcedureName("location2");
		assertEquals(false, recognizedType);
		
		// Should be false since calculate was never added to the table
		recognizedType = s1.isProcedureName("calculate");
		assertEquals(false, recognizedType);
		
		
		
		
		
		// Test for recognition of identifier names for type variable
		
		// Should be true since location1 was added earlier as type variable
		recognizedType = s1.isVariableName("location1");
		assertEquals(true, recognizedType);
		
		recognizedType = s1.isVariableName("location2");
		assertEquals(true, recognizedType);
		
		recognizedType = s1.isVariableName("rank");
		assertEquals(true, recognizedType);
		
		recognizedType = s1.isVariableName("result");
		assertEquals(true, recognizedType);
		
		// Should be false since Simple was added earlier as type program
		recognizedType = s1.isVariableName("Simple");
		assertEquals(false, recognizedType);
		
		// Should be false since funct was added earlier as type function
		recognizedType = s1.isVariableName("funct");
		assertEquals(false, recognizedType);
		
		// Should be false since subtraction was added earlier as type procedure
		recognizedType = s1.isVariableName("subtraction");
		assertEquals(false, recognizedType);
		
		// Should be false since area was never added to the table
		recognizedType = s1.isProcedureName("area");
		assertEquals(false, recognizedType);
		
	}

}
