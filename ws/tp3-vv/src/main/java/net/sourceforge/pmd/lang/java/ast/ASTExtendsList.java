/* Generated By:JJTree: Do not edit this line. ASTExtendsList.java */

package net.sourceforge.pmd.lang.java.ast;

public class ASTExtendsList extends AbstractJavaNode {
    public ASTExtendsList(int id) {
        super(id);
    }

    public ASTExtendsList(JavaParser p, int id) {
        super(p, id);
    }


    /**
     * Accept the visitor. *
     */
    public Object jjtAccept(JavaParserVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }
}
