/**
 * 
 */
package test;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

import system.PhonyArrayList;

/**
 * Test case of the two Add methods of PhonyArrayList 
 * @author Thomas LELIEVRE - Anthony LE MEE (13000170 - 10003134)
 * @since 20/09/2013
 *
 */
public class TestPhonyArrayListAdd {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	/** Attributs de la classe */
	private PhonyArrayList<Object> pal;
	private PhonyArrayList<Object> pal2;
	private PhonyArrayList<Object> pal3;
	
	/**
	 * Executed before each test
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		pal = new PhonyArrayList<Object>();
		pal2 = new PhonyArrayList<Object>(1);
		pal2.add("Toto");
		pal3 = new PhonyArrayList<Object>(1);
		pal3.add("Toto");
		pal3.add("Titi");
	}
	
	/**
	 * Tests the "Add" method when add at a negative position.
	 * @see lemee-lelievre.PhonyArrayList#add(int, E)
	 * @type
	 * @input
	 * @oracle
	 * @passed Yes
	 */
	@Test
	public void testAddEmptyListAtNegativePosition() {
		int index = -1;
		Object obj = "Toto";
		thrown.expect(IndexOutOfBoundsException.class);
		thrown.expectMessage("Index: " + index + ", Size: " + pal.size());
		pal.add(index, obj);	
	}
	
	/**
	 * Tests the "Add" method when add at a position greater than the size of
	 * the list.
	 * @see lemee-lelievre.PhonyArrayList#add(int, E)
	 * @type
	 * @input
	 * @oracle
	 * @passed yes
	 */
	@Test
	public void testAddEmptyListAtOutOfListPosition() {
		int index = 1;
		Object obj = "Toto";
		thrown.expect(IndexOutOfBoundsException.class);
		thrown.expectMessage("Index: " + index + ", Size: " + pal.size());
		pal.add(index, obj);
	}
	
	/**
	 * Tests the "Add" method when add object in an empty list at the first 
	 * position. 
	 * @see lemee-lelievre.PhonyArrayList#add(int, E)
	 * @type
	 * @input
	 * @oracle
	 * @passed no
	 * <pre>
	 * l.319
	 * - size++;
	 * + elementData[index] = element;size++;
	 * </pre>
	 */
	@Test
	public void testAddEmptyList() {
		int index = 0;
		Object obj = "Toto";
		assertTrue(pal.size() == 0);
		pal.add(index, obj);
		assertTrue(pal.size() == 1);
		assertEquals(pal.get(index), obj);
	}
	
	/**
	 * Tests the "Add" method when add object in a list of one element at the
	 * first position. 
	 * @see lemee-lelievre.PhonyArrayList#add(int, E)
	 * @type
	 * @input
	 * @oracle
	 * @passed yes
	 */
	@Test
	public void testAddFirstPositionListWithOneElement() {
		int index = 0;
		Object obj = "Titi";
		assertTrue(pal2.size() == 1);
		pal2.add(index, obj);
		assertTrue(pal2.size() == 2);
		assertEquals(pal2.get(index), obj);
	}
	
	/**
	 * Tests the "Add" method when add object in a list of one element at the
	 * end of the list. 
	 * @see lemee-lelievre.PhonyArrayList#add(int, E)
	 * @type
	 * @input
	 * @oracle
	 * @passed yes
	 */
	@Test
	public void testAddEndPositionListWithOneElement() {
		int index = 1;
		Object obj = "Titi";
		assertTrue(pal2.size() == 1);
		pal2.add(index, obj);
		assertTrue(pal2.size() == 2);
		assertEquals(pal2.get(index), obj);
	}
	
	/**
	 * Tests the "Add" method when add object in a list of two element at the
	 * first position. 
	 * @see lemee-lelievre.PhonyArrayList#add(int, E)
	 * @type
	 * @input
	 * @oracle
	 * @passed yes
	 */
	@Test
	public void testAddFirstPositionListWithTwoElement() {
		int index = 0;
		Object obj = "Tata";
		assertTrue(pal3.size() == 2);
		pal3.add(index, obj);
		assertTrue(pal3.size() == 3);
		assertEquals(pal3.get(index), obj);
	}
	
	/**
	 * Tests the "Add" method when add object in a list of two element at the
	 * middle position. 
	 * @see lemee-lelievre.PhonyArrayList#add(int, E)
	 * @type
	 * @input
	 * @oracle
	 * @passed yes
	 */
	@Test
	public void testAddMiddlePositionListWithTwoElement() {
		int index = 1;
		Object obj = "Tata";
		assertTrue(pal3.size() == 2);
		pal3.add(index, obj);
		assertTrue(pal3.size() == 3);
		assertEquals(pal3.get(index), obj);
	}
	
	/**
	 * Tests the "Add" method when add object in a list of two element at the
	 * end position. 
	 * @see lemee-lelievre.PhonyArrayList#add(int, E)
	 * @type
	 * @input
	 * @oracle
	 * @passed yes
	 */
	@Test
	public void testAddEndPositionListWithTwoElement() {
		int index = 2;
		Object obj = "Tata";
		assertTrue(pal3.size() == 2);
		pal3.add(index, obj);
		assertTrue(pal3.size() == 3);
		assertEquals(pal3.get(index), obj);
	}
}