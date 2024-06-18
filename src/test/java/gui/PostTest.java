package gui;

import com.skillo.POM.HomePage;
import com.skillo.POM.LoginPage;
import com.skillo.POM.PostPage;
import gui.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

public class PostTest extends TestBase {
    @DataProvider(name = "DataProviderPostTest")
     public Object[][] getUsers() {
        File postPicture = new File("C:\\Users\\Presi\\dog2.jpg");
        String caption = "Make a caption test 2";

        return new Object[][]{{
                "presi2345",
                "Preslavaa", postPicture, caption},
        };
    }

    @Test(dataProvider = "DataProviderPostTest")
    public void makeAPost(String password,String username,
                          File file,
                          String caption) throws InterruptedException {

        HomePage homePage = new HomePage(super.driver, log);
        var postPage = new PostPage(super.driver, log);

        log.info("STEP 1: Not logged in user has open the ISkilo HomePage.");
        homePage.openHomePage();

        log.info("STEP 2: The user has navigated to ISkilo LoginPage");
        homePage.navigateToLoginPageViaClickOnNavigationLoginButton();

        log.info("STEP 3: The user has verified that the LoginPage is open as per requirements ");
        var loginPage = new LoginPage(super.driver, log);

        log.info("STEP 4: The user has login with username and password ");
        loginPage.loginWithUSerAndPassword(username,password);

        log.info("STEP 5: The user has clicked on new post button");
        postPage.clickOnButtonNewPost();
        Thread.sleep(90);

        log.info("STEP 6: The user uploaded a picture");
        postPage.uploadAPicture(file);
        Thread.sleep(150);


        log.info("STEP 7: Show that the image is visible");
        Assert.assertTrue(postPage.isImageVisible(), "The image is not visible!");
        Assert.assertEquals(file.getName(), postPage.getImageName(), "The image name is incorrect!");
        Thread.sleep(150);

        log.info("STEP 8: The user has provided a caption and has clicked the submit button");
        postPage.providePostCaption(caption);
        postPage.clickSubmitPostButton();
        Thread.sleep(150);

        postPage.postIsCreated();
        Thread.sleep(150);



    }
}