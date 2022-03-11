package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.HomePage;

public class AppTest extends BaseTest {

	@Test
	public void test() {
		HomePage homePage = new HomePage(driver);
		homePage.getPreference().click();
	}
}
