package com.github.jjfhj.tests;

import com.github.jjfhj.pages.RegistrationsPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.github.jjfhj.tests.TestData.*;

@DisplayName("Форма регистрации 'Student Registration Form'")

public class StudentRegistrationForm extends TestBase {

    RegistrationsPage registrationsPage = new RegistrationsPage();

    @DisplayName("Позитивный тест: Заполнение формы регистрации 'Student Registration Form'")
    @Test
    void fillFormTest() {
        registrationsPage.openPage()
                //Заполнить форму регистрации "Student Registration Form"
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(email)
                .selectGender(gender)
                .typeNumber(mobileNumber)
                .setDate(day, month, year)
                .typeSubjects(subject)
                .selectHobbies(hobby1)
                .selectHobbies(hobby2)
                .uploadFile(fileName)
                .typeCurrentAddress(address)
                .selectState(state)
                .selectCity(city)
                .clickSubmit();
        //Проверить всплывающее модальное окно "Thanks for submitting the form" после успешной отправки формы
        registrationsPage
                .checkModalFormTitle()
                .checkModalFormValue("Student Name", firstName + " " + lastName)
                .checkModalFormValue("Student Email", email)
                .checkModalFormValue("Gender", gender)
                .checkModalFormValue("Mobile", mobileNumber)
                .checkModalFormValue("Date of Birth", day + " " + month + "," + year)
                .checkModalFormValue("Subjects", subject)
                .checkModalFormValue("Hobbies", hobby1 + ", " + hobby2)
                .checkModalFormValue("Picture", fileName)
                .checkModalFormValue("Address", address)
                .checkModalFormValue("State and City", state + " " + city);
    }
}
