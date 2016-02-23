package syntaxTree;

import java.util.ArrayList;

/** Represents a Declarations Node in the syntax tree.
 * @author Juan Carlos Hernandez Puebla */
public class DeclarationsNode extends SyntaxTreeNode {
	
	// Instance variable
	ArrayList<VariableNode> vars;
	
	/** Default constructor for a DeclarationNode. */
	public DeclarationsNode(ArrayList<VariableNode> vars) {
		this.vars = vars;
	}
	
	/** Creates a String representation of this node.
	 * @param level The tree level at which this node resides.
	 * @return A String representing this node. */
    @Override
    public String indentedToString(int level) {
        String answer = super.indentedToString(level);
        answer += "Declarations: " + this.vars+ "\n";
        return answer;
    }
	
}
