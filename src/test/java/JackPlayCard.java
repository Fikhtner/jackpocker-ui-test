import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.devtools.v130.browser.Browser.close;

public class JackPlayCard {

    @BeforeEach
    void setup() {
        Configuration.browser = "chrome";
        Configuration.timeout = 60000;
        Configuration.pageLoadTimeout = 50000;
        Configuration.holdBrowserOpen = true;
        open("https://jack-playcard.com/d/?tables/all");
    }

    @AfterEach
    void tearDown() {
        close();
    }

    @Test
    void registrationInvalidShortNickname() {
        $("input[type='email']").setValue("test" + System.currentTimeMillis() + "@test.com");
        $("input[type='password']").setValue("Test123456");
        $("div.field-wrapper.nick-field-wrapper input[type='text']").setValue("a");
        $(".confirmRules-field-container .FormField__control").click();
        $(".send-form.SimpleButton_interactive").click();=
        $(byText("Nickname should contain at least 3 characters")).shouldBe(visible);

    }

    @Test
    void registrationInvalidShortPassword() {
        $("input[type='email']").setValue("test" + System.currentTimeMillis() + "@test.com");
        $("input[type='password']").setValue("123");
        $("div.field-wrapper.nick-field-wrapper input[type='text']").setValue("ValidNick");
        $(".confirmRules-field-container .FormField__control").click();
        $(".send-form.SimpleButton_interactive").click();
        $(byText("Password should contain at least 5 characters.")).shouldBe(visible);
    }

    @Test
    void registrationInvalidEmailFormat() {
        $("input[type='email']").setValue("invalidEmail");
        $("input[type='password']").setValue("Test123456");
        $("div.field-wrapper.nick-field-wrapper input[type='text']").setValue("ValidNick");
        $(".confirmRules-field-container .FormField__control").click();
        $(".send-form.SimpleButton_interactive").click();

        $(byText("Incorrect email format")).shouldBe(visible);
    }

    @Test
    void registrationWithoutCheckbox() {
        $("input[type='email']").setValue("test" + System.currentTimeMillis() + "@test.com");
        $("input[type='password']").setValue("Test123456");
        $("div.field-wrapper.nick-field-wrapper input[type='text']").setValue("ValidNick");
        $(byText("CREATE ACCOUNT")).shouldNotBe(visible);
    }

    @Test
    void registrationInvalidLongNickname() {
        $("input[type='email']").setValue("test" + System.currentTimeMillis() + "@test.com");
        $("input[type='password']").setValue("Test123456");
        $("div.field-wrapper.nick-field-wrapper input[type='text']").setValue("ThisNicknameIsTooLong");
        $(".confirmRules-field-container .FormField__control").click();
        $(".send-form.SimpleButton_interactive").click();
        $(byText("Nickname should contain at most 16 characters.")).shouldBe(visible);
    }

    @Test
    void registrationInvalidLongPassword() {
        $("input[type='email']").setValue("test" + System.currentTimeMillis() + "@test.com");
        $("input[type='password']").setValue("ThisPasswordIsWayTooLong123");
        $("div.field-wrapper.nick-field-wrapper input[type='text']").setValue("ValidNick");
        $(".confirmRules-field-container .FormField__control").click();
        $(".send-form.SimpleButton_interactive").click();
        $(byText("Password should contain at most 20 characters.")).shouldBe(visible);
    }
@Test
    void registrationValid() {
        $("input[type='email']").setValue("test" + System.currentTimeMillis() + "@test.com");
        $("input[type='password'] ").setValue("Test123456");
        $("div.field-wrapper.nick-field-wrapper input[type='text']").setValue("ui" + System.currentTimeMillis());
        $(".confirmRules-field-container .FormField__control").click();
        $(".send-form.SimpleButton_interactive").click();
    }
    }
