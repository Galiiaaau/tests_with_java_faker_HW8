package utils;

import com.github.javafaker.Faker;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    public static void main(String[] args) {

        String[] names = {"a", "b", "c", "d", "e"};
        System.out.println(getRandomItemFromArray(names));
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomItemFromArray(String[] names) {
        int index = getRandomInt(0, names.length - 1);
        return names[index];
    }

    public static String getRandomName() {
        return new Faker().name().firstName();
    }

    public static String getRandomLastName() {
        return new Faker().name().lastName();
    }

    public static String getRandomEmail() {
        return new Faker().internet().emailAddress();
    }

    public static String getRandomMobile() {
        Long mobile = new Faker().number().numberBetween(1000000000, 9999999999L);
        return String.valueOf(mobile);
    }

    public static String getRandomAddress() {
        return new Faker().internet().emailAddress();
    }

    public static String getRandomGender() {
        return new Faker().options().option("Male", "Female", "Other");
    }


    public static String getRandomSubject() {
        return new Faker().options().option("Biology", "Math", "CS", "Geography", "History");
    }

    public static String getRandomBirthDay() {
        return String.valueOf(new Faker().number().numberBetween(1,28));
    }

    public static String getRandomBirthMonth() {
        return new Faker().options().option("January", "February",
                "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    }

    public static String getRandomBirthYear() {
        return String.valueOf(new Faker().number().numberBetween(1950,2000));
    }

    public static String getRandomHobby() {
        return new Faker().options().option("Reading", "Sports", "Music");
    }

    public static String getRandomState() {
        return new Faker().options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }

    public static String getRandomCity(String state) {
        String city = new String();
        if (state == "NCR") {
            city = new Faker().options().option("Delhi", "Gurgaon", "Noida");
        } else if (state == "Uttar Pradesh") {
            city = new Faker().options().option("Agra", "Lucknow", "Merrut");
        } else if (state == "Haryana") {
            city = new Faker().options().option("Karnal", "Panipat");
        } else {
            city =new Faker().options().option("Jaipur", "Jaiselmer");
        }
        return city;
    }
}
