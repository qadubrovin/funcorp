package ru.funcorp.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FunCorpMainPage {

    //selectors
    public SelenideElement aboutTitle = $("#about-title"),
            productTitle = $(".Products__title"),
            appStoreIcon = $(".Products__store a"),
            todaysJob = $(byText("Today’s jobs")),
            jobDescription = $(".Job__description p"),
            seniorBackendQADescription = $x("//*[contains(text(),'Senior QA Backend Engineer')]/../..");

    //methods
    public void openFuncorp() {
        open("https://fun.co/");
        $("#about-link").shouldHave(text("About"));
    }

    public void checkAppleStore() {
        Selenide.switchTo().window(1);
        $(".we-localnav__title__product").shouldHave(text("App Store"));
        $(".product-header h1").shouldHave(text("iFunny – hot memes and videos"));
    }

    public void goToVacancy() {
        $("#career-link").click();
        $(".Office__button").click();
    }

}
