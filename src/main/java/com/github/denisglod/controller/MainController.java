package com.github.denisglod.controller;

import com.github.denisglod.start.StageView;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TextArea;
import org.apache.commons.text.RandomStringGenerator;

import java.awt.*;
import java.io.IOException;
import java.net.URI;

public class MainController {

    @FXML
    private CheckBox digits;

    @FXML
    private CheckBox letters;

    @FXML
    private CheckBox sumbols;

    @FXML
    private Slider sizePass;

    @FXML
    private TextArea textArea;

    @FXML
    private Spinner<Integer> countPass;

    @FXML
    private ToggleGroup textMode;

    @FXML
    private void onActionGenerate() {
        char[] d = {'0', '9'};
        char[] lu = {'A', 'Z'};
        char[] ll = {'a', 'z'};
        char[] s1 = {'#', '&'};
        char[] s2 = {'<', '?'};


        StringBuilder param = new StringBuilder();
        if (digits.isSelected()) {
            param.append("D");
        }
        if (sumbols.isSelected()) {
            param.append("S");
        }
        if (letters.isSelected()) {
            param.append("L-");
            if (((RadioButton) textMode.getSelectedToggle()).getId().equals("mixedCase")) {
                param.append("MC");
            }
            if (((RadioButton) textMode.getSelectedToggle()).getId().equals("upperCase")) {
                param.append("UC");
            }
            if (((RadioButton) textMode.getSelectedToggle()).getId().equals("lowerCase")) {
                param.append("LC");
            }
        }

        switch (param.toString()) {
            case "D":
                generator(d);
                break;
            case "S":
                generator(s1, s2);
                break;
            case "L-MC":
                generator(lu, ll);
                break;
            case "L-UC":
                generator(lu);
                break;
            case "L-LC":
                generator(ll);
                break;

            case "DS":
                generator(d, s1, s2);
                break;
            case "DSL-MC":
                generator(d, s1, s2, lu, ll);
                break;
            case "DSL-UC":
                generator(d, s1, s2, lu);
                break;
            case "DSL-LC":
                generator(d, s1, s2, ll);
                break;


            case "DL-MC":
                generator(d, lu, ll);
                break;
            case "DL-UC":
                generator(d, lu);
                break;
            case "DL-LC":
                generator(d, ll);
                break;

            case "SL-MC":
                generator(s1, s2, lu, ll);
                break;
            case "SL-UC":
                generator(s1, s2, lu);
                break;
            case "SL-LC":
                generator(s1, s2, ll);
                break;
        }
    }

    private void generator(char[]... pairs) {
        RandomStringGenerator generator = new RandomStringGenerator.Builder()
                .withinRange(pairs)
                .build();
        textArea.clear();
        for (int i = 0; i < countPass.getValue(); i++) {
            textArea.appendText(generator.generate((int) sizePass.getValue()));
            if (i < countPass.getValue() - 1)
                textArea.appendText("\r\n");
        }
    }

    @FXML
    private void onActionLetters() {
        if (letters.isSelected()) {
            for (Toggle rb : textMode.getToggles()) {
                ((RadioButton) rb).setDisable(false);
            }
        } else {
            for (Toggle rb : textMode.getToggles()) {
                ((RadioButton) rb).setDisable(true);
            }
        }
    }

    @FXML
    void onActionAbout() throws IOException {
        StageView.getInstance().getAboutStage().show();
    }

    @FXML
    void onActionDonation() throws IOException {
        Desktop.getDesktop().browse(URI.create("https://money.yandex.ru/to/410011808517844"));
    }

    @FXML
    void initialize() {
        countPass.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, Integer.MAX_VALUE, 1));
    }
}

