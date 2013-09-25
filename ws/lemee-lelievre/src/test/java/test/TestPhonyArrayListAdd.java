/**
 * 
 */
package test;

import java.util.ArrayList;
import java.util.Collection;

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
	
	/**
	* Tests the "Add" method which append a element E to the end of the list
	* @see lemee-lelievre.PhonyArrayList#add()
	* @type 
	* @input 
	* @oracle Must return "true"
	* @passed Yes
	*/
	@Test
	public void testAdd() {

		int taillePred 	= pal.size();
		boolean bAdd 	= pal.add(new String("toto"));	
		assert((taillePred + 1 == pal.size()) && bAdd);	
		
	}
	
	/**
	* Tests the "AddAll" method which certify that size after adding is equals
	* with size before plus size of adding collection
	* specified collection's Iterator.
	* @see lemee-lelievre.PhonyArrayList#addAll()
	* @type 
	* @input 
	* @oracle Must return "true"
	* @passed Yes
	*/
	@Test
	public void testAddAllCompareSizeBeforeAndAfter() {

		// Init
		String toto = new String("toto");
		String titi = new String("titi");
		String tutu = new String("tutu");
		
		pal.add(toto);
		pal.add(titi);
		pal.add(tutu);
		
		int sizeBefore 	= pal.size();
		
		// tests
		Collection<String> c = new PhonyArrayList<String>(8);
		c.add(toto);
		c.add(titi);
		c.add(tutu);
		
		boolean bAddAll = pal.addAll(c);
		
		int sizeAfter 	= pal.size();
		
		// assertions
		assert(bAddAll);
		assertEquals(sizeAfter, sizeBefore + c.size());
		
	}
	
	/**
	* Tests the "AddAll" method which certify that adding of null 
	* Collection throw NullPointerException
	* specified collection's Iterator.
	* @see lemee-lelievre.PhonyArrayList#addAll()
	* @type 
	* @input 
	* @oracle Must throw NullPointerException
	* @passed Yes
	*/
	@Test
	public void testAddAllNullException() {

		// Init
		String toto = new String("toto");
		String titi = new String("titi");
		String tutu = new String("tutu");
		
		pal.add(toto);
		pal.add(titi);
		pal.add(tutu);
				
		// tests
		@SuppressWarnings("rawtypes")
		Collection c = null;
		
		thrown.expect(NullPointerException.class);
		
		pal.addAll(c);
		
	}
	
	/**
	* Tests the "AddAll" method which certify that adding of empty Collection
	* Collection throw NullPointerException
	* specified collection's Iterator.
	* @see lemee-lelievre.PhonyArrayList#addAll()
	* @type 
	* @input 
	* @oracle Must throw NullPointerException
	* @passed Yes
	*/
	@Test
	public void testAddAllEmptyCollection() {

		// Init
		String toto = new String("toto");
		String titi = new String("titi");
		String tutu = new String("tutu");
		
		pal.add(toto);
		pal.add(titi);
		pal.add(tutu);
				
		// tests
		@SuppressWarnings("rawtypes")
		Collection c = new ArrayList();

		boolean bAddAll = pal.addAll(c);
		
		assertFalse(bAddAll); //Integer.MAX_VALUE
		
	}
	
	/**
	* Tests the "AddAll" method which certify that Exception will be throw with capacity of Integer.MAX_VALUE
	* Collection throw NullPointerException
	* specified collection's Iterator.
	* @see lemee-lelievre.PhonyArrayList#addAll()
	* @type 
	* @input 
	* @oracle Must throw NullPointerException
	* @passed Yes
	*/
	@Test
	public void testAddAllGrowOverCapacity() {

		// Init
//		String toto = new String("toto");
//		String titi = new String("titi");
//		String tutu = new String("tutu");
//		
//		pal.add(toto);
//		pal.add(titi);
//		pal.add(tutu);
//				
//		// tests
//		@SuppressWarnings("rawtypes")
//		Collection c = new PhonyArrayList<String>(Integer.MAX_VALUE - 3);
//		
//		boolean bAddAll = pal.addAll(c);
		
		/**
		 * @TODO 
		 * Augmenter la VM de Eclipse ne fait rien, ou bien je le fais mal.
		 * Du coup une erreur : Java heap space, est soulevée
		 * */
		
	}
	
}
