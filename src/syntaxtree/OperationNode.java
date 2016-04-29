package syntaxtree;
import scan.TokenType;

/** Represents an Operation Node (+, -, *, or /) in the syntax tree.
 * @author Juan Carlos Hernandez Puebla */
public class OperationNode extends ExpressionNode {
	
	// Instance variables
	
	// The kind of operation
	private TokenType operation;
	// The left operator of this operation
	private ExpressionNode left;
	// The right operator of the operation
	private ExpressionNode right;
	
	/** Creates an Operation Node given an operation token. 
	 * @param op The token representing this node's math operation. */
	public OperationNode(TokenType op) {
		this.operation = op;
	}
	
	// Getters
	
	/** Retrieves the operation type of this node. 
	 * @return the operation of this OperationNode. */
	public TokenType getOperation() {
		return (this.operation);
	}
	
	/** Retrieves the left operator of this node. 
	 * @return the left operator of this OperationNode. */
	public ExpressionNode getLeft() {
		return (this.left);
	}
	
	/** Retrieves the right operator of this node. 
	 * @return the right operator of this OperationNode. */
	public ExpressionNode getRight() {
		return (this.right);
	}

	// Setters
	
	/** Sets the operation value of this this node to what is passed in.
	 * @param operation the new operation type for this node. */
	public void setOperation(TokenType operation) {
		this.operation = operation;
	}

	/** Sets the left operator value of this this node to what is passed in.
	 * @param left The new left operator type for this node. */
	public void setLeft(ExpressionNode left) {
		this.left = left;
	}

	/** Sets the right operator value of this this node to what is passed in.
	 * @param right The new right operator type for this node. */
	public void setRight(ExpressionNode right) {
		this.right = right;
	}
	
	public void attachBottomLeft(ExpressionNode left) {
		OperationNode top = this;
		while(top.getLeft() != null) {
			top = (OperationNode) top.getLeft();	
		}
		top.setLeft(left);
	}

	/** Returns the operation token as a String.
	 * @return The String version of the operation token. */
	@Override
	public String toString() {
		return operation.toString();
	}
	
    /** Creates a String representation of this node.
     * @param level The tree level at which this node resides.
     * @return A String representing this node. */
	@Override
	public String indentedToString(int level) {
		String answer = super.indentedToString(level + 1);
		answer += "Operation: " + this.operation + "\n";
		answer += left.indentedToString(level + 1);
		answer += right.indentedToString(level + 1);
		return(answer);
	}

}
