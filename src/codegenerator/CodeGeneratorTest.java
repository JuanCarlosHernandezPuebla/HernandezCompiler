package codegenerator;

import static org.junit.Assert.*;
import org.junit.Test;
import parser.Parser;
import syntaxtree.ExpressionNode;
import syntaxtree.ProgramNode;

public class CodeGeneratorTest {

	@Test
	public void test() {
		
        //String filename = args[0];
        String filename = "factortest.pas";
        Parser factor = new Parser(filename);
        ProgramNode n = factor.program();
        //System.out.println("The tree is \n" + factor.program().indentedToString(0));
        
        // Build up the code and print it out:
        
        CodeGenerator cg = new CodeGenerator( );
        String code = cg.writeCodeForRoot(factor.expression(null));
        System.out.println("The code should be:");
        System.out.println( code);
    }
}
