package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationWithPageObjectsTests {

    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successfulRegistrationForm() {
        String userName = "Frida";
        String userLastName = "Kahlo";
        String emailAddress = "fridaKahlo@gmail.com";
        String gender = "Female";
        String mobile = "8495777888";
        String birthDate = "30 March,2008";
        String subject = "Biology";
        String hobbies = "Music";
        String picture = "cat.jpg";
        String address = "Hong Kong";
        String state = "Haryana";
        String city = "Karnal";
        String pathToPicture = "src/test/resources/cat.jpg";

        // set input
        registrationPage.openPage()
                        .removeBanners()
                        .setFirstName(userName)
                        .setLastName(userLastName)
                        .setEmail(emailAddress)
                        .setGender()
                        .setPhoneNumber(mobile)
                        .setBirthDate("30", "March", "2008")
                        .setSubject(subject)
                        .setHobbies(hobbies)
                        .setPicture(pathToPicture)
                        .setAddress(address)
                        .setStateAndCity(state, city);

        // verify input
        registrationPage.verifyResultsModalAppears()
                        .verifyNameResult("Student Name", userName + " " + userLastName)
                        .verifyEmailResult("Student Email", emailAddress)
                        .verifyGenderResult("Gender", gender)
                        .verifyMobileResult("Mobile", mobile)
                        .verifyBirthDateResult("Date of Birth", birthDate)
                        .verifySubjectResult("Subjects", subject)
                        .verifyHobbiesResult("Hobbies", hobbies)
                        .verifyPictureResult("Picture", picture)
                        .verifyAddressResult("Address", address)
                        .verifyStateAndCityResult("State and City", state + " " + city);

        // close modal window
        registrationPage.modalWindowClose();
    }
}
