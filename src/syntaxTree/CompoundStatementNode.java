package syntaxTree;

import java.util.ArrayList;

/** Represents a Compound Statement Node in the syntax tree.  
 * @author Juan Carlos Hernandez Puebla */
public class CompoundStatementNode extends StatementNode {
	
	// Instance variable
	private ArrayList<StatementNode> statements;
	
	/** Creates a CompoundStatementNode. */
	public CompoundStatementNode() {
		this.statements = new ArrayList<StatementNode>();
	}
	
	/** Adds a statement to the array list of StatementNodes.
	 * @param statement The StatementNode to be added. */
	public void addStatement(StatementNode statement) {
		this.statements.add(statement);
	}
	
    /** Creates a String representation of this node.
     * @param level The tree level at which this node resides.
     * @return A String representing this node. */
    @Override
    public String indentedToString(int level) {
        String answer = super.indentedToString(level + 1);
        answer += "Compound statement: \n";
        for(StatementNode statement: this.statements) {
        	answer += statement.indentedToString(level + 1);
        }
        return(answer);
    }
    
}
