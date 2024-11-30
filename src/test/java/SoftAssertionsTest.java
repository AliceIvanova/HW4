import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertionsTest {
  @BeforeAll
  static void beforeAll() {
    Configuration.browserSize = "1920x1080";
    Configuration.browser = "edge";
 //   Configuration.pageLoadStrategy = "eager";
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
    $(".repository-content ").shouldHave(text("<div id='first' style='display:none;'>First</div>\n" +
      "  <div id='second' style='display:none;'>Second</div>"));
  }
}