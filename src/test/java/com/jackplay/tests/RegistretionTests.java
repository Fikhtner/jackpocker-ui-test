

package com.jackplay.tests;

import com.codeborne.selenide.Configuration;
import com.jackplay.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class RegistretionTests {

    RegistrationPage page = new RegistrationPage();

    @BeforeEach
    void setup() {
        Configuration.browser = "chrome";
        Configuration.timeout = 60000;
        Configuration.pageLoadTimeout = 50000;
        Configuration.holdBrowserOpen = true;
        page.openPage();
    }

    @Test
    void registrationInvalidShortNickname() {
        page.email("test" + System.currentTimeMillis() + "@test.com")
                .password("Test123456")
                .nickname("a")
                .checkBox()
                .createAccount()
                .seeError("Nickname should contain at least 3 characters");
    }

    @Test
    void registrationInvalidShortPassword() {
        page.email("test" + System.currentTimeMillis() + "@test.com")
                .password("123")
                .nickname("ValidNick")
                .createAccount()
                .checkBox()
                .seeError("Password should contain at least 5 characters.");
    }

    @Test
    void registrationInvalidEmailFormat() {
        page.email("invalidEmail")
                .password("Test123456")
                .nickname("ValidNick")
                .checkBox()
                .createAccount()
                .seeError("Incorrect email format");
    }

    @Test
    void registrationWithoutCheckbox() {
        page.email("test" + System.currentTimeMillis() + "@test.com")
                .password("Test123456")
                .nickname("ValidNick")
                .shouldNotSeeCreateAccountButton();
    }

    @Test
    void registrationInvalidLongNickname() {
        page.email("test" + System.currentTimeMillis() + "@test.com")
                .password("Test123456")
                .nickname("ThisNicknameIsTooLong")
                .checkBox()
                .createAccount()
                .seeError("Nickname should contain at most 16 characters.");
    }

    @Test
    void registrationInvalidLongPassword() {
        page.email("test" + System.currentTimeMillis() + "@test.com")
                .password("ThisPasswordIsWayTooLong123")
                .nickname("ValidNick")
                .checkBox()
                .createAccount()
                .seeError("Password should contain at most 20 characters.");
    }



    @Test
    void registrationValid() {
        page.email("test" + System.currentTimeMillis() + "@test.com")
                .password("Test123456")
                .nickname("ui" + System.currentTimeMillis())
                .checkBox()
                .createAccount();

    }
}

