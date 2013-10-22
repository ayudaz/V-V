/**
 * 
 */
package simpleGame.exception;

/**
 * Exception class when the Board is impossible to create.
 * 
 * @author Lelievre Thomas & Leloup Florian
 *
 */
public class ImpossibleBoardException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1366614881381308204L;

	/**
	 * 
	 */
	public ImpossibleBoardException() {
		super("Board construction is impossible !");
	}

}
