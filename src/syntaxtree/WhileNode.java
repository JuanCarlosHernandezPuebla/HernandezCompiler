package syntaxtree;

public class WhileNode extends StatementNode {
	
	private ExpressionNode test;
	private StatementNode doStatement;
	
	public WhileNode() {
		
	}
	
	public ExpressionNode getTest() {
		return test;
	}
	public void setTest(ExpressionNode test) {
		this.test = test;
	}
	public StatementNode getDoStatement() {
		return doStatement;
	}
	public void setDoStatement(StatementNode doStatement) {
		this.doStatement = doStatement;
	}
	
    @Override
    public String indentedToString( int level) {
        String answer = super.indentedToString(level + 1);
        answer += "While: \n" + this.test.indentedToString(level + 1);
        answer += doStatement.indentedToString(level + 1);
        return(answer);
    }

}
