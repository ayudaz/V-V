package simpleGame.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import simpleGame.exception.OutOfBoardException;
import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
public class PawnTestStub{
	
	@Mock // This annotation declares a mock attribute
	private Board board;
	private Pawn pawn;
	
	@Before
	public void setUp() {
		pawn = new Pawn('L', 0, 0, board);
		
	}
	
	@Test
	public final void testPawn() {
		assertNotNull(pawn);
		assertEquals(pawn.getX(), 0);
		assertEquals(pawn.getY(), 0);
		assertEquals(pawn.getGold(), 0);
		assertEquals(pawn.getLetter(), 'L');
	}

	@Test
	/**
	* Tests the "move" method normal behavior.
	* @see project.Pawn#move(Direction)
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
	public final void testMove() {
		when(board.getXSize()).thenReturn(10);
		when(board.getYSize()).thenReturn(10);
		when(board.getSquareContent(0,1)).thenReturn(null);
		try {
			pawn.move(Direction.Up);
		} catch (OutOfBoardException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		assertEquals(pawn.getX(), 0);
		assertEquals(pawn.getY(), 1);
	}
	
	@Test
	public final void testMoveAttack() {
		Pawn pawnDead = new Pawn('C', 0, 1, board);
		when(board.getXSize()).thenReturn(10);
		when(board.getYSize()).thenReturn(10);
		when(board.getSquareContent(0,1)).thenReturn(pawnDead);
		when(board.isBonusSquare(0, 1)).thenReturn(false);
		try {
			pawn.move(Direction.Up);
		} catch (OutOfBoardException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		assertEquals(pawn.getX(), 0);
		assertEquals(pawn.getY(), 1);
	}
	
	@Test(expected=OutOfBoardException.class)
	public final void testMoveWithException() throws OutOfBoardException {
		when(board.getXSize()).thenReturn(10);
		when(board.getYSize()).thenReturn(10);
		when(board.getSquareContent(0,-1)).thenReturn(null);
		
		pawn.move(Direction.Down);		
	}

	@Test
	public final void testIsDead() {
		fail("Not yet implemented"); // TODO
	}

}
