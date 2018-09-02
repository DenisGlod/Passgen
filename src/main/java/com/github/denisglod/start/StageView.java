package com.github.denisglod.start;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class StageView {

    private static StageView ourInstance = new StageView();

    public static StageView getInstance() {
        return ourInstance;
    }

    private StageView() {
    }

    private Stage mainStage;
    private Stage aboutStage;

    Stage getMainStage() throws IOException {
        if (mainStage == null) {
            Parent root = FXMLLoader.load(getClass().getResource("/form/main.fxml"));
            mainStage = new Stage();
            mainStage.setResizable(false);
            mainStage.getIcons().add(new Image("/image/logo.jpg"));
            mainStage.setTitle("PassGen");
            mainStage.setScene(new Scene(root, 400, 400));
        }
        return mainStage;
    }

    public Stage getAboutStage() throws IOException {
        if (aboutStage == null) {
            Parent root = FXMLLoader.load(getClass().getResource("/form/about.fxml"));
            aboutStage = new Stage();
            aboutStage.setResizable(false);
            aboutStage.getIcons().add(new Image("/image/logo.jpg"));
            aboutStage.setTitle("О программе");
            aboutStage.setScene(new Scene(root, 300, 200));
            aboutStage.initModality(Modality.WINDOW_MODAL);
            aboutStage.initOwner(mainStage.getScene().getWindow());
        }
        return aboutStage;

    }

}
