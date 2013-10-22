package simpleGame.core;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import simpleGame.exception.ImpossibleBoardException;
import simpleGame.exception.OutOfBoardException;

/**
 * Test class of the Board class.
 * 
 * @author Lelievre Thomas & Leloup Florian
 *
 */
public class BoardTest {
	
	private Board board;
	private ArrayList<Pawn> listPawn;
	private Pawn p1;
	private Pawn p2;
	private Pawn p3;
	private Pawn p4;
	private int xSize, ySize, xBonus, yBonus;
	
	/**
	 * Create a board (10x10) with 4 pawn for all test.
	 */
	@Before
	public void setUp() {
		xSize = 10;
		ySize = 10;
		xBonus = 5;
		yBonus = 5;
		listPawn = new ArrayList<Pawn>();
		board = new Board(listPawn, xSize, ySize, xBonus, yBonus);
		p1 = new Pawn('A', 0, 0, board);
		board.addPawn(p1);
		p2 = new Pawn('B', 2, 3, board);
		board.addPawn(p2);
		p3 = new Pawn('C', 1, 0, board);
		board.addPawn(p3);
		p4 = new Pawn('D', 5, 8, board);
		board.addPawn(p4);
	}

	/**
	 * Test constructor of board with generated pawns.
	 * @type Functional
	 * @input No
	 * @oracle Must return "true"
	 * @passed No
	 * @correction
	 * <pre>
	 * l.94
	 * +  * @throws ImpossibleBoardException
	 * l.97
	 * - int sizeY) {
	 * + int sizeY) throws ImpossibleBoardException {
	 * l.104
	 * + if(numberOfPawns > sizeX*sizeY){
       + 	throw new ImpossibleBoardException();
       + }
	 * l.108
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
		int xSize = 5, ySize = 10, nbPawn = 5;
		Board b;
		try {
			b = new Board(nbPawn, xSize, ySize);
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
		} catch (ImpossibleBoardException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	/**
	 * Test the Board constructor with a list of pawns, a size and 
	 * bonus position.
	 * @type Functional
	 * @input p1
	 * @oracle Must return "true"
	 * @passed Yes
	 */
	@Test
	public void testConstructorBoardListPawn() {
		assertEquals(listPawn, board.getPawns());
		assertEquals(xSize, board.getXSize());
		assertEquals(ySize, board.getYSize());
		assertEquals(xBonus, board.getxBonusSquare());
		assertEquals(yBonus, board.getyBonusSquare());
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
		// remove pawn who are on the board
		assertEquals(4, board.getPawns().size());
		assertTrue(board.getPawns().contains(p1));
		board.removePawn(p1);
		assertEquals(3, board.getPawns().size());
		assertFalse(board.getPawns().contains(p1));
		// remove pawn who are not on the board
		board.removePawn(p1);
		assertEquals(3, board.getPawns().size());
		assertFalse(board.getPawns().contains(p1));
	}
	
	/**
	 * Test the getSquareContent method on a pawn position.
	 * @type Functional
	 * @input No
	 * @oracle Must return "true"
	 * @passed Yes
	 **/
	@Test
	public void testGetSquareContentPawn() {
		assertTrue(board.getPawns().contains(p1));
		Pawn p = board.getSquareContent(p1.getX(), p1.getY());
		assertNotNull(p);
		assertEquals(p, p1);
	}
	
	/**
	 * Test the getSquareContent method on a square with no pawn
	 * @type Functional
	 * @input No
	 * @oracle Must return "true"
	 * @passed Yes
	 **/
	@Test
	public void testGetSquareContentNoPawn() {
		board.removePawn(p1);
		assertFalse(board.getPawns().contains(p1));
		Pawn p = board.getSquareContent(p1.getX(), p1.getX());
		assertNull(p);
	}
	
	/**
	 * Test the addPawn method on a non-empty square. the added pawn
	 * must not be add.
	 * @type Functional
	 * @input No
	 * @oracle Must return "true"
	 * @passed Yes
	 */
	@Test
	public void testAddPawnNonEmptySquare(){
		assertEquals(board.getPawns().size(), 4);
		assertTrue(board.getPawns().contains(p1));
		Pawn p = new Pawn('T', p1.getX(), p1.getY(), board);
		board.addPawn(p);
		assertEquals(board.getPawns().size(), 4);
		assertTrue(board.getPawns().contains(p1));
		assertFalse(board.getPawns().contains(p));
	}
	
	/**
	 * Test the addPawn method on an empty square. the added pawn must
	 * be add.
	 * @type Functional
	 * @input No
	 * @oracle Must return "true"
	 * @passed Yes
	 */
	@Test
	public void testAddPawnEmptySquare(){
		assertEquals(board.numberOfPawns(), 4);
		// find an empty square
		for (int x = 0; x < board.getXSize(); x++) {
			for (int y = 0; y < board.getYSize(); y++) {
				if(board.getSquareContent(x, y) == null){
					//add a new pawn on the empty square.
					board.addPawn(new Pawn('T', x, y, board));
					assertEquals(board.numberOfPawns(), 5);
					return;
				}
			}
		}
		fail("Empty square not found on the board");
	}
	
