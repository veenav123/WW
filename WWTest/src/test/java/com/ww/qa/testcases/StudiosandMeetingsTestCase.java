package com.ww.qa.testcases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ww.qa.base.TestBase;
import com.ww.qa.pages.HomePage;
import com.ww.qa.pages.StudiosandMeetingsPage;

public class StudiosandMeetingsTestCase extends TestBase {
	HomePage homePage;
	StudiosandMeetingsPage studiosandMeetingsPage;

	public StudiosandMeetingsTestCase() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		intialization();
		homePage = new HomePage();
		studiosandMeetingsPage = new StudiosandMeetingsPage();
	}

	@Test(priority = 1)
	public void HomePageTitle() {
		String homePageTitle = homePage.validateLoginPageTitle();
		Assert.assertEquals(homePageTitle, "WW (Weight Watchers): Weight Loss & Wellness Help");

	}

	@Test(priority = 2)
	/***********finding studio**************/
	public void findStudio() {
		studiosandMeetingsPage = homePage.clickFindStudio();
		String studiosandMeetingsPageTitle=studiosandMeetingsPage.validateStudiosandMeetingsPageTitle();
		//Assert.assertEquals(studiosandMeetingsPageTitle, "Find WW Studios & Meetings Near You | WW USA");
		studiosandMeetingsPage.enterLocation();
		String displayedLocation= studiosandMeetingsPage.location.getText();
		studiosandMeetingsPage.location.click();
		String selectedLocation=studiosandMeetingsPage.location.getText();
		Assert.assertTrue(displayedLocation.contains(selectedLocation));
		
		
				
	}
	
	@Test(priority = 3)
	/**********************display current day schedules and meeting for a particular day************************/
	public void findMeeting() {
	
		studiosandMeetingsPage.displayCurrentSchedules("TUE");
		
				
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
