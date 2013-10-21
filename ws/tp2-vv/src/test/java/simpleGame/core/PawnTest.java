package simpleGame.core;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import simpleGame.exception.OutOfBoardException;

/**
 * Test class for the Pawn class.
 * 
 * @author Lelievre Thomas & Leloup Florian
 *
 */
public class PawnTest {

	private Board board;
	private Board boardPetit;
	private Pawn pawn;
	private Pawn pawn2;

	/**
	 * Create a pawn for all test.
	 */
	@Before
	public void setUp() {
		ArrayList<Pawn> l = new ArrayList<Pawn>();
		ArrayList<Pawn> l2 = new ArrayList<Pawn>();
		board = new Board(l, 10, 10, 0, 1);
		boardPetit = new Board(l2, 1, 1, 0, 0);
		pawn = new Pawn('L', 0, 0, board);
		pawn2 = new Pawn('L', 0, 0, boardPetit);
		board.addPawn(pawn);
		board.addPawn(pawn2);
	}
	
	
	/**
	 * Test constructor.
	 * @type Functional
	 * @input No
	 * @oracle Must return "true"
	 * @passed Yes
	 **/
	@Test
	public final void testPawn() {
		assertNotNull(pawn);
		assertEquals(pawn.getX(), 0);
		assertEquals(pawn.getY(), 0);
		assertEquals(pawn.getGold(), 0);
		assertEquals(pawn.getLetter(), 'L');
	}

	
	/**
	 * Tests the "move" method normal behavior.
	 * @see Pawn#move(Direction)
	 * @type Functional
	 * @input Direction.Up
	 * @oracle Must return "true"
	 * @passed Yes
	 */
	@Test
	public final void testMoveUp() {
		try {
			pawn.move(Direction.Up);
		} catch (OutOfBoardException e) {
			e.printStackTrace();
		}
		assertEquals(pawn.getX(), 0);
		assertEquals(pawn.getY(), 1);
	}

	/**
	 * Tests the "move" method normal behavior.
	 * @see Pawn#move(Direction)
	 * @type Functional
	 * @input Direction.Right
	 * @oracle Must return "true"
	 * @passed Yes
	 */
	@Test
	public final void testMoveRight() {
		try {
			pawn.move(Direction.Right);
		} catch (OutOfBoardException e) {
			e.printStackTrace();
		}
		assertEquals(pawn.getX(), 1);
		assertEquals(pawn.getY(), 0);
	}
	
	/**
	 * Tests the "move" method normal behavior.
	 * @see Pawn#move(Direction)
	 * @type Functional
	 * @input Direction.Left
	 * @oracle Must return "true"
	 * @passed Yes
	 */
	@Test
	public final void testMoveLeft() {
		try {
			pawn.move(Direction.Right);
		} catch (OutOfBoardException e) {
			e.printStackTrace();
		}
		assertEquals(pawn.getX(), 1);
		assertEquals(pawn.getY(), 0);
		try {
			pawn.move(Direction.Left);
		} catch (OutOfBoardException e) {
			e.printStackTrace();
		}
		assertEquals(pawn.getX(), 0);
		assertEquals(pawn.getY(), 0);
	}
	
	/**
	 * Tests the "move" method with an OutOfBoardException with a down
	 * move.
	 * @throws OutOfBoardException 
	 * @see Pawn#move(Direction)
	 * @type Functional
	 * @input Direction.Down
	 * @oracle Must return "OutOfBoardException"
	 * @passed Yes
	 */
	@Test(expected = OutOfBoardException.class)
	public final void testMoveDownWithException() throws OutOfBoardException {
		pawn.move(Direction.Down);
	}
	
	/**
	 * Tests the "move" method with an OutOfBoardException with a left
	 * move.
	 * @throws OutOfBoardException 
	 * @see Pawn#move(Direction)
	 * @type Functional
	 * @input Direction.Left
	 * @oracle Must return "OutOfBoardException"
	 * @passed Yes
	 */
	@Test(expected = OutOfBoardException.class)
	public final void testMoveLeftWithException() throws OutOfBoardException {
		pawn.move(Direction.Left);
	}
	
