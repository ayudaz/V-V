package com.sun.demo.addressbook.db;

import com.sun.demo.addressbook.AddressFrame;
import com.sun.demo.addressbook.db.AddressDao;
import com.windowtester.runtime.swing.locator.JButtonLocator;
import com.windowtester.runtime.swing.UITestCaseSwing;
import com.windowtester.runtime.IUIContext;
import com.windowtester.runtime.swing.locator.LabeledTextLocator;

import java.awt.event.KeyEvent;
import java.io.FileInputStream;

import org.dbunit.Assertion;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.Column;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.filter.DefaultColumnFilter;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

import com.windowtester.runtime.WT;

/**
 * Class Generated by WindowTesterPro, and then extended with DBUnit code. 
 */
public class TestExampleDBUnit extends UITestCaseSwing {

	private FlatXmlDataSet expected;
	private IDatabaseConnection connection;
	private JdbcDatabaseTester tester;
	private IDataSet actual;

	/**
	 * In setUp(), we establish the connection to the DB
	 * and we prepare the expected dataset.
	 */
	@Override
	protected void setUp() throws Exception {
		
		WT.setLocaleToCurrent();
		
		String dbName = "DefaultAddressBook";
		
		// Loads the initial data that must be present at the begining of the tests
		FlatXmlDataSet initialData = new FlatXmlDataSetBuilder()
				.build(new FileInputStream("data/dataset1address.xml"));
				
		// Initializes the database connection for the application
		new AddressDao();
		
		// Initializes the database connection for the tester
		tester = new JdbcDatabaseTester(
				"org.apache.derby.jdbc.EmbeddedDriver", "jdbc:derby:" + dbName,
				"addressuser", "addressuser", "APP");
		connection = tester.getConnection();
		
		// Puts the initial data in the database
		DatabaseOperation.CLEAN_INSERT.execute(connection, initialData);
	}

	/**
	 * Constructor of the WindowTester test class.
	 */
	public TestExampleDBUnit() {
		super(AddressFrame.class);
	}

	/**
	 * Test method.
	 */
	public void testAddContactData() throws Exception {
		
		// WindowTester code to add data in the database
		IUIContext ui = getUI();
		ui.click(new JButtonLocator("New"));
		ui.click(new LabeledTextLocator("Last Name"));
		ui.enterText("LECRIVAIN");
		ui.keyClick(KeyEvent.VK_TAB);
		ui.enterText("Benoit");
		ui.keyClick(KeyEvent.VK_TAB);
		ui.enterText("Alexandre");
		ui.keyClick(KeyEvent.VK_TAB);
		ui.enterText("0225688722");
		ui.keyClick(KeyEvent.VK_TAB);
		ui.enterText("benoit.lecrivain@hotmail.com");
		ui.keyClick(KeyEvent.VK_TAB);
		ui.enterText("Chateau d Apigne");
		ui.keyClick(KeyEvent.VK_TAB);
		ui.enterText("Porte 4");
		ui.keyClick(KeyEvent.VK_TAB);
		ui.enterText("Apigne");
		ui.keyClick(KeyEvent.VK_TAB);
		ui.enterText("Bretagne");
		ui.keyClick(KeyEvent.VK_TAB);
		ui.enterText("35650");
		ui.keyClick(KeyEvent.VK_TAB);
		ui.enterText("France");
		ui.click(new JButtonLocator("Save"));
		ui.click(new JButtonLocator("Exit"));
		
		// Prepares the expected dataset
		expected = new FlatXmlDataSetBuilder().build(new FileInputStream(
				"data/dataset2addresses.xml"));
		
		// Fetches the content of the actual database
		actual = connection.createDataSet();
		
		// The name of the table to check in the database
		String tableName = "Address";
		
		// Get the table of interest from both actual and expected databases
		ITable expectedTable = expected.getTable(tableName);
		ITable actualTable = actual.getTable(tableName);
		
		// Filters the actual table, to only consider the data of interest
		Column[] filter = expected.getTableMetaData(tableName).getColumns();
		ITable actualFilteredTable = DefaultColumnFilter.includedColumnsTable(actualTable, 
	            filter);
		
		// Assertion that both expected and (filtered) actual table are identical
		Assertion.assertEquals(expectedTable, actualFilteredTable);
	}
	
