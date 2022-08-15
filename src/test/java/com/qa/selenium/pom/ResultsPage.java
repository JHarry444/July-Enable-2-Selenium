package com.qa.selenium.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultsPage {

	@FindBy(css = "#center_column > ul > li:nth-child(1) > div > div.right-block > h5 > a")
	private WebElement firstResult;

	public String getResult() {
		return this.firstResult.getText();
	}

}
