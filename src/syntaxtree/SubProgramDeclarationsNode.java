package syntaxtree;

import java.util.ArrayList;

/** Represents a SubProgram Declaration Node in the syntax tree.
 * @author Juan Carlos Hernandez Puebla */
public class SubProgramDeclarationsNode extends SyntaxTreeNode {
	
	// Instance variables
	private ArrayList<SubProgramDeclarationsNode> procs;
	
	/** Default constructor for a SubProgramDeclarationsNode. */
	public SubProgramDeclarationsNode() {
		this.procs = new ArrayList<SubProgramDeclarationsNode>();
	}
	
	public void addProcedures(SubProgramDeclarationsNode procedure) {
		procs.add(procedure);
	}
	
	/** Creates a String representation of this node.
	 * @param level The tree level at which this node resides.
	 * @return A String representing this node. */
    @Override
    public String indentedToString(int level) {
        String answer = super.indentedToString(level + 1);
        answer += "Subprogram declarations: \n";
        for(SubProgramDeclarationsNode subprogram: this.procs) {
        	answer += subprogram.indentedToString(level + 1);
        }
        return (answer);
    }

}
