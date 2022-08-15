package com.qa.selenium.pom;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public class PomTest {

	private RemoteWebDriver driver;

	@BeforeEach
	void setup() {

		ChromeOptions opts = new ChromeOptions();
		opts.setHeadless(true);
		this.driver = new ChromeDriver(opts);
		this.driver.manage().window().maximize();
	}

	@Test
	void testPOM() {

		this.driver.get("http://www.automationpractice.com");

		HomePage home = PageFactory.initElements(driver, HomePage.class);

		home.search("Dress");

		ResultsPage results = PageFactory.initElements(driver, ResultsPage.class);

		assertEquals("Printed Summer Dress", results.getResult());

	}

	@AfterEach
	void tearDown() {
		this.driver.close();
	}
}
