package vv.tp3;

import net.sourceforge.pmd.lang.java.ast.*;
import net.sourceforge.pmd.lang.java.rule.AbstractJavaRule;

/**
 * Class who check if the code have some for loops nested.
 * 
 * @author Lelievre Thomas & Leloup Florian
 *
 */
public class ForLoopsMustNotBeNested extends AbstractJavaRule {

	public Object visit(ASTForStatement node, Object data){
		if(node.hasDescendantOfType(ASTForStatement.class)){
			addViolation(data, node);
		}
		return super.visit(node, data);
	}
}
