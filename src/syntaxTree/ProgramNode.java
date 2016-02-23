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
	public ProgramNode(String name) {
		this.name = name;
	}
	
	/** Creates a String representation of this node.
	 * @param level The tree level at which this node resides.
	 * @return A String representing this node. */
    @Override
    public String indentedToString(int level) {
        String answer = super.indentedToString(level);
        answer += "Program: " + this.name + "\n";
        answer += variables.indentedToString(level + 1);
        answer += main.indentedToString(level + 1);
        answer += functions.indentedToString(level + 1);
        return(answer);
    }

}
