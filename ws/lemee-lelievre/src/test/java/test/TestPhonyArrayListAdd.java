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
 * Test case of the two Add methods of {@link PhonyArrayList}
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
	 * Tests the "{@link PhonyArrayList#Add(int, E)}" method when add at a 
	 * negative position.
	 * @see lemee-lelievre.PhonyArrayList#add(int, E)
	 * @type Functional
	 * @input -1,"Toto"
	 * @oracle Must return throw IndexOutOfBoundsException
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
	 * Tests the "{@link PhonyArrayList#Add(int, E)}" method when add at a 
	 * position greater than the size of the list.
	 * @see lemee-lelievre.PhonyArrayList#add(int, E)
	 * @type Functional
	 * @input 1, "Toto"
	 * @oracle Must return throw IndexOutOfBoundsException
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
	 * Tests the "{@link PhonyArrayList#Add(int, E)}" method when add object 
	 * in an empty list at the first position. 
	 * @see lemee-lelievre.PhonyArrayList#add(int, E)
	 * @type Functional
	 * @input 0, "Toto"
	 * @oracle Must return "true"
	 * @passed no
	 * @correction
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
	 * Tests the "{@link PhonyArrayList#Add(int, E)}" method when add object in
	 * a list of one element at the first position. 
	 * @see lemee-lelievre.PhonyArrayList#add(int, E)
	 * @type Functional
	 * @input 0, "Titi"
	 * @oracle Must return "true"
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
	 * Tests the "{@link PhonyArrayList#Add(int, E)}" method when add object 
	 * in a list of one element at the end of the list. 
	 * @see lemee-lelievre.PhonyArrayList#add(int, E)
	 * @type Functional
	 * @input 1, "Titi"
	 * @oracle Must return "true"
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
	 * Tests the "{@link PhonyArrayList#Add(int, E)}" method when add object in
	 * a list of two element at the first position. 
	 * @see lemee-lelievre.PhonyArrayList#add(int, E)
	 * @type Functional
	 * @input 0, "Tata"
	 * @oracle Must return "true"
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
	 * Tests the "{@link PhonyArrayList#Add(int, E)}" method when add object 
	 * in a list of two element at the middle position. 
	 * @see lemee-lelievre.PhonyArrayList#add(int, E)
	 * @type Functional
	 * @input 1, "Tata"
	 * @oracle Must return "true"
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
	 * Tests the "{@link PhonyArrayList#Add(int, E)}" method when add object in
	 * a list of two element at the end position. 
	 * @see lemee-lelievre.PhonyArrayList#add(int, E)
	 * @type Functional
	 * @input 2, "Tata"
	 * @oracle Must return "true"
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
	* Tests the "{@link PhonyArrayList#Add(int, E)}" method which append a 
	* element E to the end of the list.
	* @see lemee-lelievre.PhonyArrayList#add()
	* @type Functional
	* @input "Toto"
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
	* Tests the "{@link PhonyArrayList#addAll(Collection<?>)}" method which 
	* certify that size after adding is equals with size before plus size of
	* adding collection specified collection's Iterator.
	* @see lemee-lelievre.PhonyArrayList#addAll(Collection<?>)
	* @type Functional
	* @input c
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
	* Tests the "{@link PhonyArrayList#addAll(Collection<?>)}" method which 
	* certify that adding of null Collection throw NullPointerException
	* specified collection's Iterator.
	* @see lemee-lelievre.PhonyArrayList#addAll(Collection<?>)
	* @type Functional
	* @input null
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
		Collection<Object> c = null;
		
		thrown.expect(NullPointerException.class);
		
		pal.addAll(c);
		
	}
	
	/**
	* Tests the "AddAll" method which certify that adding of empty Collection
	* Collection.
	* @see lemee-lelievre.PhonyArrayList#addAll(Collection)
	* @type Functional
	* @input c
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
		Collection<Object> c = new ArrayList<Object>();

		boolean bAddAll = pal.addAll(c);
		
		assertFalse(bAddAll); 
		
	}
	
	/**
	* Tests the "AddAll" method which certify that Exception will be throw with
	*  capacity of Integer.MAX_VALUE
	* Collection throw NullPointerException
	* specified collection's Iterator.
	* @see lemee-lelievre.PhonyArrayList#addAll(Collection)
	* @type Functional
	* @input 
	* @oracle Must throw NullPointerException
	* @passed Yes
	*/
	@Test
	public void testAddAllGrowOverCapacity() {

//		// Init
//		String toto = new String("toto");
//		String titi = new String("titi");
//		String tutu = new String("tutu");
//		
//		pal.add(toto);
//		pal.add(titi);
//		pal.add(tutu);
//				
//		// tests
//		Collection<Integer> c = new PhonyArrayList<Integer>(715833340);
//		for(int i=0 ; i<715833340 ; i++){
//				c.add(i);
//		}
//		
//		boolean bAddAll = pal.addAll(c);
		
	}
	
	/**
	* Tests the "AddAll" method which certify that size after adding is equals
	* with size before plus size of adding collection
	* specified collection's Iterator.
	* @see lemee-lelievre.PhonyArrayList#addAll(int, Collection)
	* @type  Functional
	* @input 
	* @oracle Must return "true"
	* @passed Yes
	*/
	@Test
	public void testAddAllAtPositionCompareSizeBeforeAndAfter() {

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
		
		boolean bAddAll = pal.addAll(1, c);
		
		int sizeAfter 	= pal.size();
		
		// assertions
		assert(bAddAll);
		assertEquals(sizeAfter, sizeBefore + c.size());
		
	}
	
	/**
	* Tests the "AddAll" method which certify that adding of empty Collection
	* Collection throw NullPointerException
	* specified collection's Iterator.
	* @see lemee-lelievre.PhonyArrayList#addAll(int,Collection)
	* @type  Functional
	* @input 
	* @oracle Must throw NullPointerException
	* @passed Yes
	*/
	@Test
	public void testAddAllAtPositionEmptyCollection() {

		// Init
		String toto = new String("toto");
		String titi = new String("titi");
		String tutu = new String("tutu");
		
		pal.add(toto);
		pal.add(titi);
		pal.add(tutu);
				
		// tests
		Collection<Object> c = new ArrayList<Object>();

		boolean bAddAll = pal.addAll(1,c);
		
		assertFalse(bAddAll);
		
	}
	
	/**
	* Tests the "AddAll" method which certify that adding of null 
	* Collection throw NullPointerException
	* specified collection's Iterator.
	* @see lemee-lelievre.PhonyArrayList#addAll(int, Collection)
	* @type  Functional
	* @input 
	* @oracle Must throw NullPointerException
	* @passed Yes
	*/
	@Test
	public void testAddAllAtPositionNullException() {

		// Init
		String toto = new String("toto");
		String titi = new String("titi");
		String tutu = new String("tutu");
		
		pal.add(toto);
		pal.add(titi);
		pal.add(tutu);
				
		// tests
		Collection<Object> c = null;
		
		thrown.expect(NullPointerException.class);
		
		pal.addAll(1, c);
		
	}
	
	
	/**
	* Tests the "AddAll" append with index equals to source Collection size
	* Collection throw NullPointerException
	* specified collection's Iterator.
	* @see lemee-lelievre.PhonyArrayList#addAll(int, Collection)
	* @type  Functional
	* @input 
	* @oracle Must throw NullPointerException
	* @passed Yes
	*/
	@Test
	public void testAddAllAtPositionIndexEqualsSize() {

		// Init
		String toto = new String("toto");
		String titi = new String("titi");
		String tutu = new String("tutu");
		
		pal.add(toto);
		pal.add(titi);
		pal.add(tutu);
			
		int sizeBefore = pal.size();
		
		// tests
		ArrayList<String> c = new ArrayList<String>();

		c.add(toto);
		c.add(titi);
		c.add(tutu);
		
		boolean bAddAll = pal.addAll(pal.size(),c);
		
		assert(bAddAll);
		assertEquals(pal.get(sizeBefore), c.get(0));
		
	}
	
	/**
	* Tests the "AddAll" append with Out Of Bounds Index and Source Collection empty
	* Collection throw NullPointerException
	* specified collection's Iterator.
	* @see lemee-lelievre.PhonyArrayList#addAll(int, Collection)
	* @type  Functional
	* @input 
	* @oracle Must throw NullPointerException
	* @passed Yes
	*/
	@Test
	public void testAddAllAtPositionOutOfBoundsIndex() {

		// Init
		String toto = new String("toto");
		String titi = new String("titi");
		String tutu = new String("tutu");
					
		// tests
		ArrayList<String> c = new ArrayList<String>();

		c.add(toto);
		c.add(titi);
		c.add(tutu);
		
		pal.add(toto);
		pal.add(titi);
		pal.add(tutu);
		
		int index = pal.size() + 1;
		
		thrown.expect(IndexOutOfBoundsException.class);
		
		pal.addAll(index,c);
				
	}
	
	/**
	* Tests the "AddAll" append with empty source collection
	* Collection throw NullPointerException
	* specified collection's Iterator.
	* @see lemee-lelievre.PhonyArrayList#addAll(int, Collection)
	* @type  Functional
	* @input 
	* @oracle Must throw NullPointerException
	* @passed No
	* @correction 
	* <pre>
	* 	Dead Branch Detected
	* 	l.451
	* 	- else if (numMoved > size) {
	* 	+ else if (numMoved >= size) {
	* </pre>
	*/
	@Test
	public void testAddAllAtPositionEmptySource() {

		// Init
		String toto = new String("toto");
		String titi = new String("titi");
		String tutu = new String("tutu");
					
		// tests
		ArrayList<String> c = new ArrayList<String>();

		c.add(toto);
		c.add(titi);
		c.add(tutu);
		
		int index = 0;
				
		boolean b = pal.addAll(index,c);
		
		assert(b);
		assertEquals(pal.size(), c.size());
				
	}
	
}
