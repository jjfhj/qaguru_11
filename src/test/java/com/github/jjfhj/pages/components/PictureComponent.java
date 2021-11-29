package com.github.jjfhj.pages.components;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class PictureComponent {

    private final SelenideElement selectFileButton = $("#uploadPicture");

    public void uploadFile(String fileToUpload) {
        selectFileButton.uploadFile(new File("src/test/resources/" + fileToUpload));
    }
}
