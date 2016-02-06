package symbolTable;

import static org.junit.Assert.*;

import org.junit.Test;

/** A unit test based on the addition of identifiers to a SymbolTable. It
 * asserts whether the SymbolTable is correctly represented by its toString.
 * @author Juan Carlos Hernandez Puebla */
public class toStringTest {

	/** Test for valid representation of a SymbolTable by its toString after
	 *  the addition of identifiers.*/
	@Test
	public void test() {
		
		// Test presentation of the Symbol Table
		SymbolTable symbol = new SymbolTable();
		
		symbol.addProgramName("Calendar");
		
		// The symbol table should only contain the identifier Calendar
		String table = "ID              kind            variable type   \n" +
					   "Calendar        PROGRAM         \n";
		assertEquals(symbol.toString(), table);
		
		
		
		// Test presentation of the Symbol Table after more additions
		symbol.addFunctionName("printDate");
		
		// The symbol table should now contain the identifiers Calendar and printDate
		table = "ID              kind            variable type   \n" +
				"printDate       FUNCTION        \n" +
				"Calendar        PROGRAM         \n";
		assertEquals(symbol.toString(),table);
		
				
		symbol.addProcedureName("out");
		
		symbol.addVariableName("year");
		
		//  The symbol table should now contain year, out, printDate, and Calendar
		table = "ID              kind            variable type   \n" +
				"out             PROCEDURE       \n" +
				"year            VARIABLE        \n" +  
				"printDate       FUNCTION        \n" +
				"Calendar        PROGRAM         \n";
		assertEquals(symbol.toString(),table);
		
		// Test presentation of the Symbol Table after invalid additions
		symbol.addProgramName("year");
		symbol.addProgramName("Calendar");
		symbol.addFunctionName("out");
		symbol.addFunctionName("printDate");
		symbol.addProcedureName("year");
		symbol.addProcedureName("out");
		symbol.addVariableName("Calendar");
		symbol.addVariableName("year");
		
		//  The Symbol Table should still contain year, out, printDate, and Calendar
		table = "ID              kind            variable type   \n" +
				"out             PROCEDURE       \n" +
				"year            VARIABLE        \n" +  
				"printDate       FUNCTION        \n" +
				"Calendar        PROGRAM         \n";
		assertEquals(symbol.toString(),table);
		
		// Test presentation of the Symbol Table after more additions
		symbol.addProgramName("Course");
		symbol.addFunctionName("getGrades");
		symbol.addProcedureName("rubric");
		symbol.addVariableName("students");
		
		/* The symbol table should now contain students, rubric, getGrades,
		 *Course, year, out, printDate, and Calendar.*/
		table = "ID              kind            variable type   \n" +
				"out             PROCEDURE       \n" +
				"rubric          PROCEDURE       \n" +
				"year            VARIABLE        \n" +  
				"printDate       FUNCTION        \n" +
				"Course          PROGRAM         \n" +
				"getGrades       FUNCTION        \n" +
				"Calendar        PROGRAM         \n" +
				"students        VARIABLE        \n";
		assertEquals(symbol.toString(),table);
		
		// Test presentation of the Symbol Table after more additions
		symbol.addProgramName("Store");
		symbol.addFunctionName("type");
		symbol.addProcedureName("count");
		symbol.addVariableName("salary");
		
		/* The symbol table should contain salary, count, type, Store, students,
		 * Calendar, getGrades, Course, printDate, year, rubric, and out.
		 * 
		 */
		table = "ID              kind            variable type   \n" +
				"Calendar        PROGRAM         \n" +
				"rubric          PROCEDURE       \n" +
				"printDate       FUNCTION        \n" +
				"out             PROCEDURE       \n" +
				"count           PROCEDURE       \n" +
				"getGrades       FUNCTION        \n" +
				"Store           PROGRAM         \n" +
				"students        VARIABLE        \n" +
				"Course          PROGRAM         \n" +
				"type            FUNCTION        \n" +  
				"year            VARIABLE        \n" +  
				"salary          VARIABLE        \n";
		assertEquals(symbol.toString(),table);
			
	}

}
