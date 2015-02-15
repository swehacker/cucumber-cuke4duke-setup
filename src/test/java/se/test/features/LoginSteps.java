package se.test.features;

import com.thoughtworks.selenium.SeleneseTestCase;

import cuke4duke.annotation.After;
import cuke4duke.annotation.Before;
import cuke4duke.annotation.I18n.EN.Given;
import cuke4duke.annotation.I18n.EN.Then;
import cuke4duke.annotation.I18n.EN.When;
import cuke4duke.spring.StepDefinitions;

@StepDefinitions
public class LoginSteps extends SeleneseTestCase {

	private final static String USERNAME = "_Header_login-username";
	private final static String PASSWORD = "_Header_login-password";
	private final static String SUBMIT = "_Header_login";

	@Before
	public void setup() throws Exception {
		this.setUp("https://eshopqa.atea.com", "*firefox");
	}

	@After
	public void tearDown() {
		this.selenium.close();
	}

	@Given("I am on the dk web site")
	public void haveSkeletonWebApplication() {
		this.selenium.open("/dk/");
	}

	@When("I fill in \"(.*)\" with \"(.*)\"")
	public void iFillIn(String inputField, String value) {
		if ("username".equalsIgnoreCase(inputField)) {
			inputField = USERNAME;
		} else if ("password".equalsIgnoreCase(inputField)) {
			inputField = PASSWORD;
		}

		this.selenium.type(inputField, value);
	}

	@When("I press the button \"(.*)\"")
	public void iPressTheButton(String btnName) {
		if ("submit".equalsIgnoreCase(btnName)) {
			btnName = SUBMIT;
		}

		this.selenium.click(btnName);
		this.selenium.waitForPageToLoad("30000");
	}

	@Then("^I should see the message \"([^\"]*)\"$")
	public void iShouldSeeMessage(String expectedTitle) {
		assertEquals(true, selenium.isTextPresent(expectedTitle));
	}
}
