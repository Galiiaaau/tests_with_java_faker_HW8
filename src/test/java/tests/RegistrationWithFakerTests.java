package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.util.Locale;

import static utils.RandomUtils.*;

public class RegistrationWithFakerTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    String picture = "cat.jpg";
    String pathToPicture = "src/test/resources/cat.jpg";


    @Test
    void successfulRegistrationForm() {

        Faker faker = new Faker(new Locale("it"));


        String userName =getRandomName(),
               userLastName = getRandomLastName(),
               emailAddress = getRandomEmail(),
               currentAddress = getRandomAddress(),
               gender = getRandomGender(),
               subject = getRandomSubject(),
               birthDay = getRandomBirthDay(),
               birthMonth = getRandomBirthMonth(),
               birthYear = getRandomBirthYear(),
                mobile = getRandomMobile(),
                hobby = getRandomHobby(),
                state = getRandomState(),
                city = getRandomCity(state);


        // set input
        registrationPage.openPage()
                        .removeBanners()
                        .setFirstName(userName)
                        .setLastName(userLastName)
                        .setEmail(emailAddress)
                        .setGender(gender)
                        .setPhoneNumber(String.valueOf(mobile))
                        .setBirthDate(birthDay, birthMonth, birthYear)
                        .setSubject(subject)
                        .setHobbies(hobby)
                        .setPicture(pathToPicture)
                        .setAddress(currentAddress)
                        .setStateAndCity(state, city);

        // verify input
        registrationPage.verifyResultsModalAppears()
                        .verifyNameResult("Student Name", userName + " " + userLastName)
                        .verifyEmailResult("Student Email", emailAddress)
                        .verifyGenderResult("Gender", gender)
                        .verifyMobileResult("Mobile", String.valueOf(mobile))
                        .verifyBirthDateResult("Date of Birth", birthDay + " " + birthMonth + "," + birthYear)
                        .verifySubjectResult("Subjects", subject)
                        .verifyHobbiesResult("Hobbies", hobby)
                        .verifyPictureResult("Picture", picture)
                        .verifyAddressResult("Address", currentAddress)
                        .verifyStateAndCityResult("State and City", state + " " + city);

        // close modal window
        registrationPage.modalWindowClose();
    }
}
