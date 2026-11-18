package com.shephertz.app42.paas.sample.util;

public class Util {

    // Берем адрес MySQL из Docker Compose
    public static String getDBIp() {
        return System.getenv("DB_HOST");
    }

    // Берем пароль от базы
    public static String getDBPassword() {
        return System.getenv("DB_PASSWORD");
    }

    // Берем логин пользователя MySQL
    public static String getDBUser() {
        return System.getenv("DB_USER");
    }

    // Берем название базы
    public static String getDBName() {
        return System.getenv("DB_NAME");
    }

    // Берем порт и переводим его из строки в число
    public static int getDBPort() {
        return Integer.parseInt(System.getenv("DB_PORT"));
    }
}
