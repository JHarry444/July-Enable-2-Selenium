package com.qa.selenium.solution;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingTest {

	private RemoteWebDriver driver;

	@BeforeEach
	void setup() {
		ChromeOptions opts = new ChromeOptions();
//		opts.setHeadless(true);
		this.driver = new ChromeDriver(opts);
		this.driver.manage().window().maximize();
	}

	@Test
	void testCheckout() {
		this.driver.get("http://www.automationpractice.com");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		WebElement search = this.driver.findElement(By.id("search_query_top"));
		search.sendKeys("Dress");
		search.sendKeys(Keys.ENTER);

		WebElement dress = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
				"#center_column > ul > li:nth-child(1) > div > div.left-block > div > a.product_img_link > img")));
		new Actions(driver).scrollToElement(dress).moveToElement(dress).pause(Duration.ofMillis(500L)).perform();

		WebElement addToCart = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
				"#center_column > ul > li:nth-child(1) > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default > span")));
		wait.until(ExpectedConditions.elementToBeClickable(addToCart));

		addToCart.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
				"#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a")))
				.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
				"#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium > span")))
				.click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email"))).sendKeys("J@H.com");
		this.driver.findElement(By.id("passwd")).sendKeys("password");
		this.driver.findElement(By.id("SubmitLogin")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#center_column > form > p > button > span")))
				.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#form > div > p.checkbox > label"))).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#form > p > button > span"))).click();

		wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("#HOOK_PAYMENT > div:nth-child(1) > div > p > a"))).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#cart_navigation > button"))).click();

		assertEquals("Your order on My Store is complete.",
				this.driver.findElement(By.cssSelector("#center_column > div > p")).getText());

	}

	@AfterEach
	void tearDown() {
		this.driver.close();
	}
}
