package com.comp301.a09akari.view;

import com.comp301.a09akari.controller.AlternateMvcController;
import com.comp301.a09akari.controller.ClassicMvcController;
import com.comp301.a09akari.model.*;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import com.comp301.a09akari.controller.ControllerImpl;
import javafx.scene.layout.HBox;

import java.util.List;

public class ControlView implements FXComponent{
    private final AlternateMvcController controller;

    public ControlView(AlternateMvcController controller) {
        this.controller = controller;
    }
    //this component displays the puzzle controls, buttons to move through the puzzle library
    @Override
    public Parent render() {
        HBox layout = new HBox();
        layout.getStyleClass().add("button-layout");

    // resetButton
    Button resetButton = new Button("RESET");
    resetButton.setOnAction((ActionEvent event) -> {
        controller.clickResetPuzzle();
    });
    layout.getChildren().add(resetButton);

    // randButton
    Button randButton = new Button("RANDOM");
    randButton.setOnAction((ActionEvent event) -> {
        controller.clickRandPuzzle();
    });
    layout.getChildren().add(randButton);

    // nextButton
    Button nextButton = new Button("NEXT");
    nextButton.setOnAction((ActionEvent event) -> {
        controller.clickNextPuzzle();
    });
    layout.getChildren().add(nextButton);

    // prevButton
    Button prevButton = new Button("PREVIOUS");
    prevButton.setOnAction((ActionEvent event) -> {
        controller.clickPrevPuzzle();
    });
    layout.getChildren().add(prevButton);

    return layout;
    }
}
