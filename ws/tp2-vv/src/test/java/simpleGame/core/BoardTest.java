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
		board = new Board(0, 10, 10);
		p1 = new Pawn('A', 0, 0, board);
		p2 = new Pawn('B', 5, 5, board);
		p3 = new Pawn('C', 3, 6, board);
		p4 = new Pawn('D', 1, 8, board);
		board.addPawn(p1);
		board.addPawn(p2);
		board.addPawn(p3);
		board.addPawn(p4);
	}

	/**
	 * Test construtor.
	 * @type Functional
	 * @input No
	 * @oracle Must return "true"
	 * @passed Yes
	 **/
	@Test
	public void testConstructeurBoard() {
		int xSize = 10, ySize = 20, nbPawn = 5;
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
	 * Test the GetContentSquare method.
	 * @type Functional
	 * @input No
	 * @oracle Must return "true"
	 * @passed Yes
	 **/
	@Test
	public void testGetContentSquare() {
		
	}

}
