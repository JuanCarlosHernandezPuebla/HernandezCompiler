package symboltable;

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
					   "Calendar        PROGRAM         null            \n";

		assertEquals(table, symbol.toString());
		
		
		
		// Test presentation of the Symbol Table after more additions
		symbol.addFunctionName("printDate");
		
		// The symbol table should now contain the identifiers Calendar and printDate
		table = "ID              kind            variable type   \n" +
				"printDate       FUNCTION        null            \n" +
				"Calendar        PROGRAM         null            \n";
		assertEquals(table, symbol.toString());
		
				
		symbol.addProcedureName("out");
		
		symbol.addVariableName("year");
		
		//  The symbol table should now contain year, out, printDate, and Calendar
		table = "ID              kind            variable type   \n" +
				"out             PROCEDURE       null            \n" +
				"year            VARIABLE        null            \n" +  
				"printDate       FUNCTION        null            \n" +
				"Calendar        PROGRAM         null            \n";
		assertEquals(table, symbol.toString());
		
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
				"out             PROCEDURE       null            \n" +
				"year            VARIABLE        null            \n" +  
				"printDate       FUNCTION        null            \n" +
				"Calendar        PROGRAM         null            \n";
		assertEquals(table, symbol.toString());
		
		// Test presentation of the Symbol Table after more additions
		symbol.addProgramName("Course");
		symbol.addFunctionName("getGrades");
		symbol.addProcedureName("rubric");
		symbol.addVariableName("students");
		
		/* The symbol table should now contain students, rubric, getGrades,
		 *Course, year, out, printDate, and Calendar.*/
		table = "ID              kind            variable type   \n" +
				"out             PROCEDURE       null            \n" +
				"rubric          PROCEDURE       null            \n" +
				"year            VARIABLE        null            \n" +  
				"printDate       FUNCTION        null            \n" +
				"Course          PROGRAM         null            \n" +
				"getGrades       FUNCTION        null            \n" +
				"Calendar        PROGRAM         null            \n" +
				"students        VARIABLE        null            \n";
		assertEquals(table, symbol.toString());
		
		// Test presentation of the Symbol Table after more additions
		symbol.addProgramName("Store");
		symbol.addFunctionName("type");
		symbol.addProcedureName("count");
		symbol.addVariableName("salary");
		
		/* The symbol table should contain salary, count, type, Store, students,
		 * Calendar, getGrades, Course, printDate, year, rubric, and out.*/
		table = "ID              kind            variable type   \n" +
				"Calendar        PROGRAM         null            \n" +
				"rubric          PROCEDURE       null            \n" +
				"printDate       FUNCTION        null            \n" +
				"out             PROCEDURE       null            \n" +
				"count           PROCEDURE       null            \n" +
				"getGrades       FUNCTION        null            \n" +
				"Store           PROGRAM         null            \n" +
				"students        VARIABLE        null            \n" +
				"Course          PROGRAM         null            \n" +
				"type            FUNCTION        null            \n" +  
				"year            VARIABLE        null            \n" +  
				"salary          VARIABLE        null            \n";
		assertEquals(table, symbol.toString());
	}
}
