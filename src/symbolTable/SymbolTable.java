package symbolTable;

import java.util.Enumeration;
import java.util.Hashtable;

/** Stores information about an identifier, such as its type and name. It will
 * contain other important information such as whether its of an array value.
 * As well as the starting and ending index if applicable to the identifier. 
 * @author Juan Carlos Hernandez Puebla */
public class SymbolTable {
	
	// Instance variable
	private Hashtable<String, InformationTable> symbols = new Hashtable<String, InformationTable>();
	
	/** Default constructor for a SymbolTable. */
	public SymbolTable() {
		
	}
	
	/** Represents the table that will contain information about an identifier.
	 * It stores the identifier name and its type. It will contain information
	 * on whether it is an array, as well as the starting and ending index
	 * values.
	 * @author Juan Carlos Hernandez Puebla */
	private class InformationTable {
		// Field variables
		String identifier;
		IDType kind;
		
		// Constructors
		/** Creates an InformationTable that takes in a identifier name and a
		 *  identifier type to be stored.
		 * @param identifier the name of the identifier
		 * @param kind the identifier type */
		public InformationTable(String identifier, IDType kind) {
			this.identifier = identifier;
			this.kind = kind;
		}
		
		/** Default constructor for an InformationTable. */
		public InformationTable() {
			
		}
		
	}
	
	/** Adds a program identifier name to the symbol table as a key, if that
	 *  name has not already been added to the table. It puts the information
	 *  table of the name, to the symbol table as its value.
	 * @param name the identifier name to be added as type program
	 * @return true if it successfully added the program name to the symbol
	 *  table else false */
	public boolean addProgramName(String name) {
		// The identifier name is already in the table
		if(this.symbols.containsKey(name)) return false;
		InformationTable information = new InformationTable();
		information.identifier = name;
		information.kind = IDType.PROGRAM;
		this.symbols.put(name, information);
		return true;
	}
	
	/** Adds a function identifier name to the symbol table as a key, if that
	 *  name has not already been added to the table. It puts the information
	 *  table of the name, to the symbol table as its value.
	 * @param name the identifier name to be added as type function
	 * @return true if it successfully added the function name to the symbol
	 *  table else false */
	public boolean addFunctionName(String name) {
		// The identifier name is already in the table
		if(symbols.containsKey(name)) return false;
		InformationTable information = new InformationTable();
		information.identifier = name;
		information.kind = IDType.FUNCTION;
		symbols.put(name, information);
		return true;
	}

	/** Adds a procedure identifier name to the symbol table as a key, if that
	 *  name has not already been added to the table. It puts the information
	 *  table of the name, to the symbol table as its value.
	 * @param name the identifier name to be added as type procedure
	 * @return true if it successfully added the procedure name to the symbol
	 *  table else false */
	public boolean addProcedureName(String name) {
		// The identifier name is already in the table
		if(symbols.containsKey(name)) return false;
		InformationTable information = new InformationTable();
		information.identifier = name;
		information.kind = IDType.PROCEDURE;
		symbols.put(name, information);
		return true;
	}
	
	/** Adds a variable identifier name to the symbol table as a key, if that
	 *  name has not already been added to the table. It puts the information
	 *  table of the name, to the symbol table as its value.
	 * @param name the identifier name to be added as type variable
	 * @return true if it successfully added the variable name to the symbol
	 *  table else false */
	public boolean addVariableName(String name) {
		// The identifier name is already in the table
		if(symbols.containsKey(name)) return false;
		InformationTable information = new InformationTable();
		information.identifier = name;
		information.kind = IDType.VARIABLE;
		symbols.put(name, information);
		return true;
	}
	
	/** Verifies whether a given identifier name is that of a program. If it is,
	 *  then it returns true. Otherwise, it returns false if either the name is
	 *  not found in the symbol table or if it is not of type program. 
	 * @param name the identifier name to look up in the symbol table
	 * @return true if the name is of a program else false */
	public boolean isProgramName(String name) {
		InformationTable information = symbols.get(name);
		// The identifier name is not in the table
		if(information == null) return false;
		if(information.kind == IDType.PROGRAM) return true;
		// The identifier name is not of a program
		return false;
	}
	
	/** Verifies whether a given identifier name is that of a function. If it is,
	 *  then it returns true. Otherwise, it returns false if either the name is
	 *  not found in the symbol table or if it is not of type function. 
	 * @param name the identifier name to look up in the symbol table
	 * @return true if the name is of a function else false */
	public boolean isFunctionName(String name) {
		InformationTable information = symbols.get(name);
		// The identifier name is not in the table
		if(information == null) return false;
		if(information.kind == IDType.FUNCTION) return true;
		// The identifier name is not of a function
		return false;
	}
	
	/** Verifies whether a given identifier name is that of a procedure. If it is,
	 *  then it returns true. Otherwise, it returns false if either the name is
	 *  not found in the symbol table or if it is not of type procedure. 
	 * @param name the identifier name to look up in the symbol table
	 * @return true if the name is of a procedure else false */
	public boolean isProcedureName(String name) {
		InformationTable information = symbols.get(name);
		// The identifier name is not in the table
		if(information == null) return false;
		if(information.kind == IDType.PROCEDURE) return true;
		// The identifier name is not of a procedure
		return false;
	}
	
	/** Verifies whether a given identifier name is that of a variable. If it is,
	 *  then it returns true. Otherwise, it returns false if either the name is
	 *  not found in the symbol table or if it is not of type variable. 
	 * @param name the identifier name to look up in the symbol table
	 * @return true if the name is of a variable else false */
	public boolean isVariableName(String name) {
		InformationTable information = symbols.get(name);
		// The identifier name is not in the table
		if(information == null) return false;
		if(information.kind == IDType.VARIABLE)return true;
		// The identifier name is not of a variable
		return false;
	}
	
	/** Prints out a formated table of the symbol table contents. It has
	 *  columns for the ID, kind, and variable type. It will contain more
	 *  necessary information.
	 *  @return formated string of the symbol table. */
	@Override
	public String toString() {
		String information = "";
		Enumeration<String> keys = symbols.keys();
		while(keys.hasMoreElements()) {
			String store = keys.nextElement();
			information += String.format("%-16s",symbols.get(store).identifier) +
			String.format("%-16s",symbols.get(store).kind) + "\n";
		}
		return  String.format("%-16s", "ID") + String.format("%-16s", "kind") +
				String.format("%-16s", "variable type") + "\n" + information;
	}
}
