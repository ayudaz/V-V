package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

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
		palOneElement.remove(objToto);
		assertTrue(palOneElement.size() == 0);
		assertFalse(palOneElement.contains(objToto));
	}
	
	/**
	 * Tests remove(object) method on a two elements list with an object who
	 * are in the first position of the list.
	 * @see lemee-lelievre.PhonyArrayList#remove(object)
	 * @type
	 * @input
	 * @oracle
	 * @passed Yes
	 */
	@Test
	public final void testRemoveFirstObjectInTwoElementList() {
		assertTrue(palTwoElement.size() == 2);
		assertTrue(palTwoElement.contains(objToto));
		palTwoElement.remove(objToto);
		assertTrue(palTwoElement.size() == 1);
		assertFalse(palTwoElement.contains(objToto));
	}
	
	/**
	 * Tests remove(object) method on a two elements list with an object who
	 * are in the second position of the list.
	 * @see lemee-lelievre.PhonyArrayList#remove(object)
	 * @type
	 * @input
	 * @oracle
	 * @passed Yes
	 */
	@Test
	public final void testRemoveSecondObjectInTwoElementList() {
		assertTrue(palTwoElement.size() == 2);
		assertTrue(palTwoElement.contains(objTata));
		palTwoElement.remove(objTata);
		assertTrue(palTwoElement.size() == 1);
		assertFalse(palTwoElement.contains(objTata));
	}
	
	/**
	 * Tests remove(object) method with a null object on a list who don't 
	 * contain a null object.
	 * @see lemee-lelievre.PhonyArrayList#remove(object)
	 * @type
	 * @input
	 * @oracle
	 * @passed No
	 * <pre>
	 * l.362
	 * - if (elementData[index] != null) {
	 * + if (elementData[index] == null) {
	 * </pre>
	 */
	@Test
	public final void testRemoveNullObjectInTwoElementList() {
		assertTrue(palTwoElement.size() == 2);
		assertTrue(palTwoElement.contains(objToto));
		assertTrue(palTwoElement.contains(objTata));
		palTwoElement.remove(null);
		assertTrue(palTwoElement.size() == 2);
		assertTrue(palTwoElement.contains(objToto));
		assertTrue(palTwoElement.contains(objTata));
	}
	
	/**
	 * Tests remove(object) method with a null object on a list who contain a
	 * null object.
	 * @see lemee-lelievre.PhonyArrayList#remove(object)
	 * @type
	 * @input
	 * @oracle
	 * @passed Yes
	 */
	@Test
	public final void testRemoveNullObjectInTwoElementList2() {
		palTwoElement.add(null);
		assertTrue(palTwoElement.size() == 3);
		assertTrue(palTwoElement.contains(objToto));
		assertTrue(palTwoElement.contains(objTata));
		assertTrue(palTwoElement.contains(null));
		palTwoElement.remove(null);
		assertTrue(palTwoElement.size() == 2);
		assertTrue(palTwoElement.contains(objToto));
		assertTrue(palTwoElement.contains(objTata));
		assertFalse(palTwoElement.contains(null));
	}
	
	/**
	 * Tests remove(object) method with a null object on a list who contain 
	 * some null objects.
	 * @see lemee-lelievre.PhonyArrayList#remove(object)
	 * @type
	 * @input
	 * @oracle
	 * @passed Yes
	 */
	@Test
	public final void testRemoveNullObjectInTwoElementList3() {
		palOneElement.add(null);
		palOneElement.add(objTata);
		palOneElement.add(null);
		assertTrue(palOneElement.size() == 4);
		assertTrue(palOneElement.contains(objToto));
		assertTrue(palOneElement.contains(objTata));
		assertTrue(palOneElement.contains(null));
		assertTrue(palOneElement.indexOf(null) == 1);
		assertTrue(palOneElement.lastIndexOf(null) == 3);
		palOneElement.remove(null);
		assertTrue(palOneElement.size() == 3);
		assertTrue(palOneElement.contains(objToto));
		assertTrue(palOneElement.contains(objTata));
		assertTrue(palOneElement.contains(null));
		assertTrue(palOneElement.lastIndexOf(null) == 2);
		assertTrue(palOneElement.indexOf(null) == 2);
	}
	
	
	/**
	 * Tests remove(Collection<?>) method with a collection of objects who are
	 * not in the one element list.
	 * @see lemee-lelievre.PhonyArrayList#removeAll(Collection<?>)
	 * @type
	 * @input
	 * @oracle
	 * @passed Yes
	 */
	@Test
	public final void testRemoveAllCollectionOfObjectNotInOneElementList() {
		Collection<Object> objList = new ArrayList<Object>();
		Object gli = "GLI";
		Object trois = 3;
		objList.add(gli);
		objList.add(trois);
		assertFalse(palOneElement.contains(gli));
		assertFalse(palOneElement.contains(trois));
		assertTrue(palOneElement.size() == 1);
		assertTrue(palOneElement.contains(objToto));
		palOneElement.removeAll(objList);
		assertTrue(palOneElement.size() == 1);
		assertFalse(palOneElement.contains(gli));
		assertFalse(palOneElement.contains(trois));
		assertTrue(palOneElement.contains(objToto));
	}
	
	/**
	 * Tests remove(Collection<?>) method with a collection of objects who are
	 * not in the two element list.
	 * @see lemee-lelievre.PhonyArrayList#removeAll(Collection<?>)
	 * @type
	 * @input
	 * @oracle
	 * @passed Yes
	 */
	@Test
	public final void testRemoveAllCollectionOfObjectNotInTwoElementList() {
		Collection<Object> objList = new ArrayList<Object>();
		Object gli = "GLI";
		Object trois = 3;
		objList.add(gli);
		objList.add(trois);
		assertFalse(palTwoElement.contains(gli));
		assertFalse(palTwoElement.contains(trois));
		assertTrue(palTwoElement.size() == 2);
		assertTrue(palTwoElement.contains(objToto));
		assertTrue(palTwoElement.contains(objTata));
		assertFalse(palTwoElement.removeAll(objList));
		assertTrue(palTwoElement.size() == 2);
		assertFalse(palTwoElement.contains(gli));
		assertFalse(palTwoElement.contains(trois));
		assertTrue(palTwoElement.contains(objToto));
		assertTrue(palTwoElement.contains(objTata));
	}
	
	/**
	 * Tests remove(Collection<?>) method with a collection of objects where 
	 * one element is in the one element list.
	 * @see lemee-lelievre.PhonyArrayList#removeAll(Collection<?>)
	 * @type
	 * @input
	 * @oracle
	 * @passed No
	 * <pre>
	 * l.563
	 * - for (; r < size+1; r++)
	 * + for (; r < size; r++)
	 * </pre>
	 */
	@Test
	public final void testRemoveAllCollectionOfObjectInOneElementList() {
		Collection<Object> objList = new ArrayList<Object>();
		Object trois = 3;
		objList.add(objToto);
		objList.add(trois);
		assertFalse(palOneElement.contains(trois));
		assertTrue(palOneElement.size() == 1);
		assertTrue(palOneElement.contains(objToto));
		assertTrue(palOneElement.removeAll(objList));
		assertTrue(palOneElement.size() == 0);
		assertFalse(palOneElement.contains(trois));
		assertFalse(palOneElement.contains(objToto));
	}
	
	/**
	 * Tests remove(Collection<?>) method with a collection of objects where 
	 * one element is in the two element list.
	 * @see lemee-lelievre.PhonyArrayList#removeAll(Collection<?>)
	 * @type
	 * @input
	 * @oracle
	 * @passed Yes
	 */
	@Test
	public final void testRemoveAllCollectionOfObjectInTwoElementList() {
		Collection<Object> objList = new ArrayList<Object>();
		Object trois = 3;
		objList.add(objToto);
		objList.add(trois);
		assertFalse(palTwoElement.contains(trois));
		assertTrue(palTwoElement.size() == 2);
		assertTrue(palTwoElement.contains(objToto));
		assertTrue(palTwoElement.contains(objTata));
		assertTrue(palTwoElement.removeAll(objList));
		assertTrue(palTwoElement.size() == 1);
		assertFalse(palTwoElement.contains(trois));
		assertFalse(palTwoElement.contains(objToto));
		assertTrue(palTwoElement.contains(objTata));
	}
	
	/**
	 * Tests remove(Collection<?>) method with a collection of objects where 
	 * two elements is in a three element list.
	 * @see lemee-lelievre.PhonyArrayList#removeAll(Collection<?>)
	 * @type
	 * @input
	 * @oracle
	 * @passed Yes
	 */
	@Test
	public final void testRemoveAllCollectionOfObjectInThreeElementList() {
		palTwoElement.add("Titi");
		Collection<Object> objList = new ArrayList<Object>();
		Object trois = 3;
		objList.add(objToto);
		objList.add(objTata);
		objList.add(trois);
		assertFalse(palTwoElement.contains(trois));
		assertTrue(palTwoElement.size() == 3);
		assertTrue(palTwoElement.contains(objToto));
		assertTrue(palTwoElement.contains(objTata));
		assertTrue(palTwoElement.removeAll(objList));
		assertTrue(palTwoElement.size() == 1);
		assertFalse(palTwoElement.contains(trois));
		assertFalse(palTwoElement.contains(objToto));
		assertFalse(palTwoElement.contains(objTata));
	}
	
	/**
	 * Tests remove(Collection<?>) method with a collection of objects where 
	 * two elements is in a three element list who have two elements identical
	 * who must be deleted.
	 * @see lemee-lelievre.PhonyArrayList#removeAll(Collection<?>)
	 * @type
	 * @input
	 * @oracle
	 * @passed Yes
	 */
	@Test
	public final void testRemoveAllCollectionOfObjectInThreeElementList2() {
		palTwoElement.add(objToto);
		Collection<Object> objList = new ArrayList<Object>();
		Object trois = 3;
		objList.add(objToto);
		objList.add(objTata);
		objList.add(trois);
		assertFalse(palTwoElement.contains(trois));
		assertTrue(palTwoElement.size() == 3);
		assertTrue(palTwoElement.contains(objToto));
		assertTrue(palTwoElement.contains(objTata));
		assertTrue(palTwoElement.removeAll(objList));
		assertTrue(palTwoElement.size() == 0);
		assertFalse(palTwoElement.contains(trois));
		assertFalse(palTwoElement.contains(objToto));
		assertFalse(palTwoElement.contains(objTata));
	}
	
	/*
	@Test
	public final void testRetainAllCollectionOfQ() {
		fail("Not yet implemented"); // TODO
	}
*/
}
