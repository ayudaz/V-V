/* Generated By:JJTree: Do not edit this line. ASTAndExpression.java */

package net.sourceforge.pmd.lang.java.ast;

public class ASTAndExpression extends AbstractJavaTypeNode {
    public ASTAndExpression(int id) {
        super(id);
    }

    public ASTAndExpression(JavaParser p, int id) {
        super(p, id);
    }


    /**
     * Accept the visitor. *
     */
    public Object jjtAccept(JavaParserVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }
}
