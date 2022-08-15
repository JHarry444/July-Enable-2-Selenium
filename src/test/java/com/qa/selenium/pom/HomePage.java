package com.qa.selenium.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	@FindBy(id = "search_query_top")
	private WebElement searchBar;

	@FindBy(css = "#searchbox > button")
	private WebElement searchButton;

	public void search(String query) {
		this.searchBar.sendKeys(query);
		this.searchButton.click();
	}
}
