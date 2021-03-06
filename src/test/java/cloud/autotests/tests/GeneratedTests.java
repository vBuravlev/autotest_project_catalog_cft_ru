package cloud.autotests.tests;

import cloud.autotests.config.Project;
import cloud.autotests.helpers.DriverUtils;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;
import static io.qameta.allure.Allure.step;

import java.util.concurrent.atomic.AtomicInteger;

public class GeneratedTests extends TestBase {


    @Test
    @DisplayName("Search by application name on the website")
    @Issue("Search-1000")
    void searchTestNameApplication() {
        step("Open catalog.cft.ru", () -> {
            open("https://catalog.cft.ru/");
        });

        step("Input in the search box the name of the application 1B280190", () -> {
            $("input[aria-label='search']").setValue("SWIFT-сообщения свободного формата МТ799, МТ999").pressEnter();
        });

        step("Check the search results", () -> {
            $$("[id='simple-tabpanel-0']").findBy(text("SWIFT-сообщения свободного формата МТ799, МТ999")).shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Search by application code on the website")
    void searchTestCodeApplication() {
        step("Open catalog.cft.ru", () -> {
            open("https://catalog.cft.ru/");
        });

        step("Input in the search box the code of the application 1B280190", () -> {
            $("input[aria-label='search']").setValue("1B280190").pressEnter();
        });

        step("Check the search results", () -> {
            $$("[id='simple-tabpanel-0']").findBy(text("1B280190")).shouldBe(visible);
        });
    }

    @Test
    @Issue("Search-1001")
    @DisplayName("Checking the operation of \"chips\" on the main page")
    void chipsMainTest() {
        AtomicInteger collectionNotChipsUse = new AtomicInteger();
        AtomicInteger collectionChipsUse = new AtomicInteger();
        AtomicInteger collectionNotChipsUse2 = new AtomicInteger();

        step("Open catalog.cft.ru", () -> {
            open("https://catalog.cft.ru/");
        });

        if (Project.config.browser().equals("firefox")) {
            step("Checking the initial state of the \"chips\"", () -> {
                collectionNotChipsUse.set($$("div.MuiGrid-root.MuiGrid-container.MuiGrid-spacing-xs-3").size());
                $$("#ChipArrayCntr ul li div[role='button']").first().shouldHave(cssValue("background-color", "rgb(255, 255, 255)"));
            });
        } else {
            step("Checking the initial state of the \"chips\"", () -> {
                collectionNotChipsUse.set($$("div.MuiGrid-root.MuiGrid-container.MuiGrid-spacing-xs-3").size());
                $$("#ChipArrayCntr ul li div[role='button']").first().shouldHave(cssValue("background-color", "rgba(255, 255, 255, 1)"));
            });
        }

        step("Click on the \"chips\"", () ->
                $$("#ChipArrayCntr ul li").first().click()
        );

        if (Project.config.browser().equals("firefox")) {
            step("Checking the status of the \"chips\" after its selection", () -> {
                $$("#ChipArrayCntr ul li div[role='button']").first().shouldHave(cssValue("background-color", "rgb(235, 80, 94)"));
            });
        } else {
            step("Checking the status of the \"chips\" after its selection", () -> {
                $$("#ChipArrayCntr ul li div[role='button']").first().shouldHave(cssValue("background-color", "rgba(235, 80, 94, 1)"));
            });
        }

        step("Checking filtering by the selected \"chips\"", () -> {
            collectionChipsUse.set($$("div.MuiGrid-root.MuiGrid-container.MuiGrid-spacing-xs-3").size());
            assertThat(collectionNotChipsUse.get() < collectionChipsUse.get());
        });


        step("Click on the selected \"chips\"", () ->
                $$("#ChipArrayCntr ul li div[role='button'] button.MuiButtonBase-root.MuiIconButton-root.MuiChip-deleteIcon").first().click()
        );

        if (Project.config.browser().equals("firefox")) {
            step("Checking the status of the \"chips\" after use", () -> {
                $$("#ChipArrayCntr ul li div[role='button']").first().shouldHave(cssValue("background-color", "rgb(255, 255, 255)"));
            });
        } else {
            step("Checking the status of the \"chips\" after use", () -> {
                $$("#ChipArrayCntr ul li div[role='button']").first().shouldHave(cssValue("background-color", "rgba(255, 255, 255, 1)"));
            });
        }
        

        step("Checking for lack of filtration if chips are not used", () -> {
            collectionNotChipsUse2.set($$("div.MuiGrid-root.MuiGrid-container.MuiGrid-spacing-xs-3").size());
            assertThat(collectionNotChipsUse2.get() > collectionChipsUse.get());
        });
    }

    @Test
    @Issue("Search-1002")    
    @DisplayName("Checking the availability of the application in the business direction and the catalog on the site")
    void applicationSearchTest() {
        step("Open catalog.cft.ru", () -> {
            open("https://catalog.cft.ru/");
        });

        step("Input a query into the search bar IDE", () -> {
            $("input[aria-label='search']").setValue("IDE").pressEnter();
        });
        step("Checking the business direction 'Плагин IDE PlpCheck' in the catalog", () -> {
            $$("div.MuiGrid-root.MuiGrid-container.MuiGrid-item").findBy(text("Плагин IDE PlpCheck")).shouldHave(visible);
        });
    }

    @Test
    @Issue("Search-1003")
    @Description("Autogenerated test")
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Open catalog.cft.ru", () -> {
            open("https://catalog.cft.ru/");
        });

        step("Page title should have text 'Каталоги Решений и Продуктов'", () -> {
            String expectedTitle = "Каталоги Решений и Продуктов";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @Issue("Search-1004")    
    @Description("Autogenerated test")
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open catalog.cft.ru", () -> {
            open("https://catalog.cft.ru/");
        });

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }




}
