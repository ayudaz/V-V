package vv.tp3;

import net.sourceforge.pmd.lang.ast.Node;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTBreakStatement;
import net.sourceforge.pmd.lang.java.ast.ASTBooleanLiteral;
import net.sourceforge.pmd.lang.java.ast.ASTReturnStatement;
import net.sourceforge.pmd.lang.java.ast.ASTWhileStatement;
import net.sourceforge.pmd.lang.java.rule.AbstractJavaRule;

/**
 * Class who check if the code have some for while loops with a boolean 
 * directly as stop condition without an escape with 'return' or 'break'.
 * 
 * @author Lelievre Thomas & Leloup Florian
 *
 */
public class WhileLoopsMustNotUseBooleanDirectlyWithoutEscapeRule extends
		AbstractJavaRule {
	
	public Object visit(ASTWhileStatement node, Object data){
		Node expression = node.jjtGetChild(0);
		Node statement = node.jjtGetChild(1);
		if(expression.hasDescendantOfType(ASTBooleanLiteral.class)){
			if(!statement.hasDescendantOfType(ASTBreakStatement.class) && 
					!statement.hasDescendantOfType(ASTReturnStatement.class)){
				addViolation(data, node);
			}
		}
		return super.visit(node, data);
	}
}
