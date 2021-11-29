package com.github.jjfhj.tests;

import com.github.javafaker.Faker;

public class TestData {

    public static String
            gender = "Male",
            day = "16",
            month = "August",
            year = "1988",
            subject = "Hindi",
            hobby1 = "Reading",
            hobby2 = "Music",
            fileName = "Duck_on_Yeadon_Tarn.jpg",
            state = "Haryana",
            city = "Panipat";

    public static Faker faker = new Faker();

    public static String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.name().username() + "@demoqa.com",
            mobileNumber = faker.phoneNumber().subscriberNumber(10),
            address = faker.address().fullAddress();
}
