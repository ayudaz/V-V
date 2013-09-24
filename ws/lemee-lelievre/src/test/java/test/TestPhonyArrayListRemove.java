package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import system.PhonyArrayList;

/**
 * Test Case of the four method :
 * remove(int)
 * remove(object)
 * removeAll(Collection)
 * retainAll(Collection)
 * @author Thomas LELIEVRE - Anthony LE MEE (13000170 - 10003134)
 * @since 23/09/2013
 */
public class TestPhonyArrayListRemove {
	
	private PhonyArrayList<Object> palEmpty;
	private PhonyArrayList<Object> palOneElement;
	private PhonyArrayList<Object> palTwoElement;
	
	private Object objToto;
	private Object objTata;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
		objToto = "Toto";
		objTata = "Tata";
		palEmpty = new PhonyArrayList<Object>();
		palOneElement = new PhonyArrayList<Object>(1);
		palOneElement.add(objToto);
		palTwoElement = new PhonyArrayList<Object>(2);
		palTwoElement.add(objToto);
		palTwoElement.add(objTata);
	}

	/**
	 * Tests remove(0) method when the list is empty.
	 * @see lemee-lelievre.PhonyArrayList#add(int, E)
	 * @type
	 * @input 0
	 * @oracle
	 * @passed Yes
	 */
	@Test
	public final void testRemoveIntWithEmptyListAtZero() {
		int index = 0;
		thrown.expect(IndexOutOfBoundsException.class);
		thrown.expectMessage("Index: " + index + ", Size: " + palEmpty.size());
		palEmpty.remove(index);
	}
	
	/**
	 * Tests remove(-5) method when the list is empty.
	 * @see lemee-lelievre.PhonyArrayList#add(int, E)
	 * @type
	 * @input -5
	 * @oracle
	 * @passed Yes
	 */
	@Test
	public final void testRemoveIntWithEmptyListAtNegative() {
		int index = -5;
		thrown.expect(ArrayIndexOutOfBoundsException.class);
		palEmpty.remove(index);
	}
	
	/**
	 * Tests remove(5) method when the list is empty.
	 * @see lemee-lelievre.PhonyArrayList#add(int, E)
	 * @type
	 * @input 5
	 * @oracle
	 * @passed Yes
	 */
	@Test
	public final void testRemoveIntWithEmptyListAtPostive() {
		int index = 5;
		thrown.expect(IndexOutOfBoundsException.class);
		thrown.expectMessage("Index: " + index + ", Size: " + palEmpty.size());
		palEmpty.remove(index);
	}
	
	/**
	 * Tests remove(int) method on the element of a list of one element.
	 * @see lemee-lelievre.PhonyArrayList#add(int, E)
	 * @type
	 * @input
	 * @oracle
	 * @passed Yes
	 */
	@Test
	public final void testRemoveIntWithOneElementListAtFirstPosition() {
		int index = 0;
		assertTrue(palOneElement.size() == 1);
		Object o = palOneElement.remove(index);
		assertTrue(palOneElement.size() == 0);
		assertEquals(objToto, o);
	}
	
	
	/**
	 * Tests remove(int) method on the first element of a list of two element.
	 * @see lemee-lelievre.PhonyArrayList#add(int, E)
	 * @type
	 * @input
	 * @oracle
	 * @passed Yes
	 */
	@Test
	public final void testRemoveIntWithTwoElementListAtFirstPosition() {
		int index = 0;
		assertTrue(palTwoElement.size() == 2);
		Object o = palTwoElement.remove(index);
		assertTrue(palTwoElement.size() == 1);
		assertEquals(objToto, o);
	}
	
	/**
	 * Tests remove(int) method on the second element of a list of two element.
	 * @see lemee-lelievre.PhonyArrayList#add(int, E)
	 * @type
	 * @input
	 * @oracle
	 * @passed Yes
	 */
	@Test
	public final void testRemoveIntWithTwoElementListAtSecondPosition() {
		int index = 1;
		assertTrue(palTwoElement.size() == 2);
		Object o = palTwoElement.remove(index);
		assertTrue(palTwoElement.size() == 1);
		assertEquals(objTata, o);
	}
	

	/**
	 * Tests remove(object) method on an empty List
	 * @see lemee-lelievre.PhonyArrayList#remove(object)
	 * @type
	 * @input
	 * @oracle
	 * @passed Yes
	 */
	@Test
	public final void testRemoveObjectWithListEmpty() {
		assertTrue(palEmpty.size() == 0);
		assertFalse(palEmpty.contains(objToto));
		palEmpty.remove(objToto);
		assertTrue(palEmpty.size() == 0);
		assertFalse(palEmpty.contains(objToto));
	}
	
	/**
	 * Tests remove(object) method on an one element list with an object who
	 * are not in the list
	 * @see lemee-lelievre.PhonyArrayList#remove(object)
	 * @type
	 * @input
	 * @oracle
	 * @passed Yes
	 */
	@Test
	public final void testRemoveObjectNotInOneElementList() {
		assertTrue(palOneElement.size() == 1);
		assertTrue(palOneElement.contains(objToto));
		assertFalse(palOneElement.contains(objTata));
		palEmpty.remove(objTata);
		assertTrue(palOneElement.size() == 1);
		assertTrue(palOneElement.contains(objToto));
		assertFalse(palOneElement.contains(objTata));
	}
	
	/**
	 * Tests remove(object) method on an one element list with an object who
	 * are in the list
	 * @see lemee-lelievre.PhonyArrayList#remove(object)
	 * @type
	 * @input
	 * @oracle
	 * @passed Yes
	 */
	@Test
	public final void testRemoveObjectInOneElementList() {
		assertTrue(palOneElement.size() == 1);
		assertTrue(palOneElement.contains(objToto));
		System.out.println(palOneElement);
		palEmpty.remove(objToto);
		assertTrue(palOneElement.size() == 1);
		System.out.println(palOneElement);
		assertFalse(palOneElement.contains(objToto));
	}
	
	/*
	@Test
	public final void testRemoveAllCollectionOfQ() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testRetainAllCollectionOfQ() {
		fail("Not yet implemented"); // TODO
	}
*/
}
