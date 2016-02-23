package syntaxTree;

/** Represents an Assignment Statement Node in the syntax tree.
 * @author Juan Carlos Hernandez Puebla */
public class AssignmentStatementNode extends StatementNode {
	
	// Instance variables
	private VariableNode lvalue;
	private ExpressionNode expression;
	
	/** Default constructor for a AssignmentStatementNode. */
	public AssignmentStatementNode() {
		
	}
	
    /** Creates a String representation of this node.
     * @param level The tree level at which this node resides.
     * @return A String representing this node. */
    @Override
    public String indentedToString(int level) {
        String answer = super.indentedToString(level);
        answer += "Assignment statement: " + this.lvalue + "\n";
        answer += expression.indentedToString(level + 1);
        return(answer);
    }

}
