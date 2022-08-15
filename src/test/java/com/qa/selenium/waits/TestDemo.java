package com.qa.selenium.waits;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestDemo {

	private String url = "https://christophperrins.github.io/TestingSite/";

	private RemoteWebDriver driver;

	@BeforeEach
	void setup() {
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();

//		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test
	void testDelay() {
		this.driver.get(url);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

//		WebElement surprise = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#quote > h1")));
		WebElement surprise = this.driver.findElement(By.cssSelector("#quote > h1"));

		assertEquals("Surprise!", surprise.getText());
	}

	@AfterEach
	void tearDown() {
		this.driver.close();
	}

}
