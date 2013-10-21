package simpleGame.core;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class of the Board class.
 * 
 * @author Lelievre Thomas & Leloup Florian
 *
 */
public class BoardTest {
	
	private Board board;
	private Pawn p1;
	private Pawn p2;
	private Pawn p3;
	private Pawn p4;
	
	/**
	 * Create a board (10x10) with 4 pawn for all test.
	 */
	@Before
	public void setUp() {
		board = new Board(4, 10, 10);
		p1 = board.getNextPawn();
		p2 = board.getNextPawn();
		p3 = board.getNextPawn();
		p4 = board.getNextPawn();
	}

	/**
	 * Test construtor.
	 * @type Functional
	 * @input No
	 * @oracle Must return "true"
	 * @passed No
	 * @correction
	 * <pre>
	 * l.76
	 * - Pawn pawn = new Pawn(Character.forDigit(i, 10),
	 * - 						random.nextInt(xSize),random.nextInt(ySize),this);
	 * 
	 * + Pawn pawn;
     * + 	do{
     * +  		pawn = new Pawn(Character.forDigit(i, 10),
     * +                        random.nextInt(xSize),random.nextInt(ySize),this);
     * +  	}while(this.getSquareContent(pawn.getX(), pawn.getY()) != null);
	 * </pre>
	 **/
	@Test
	public void testConstructeurBoard() {
		int xSize = 5, ySize = 5, nbPawn = 5;
		Board b = new Board(nbPawn, xSize, ySize);
		assertEquals(b.getXSize(), xSize);
		assertEquals(b.getYSize(), ySize);
		assertEquals(b.numberOfPawns(), nbPawn);
		// There only one bonus square
		int nbBonus = 0;
		for(int x = 0 ; x < xSize ; x++ ){
			for(int y = 0 ; y < ySize ; y++){
				if(b.isBonusSquare(x, y)){
					nbBonus++;
				}
			}
		}
		assertEquals(1, nbBonus);
	}
	
	/**
	 * Test the removePawn method.
	 * @type Functional
	 * @input p1
	 * @oracle Must return "true"
	 * @passed Yes
	 */
	@Test
	public void testRemovePawn(){
		assertEquals(4, board.numberOfPawns());
		board.removePawn(p1);
		assertEquals(3, board.numberOfPawns());
	}
	
	/**
	 * Test the getSquareContent method.
	 * @type Functional
	 * @input No
	 * @oracle Must return "true"
	 * @passed Yes
	 **/
	@Test
	public void testGetSquareContent() {
		// getSquareContent on a pawn position.
		Pawn p = board.getSquareContent(p1.getX(), p1.getY());
		assertNotNull(p);
		
		// getSquareContent on a square with no pawn
		board.removePawn(p1);
		p = board.getSquareContent(p1.getX(), p1.getX());
		assertNull(p);
	}

}
