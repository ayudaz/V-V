package simpleGame.core;

import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import simpleGame.core.Board;

/**
 * Test Class for the verification of compliance with
 * the UML sequence diagram.
 * @author Lelievre Thomas & Leloup Florian
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class TestSequenceDiagram {
	
	@Mock
	private Board bo;
	@InjectMocks
	private Game g;
	@Mock
	private Pawn p1;
	@Mock 
	private Pawn p2;
	@InjectMocks
	private Board bo2 = new Board(10, 10, 0, 0);
	
	/**
	 * Integration test of the numberOfPawns method.
	 * We verify that the call of isGameOver on a Game
	 * call once the method numberOfPawns & maxGold.
	 * @type Integration
	 * @input No
	 * @oracle Must return "true"
	 * @passed Yes 
	 */
	@Test
	public void testNumberOfPawns(){
		when(bo.maxGold()).thenReturn(3);
		when(bo.numberOfPawns()).thenReturn(2);
		assertTrue(g.isGameOver());
		verify(bo, times(1)).numberOfPawns();
		verify(bo, times(1)).maxGold();
	}
	
	/**
	 * Integration test for MaxGold method.
	 * We verify that the call of maxGold call
	 * once getGold on each pawn added to the board.
	 * @type Integration
	 * @input No
	 * @oracle Must return "true"
	 * @passed Yes
	 */
	@Test
	public void testMaxGold(){
		when(p1.getX()).thenReturn(0);
		when(p1.getY()).thenReturn(0);
		when(p2.getX()).thenReturn(3);
		when(p2.getY()).thenReturn(3);
		when(p1.getGold()).thenReturn(1);
		when(p2.getGold()).thenReturn(3);
		bo2.addPawn(p1);
		bo2.addPawn(p2);
		assertEquals(bo2.maxGold(), 3);
		verify(p1, times(1)).getGold();
		verify(p2, times(1)).getGold();
	}
}
