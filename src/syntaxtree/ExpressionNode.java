package syntaxtree;

import scan.TokenType;

/** Represents a node in the syntax tree for expressions.
 * @author Juan Carlos Hernandez Puebla */
public abstract class ExpressionNode extends SyntaxTreeNode {
	
	TokenType expressionType;

	public TokenType getExpressionType() {
		return expressionType;
	}

	public void setExpressionType(TokenType expressionType) {
		this.expressionType = expressionType;
	}


}
