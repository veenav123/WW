package com.ww.qa.pages;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.ww.qa.base.TestBase;

public class StudiosandMeetingsPage extends TestBase {
	
	@FindBy(id="meetingSearch")
	public WebElement locationsearchbox;
	
	
	@FindBy(xpath="//div[@class='location__top']")
	public WebElement location;	
   
	

	@FindAll(@FindBy(xpath="//div[@class='schedule-detailed-day']"))
	public List <WebElement>currentday;
	//@FindBy(xpath="//div[@class='menu-link__inner-wrapper']"
	//public List<WebElement> currentdayscheduledetails;
	
	
	
	public StudiosandMeetingsPage(){
		PageFactory.initElements(driver,this);
	}
	
	public void displayCurrentSchedules(String selectedDay){
		for (WebElement e  : currentday)
        {
			Calendar calendar = Calendar.getInstance();
			Date date = calendar.getTime();
			
			String curday=(new SimpleDateFormat("EE", Locale.ENGLISH).format(date.getTime())).toUpperCase();
			if(e.findElement(By.className("schedule-detailed-day-label")).getText().equals(curday)){
				System.out.println("--All meetings on "+ curday + "--");
				System.out.println(e.getText());
			}	
			if(e.findElement(By.className("schedule-detailed-day-label")).getText().equals(selectedDay)){
					
				System.out.println("--Number of meetings each person has on  "+ selectedDay +"--");
				ArrayList<String> list = new ArrayList<String>();
				for (WebElement l : e.findElements(By.className("schedule-detailed-day-meetings-item-leader"))){
					//System.out.println(l.getText());
					list.add(l.getText());
				}
				Set<String> st = new HashSet<String>(list); 
		        for (String s : st) 
		            System.out.println(s + ": " + Collections.frequency(list, s));
			}
        }
	}
	
	public String validateStudiosandMeetingsPageTitle(){
		return driver.getTitle();
	}
	public void enterLocation(){
		locationsearchbox.sendKeys("10011");
		locationsearchbox.sendKeys(Keys.ENTER);
	}
	
}
