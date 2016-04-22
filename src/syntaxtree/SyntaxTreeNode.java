package syntaxtree;

/** Represents a Syntax Tree Node for the mini Pascal language.
 * @author Juan Carlos Hernandez Puebla */
public abstract class SyntaxTreeNode {
	
	/** Creates a String representation of this node and its children.
	 * @param level The tree level at which this node resides.
	 * @return A string representing this node.*/
	public String indentedToString(int level) {
		String answer = "";
		if(level > 0) {
			answer = "|-- ";
		}
		for(int indent = 1;indent < level; indent++) answer += "--- ";
		return (answer);
	}

}
