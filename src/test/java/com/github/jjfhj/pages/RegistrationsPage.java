package com.github.jjfhj.pages;

import com.codeborne.selenide.SelenideElement;
import com.github.jjfhj.pages.components.CalendarComponent;
import com.github.jjfhj.pages.components.PictureComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationsPage {

    // Locators & Elements
    private final String FORM_TITLE = "Student Registration Form";
    private final String MODAL_TITLE = "Thanks for submitting the form";
    private final SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderRadio = $("#genterWrapper"),
            numberInput = $("#userNumber"),
            subjectsAutocomplete = $("#subjectsInput"),
            hobbiesCheckbox = $("#hobbiesWrapper"),
            currentAddressTextarea = $("#currentAddress"),
            stateDropdown = $("#react-select-3-input"),
            cityDropdown = $("#react-select-4-input"),
            submitButton = $("#submit"),
            modalTitle = $("#example-modal-sizes-title-lg"),
            resultsTable = $(".table-responsive");

    // Actions
    public RegistrationsPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));

        return this;
    }

    public RegistrationsPage typeFirstName(String firstName) {
        firstNameInput.setValue(firstName);

        return this;
    }

    public RegistrationsPage typeLastName(String lastName) {
        lastNameInput.setValue(lastName);

        return this;
    }

    public RegistrationsPage typeEmail(String email) {
        emailInput.setValue(email);

        return this;
    }

    public RegistrationsPage selectGender(String gender) {
        genderRadio.$(byText(gender)).click();

        return this;
    }

    public RegistrationsPage typeNumber(String number) {
        numberInput.setValue(number);

        return this;
    }

    public RegistrationsPage setDate(String day, String month, String year) {
        new CalendarComponent().setDate(day, month, year);

        return this;
    }

    public RegistrationsPage typeSubjects(String subjects) {
        subjectsAutocomplete.setValue(subjects).pressEnter();

        return this;
    }

    public RegistrationsPage selectHobbies(String hobby) {
        hobbiesCheckbox.$(byText(hobby)).click();

        return this;
    }

    public RegistrationsPage uploadFile(String fileToUpload) {
        new PictureComponent().uploadFile(fileToUpload);

        return this;
    }

    public RegistrationsPage typeCurrentAddress(String address) {
        currentAddressTextarea.setValue(address);

        return this;
    }

    public RegistrationsPage selectState(String state) {
        stateDropdown.setValue(state).pressEnter();

        return this;
    }

    public RegistrationsPage selectCity(String city) {
        cityDropdown.setValue(city).pressEnter();

        return this;
    }

    public RegistrationsPage clickSubmit() {
        submitButton.click();

        return this;
    }

    public RegistrationsPage checkModalFormTitle() {
        modalTitle.shouldHave(text(MODAL_TITLE));

        return this;
    }

    public RegistrationsPage checkModalFormValue(String key, String value) {
        resultsTable.$(byText(key)).parent().shouldHave(text(value));

        return this;
    }
}
