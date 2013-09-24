import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import  static org.junit.Assert.*;

import  system.PhonyArrayList;

/**
 * 
 */

/**
 * test Case of {@link TestPhonyArrayList}
 * @author Thomas LELIEVRE - Anthony LE MEE (13000170 - 10003134)
 * @since 20/09/2013
 */
public class TestPhonyArrayList {
	

	/** Class Attributes */
	private PhonyArrayList<Object> pal;
	
	/**
	 * Executed before each test
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		pal = new PhonyArrayList<Object>();
		
	}

	/**
	 * Executed after each test
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		
		pal = null;
		
	}

	/**
	* Tests the "PhonyArrayList" constructor with illegal "Capacity" parameter.
	* @see lemee-lelievre.PhonyArrayList#PhonyArrayList(int)
	* @type 
	* @input -1
	* @oracle Must return throw IllegalArgumentException
	* @passed Yes
	*/
	@Test(expected=IllegalArgumentException.class)
	public void testPhonyArrayListCapacityException() {
		
		pal = new PhonyArrayList<Object>(-1);
		
	}
	
	/**
	* Tests the "PhonyArrayList" constructor with correct "Capacity" parameter.
	* @see lemee-lelievre.PhonyArrayList#PhonyArrayList(int)
	* @type 
	* @input 8
	* @oracle Must return "true"
	* @passed Yes
	*/
	@Test
	public void testPhonyArrayListCapacityCreat() {
		
		pal = new PhonyArrayList<Object>(8);
		assert(pal!=null);
		
	}

	/**
	* Tests the "PhonyArrayList" constructor with empty "Collection" parameter.
	* @see lemee-lelievre.PhonyArrayList#PhonyArrayList(Collection)
	* @type 
	* @input 
	* @oracle Must return "true"
	* @passed Yes
	*/
	@Test
	public void testPhonyArrayListCollectionVide() {
		
		Collection<Object> c = new LinkedList<Object>();
		pal = new PhonyArrayList<Object>(c);
		assert(pal != null);
		
	}
	
	/**
	* Tests the "PhonyArrayList" constructor with full "Collection" parameter.
	* @see lemee-lelievre.PhonyArrayList#PhonyArrayList(Collection)
	* @type 
	* @input ArrayList with two elements : String("toto") and String ("titi")
	* @oracle Must return "true"
	* @passed Yes
	*/
	@Test
	public void testPhonyArrayListCollectionPleine() {
		
		Collection<Object> c = new ArrayList<Object>();
		c.add(new String("toto"));
		c.add(new String("titi"));
		pal = new PhonyArrayList<Object>(c);
		assert(pal.size() == c.size());
		
	}
	
	/**
	* Tests the "PhonyArrayList" constructor with illegal "Collection" parameter.
	* @see lemee-lelievre.PhonyArrayList#PhonyArrayList(int)
	* @type 
	* @input -1
	* @oracle Must return throw NullPointerException
	* @passed Yes
	*/
	@Test(expected=NullPointerException.class)
	public void testPhonyArrayListCollectionNull() {
		
		Collection<Object> c = null;
		pal = new PhonyArrayList<Object>(c);
		
	}

	/**
	* Tests the "isEmpty" method when "this.elementData = EMPTY_ELEMENTDATA"
	* @see lemee-lelievre.PhonyArrayList#isEmpty()
	* @type 
	* @input 
	* @oracle Must return "true"
	* @passed Yes
	*/
	@Test
	public void testIsEmptyTrue () {
		
		assert(pal.isEmpty());
		
	}
	
	/**
	* Tests the "isEmpty" method when "this.elementData != EMPTY_ELEMENTDATA"
	* @see lemee-lelievre.PhonyArrayList#isEmpty()
	* @type 
	* @input 
	* @oracle Must return "true"
	* @passed Yes
	*/
	@Test
	public void testIsEmptyFalse () {
		
		Collection<Object> c = new ArrayList<Object>();
		c.add(new String("toto"));
		c.add(new String("titi"));
		pal = new PhonyArrayList<Object>(c);
		assertFalse(pal.isEmpty());
		
	}
	
