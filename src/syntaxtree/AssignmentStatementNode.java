package syntaxtree;

/** Represents an Assignment Statement Node in the syntax tree.
 * @author Juan Carlos Hernandez Puebla */
public class AssignmentStatementNode extends StatementNode {
	
	// Instance variables
	private VariableNode lvalue;
	private ExpressionNode expression;
	
	/** Default constructor for a AssignmentStatementNode. */
	public AssignmentStatementNode(VariableNode variable, ExpressionNode expression) {
		this.lvalue = variable;
		this.expression = expression;
	}
	
    /** Creates a String representation of this node.
     * @param level The tree level at which this node resides.
     * @return A String representing this node. */
    @Override
    public String indentedToString(int level) {
        String answer = super.indentedToString(level + 1);
        answer += "Assignment statement: \n" + this.lvalue.indentedToString(level + 1);
        answer += expression.indentedToString(level + 1);
        return(answer);
    }
    
}
