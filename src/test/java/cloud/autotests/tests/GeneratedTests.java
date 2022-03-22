package cloud.autotests.tests;

import cloud.autotests.helpers.DriverUtils;
import jdk.jfr.Description;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;
import static io.qameta.allure.Allure.step;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.atomic.AtomicInteger;

public class GeneratedTests extends TestBase {

    @ValueSource(strings = {"SWIFT-сообщения свободного формата МТ799, МТ999"})
    @ParameterizedTest (name = "Search by application name on the website")
    void searchTestNameApplication(String testData) {
        step("Open catalog.cft.ru", () ->
            open("https://catalog.cft.ru/")
        );

        step("Input in the search box the name of the application " + testData, () -> {
            $("input[aria-label='search']").setValue(testData).pressEnter();
        });

        step("Check the search results", () -> {
            $$("[id='simple-tabpanel-0']").findBy(text(testData)).shouldBe(visible);
        });
    }

    @ValueSource(strings = {"1B280190"})
    @ParameterizedTest(name = "Search by application code on the website")
    void searchTestCodeApplication(String testData) {
        step("Open catalog.cft.ru", () ->
            open("https://catalog.cft.ru/")
        );

        step("Input in the search box the code of the application " + testData, () -> {
            $("input[aria-label='search']").setValue(testData).pressEnter();
        });

        step("Check the search results", () -> {
            $$("[id='simple-tabpanel-0']").findBy(text(testData)).shouldBe(visible);
        });
    }

    @CsvSource(value = {
            "rgba(255, 255, 255, 1)| rgba(235, 80, 94, 1)"}, delimiter = '|')
    @ParameterizedTest (name ="Checking the operation of \"chips\" on the main page")
    void chipsMainTest(String testData, String expectedText) {
        AtomicInteger collectionNotChipsUse = new AtomicInteger();
        AtomicInteger collectionChipsUse = new AtomicInteger();
        AtomicInteger collectionNotChipsUse2 = new AtomicInteger();

        step("Open catalog.cft.ru", () ->
            open("https://catalog.cft.ru/")
        );

        step("Checking the initial state of the \"chips\"", () -> {
           collectionNotChipsUse.set($$("div.MuiGrid-root.MuiGrid-container.MuiGrid-spacing-xs-3").size());
            $$("#ChipArrayCntr ul li div[role='button']").first().shouldHave(cssValue("background-color", testData));
        });

        step("Click on the \"chips\"", () ->
            $$("#ChipArrayCntr ul li").first().click()
        );

        step("Checking the status of the \"chips\" after its selection", () -> {
            $$("#ChipArrayCntr ul li div[role='button']").first().shouldHave(cssValue("background-color", expectedText));
        });


        step("Checking filtering by the selected \"chips\"", () -> {
            collectionChipsUse.set($$("div.MuiGrid-root.MuiGrid-container.MuiGrid-spacing-xs-3").size());
            assertThat(collectionNotChipsUse.get() < collectionChipsUse.get());
        });


        step("Click on the selected \"chips\"", () ->
            $$("#ChipArrayCntr ul li div[role='button'] button.MuiButtonBase-root.MuiIconButton-root.MuiChip-deleteIcon").first().click()
        );

        step("Checking the status of the \"chips\" after use", () -> {
            $$("#ChipArrayCntr ul li div[role='button']").first().shouldHave(cssValue("background-color", testData));
        });

        step("Checking for lack of filtration if chips are not used", () -> {
            collectionNotChipsUse2.set($$("div.MuiGrid-root.MuiGrid-container.MuiGrid-spacing-xs-3").size());
            assertThat(collectionNotChipsUse2.get() > collectionChipsUse.get());
            System.out.println(assertThat(collectionNotChipsUse2.get() > collectionChipsUse.get()));
        });
    }

    @CsvSource(value = {
            "IDE| Плагин IDE PlpCheck",
            "экспресс-карт| Авторизация экспресс-карт",
            "удаленная идентификация| F.ID. Удаленная идентификация клиента в ЕБС"
    }, delimiter = '|')
    @ParameterizedTest (name = "Checking the availability of the application in the business direction and the catalog on the site")
    void applicationSearchTest(String testData, String expectedText) {
        step("Open catalog.cft.ru", () ->
            open("https://catalog.cft.ru/")
        );

        step("Input a query into the search bar " + testData, () -> {
            $("input[aria-label='search']").setValue(testData).pressEnter();
        });
        step("Checking the business direction " + expectedText + " in the catalog", () -> {
            $$("div.MuiGrid-root.MuiGrid-container.MuiGrid-item").findBy(text(expectedText)).shouldHave(visible);
        });
    }


    @Test
    @Description("Autogenerated test")
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Open catalog.cft.ru", () ->
                open("https://catalog.cft.ru/"));

        step("Page title should have text 'Каталоги Решений и Продуктов'", () -> {
            String expectedTitle = "Каталоги Решений и Продуктов";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @Disabled
    @Description("Autogenerated test")
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://catalog.cft.ru/'", () ->
                open("https://catalog.cft.ru/"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}