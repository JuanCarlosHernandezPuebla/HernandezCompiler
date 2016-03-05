package syntaxTree;

/** Represents a Value Node in the syntax tree.
 * @author Juan Carlos Hernandez Puebla */
public class ValueNode extends ExpressionNode {
	
	// Instance variable
	private String attribute;
	
	/** Creates a ValueNode with the given attribute passed in.
	 * @param attr The attribute corresponding to this value node. */
	public ValueNode(String attr) {
		this.attribute = attr;
	}
	
	/** Retrieves the attribute of this node.
	 * @return The attribute for this ValueNode. */
	public String getAttribute() {
		return (this.attribute);
	}
	
    /** Returns the attribute as the description of this node.
     * @return The attribute String of this node. */
    @Override
    public String toString() {
        return (attribute);
    }
 
    /** Creates a String representation of this node.
     * @param level The tree level at which this node resides.
     * @return A String representing this node. */
	@Override
	public String indentedToString(int level) {
		String answer = super.indentedToString(level + 1);
		answer += "Value: " + this.attribute + "\n";
		return answer;
	}
	
}
