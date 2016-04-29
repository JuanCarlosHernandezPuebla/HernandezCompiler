package syntaxtree;

public class IfNode extends StatementNode {
	
	private ExpressionNode test;
	private StatementNode thenStatement;
	private StatementNode elseStatement;
	
	public IfNode() {
		
	}

	public ExpressionNode getTest() {
		return test;
	}

	public void setTest(ExpressionNode test) {
		this.test = test;
	}

	public StatementNode getThenStatement() {
		return thenStatement;
	}

	public void setThenStatement(StatementNode thenStatement) {
		this.thenStatement = thenStatement;
	}

	public StatementNode getElseStatement() {
		return elseStatement;
	}

	public void setElseStatement(StatementNode elseStatement) {
		this.elseStatement = elseStatement;
	}
	
    @Override
    public String indentedToString(int level) {
        String answer = super.indentedToString(level + 1);
        answer += "If: \n" + this.test.indentedToString(level + 1);
        answer += thenStatement.indentedToString(level + 1);
        answer += elseStatement.indentedToString(level + 1);
        return(answer);
    }
	
}
