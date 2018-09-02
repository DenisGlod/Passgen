package com.github.denisglod.controller;

import javafx.fxml.FXML;

import java.awt.*;
import java.io.IOException;
import java.net.URI;

public class AboutController {
    @FXML
    void onActionLink() throws IOException {
        Desktop.getDesktop().browse(URI.create("https://vk.com/dkglod"));
    }
}
