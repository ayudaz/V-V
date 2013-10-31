import com.windowtester.runtime.swing.locator.LabeledTextLocator;
import com.windowtester.runtime.swing.UITestCaseSwing;
import com.windowtester.runtime.IUIContext;
import com.windowtester.runtime.swing.locator.JTextComponentLocator;

import javax.swing.JTextField;

import org.junit.Before;

import com.windowtester.runtime.swing.locator.JButtonLocator;
import com.windowtester.runtime.swing.locator.JListLocator;
import com.windowtester.runtime.swing.locator.NamedWidgetLocator;
import com.windowtester.runtime.swing.condition.WindowDisposedCondition;

public class GUITesting extends UITestCaseSwing {

	/**
	 * Create an Instance
	 */
	public GUITesting() {
		super(com.sun.demo.addressbook.AddressFrame.class);
	}
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		createExecutionContext();
	}

	/**
	 * @throws Exception
	 */
	public void testAssertOne() throws Exception {
		IUIContext ui = getUI();
		ui.assertThat(new LabeledTextLocator("Last Name").isEnabled(false));
		ui.assertThat(new LabeledTextLocator("Phone").isEnabled(false));
		ui.assertThat(new LabeledTextLocator("Address 1").isEnabled(false));
		ui.assertThat(new LabeledTextLocator("Address 1").isEnabled(false));
		ui.assertThat(new LabeledTextLocator("Address 2").isEnabled(false));
		ui.assertThat(new LabeledTextLocator("City").isEnabled(false));
		ui.assertThat(new JTextComponentLocator(JTextField.class)
				.isEnabled(false));
		ui.assertThat(new LabeledTextLocator("Country").isEnabled(false));
		ui.assertThat(new LabeledTextLocator("First Name").isEnabled(false));
		ui.assertThat(new LabeledTextLocator("Middle Name").isEnabled(false));
		ui.assertThat(new LabeledTextLocator("Email").isEnabled(false));
		ui.assertThat(new JTextComponentLocator(JTextField.class)
				.isEnabled(false));
		ui.click(new NamedWidgetLocator("frame0"));
	}
	
	/**
	 * @throws Exception
	 */
	public void testAssertTwo() throws Exception {
		IUIContext ui = getUI();
		ui.click(new JButtonLocator("New"));
		ui.assertThat(new LabeledTextLocator("Last Name").isEnabled());
		ui.assertThat(new LabeledTextLocator("Phone").isEnabled());
		ui.assertThat(new LabeledTextLocator("Address 1").isEnabled());
		ui.assertThat(new LabeledTextLocator("City").isEnabled());
		ui.assertThat(new LabeledTextLocator("Address 2").isEnabled());
		ui.assertThat(new JButtonLocator("Edit").isEnabled());
		ui.assertThat(new LabeledTextLocator("First Name").isEnabled());
		ui.assertThat(new LabeledTextLocator("Email").isEnabled());
		ui.assertThat(new LabeledTextLocator("Middle Name").isEnabled());
		ui.assertThat(new LabeledTextLocator("Country").isEnabled());
		ui.assertThat(new JTextComponentLocator(JTextField.class)
				.isEnabled());
		ui.click(new NamedWidgetLocator("frame0"));
	}
	
	/**
	 * @throws Exception
	 */
	public void testAssertThree() throws Exception {
		IUIContext ui = getUI();
		ui.click(new JButtonLocator("New"));
		ui.click(new LabeledTextLocator("Last Name"));
		ui.enterText("toto");
		ui.click(new JButtonLocator("Save"));
		ui.click(new JListLocator("toto,"));
		ui.assertThat(new JButtonLocator("Delete").isEnabled());
		ui.click(new NamedWidgetLocator("frame0"));
	}
	
	/**
	 * @throws Exception
	 */
	public void testAssertFour() throws Exception {
		IUIContext ui = getUI();
		ui.assertThat(new JButtonLocator("Save").isEnabled(false));
		ui.click(new JButtonLocator("New"));
		ui.assertThat(new JButtonLocator("Save").isEnabled(false));
		ui.click(new LabeledTextLocator("Last Name"));
		ui.enterText("toto");
		ui.assertThat(new JButtonLocator("Save").isEnabled());
		ui.click(new NamedWidgetLocator("frame0"));
	}
	
	/**
	 * @throws Exception
	 */
	public void testAssertFive() throws Exception {
		IUIContext ui = getUI();
		ui.assertThat(new JButtonLocator("Delete").isEnabled(false));
		ui.click(new LabeledTextLocator("Last Name"));
		ui.enterText("toto");
		ui.click(new JButtonLocator("Save"));
		ui.assertThat(new JButtonLocator("Delete").isEnabled(false));
		ui.click(new NamedWidgetLocator("frame0"));
	}
		
}