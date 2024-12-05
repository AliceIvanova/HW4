import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertionsTest {
  @BeforeAll
  static void setup() {
    Configuration.browserSize = "1920x1080";
    Configuration.browser = "edge";
  }
  @Test
  void findExampleJUnit5() {
    //- Откройте страницу Selenide в Github
    open("https://github.com/selenide/selenide");
    // - Перейдите в раздел Wiki проекта
    $("#wiki-tab").click();
    // - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
    $("#wiki-pages-filter").setValue("SoftAssertions").pressEnter();
    $(".filterable-active").shouldHave(text("SoftAssertions")).click();
    // - Откройте страницу SoftAssertions
    $(byText("Soft assertions")).click();
    //-проверьте что внутри есть пример кода для JUnit5
    $(".markdown-body").shouldHave(text("Example:"));
    $(".repository-content ").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
      "class Tests {\n" +
      "  @Test\n" +
      "  void test() {\n" +
      "    Configuration.assertionMode = SOFT;\n" +
      "    open(\"page.html\");\n" +
      "\n" +
      "    $(\"#first\").should(visible).click();\n" +
      "    $(\"#second\").should(visible).click();\n" +
      "  }\n" +
      "}"));
  sleep(20000);
  }
    @AfterEach
    void teardown() {
      Selenide.closeWebDriver();
  }
}