	/**
	 * Test method.
	 */
	public void testSameTuple() throws Exception {
		
		// WindowTester code to add data in the database
		IUIContext ui = getUI();
		ui.click(new JButtonLocator("New"));
		ui.click(new LabeledTextLocator("Last Name"));
		ui.enterText("LECRIVAIN");
		ui.keyClick(KeyEvent.VK_TAB);
		ui.enterText("Benoit");
		ui.keyClick(KeyEvent.VK_TAB);
		ui.enterText("Alexandre");
		ui.keyClick(KeyEvent.VK_TAB);
		ui.enterText("0225688722");
		ui.keyClick(KeyEvent.VK_TAB);
		ui.enterText("benoit.lecrivain@hotmail.com");
		ui.keyClick(KeyEvent.VK_TAB);
		ui.enterText("Chateau d Apigne");
		ui.keyClick(KeyEvent.VK_TAB);
		ui.enterText("Porte 4");
		ui.keyClick(KeyEvent.VK_TAB);
		ui.enterText("Apigne");
		ui.keyClick(KeyEvent.VK_TAB);
		ui.enterText("Bretagne");
		ui.keyClick(KeyEvent.VK_TAB);
		ui.enterText("35650");
		ui.keyClick(KeyEvent.VK_TAB);
		ui.enterText("France");
		ui.click(new JButtonLocator("Save"));
		
		ui.click(new JButtonLocator("New"));
		ui.click(new LabeledTextLocator("Last Name"));
		ui.enterText("LECRIVAIN");
		ui.keyClick(KeyEvent.VK_TAB);
		ui.enterText("Benoit");
		ui.keyClick(KeyEvent.VK_TAB);
		ui.enterText("Alexandre");
		ui.keyClick(KeyEvent.VK_TAB);
		ui.enterText("0225688722");
		ui.keyClick(KeyEvent.VK_TAB);
		ui.enterText("benoit.lecrivain@hotmail.com");
		ui.keyClick(KeyEvent.VK_TAB);
		ui.enterText("Chateau d Apigne");
		ui.keyClick(KeyEvent.VK_TAB);
		ui.enterText("Porte 4");
		ui.keyClick(KeyEvent.VK_TAB);
		ui.enterText("Apigne");
		ui.keyClick(KeyEvent.VK_TAB);
		ui.enterText("Bretagne");
		ui.keyClick(KeyEvent.VK_TAB);
		ui.enterText("35650");
		ui.keyClick(KeyEvent.VK_TAB);
		ui.enterText("France");
		ui.click(new JButtonLocator("Save"));
		
		ui.click(new JButtonLocator("Exit"));
		
		// Prepares the expected dataset
		expected = new FlatXmlDataSetBuilder().build(new FileInputStream(
				"data/dataset2addresses.xml"));
		
		// Fetches the content of the actual database
		actual = connection.createDataSet();
		
		// The name of the table to check in the database
		String tableName = "Address";
		
		// Get the table of interest from both actual and expected databases
		ITable expectedTable = expected.getTable(tableName);
		ITable actualTable = actual.getTable(tableName);
		
		// Filters the actual table, to only consider the data of interest
		Column[] filter = expected.getTableMetaData(tableName).getColumns();
		ITable actualFilteredTable = DefaultColumnFilter.includedColumnsTable(actualTable, 
	            filter);
		
		// Assertion that both expected and (filtered) actual table are identical
		Assertion.assertEquals(expectedTable, actualFilteredTable);
	}
	
	/**
	 * In tearDown(), we delete everything from the database,
	 * and we close the connection between the test runner and the database.
	 */
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		connection = tester.getConnection();
		DatabaseOperation.DELETE_ALL.execute(connection, actual);
		connection.close();
	}

}