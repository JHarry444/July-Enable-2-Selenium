package com.qa.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DemoTest {

	private RemoteWebDriver driver;

	@BeforeEach
	void setup() {
		this.driver = new ChromeDriver(); // opens a new window
	}

	@Test
	void demoTest() {
		this.driver.get("https://www.bbc.co.uk/search?q="); // goes to the page
		WebElement search = this.driver.findElement(By.cssSelector("#search-input")); // selects the search input
		search.sendKeys("Turtles"); // types in "turtles"
		search.sendKeys(Keys.ENTER); // submits using the enter key
//		this.driver.findElement(By.cssSelector("#main-content > div:nth-child(2) > form > div > div > div > button"))
//				.click();
		// First result in the results page:
		WebElement result = this.driver.findElement(By.cssSelector(
				"#main-content > div:nth-child(3) > div.ssrcss-1v7bxtk-StyledContainer.enjd40x0 > div > div > ul > li:nth-child(1) > div > div > div.ssrcss-tq7xfh-PromoContent.e1f5wbog7 > div.ssrcss-1f3bvyz-Stack.e1y4nx260 > a > span > p > span"));

//		search.getRect();  lol
		// comparing the text of the result to the expected value
		assertEquals("The Man Who Made Mock Turtle Soup", result.getText());

	}

	@AfterEach
	void tearDown() {
		this.driver.close();
	}
}
