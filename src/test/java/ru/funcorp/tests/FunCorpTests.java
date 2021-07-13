package ru.funcorp.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.funcorp.pages.FunCorpMainPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class FunCorpTests extends TestBase {

    FunCorpMainPage promo = new FunCorpMainPage();

    String aboutTitleText = "Entertainment apps  with over million of users worldwide",
            qaSpecialist = "QA specialist",
            tariffsText = "списание остатка до минимальной платы происходит в конце месяца",
            alertNotificationPhone = "Укажите номер телефона",
            englishHeader = "Our Products";

    @Test
    @DisplayName("Check about title text")
    void promoTitle() {
        step("Открыть https://fun.co/", () -> {
            promo.openFuncorp();
        });

        step("Check title text", () -> {
            promo.aboutTitle.shouldHave(text(aboutTitleText));
        });
    }

    @Test
    @DisplayName("Check App Store is available")
    void appStoreIsAvailable() {
        step("Открыть https://fun.co/", () -> {
            promo.openFuncorp();
        });

        step("Scroll into view of application stores", () -> {
            promo.productTitle.scrollIntoView(true);
        });

        step("Transition to app store", () -> {
            promo.appStoreIcon.click();
        });

        step("Check apple store available", () -> {
            promo.checkAppleStore();
        });
    }

    @Test
    @DisplayName("Check QA backend vacancy")
    void qaBackendVacancy() {
        step("Открыть https://fun.co/", () -> {
            promo.openFuncorp();
        });

        step("Go to vacancy", () -> {
            promo.goToVacancy();
            promo.todaysJob.scrollIntoView(true);
        });

        step("Check QA vacancy", () -> {
            promo.seniorBackendQADescription.click();
            promo.jobDescription.shouldHave(text(qaSpecialist));

        });

    }

}