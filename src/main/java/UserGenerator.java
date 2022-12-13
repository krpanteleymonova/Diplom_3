import com.github.javafaker.Faker;

import java.sql.Timestamp;

public class UserGenerator {
    static Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    static Faker faker = new Faker();
    public static final String email = faker.internet().emailAddress();
    public static final String name = faker.name().firstName();
    protected static final String password = name + timestamp.getTime();
    static String defaultName = "pokemon";
    static String defaultEmail = "pokemon@ya.ru";
    static String defaultPassword = "123456";
    static String passwordError = "123";
}
