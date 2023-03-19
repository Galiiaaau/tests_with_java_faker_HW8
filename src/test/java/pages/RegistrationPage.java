package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    private String TITLE_TEXT = "Student Registration Form";

    private String fixedBanner = "$('#fixedban').remove()";
    private String footer = "$('footer').remove()";
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailAddressInput = $("#userEmail"),
            subjectInput = $("#subjectsInput"),
            pictureInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $(("#state")),
            cityInput = $(("#city")),
            submitBtn = $(("#submit")),
            modalWindowCloseBtn = $("#closeLargeModal");

    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        return this;
    }

    public RegistrationPage removeBanners() {
        Selenide.executeJavaScript(fixedBanner);
        Selenide.executeJavaScript(footer);
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String gender) {
        $(byText(gender)).click();
        return this;
    }

    public RegistrationPage setPhoneNumber(String value ) {
        $("#userNumber").setValue(value);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
}

    public RegistrationPage setSubject(String subject) {
        subjectInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String hobbies) {
        $(byText(hobbies)).click();
        return this;
    }

    public RegistrationPage setPicture(String picture) {
        File fileToUpload = new File(picture);
        pictureInput.uploadFile(fileToUpload);
        return this;
    }

    public RegistrationPage setAddress(String address) {
        addressInput.setValue(address);
        return this;
    }

    public RegistrationPage setStateAndCity(String state, String city) {
        stateInput.click();
        $(byText(state)).click();
        cityInput.click();
        $(byText(city)).click();
        submitBtn.click();
        return this;
    }

    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();
        return this;
    }

    public RegistrationPage verifyNameResult (String key, String value) {
        registrationResultsModal.verifyName(key, value);
        return this;
    }

    public RegistrationPage verifyEmailResult(String key, String value) {
        registrationResultsModal.verifyEmail(key, value);
        return this;
    }

    public RegistrationPage verifyGenderResult(String key, String value) {
        registrationResultsModal.verifyGender(key, value);
        return this;
    }

    public RegistrationPage verifyMobileResult(String key, String value) {
        registrationResultsModal.verifyMobile(key, value);
        return this;
    }

    public RegistrationPage verifyBirthDateResult(String key, String value) {
        registrationResultsModal.verifyBirthDate(key, value);
        return this;
    }

    public RegistrationPage verifySubjectResult(String key, String value) {
        registrationResultsModal.verifySubject(key, value);
        return this;
    }

    public RegistrationPage verifyHobbiesResult(String key, String value) {
        registrationResultsModal.verifyHobbies(key, value);
        return this;
    }

    public RegistrationPage verifyPictureResult(String key, String value) {
        registrationResultsModal.verifyPicture(key, value);
        return this;
    }

    public RegistrationPage verifyAddressResult(String key, String value) {
        registrationResultsModal.verifyAddress(key, value);
        return this;
    }

    public RegistrationPage verifyStateAndCityResult(String key, String value) {
        registrationResultsModal.verifyStateAndCity(key, value);
        return this;
    }

    public RegistrationPage modalWindowClose() {
        modalWindowCloseBtn.click();
        return this;
    }
}
