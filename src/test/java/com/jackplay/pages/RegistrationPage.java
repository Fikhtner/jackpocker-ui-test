package com.jackplay.pages;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;

public class RegistrationPage {

    public RegistrationPage openPage() {
        open("https://jack-playcard.com/d/?tables/all");
        return this;
    }

    public RegistrationPage email(String email) {
        $("input[type='email']").setValue(email);
        return this;
    }

    public RegistrationPage password(String password) {
        $("input[type='password']").setValue(password);
        return this;
    }

    public RegistrationPage nickname(String nickname) {
        $("div.field-wrapper.nick-field-wrapper input[type='text']").setValue(nickname);
        return this;
    }

    public RegistrationPage checkBox() {
        $(".confirmRules-field-container .FormField__control").click();
        return this;
    }

    public RegistrationPage createAccount() {
        $(".send-form.SimpleButton_interactive").click();
        return this;
    }

    public RegistrationPage seeError(String errorText) {
        $(byText(errorText)).shouldBe(visible);
        return this;
    }

    public RegistrationPage shouldNotSeeCreateAccountButton() {
        $(byText("CREATE ACCOUNT")).shouldNotBe(visible);
        return this;
    }
}