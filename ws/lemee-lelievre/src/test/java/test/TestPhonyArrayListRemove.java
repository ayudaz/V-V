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
		assertEquals(objToto, o);
	}
	
/*
	@Test
	public final void testRemoveObject() {
		fail("Not yet implemented"); // TODO
	}

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
