package syntaxtree;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import scan.TokenType;

/** A unit test based on building up a Pascal program. It asserts that the syntax tree
 *  correctly represents the Pascal program that was build.
 * @author Juan Carlos Hernandez Puebla */
public class SyntaxTreeTest {
	
	/** A test for correct representation of the syntax tree corresponding to
	 *  a build up Pascal program. */
	@Test
	public void test() {
		/* Constructs the following program,
		 * program sample;

			var  dollars,yen,bitcoin:integer;

			begin
   				dollars := 1000000;
   				yen := dollars * 102;
   				bitcoins := dollars / 400
			end
			. 
		 * Then its tests that its proper syntax tree was generated. */
		DeclarationsNode variables = new DeclarationsNode();
		VariableNode dollars = new VariableNode("dollars");
		VariableNode yen = new VariableNode("yen");
		VariableNode bitcoins = new VariableNode("bitcoins");
		variables.addVariable(dollars);
		variables.addVariable(yen);
		variables.addVariable(bitcoins);
		SubProgramDeclarationsNode sub = new SubProgramDeclarationsNode();
		CompoundStatementNode compound = new CompoundStatementNode();
		ValueNode dollarsValue = new ValueNode("1000000");
		compound.addStatement(new AssignmentStatementNode(dollars,dollarsValue));
		OperationNode yenValue = new OperationNode(TokenType.MULTIPLICATION);
		yenValue.setLeft(dollars);
		yenValue.setRight(new ValueNode("102"));
		compound.addStatement(new AssignmentStatementNode(yen, yenValue));
		OperationNode bitcoinsValue = new OperationNode(TokenType.DIVISION);
		bitcoinsValue.setLeft(dollars);
		bitcoinsValue.setRight(new ValueNode("400"));
		compound.addStatement(new AssignmentStatementNode(bitcoins, bitcoinsValue));
		ProgramNode sample = new ProgramNode("sample.pas",variables,sub, compound);
		
		String syntaxTree = "Program: sample.pas\n|-- Declarations: \n"
				+ "|-- --- Variable: dollars\n|-- --- Type: null\n"
				+ "|-- --- Variable: yen\n|-- --- Type: null\n"
				+ "|-- --- Variable: bitcoins\n|-- --- Type: null\n"
				+ "|-- Subprogram declarations: \n|-- Compound statement: \n"
				+ "|-- --- Assignment statement: \n|-- --- --- Variable: dollars\n"
				+ "|-- --- --- Type: null\n|-- --- --- Value: 1000000\n"
				+ "|-- --- Assignment statement: \n|-- --- --- Variable: yen\n"
				+ "|-- --- --- Type: null\n|-- --- --- Operation: MULTIPLICATION\n"
				+ "|-- --- --- --- Variable: dollars\n|-- --- --- --- Type: null\n"
				+ "|-- --- --- --- Value: 102\n|-- --- Assignment statement: \n"
				+ "|-- --- --- Variable: bitcoins\n|-- --- --- Type: null\n"
				+ "|-- --- --- Operation: DIVISION\n|-- --- --- --- Variable: dollars\n"
				+ "|-- --- --- --- Type: null\n|-- --- --- --- Value: 400\n";
		
		assertEquals(syntaxTree, sample.indentedToString(0));
		//System.out.println(sample.indentedToString(0));
		
	}

}
