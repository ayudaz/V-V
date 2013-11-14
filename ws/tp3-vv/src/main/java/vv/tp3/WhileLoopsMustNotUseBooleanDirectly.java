package vv.tp3;

import net.sourceforge.pmd.lang.java.ast.ASTWhileStatement;
import net.sourceforge.pmd.lang.java.ast.ASTBooleanLiteral;
import net.sourceforge.pmd.lang.java.rule.AbstractJavaRule;

public class WhileLoopsMustNotUseBooleanDirectly extends AbstractJavaRule {

	public Object visit(ASTWhileStatement node, Object data){
		if(node.jjtGetChild(0).hasDescendantOfType(ASTBooleanLiteral.class)){
			addViolation(data, node);
		}
		return super.visit(node, data);
	}
}
