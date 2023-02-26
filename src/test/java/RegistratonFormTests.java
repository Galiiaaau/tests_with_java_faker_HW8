import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistratonFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillRegistrationForm() {
        open("https://demoqa.com/automation-practice-form");
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Frida");
        $("#lastName").setValue("Kahlo");
        $("#userEmail").setValue("fridaKahlo@gmail.com");
        $(byText("Female")).click();
        $("#userNumber").setValue("8495777888");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-dropdown-container").$(byText("June")).click();
        $(".react-datepicker__year-select").selectOptionByValue("1994");
        $(".react-datepicker__month-container").$(byText("13")).click();
        $("#subjectsInput").setValue("Biology").pressEnter();
        $(byText("Music")).click();
        File fileToUpload = new File("src/test/resources/cat.jpg");
        $("#uploadPicture").uploadFile(fileToUpload);
        $("#currentAddress").setValue("Hong Kong");
        $(("#state")).click();
        $(byText("Haryana")).click();
        $(("#city")).click();
        $(byText("Karnal")).click();
        $(("#submit")).click();

        $(".modal-open").shouldHave(text("Thanks for submitting the form"));
        $("table tbody tr:nth-child(1) td:nth-child(2)").shouldHave(exactText("Frida Kahlo"));
        $("table tbody tr:nth-child(2) td:nth-child(2)").shouldHave(exactText("fridaKahlo@gmail.com"));
        $("table tbody tr:nth-child(3) td:nth-child(2)").shouldHave(exactText("Female"));
        $("table tbody tr:nth-child(4) td:nth-child(2)").shouldHave(exactText("8495777888"));
        $("table tbody tr:nth-child(5) td:nth-child(2)").shouldHave(exactText("13 June,1994"));
        $("table tbody tr:nth-child(6) td:nth-child(2)").shouldHave(exactText("Biology"));
        $("table tbody tr:nth-child(7) td:nth-child(2)").shouldHave(exactText("Music"));
        $("table tbody tr:nth-child(8) td:nth-child(2)").shouldHave(exactText("cat.jpg"));
        $("table tbody tr:nth-child(9) td:nth-child(2)").shouldHave(exactText("Hong Kong"));
        $("table tbody tr:nth-child(10) td:nth-child(2)").shouldHave(exactText("Haryana Karnal"));
        $("#closeLargeModal").click();
    }
}