	/**
	* Tests the "add" method which append a element E to the end of the list
	* @see lemee-lelievre.PhonyArrayList#add()
	* @type 
	* @input 
	* @oracle Must return "true"
	* @passed Yes
	*/
	@Test
	public void testAdd() {

		int taillePred = pal.size();
		
		boolean bAdd = pal.add(new String("toto"));
		
		boolean bAdd2 = pal.add(new String("titi"));
		
		assert((taillePred + 2 == pal.size()) && bAdd);	
		
	}
	
	/**
	* Tests the "indexOf" method - test membership and not membership to an 
	* Object that is present only once
	* @see lemee-lelievre.PhonyArrayList#indexOf()
	* @type 
	* @input 
	* @oracle Must return "true"
	* @passed Yes
	*/
	@Test
	public void testIndexOfOneOcc() {
		
		String toto = new String("toto");
		String titi = new String("titi");
		
		assert(pal.indexOf(toto) < 0);
		
		pal.add(toto);
		
		assert(pal.indexOf(toto) == 0);
		assert(pal.indexOf(titi) < 0);
		
	}
	
	/**
	* Tests the "indexOf" method - test d'appartenance et de non appartenance d'un Object (null) présent qu'une fois
	* @see lemee-lelievre.PhonyArrayList#indexOf()
	* @type 
	* @input 
	* @oracle Must return "true"
	* @passed Yes
	*/
	@Test
	public void testIndexOfOneOccNull() {
		
		assert(pal.indexOf(null) < 0);
		
		String toto = new String("toto");
		
		pal.add(toto);
		pal.add(null);
		pal.add(toto);
		pal.add(null);

		assert(pal.indexOf(null) == 1);
		
	}
	
	/**
	* Tests the "indexOf" method - test membership and not memberships to an 
	* object that is present several times
	* @see lemee-lelievre.PhonyArrayList#indexOf()
	* @type 
	* @input 
	* @oracle Must return "true"
	* @passed Yes
	*/
	@Test
	public void testIndexOfMultiOcc() {
		
		String toto = new String("toto");
		String titi = new String("titi");
		
		pal.add(toto);
		pal.add(titi);
		pal.add(toto);
				
		assert(pal.indexOf(toto) == 0);
		assert(pal.indexOf(titi) == 1);
		
	}
	
	/**
	* Tests the "contains" method 
	* @see lemee-lelievre.PhonyArrayList#contains()
	* @type 
	* @input 
	* @oracle Must return "true"
	* @passed No
	* @correction
	* <pre>
	* 	l.208
	* 	- indexOf(o) > 0; 
	*   + indexOf(o) >= 0;
	* </pre>
	*/
	@Test
	public void testContains() {
		
		String toto = new String("toto");
		String titi = new String("titi");
		String tutu = new String("tutu");
		
		pal.add(toto);
		pal.add(titi);
		pal.add(toto);
				
		assert(pal.contains(toto));
		assertFalse(pal.contains(tutu));
		
	}
	
	/**
	* Tests the "lastIndexOf" method - test d'appartenance et de non appartenance d'un Object présent qu'une fois
	*  - test d'appartenance et de non appartenance d'un Object présent plusieur fois
	* @see lemee-lelievre.PhonyArrayList#lastIndexOf(Object o)
	* @type 
	* @input 
	* @oracle Must return "true"
	* @passed No
	* @correction
	* <pre>
	* 	
	* </pre>
	*/
	@Test
	public void testLastIndexOfOneOcc() {
		
		String toto = new String("toto");
		String titi = new String("titi");
		
		assert(pal.lastIndexOf(toto) < 0);
		
		pal.add(toto);
		
		assert(pal.lastIndexOf(toto) == 0);
		assert(pal.lastIndexOf(titi) < 0);
		
	}
	
	/**
	* Tests the "lastIndexOf" method - test d'appartenance et de non appartenance d'un Object présent plusieur fois
	* @see lemee-lelievre.PhonyArrayList#lastIndexOf(Object o)
	* @type 
	* @input 
	* @oracle Must return "true"
	* @passed No
	* @correction
	* <pre>
	* 	
	* </pre>
	*/
	@Test
	public void testLastIndexOfMultiOcc() {
		
//		String toto = new String("toto");
//		String titi = new String("titi");
//		String tutu = new String("tutu");
//		
//		pal.add(toto);
//		pal.add(titi);
//		pal.add(tutu);
//
//		assert(pal.indexOf(toto) == 2);
//		assert(pal.indexOf(titi) == 1);
		
	}
	
	
}
