package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;

import static io.qameta.allure.Allure.step;
import static utils.Utils.*;

public class RegistrationWithFakerTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    @Tag("java_faker")
    void successfulRegistrationForm() {

        RandomUtils testRandomUtils = new RandomUtils();

        step("Open form", () -> {
            registrationPage
                    .openPage()
                    .removeBanners();
        });

        step("Fill registration form", () -> {
            registrationPage
                    .setFirstName(testRandomUtils.getFirstName())
                    .setLastName(testRandomUtils.getLastName())
                    .setEmail(testRandomUtils.getEmailAddress())
                    .setGender(testRandomUtils.getUserGender())
                    .setPhoneNumber(String.valueOf(testRandomUtils.getUserMobile()))
                    .setBirthDate(testRandomUtils.getUserBirthDay(), testRandomUtils.getUserBirthMonth(), testRandomUtils.getUserBirthYear())
                    .setSubject(testRandomUtils.getUserSubject())
                    .setHobbies(testRandomUtils.getUserHobby())
                    .setPicture(nameWithPathToPicture)
                    .setAddress(testRandomUtils.getCurrentAddress())
                    .setStateAndCity(testRandomUtils.getUserState(), testRandomUtils.getUserCity());
        });

        step("Verify registration form", () -> {
            registrationPage
                    .verifyResultsModalAppears()
                    .verifyNameResult("Student Name", testRandomUtils.getFirstName() + " " + testRandomUtils.getLastName())
                    .verifyEmailResult("Student Email", testRandomUtils.getEmailAddress())
                    .verifyGenderResult("Gender", testRandomUtils.getUserGender())
                    .verifyMobileResult("Mobile", String.valueOf(testRandomUtils.getUserMobile()))
                    .verifyBirthDateResult("Date of Birth", testRandomUtils.getUserBirthDay() + " " + testRandomUtils.getUserBirthMonth() + "," + testRandomUtils.getUserBirthYear())
                    .verifySubjectResult("Subjects", testRandomUtils.getUserSubject())
                    .verifyHobbiesResult("Hobbies", testRandomUtils.getUserHobby())
                    .verifyPictureResult("Picture", picture)
                    .verifyAddressResult("Address", testRandomUtils.getCurrentAddress())
                    .verifyStateAndCityResult("State and City", testRandomUtils.getUserState() + " " + testRandomUtils.getUserCity());
        });

        step("Close modal window", () -> {
            registrationPage.modalWindowClose();
        });
    }
}
