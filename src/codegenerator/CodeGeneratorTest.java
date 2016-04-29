package codegenerator;

import static org.junit.Assert.*;
import org.junit.Test;
import codegenerator.CodeGenerator;
import parser.Parser;
import syntaxtree.ExpressionNode;

public class CodeGeneratorTest {

	@Test
	public void test(){
		
        String filename = "factortest.pas";
        Parser factor = new Parser(filename);
        System.out.println("The tree is \n" + factor.program().indentedToString(0));
        
        // Build up the code and print it out:
        
        CodeGenerator cg = new CodeGenerator( );
        ExpressionNode expressionNode = factor.expression();
        String code = cg.writeCodeForRoot(expressionNode);
        System.out.println("The code should be:");
        System.out.println(code);
        
       
       /* //String filename = args[0];
        String filename = "factortest.pas";
        Parser ep = new Parser(filename);
        ExpressionNode en = ep.expression();
        System.out.println("The tree is \n" + en.indentedToString(0));
        
        // Build up the code and print it out:
        
        CodeGenerator cg = new CodeGenerator( );
        String code = cg.writeCodeForRoot(en);
        System.out.println("The code should be:");
        System.out.println( code);
       /* 
        
        /*The tree is 
        Operation: PLUS
        |-- Operation: MINUS
        |-- --- Operation: MULTIPLY
        |-- --- --- Value: 5
        |-- --- --- Value: 7
        |-- --- Value: 6
        |-- Operation: MULTIPLY
        |-- --- Value: 3
        |-- --- Operation: DIVIDE
        |-- --- --- Value: 2
        |-- --- --- Value: 4
       */ 
    }
}
