package utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;


public class RandomUtils {
    Faker faker = new Faker();

    private final String firstName = faker.name().firstName();

    private final String lastName =  faker.name().lastName();

    private final String emailAddress =  faker.internet().emailAddress();

    private final String userMobile = String.valueOf(Long.valueOf(8 + faker.phoneNumber().subscriberNumber(9)));

    private final String currentAddress =  faker.address().fullAddress();

    private final String userGender =  faker.demographic().sex();

    private final String userSubject =  faker.options().option("Biology", "Math", "CS", "Geography", "History");

    private final Date fakerDateOfBirthday = faker.date().birthday();
    private final String birthDay = (new SimpleDateFormat("d", Locale.ENGLISH)).format(fakerDateOfBirthday);
    private final String birthMonth = (new SimpleDateFormat("MMMM", Locale.ENGLISH)).format(fakerDateOfBirthday);
    private final String birthYear = (new SimpleDateFormat("y", Locale.ENGLISH)).format(fakerDateOfBirthday);

    private final String userHobby = faker.options().option("Reading", "Sports", "Music");

    private final String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");


    private String getRandomCity(String state) {
        String city;
        if (Objects.equals(state, "NCR")) {
            city = new Faker().options().option("Delhi", "Gurgaon", "Noida");
        } else if (Objects.equals(state, "Uttar Pradesh")) {
            city = new Faker().options().option("Agra", "Lucknow", "Merrut");
        } else if (Objects.equals(state, "Haryana")) {
            city = new Faker().options().option("Karnal", "Panipat");
        } else {
            city =new Faker().options().option("Jaipur", "Jaiselmer");
        }
        return city;
    }

    private final String city = getRandomCity(state);


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public String getUserGender() {
        return userGender;
    }

    public String getUserSubject() {
        return userSubject;
    }

    public String getUserBirthDay() {
        return birthDay;
    }

    public String getUserBirthMonth() {
        return birthMonth;
    }

    public String getUserBirthYear() {
        return birthYear;
    }

    public String getUserHobby() {
        return userHobby;
    }

    public String getUserState() {
        return state;
    }

    public String getUserCity() {
        return city;
    }
}
