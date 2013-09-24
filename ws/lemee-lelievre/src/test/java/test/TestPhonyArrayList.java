package test;
import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;
import system.PhonyArrayList;

/**
 * test Case of {@link TestPhonyArrayList}
 * @author Thomas LELIEVRE - Anthony LE MEE (13000170 - 10003134)
 * @since 20/09/2013
 */
public class TestPhonyArrayList {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

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
	* Tests the "{@link PhonyArrayList#get(int)}" method 
	* @see lemee-lelievre.PhonyArrayList#get(int)
	* @type 
	* @input 
	* @oracle Must return "true"
	* @passed Yes
	*/
	@Test
	public void testGet() { 
		
		String toto = new String("toto");
		int goodIndex = 0;
		
		pal.add(toto);
		Object test1 = pal.get(goodIndex);
		
		assertEquals(test1, toto);
		assertEquals(pal.indexOf(test1), goodIndex);
		
	}
	
	/**
	* Tests the "{@link PhonyArrayList#get(int)}" method with 
	* wrong index parameter
	* @see lemee-lelievre.PhonyArrayList#get(int)
	* @type 
	* @input 
	* @oracle Must return throw IndexOutOfBoundsException
	* @passed Yes
	*/
	@Test
	public void testGetException() {
		
		String toto 	= new String("toto");
		int wrongIndex 	= 2;
		
		pal.add(toto);
		
		thrown.expect(IndexOutOfBoundsException.class);
		thrown.expectMessage("Index: " + wrongIndex + ", Size: " + pal.size());
		
		pal.get(wrongIndex);
		
	}
	
	/**
	* Tests the "{@link PhonyArrayList#set(int, Object)}" method with 
	* wrong index parameter
	* @see lemee-lelievre.PhonyArrayList#set(int, Object)
	* @type 
	* @input 
	* @oracle Must return throw IndexOutOfBoundsException
	* @passed Yes
	*/
	@Test
	public void testSetException() {
		
		String toto 	= new String("toto");
		String titi 	= new String("titi");
		int wrongIndex 	= 2;
		
		pal.add(toto);
		
		thrown.expect(IndexOutOfBoundsException.class);
		thrown.expectMessage("Index: " + wrongIndex + ", Size: " + pal.size());
		
		pal.set(wrongIndex, titi);
		
	}
	
	/**
	* Tests the "{@link PhonyArrayList#set(int, Object)}" method 
	* @see lemee-lelievre.PhonyArrayList#set(int, Object)
	* @type 
	* @input 
	* @oracle Must return "true"
	* @passed No
	* @correction
	* <pre>
	* 	- elementData[++index] = element;
	* 	+ elementData[index] = element;
	* </pre>
	*/
	@Test
	public void testSet() { 
		
		String toto = new String("toto");
		String titi = new String("titi");
		
		pal.add(null);
		pal.add(toto);
		pal.add(null);
		
		int oldSize = pal.size();
		
		Object test1 = pal.set(1, titi);
		
		int newSize = pal.size();
		
		Object test2 = pal.get(1);
		
		assertEquals(test1, toto);
		assertEquals(test2, titi);
		assertEquals(oldSize, newSize);
		
	}
	
}
