package syntaxTree;

/** Represents a Program Node in the syntax tree.
 * @author Juan Carlos Hernandez Puebla */
public class ProgramNode extends SyntaxTreeNode {
	
	// Instance variables
	private String name;
	private DeclarationsNode variables;
	private CompoundStatementNode main; 
	private SubProgramDeclarationsNode functions;
	
	/** Creates a ProgrameNode with the specified name passed in.
	 * @param name The name of the program. */
	public ProgramNode(String name, DeclarationsNode var,
			CompoundStatementNode main, SubProgramDeclarationsNode functions) {
		this.name = name;
		this.variables = var;
		this.main = main;
		this.functions = functions;
	}
	
	/** Creates a String representation of this node.
	 * @param level The tree level at which this node resides.
	 * @return A String representing this node. */
    @Override
    public String indentedToString(int level) {
        String answer = super.indentedToString(level);
        answer += "Program: " + this.name + "\n";
        answer += this.variables.indentedToString(level);
        answer += this.functions.indentedToString(level);
        answer += this.main.indentedToString(level);
        return(answer);
    }

}