	/**
	 * Test the getNextPawn method with a board who contain only one
	 * pawn. this method must return the pawn every time.
	 * @type Functional
	 * @input No
	 * @oracle Must return "true"
	 * @passed Yes
	 */
	@Test
	public void testGetNextPawnWithOnePawn(){
		ArrayList<Pawn> l = new ArrayList<Pawn>(1);
		l.add(p1);
		board = new Board(l, 10, 10, 0, 0);
		assertEquals(board.getPawns().size(), 1);
		assertTrue(board.getPawns().contains(p1));
		// the current pawn on starting must be p1
		assertEquals(board.getCurrentPawn(), p1);
		// the method getNewPawn must return p1 as next pawn
		assertEquals(board.getNextPawn(), p1);
		// the currentPawn attribute must stay p1
		assertEquals(board.getCurrentPawn(), p1);
	}
	
	/**
	 * Tests the getNextPawn method with a board who contain 4 pawn.
	 * this method must return alternatively each pawn in the same
	 * order than in the listPawn who create the board.
	 * @type Functional
	 * @input No
	 * @oracle Must return "true"
	 * @passed Yes
	 */
	@Test
	public void testGetNextPawnWithSomePawn(){
		assertEquals(board.numberOfPawns(), 4);
		// the current pawn must be the first element of listPawn
		assertEquals(board.getCurrentPawn(), listPawn.get(0));
		// the getNextPawn method must return the first element of listPawn
		assertEquals(board.getNextPawn(), listPawn.get(0));
		// the current pawn must be the second element of listPawn
		assertEquals(board.getCurrentPawn(), listPawn.get(1));
		// the getNextPawn method must return the second element of listPawn
		assertEquals(board.getNextPawn(), listPawn.get(1));
		// the current pawn must be the third element of listPawn
		assertEquals(board.getCurrentPawn(), listPawn.get(2));
		// the getNextPawn method must return the third element of listPawn
		assertEquals(board.getNextPawn(), listPawn.get(2));
		// the current pawn must be the fourth element of listPawn
		assertEquals(board.getCurrentPawn(), listPawn.get(3));
		// the getNextPawn method must return the fourth element of listPawn
		assertEquals(board.getNextPawn(), listPawn.get(3));
		// the current pawn must be the first element of listPawn
		assertEquals(board.getCurrentPawn(), listPawn.get(0));
		// the getNextPawn method must return the first element of listPawn
		assertEquals(board.getNextPawn(), listPawn.get(0));
	}
	
	/**
	 * Test the isBonusSquare method.
	 * @type Functional
	 * @input No
	 * @oracle Must return "true"
	 * @passed Yes
	 */
	@Test
	public void testIsBonusSquare(){
		for(int x=0; x<board.getXSize(); x++){
			for(int y=0; y<board.getYSize(); y++){
				if(x == xBonus && y == yBonus){
					assertTrue(board.isBonusSquare(x, y));
				}
				else{
					assertFalse(board.isBonusSquare(x, y));
				}
			}
		}
	}
	
	/**
	 * Test the SquareContentSprite method.
	 * @type Functional
	 * @input No
	 * @oracle Must return "true"
	 * @passed Yes
	 **/
	@Test
    public void testSquareContentSprite() {
		//Test with pawn equals to the pawn of the board
		Pawn currentPawn = board.getCurrentPawn();
		char returnValue = board.squareContentSprite(currentPawn.getX(),currentPawn.getY());
		assertEquals('c', returnValue);
		
		board.removePawn(currentPawn);
		returnValue = board.squareContentSprite(currentPawn.getX(),currentPawn.getY());
		assertEquals('.', returnValue);
		
		//Test with a random pawn of the board
		returnValue = board.squareContentSprite(p2.getX(), p2.getY());
		char pawnName = p2.getLetter();
		assertEquals(returnValue, pawnName);
		
		//Test the bonus square
		assertEquals('#', board.squareContentSprite(xBonus, yBonus));
		
		//Test empty square
		assertEquals('.',board.squareContentSprite(4, 4));
    }
	
	/**
	 * Test the numberOfPawns method.
	 * @type Functional
	 * @input No
	 * @oracle Must return "true"
	 * @passed Yes
	 **/
	@Test
	public void testNumberOfPawns(){
		assertEquals(4, board.numberOfPawns());
		board.removePawn(p1);
		assertEquals(3, board.numberOfPawns());
		board.removePawn(p2);
		assertEquals(2, board.numberOfPawns());
		board.removePawn(p3);
		assertEquals(1, board.numberOfPawns());		
		board.removePawn(p4);
		assertEquals(0, board.numberOfPawns());
		board.addPawn(p1);
		assertEquals(1,board.numberOfPawns());
	}

	/**
	 * Test maxGold method.
	 * @type Functional
	 * @input No
	 * @oracle Must return "true"
	 * @passed Yes
	 **/
	@Test
	public void testMaxGold(){
		Pawn p = new Pawn('X', 2, 0, board);
		board.addPawn(p);

		Pawn p2 = new Pawn('Y', 3, 0, board);
		board.addPawn(p2);
		
		assertEquals(0, board.maxGold());
		
		try {
			p.move(Direction.Right);
			p.move(Direction.Left);
			p.move(Direction.Right);
			p.move(Direction.Left);
			p.move(Direction.Right);
			p.move(Direction.Left);
			p.move(Direction.Right);
			p.move(Direction.Left);
			p.move(Direction.Right);
			p.move(Direction.Left);
		} catch (OutOfBoardException e) {
			e.printStackTrace();
		}
		
		assertEquals(1, board.maxGold());
	}
	
	/**
	 * Test the toString method.
	 * @type Functional
	 * @input No
	 * @oracle Must return "true"
	 * @passed Yes
	 **/
	public void testToString(){
		assertNotNull(board.toString());
	}
}