	/**
	 * Tests the "move" method with an OutOfBoardException with a up
	 * move.
	 * @throws OutOfBoardException 
	 * @see Pawn#move(Direction)
	 * @type Functional
	 * @input Direction.Up
	 * @oracle Must return "OutOfBoardException"
	 * @passed Yes
	 */
	@Test(expected = OutOfBoardException.class)
	public final void testMoveUpWithException() throws OutOfBoardException {
		pawn2.move(Direction.Up);
	}
	
	/**
	 * Tests the "move" method with an OutOfBoardException with a right
	 * move.
	 * @throws OutOfBoardException 
	 * @see Pawn#move(Direction)
	 * @type Functional
	 * @input Direction.Right
	 * @oracle Must return "OutOfBoardException"
	 * @passed Yes
	 */
	@Test(expected = OutOfBoardException.class)
	public final void testMoveRightWithException() throws OutOfBoardException {
		pawn2.move(Direction.Right);
	}
	
	/**
	 * Tests the "move" method with a pawn on the case we want to move-on.
	 * @see Pawn#move(Direction)
	 * @type Functional
	 * @input Direction.Up
	 * @oracle Must return "true"
	 * @passed Yes
	 */
	@Test
	public final void testMoveAttack() {
		Pawn pawnDead = new Pawn('C', 0, 1, board);
		try {
			pawn.move(Direction.Up);
		} catch (OutOfBoardException e) {
			e.printStackTrace();
		}
		assertEquals(pawn.getX(), 0);
		assertEquals(pawn.getY(), 1);
		assertEquals(pawn.getGold(), 0);
		assertEquals(pawnDead.isDead(), false);
	}

	/**
	 * Tests the "move" method with a pawn and a bonus on the case we want to move-on.
	 * @see Pawn#move(Direction)
	 * @type Functional
	 * @input Direction.Up
	 * @oracle Must return "true"
	 * @passed Yes
	 */
	@Test
	public final void testMoveAttackBonus() {
		Pawn pawnDead = new Pawn('C', 0, 1, board);
		try {
			pawn.move(Direction.Up);
		} catch (OutOfBoardException e) {
			e.printStackTrace();
		}
		assertEquals(pawn.getX(), 0);
		assertEquals(pawn.getY(), 1);
		assertEquals(pawn.getGold(), 0);
		assertEquals(pawnDead.isDead(), false);
	}
	
	/**
	 * Tests the "move" method with a pawn and a bonus on the case we want to move-on.
	 * Move three times on the bonus case to kill the pawn on this case.
	 * @see Pawn#move(Direction)
	 * @type Functional
	 * @input Direction.Up
	 * @oracle Must return "true"
	 * @passed Yes
	 */
	@Test
	public final void testPawnDead() {
		Pawn pawnDead = new Pawn('C', 0, 1, board);
		board.addPawn(pawnDead);
		try {
			pawn.move(Direction.Up);
		} catch (OutOfBoardException e) {
			e.printStackTrace();
		}
		assertEquals(pawn.getX(), 0);
		assertEquals(pawn.getY(), 1);
		assertEquals(pawn.getGold(), 0);
		assertEquals(pawnDead.isDead(), false);
		try {
			pawn.move(Direction.Down);
		} catch (OutOfBoardException e) {
			e.printStackTrace();
		}
		assertEquals(pawn.getX(), 0);
		assertEquals(pawn.getY(), 0);
		assertEquals(pawn.getGold(), 0);
		try {
			pawn.move(Direction.Up);
		} catch (OutOfBoardException e) {
			e.printStackTrace();
		}
		assertEquals(pawn.getX(), 0);
		assertEquals(pawn.getY(), 1);
		assertEquals(pawn.getGold(), 0);
		assertEquals(pawnDead.isDead(), false);
		try {
			pawn.move(Direction.Down);
		} catch (OutOfBoardException e) {
			e.printStackTrace();
		}
		assertEquals(pawn.getX(), 0);
		assertEquals(pawn.getY(), 0);
		assertEquals(pawn.getGold(), 0);
		try {
			pawn.move(Direction.Up);
		} catch (OutOfBoardException e) {
			e.printStackTrace();
		}
		assertEquals(pawn.getX(), 0);
		assertEquals(pawn.getY(), 1);
		assertEquals(pawn.getGold(), 1);
		assertEquals(pawnDead.isDead(), true);
	}
}
