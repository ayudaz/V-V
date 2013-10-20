package simpleGame.core;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import simpleGame.exception.OutOfBoardException;
import static org.mockito.Mockito.*;

/**
 * Test class for the Pawn class with a stub of the Board class.
 * 
 * @author Lelievre Thomas & Leloup Florian
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class PawnStubTest {

	@Mock	// This annotation declares a mock attribute
	private Board board;
	private Pawn pawn;

	/**
	 * Create a pawn for all test.
	 */
	@Before
	public void setUp() {
		pawn = new Pawn('L', 0, 0, board);

	}
	
	
	/**
	 * Test construtor.
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
	 * @passed No
	 * @correction
	 * <pre>
	 * l.105
	 * -  && newy > 0
	 * +  && newy >= 0
	 *
	 * l.106
	 * -  && newx > 0
	 * +  && newx >= 0
	 * </pre>
	 */
	@Test
	public final void testMoveUp() {
		when(board.getXSize()).thenReturn(10);
		when(board.getYSize()).thenReturn(10);
		when(board.getSquareContent(0, 1)).thenReturn(null);
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
	 * @passed No
	 */
	@Test
	public final void testMoveRight() {
		when(board.getXSize()).thenReturn(10);
		when(board.getYSize()).thenReturn(10);
		when(board.getSquareContent(0, 1)).thenReturn(null);
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
	 * @passed No
	 */
	@Test
	public final void testMoveLeft() {
		when(board.getXSize()).thenReturn(10);
		when(board.getYSize()).thenReturn(10);
		when(board.getSquareContent(0, 1)).thenReturn(null);
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
		when(board.getXSize()).thenReturn(10);
		when(board.getYSize()).thenReturn(10);
		when(board.getSquareContent(0, -1)).thenReturn(null);
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
		when(board.getXSize()).thenReturn(10);
		when(board.getYSize()).thenReturn(10);
		when(board.getSquareContent(-1, 0)).thenReturn(null);
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
	 * @passed No
	 * @correction
	 * <pre>
	 * l.103
	 * - if(newy <= board.getYSize()
	 * + if(newy < board.getYSize()
	 * </pre>
	 */
	@Test(expected = OutOfBoardException.class)
	public final void testMoveUpWithException() throws OutOfBoardException {
		when(board.getXSize()).thenReturn(1);
		when(board.getYSize()).thenReturn(1);
		when(board.getSquareContent(0, 1)).thenReturn(null);
		pawn.move(Direction.Up);
	}
	
	/**
	 * Tests the "move" method with an OutOfBoardException with a right
	 * move.
	 * @throws OutOfBoardException 
	 * @see Pawn#move(Direction)
	 * @type Functional
	 * @input Direction.Right
	 * @oracle Must return "OutOfBoardException"
	 * @passed No
	 * @correction
	 * <pre>
	 * l.104
	 * - && newx <= board.getXSize()
	 * + && newx < board.getXSize()
	 * </pre>
	 */
	@Test(expected = OutOfBoardException.class)
	public final void testMoveRightWithException() throws OutOfBoardException {
		when(board.getXSize()).thenReturn(1);
		when(board.getYSize()).thenReturn(1);
		when(board.getSquareContent(1, 0)).thenReturn(null);
		pawn.move(Direction.Right);
	}
	
	/**
	 * Tests the "move" method with a pawn on the case we want to move-on.
	 * @see Pawn#move(Direction)
	 * @type Functional
	 * @input Direction.Up
	 * @oracle Must return "true"
	 * @passed No
	 * @correction
	 * <pre>
	 * l.113
	 * +  x = newx;
	 *
	 * l.114
	 * + y = newy;
	 * </pre>
	 */
	@Test
	public final void testMoveAttack() {
		Pawn pawnDead = new Pawn('C', 0, 1, board);
		when(board.getXSize()).thenReturn(10);
		when(board.getYSize()).thenReturn(10);
		when(board.getSquareContent(0, 1)).thenReturn(pawnDead);
		when(board.isBonusSquare(0, 1)).thenReturn(false);
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
	 * @passed No
	 * @correction
	 * <pre>
	 * l.58
	 * - * Creates a Pawn with 2 hitpoints and 0 gold.
	 * + * Creates a Pawn with 5 hitpoints and 0 gold.
	 * 
	 * l.69
	 * - this.hitpoints = 2;
	 * + this.hitpoints = 5;
	 * </pre>
	 */
	@Test
	public final void testMoveAttackBonus() {
		Pawn pawnDead = new Pawn('C', 0, 1, board);
		when(board.getXSize()).thenReturn(10);
		when(board.getYSize()).thenReturn(10);
		when(board.getSquareContent(0, 1)).thenReturn(pawnDead);
		when(board.isBonusSquare(0, 1)).thenReturn(true);
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
	 * @passed No
	 * @correction
	 * <pre>
	 * l.165
	 * - return this.hitpoints == 0;
	 * + return this.hitpoints <= 0;
	 * </pre>
	 */
	@Test
	public final void testPawnDead() {
		Pawn pawnDead = new Pawn('C', 0, 1, board);
		when(board.getXSize()).thenReturn(10);
		when(board.getYSize()).thenReturn(10);
		when(board.getSquareContent(0, 1)).thenReturn(pawnDead);
		when(board.isBonusSquare(0, 1)).thenReturn(true);
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
