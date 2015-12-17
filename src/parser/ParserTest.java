package parser;

public class ParserTest {

	public static void main(String[] args) {
		System.out.println("=========Test for simplest.pas=========");
		
		String filename = args[0];
		Parser pp = new Parser(filename);
		pp.program();
		System.out.println("Parse of " + filename + " Successful");
		
		
		System.out.println("\n\n=========Test for singleDeclaration.pas=========");
		
		filename = args[1];
		pp = new Parser(filename);
		pp.program();
		System.out.println("Parse of " + filename + " Sucessful");
		
		
		System.out.println("\n\n=========Test for declarations.pas=========");
		
		filename = args[2];
		pp = new Parser(filename);
		pp.program();
		System.out.println("Parse of " + filename + " Sucessful");
		

		System.out.println("\n\n=========Test for badDeclaration.pas=========");
		
		filename = args[3];
		pp = new Parser(filename);
		try{
		pp.program();
		}
		catch (Error er) {
			System.out.println("Parse of " + filename + " Unsucessful\nReason: " + er.toString());
		}
		
		
		System.out.println("\n\n=========Test for subprogram_declarations.pas=========");
		filename = args[4];
		pp = new Parser(filename);
		pp.program();
		System.out.println("Parse of " + filename + " Successful");
		
		
		System.out.println("\n\n=========Test for subprogram_declarations_add_on.pas=========");
		filename = args[5];
		pp = new Parser(filename);
		pp.program();
		System.out.println("Parse of " + filename + " Successful");
		
		
		System.out.println("\n\n=========Test for subprogram_declarations_add_on2.pas=========");
		filename = args[6];
		pp = new Parser(filename);
		pp.program();
		System.out.println("Parse of " + filename + " Successful");
		
		
		System.out.println("\n\n=========Test for compound_statement.pas=========");
		filename = args[7];
		pp = new Parser(filename);
		pp.program();
		System.out.println("Parse of " + filename + " Successful");
		
		System.out.println("\n\n=========Test for compound_statement_add_on.pas=========");
		filename = args[8];
		pp = new Parser(filename);
		pp.program();
		System.out.println("Parse of " + filename + " Successful");
		
		
		

	}

}
