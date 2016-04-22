package syntaxtree;

import java.util.ArrayList;

/** Represents a Declarations Node in the syntax tree.
 * @author Juan Carlos Hernandez Puebla */
public class DeclarationsNode extends SyntaxTreeNode {
	

	// Instance variable
	private ArrayList<VariableNode> vars;
	
	/** Default constructor for a DeclarationNode. */
	public DeclarationsNode() {
		this.vars = new ArrayList<VariableNode>();
	}
	
	/** Adds a variable to the array list of VariableNodes.
	 * @param variable The VariableNode to be added. */
	public void addVariable(VariableNode variable) {
		this.vars.add(variable);
	}
	
	public ArrayList<VariableNode> getVariables() {
		return vars;
	}
	
	/** Creates a String representation of this node.
	 * @param level The tree level at which this node resides.
	 * @return A String representing this node. */
    @Override
    public String indentedToString(int level) {
        String answer = super.indentedToString(level + 1);
        answer += "Declarations: \n";
        for(VariableNode var: this.vars) {
        	answer += var.indentedToString(level + 1);
        }
        return answer;
    }
	
}
