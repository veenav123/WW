package com.ww.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ww.qa.base.TestBase;

public class HomePage extends TestBase {
	//**********Defining object repositiries***********************//
	
	/**Page Object of WW Home Pages**/
	//@FindBy(className="Find a Studio")
	@FindBy(xpath="//span[@class='menu-link__inner-wrapper' and contains(text(),'Find a Studio')]")
	public WebElement findstudio;
	
	/**Intaializing Page Objects:**/
	public HomePage(){
		PageFactory.initElements(driver,this	);
	}

	/*******************************Actions***********************************
	 * 
	 * 
	 * 
	*********validateLoginPageTitle***************************/
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}

	public StudiosandMeetingsPage clickFindStudio(){
		findstudio.click();
		return new StudiosandMeetingsPage();
	}
}
