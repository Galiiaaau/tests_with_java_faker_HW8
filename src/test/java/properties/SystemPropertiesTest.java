package properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;

public class SystemPropertiesTest {

    @Test
    void simplePropertyTest() {
        String browserName = System.getProperty("browser");
        System.out.println(browserName);
    }

    @Test
    void simpleProperty1Test() {
        System.setProperty("browser", "opera");
        String browserName = System.getProperty("browser");
        System.out.println(browserName);
    }

    @Test
    void simpleProperty2Test() {
        String browserName = System.getProperty("browser", "mozilla");
        System.out.println(browserName);
    }

    @Test
    void simpleProperty3Test() {
        System.setProperty("browser", "opera");
        String browserName = System.getProperty("browser","mozilla");
        System.out.println(browserName);
    }

    @Test
    @Tag("one_property")
    void simpleProperty4Test() {
        String browserName = System.getProperty("browser", "mozilla");
        System.out.println(browserName);

        // gradle clean one_property_test
    }

    @Test
    @Tag("many_properties")
    void simpleProperty5Test() {
        String browserName = System.getProperty("browser", "mozilla");
        String browserVersion = System.getProperty("browser_version", "99.0");

        System.out.println(browserName);
        System.out.println(browserVersion);

        // gradle clean one_property_test
    }

    @Test
    @Tag("hello")
    void simpleProperty6Test() {
        System.out.println(format("Hello, %s!", System.getProperty("user_name", "unknown student")));

        // gradle clean hello_test

        //gradle clean hello_test -Duser_name=Alex Egorov
    }
}
