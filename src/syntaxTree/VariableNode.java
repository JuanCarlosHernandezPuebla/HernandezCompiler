package syntaxTree;

/** Represents a Variable Node in the syntax tree.
 * @author Juan Carlos Hernandez Puebla */
public class VariableNode extends ExpressionNode {
	
	// Instance variable
	private String name;
	
	/** Creates a VariableNode with the given name passed in. 
	 * @param name The name of this VariabelNode. */
	public VariableNode(String name) {
		this.name = name;
	}
	
	/** Retrieves the name of this node.
	 * @return The name of this Variable Node*/
	public String getName() {
		return (this.name);
	}

    /** Returns the name as the description of this node.
     * @return The name String of this node. */
	@Override
	public String toString() {
		return (name);
	}

    /** Creates a String representation of this node.
     * @param level The tree level at which this node resides.
     * @return A String representing this node. */
	@Override
	public String indentedToString(int level) {
		String answer = super.indentedToString(level + 1);
		answer += "Variable: " + this.name + "\n";
		return answer;
	}

}
