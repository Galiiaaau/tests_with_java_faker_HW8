package utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;


public class RandomUtils {
    public static Faker faker = new Faker();

    public static String firstName = faker.name().firstName();

    public static String lastName =  faker.name().lastName();

    public static String emailAddress =  faker.internet().emailAddress();

    public static String userMobile = String.valueOf(Long.valueOf(8 + faker.phoneNumber().subscriberNumber(9)));

    public static String currentAddress =  faker.address().fullAddress();

    public static String userGender =  faker.demographic().sex();

    public static String userSubject =  faker.options().option("Biology", "Math", "CS", "Geography", "History");

    static Date fakerDateOfBirthday = faker.date().birthday();
    public static String birthDay = (new SimpleDateFormat("d", Locale.ENGLISH)).format(fakerDateOfBirthday);
    public static String birthMonth = (new SimpleDateFormat("MMMM", Locale.ENGLISH)).format(fakerDateOfBirthday);
    public static String birthYear = (new SimpleDateFormat("y", Locale.ENGLISH)).format(fakerDateOfBirthday);

    public static String userHobby = faker.options().option("Reading", "Sports", "Music");

    public static String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");


    public static String getRandomCity(String state) {
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

    public static String city = getRandomCity(state);
}
