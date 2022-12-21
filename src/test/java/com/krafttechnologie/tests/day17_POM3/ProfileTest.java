package com.krafttechnologie.tests.day17_POM3;

import com.krafttechnologie.pages.DashboardPage;
import com.krafttechnologie.pages.LoginPages;
import com.krafttechnologie.pages.ProfilePage;
import com.krafttechnologie.tests.TestBase;
import com.krafttechnologie.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ProfileTest extends TestBase {

    LoginPages loginPages=new LoginPages();
    ProfilePage profilePage=new ProfilePage();
    DashboardPage dashboardPage=new DashboardPage();


    @Test
    public void editProfile(){

        loginPages.loginUser();
        dashboardPage.myProfile.click();
        BrowserUtils.waitFor(3);
        profilePage.profileTabs("Edit Profile");

        profilePage.fullName.clear();
        profilePage.fullName.sendKeys("Rabinson");

        profilePage.about.clear();
        profilePage.about.sendKeys("Some words are here");

        profilePage.company.clear();
        profilePage.company.sendKeys("GHAN IT");

        BrowserUtils.waitForPresenceOfElement(By.cssSelector("#terms"),5);
        BrowserUtils.dragAndDropBy(profilePage.slider); //**slide menu-BrowserUtils'den metod çağırılır

        Select select=new Select(profilePage.job);
        select.selectByVisibleText("Developer");

        profilePage.website.clear();
        profilePage.website.sendKeys("https://krafttechnologie.com");

        profilePage.location.clear();
        profilePage.location.sendKeys("Istanbul");

        profilePage.skills.clear();
        profilePage.skills.sendKeys("TestNG, Cucumber");

        // profilePage.save.click();
        BrowserUtils.clickWithJS(profilePage.save);

    }

    @Test
    public void addExperience() throws InterruptedException {

        loginPages.loginUser();
        dashboardPage.myProfile.click();
        BrowserUtils.waitFor(3);
        profilePage.profileTabs("Add Experience");

        profilePage.jobTitle.clear();
        profilePage.jobTitle.sendKeys("Software Tester");

        profilePage.companyexperience.clear();
        profilePage.companyexperience.sendKeys("Kraft Tech");

        profilePage.locationExperience.clear();
        profilePage.locationExperience.sendKeys("Ankara");

        profilePage.startYear.clear();
        profilePage.startYear.sendKeys("2020");

        profilePage.endYear.clear();
        profilePage.endYear.sendKeys("2022");

        profilePage.jobDescription.clear();
        profilePage.jobDescription.sendKeys("High Salary");

        // profilePage.addExperienceBtn.click();
        BrowserUtils.clickWithJS(profilePage.save);

    }

}
