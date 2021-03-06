package com.rtb.Tests;

import com.rtb.Pages.HomePage;
import com.rtb.Pages.SearchPage;
import com.rtb.Pages.SignInPage;
import com.rtb.Settings.Base;
import org.junit.Test;


public class LoginTest extends Base {

    @Test
    // 1. Registration
    public void testFlow() throws InterruptedException {
        HomePage homepage = new HomePage(driver);
        homepage.registrationSite(userName, userEmail, userPassword);
//        homepage.clickXiconGenresPopUp();
        homepage.clickGoodreadsLabel();
//
        homepage.clickSignOut();
        homepage.clickGoodreadsHomeInscription();
    // 2. Login with invalid credentials
        homepage.loginSite(userEmail, invalidUserPassword);
        homepage.clickXiconGenresPopUp();
        SignInPage signInpage = new SignInPage(driver);
        signInpage.assertSignInPageTitle();
    // 3. Login with valid credentials
        homepage.loginSite(userEmail, userPassword);
        //homepage.clickXiconGenresPopUp();
    // 4. Search for “Best crime and mystery books”
        homepage.bookSearch(userBookTitle);
        SearchPage searchpage = new SearchPage(driver);
//        searchpage.closePopUp();
    // 5. Mark top 3 books as “Want to read”
        searchpage.clickWantToReadButtons123();
    // 6. Mark as read
        searchpage.markReadInDropDownList1();
        Thread.sleep (1000);
        searchpage.markReadInDropDownList2();
        Thread.sleep (1000);
        searchpage.markReadInDropDownList3();
    // 7. Rate and leave feedback for them (add different read dates)
        searchpage.clickRate1();
        searchpage.setReview1(userReview1);
        searchpage.clickSaveButtonReadPopUp1();
        homepage.bookSearch(userBookTitle);

        searchpage.clickRate3();
        searchpage.setReview2(userReview2);
        searchpage.clickSaveButtonReadPopUp2();
        homepage.bookSearch(userBookTitle);

        searchpage.clickRate5();
        searchpage.setReview3(userReview3);
        searchpage.clickSaveButtonReadPopUp3();
        homepage.bookSearch(userBookTitle);
    // 8. Logout
        homepage.clickSignOut();
    }
}
