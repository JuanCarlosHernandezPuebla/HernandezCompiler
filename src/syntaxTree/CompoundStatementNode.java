package syntaxTree;

import java.util.ArrayList;

/** Represents a Compound Statement Node in the syntax tree.  
 * @author Juan Carlos Hernandez Puebla */
public class CompoundStatementNode extends StatementNode {
	
	// Instance variable
	private ArrayList<StatementNode> statements;
	
	/** Creates a CompoundStatementNode. */
	public CompoundStatementNode(ArrayList<StatementNode> statements) {
		this.statements = statements;
	}
	
    /** Creates a String representation of this node.
     * @param level The tree level at which this node resides.
     * @return A String representing this node. */
    @Override
    public String indentedToString(int level) {
        String answer = super.indentedToString(level);
        answer += "Compound statement: " + this.statements + "\n";
        return(answer);
    }

}
