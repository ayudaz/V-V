package vv.tp3;

import net.sourceforge.pmd.lang.java.ast.ASTWhileStatement;
import net.sourceforge.pmd.lang.java.ast.ASTBooleanLiteral;
import net.sourceforge.pmd.lang.java.rule.AbstractJavaRule;

/**
 * Class who check if the code have some for while loops with a boolean 
 * directly as stop condition.
 * 
 * @author Lelievre Thomas & Leloup Florian
 *
 */
public class WhileLoopsMustNotUseBooleanDirectlyRule extends AbstractJavaRule {

	public Object visit(ASTWhileStatement node, Object data){
		if(node.jjtGetChild(0).hasDescendantOfType(ASTBooleanLiteral.class)){
			addViolation(data, node);
		}
		return super.visit(node, data);
	}
}
