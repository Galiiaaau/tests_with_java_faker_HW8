package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


import static utils.RandomUtils.*;
import static utils.Utils.*;

public class RegistrationWithFakerTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void successfulRegistrationForm() {

        // set input
        registrationPage.openPage()
                        .removeBanners()
                        .setFirstName(firstName)
                        .setLastName(lastName)
                        .setEmail(emailAddress)
                        .setGender(userGender)
                        .setPhoneNumber(String.valueOf(userMobile))
                        .setBirthDate(birthDay, birthMonth, birthYear)
                        .setSubject(userSubject)
                        .setHobbies(userHobby)
                        .setPicture(nameWithPathToPicture)
                        .setAddress(currentAddress)
                        .setStateAndCity(state, city);

        // verify input
        registrationPage.verifyResultsModalAppears()
                        .verifyNameResult("Student Name", firstName + " " + lastName)
                        .verifyEmailResult("Student Email", emailAddress)
                        .verifyGenderResult("Gender", userGender)
                        .verifyMobileResult("Mobile", String.valueOf(userMobile))
                        .verifyBirthDateResult("Date of Birth", birthDay + " " + birthMonth + "," + birthYear)
                        .verifySubjectResult("Subjects", userSubject)
                        .verifyHobbiesResult("Hobbies", userHobby)
                        .verifyPictureResult("Picture", picture)
                        .verifyAddressResult("Address", currentAddress)
                        .verifyStateAndCityResult("State and City", state + " " + city);

        // close modal window
        registrationPage.modalWindowClose();
    }
}
