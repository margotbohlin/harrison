package com.comp301.a09akari.view;

import com.comp301.a09akari.controller.AlternateMvcController;
import com.comp301.a09akari.controller.ClassicMvcController;
import com.comp301.a09akari.controller.ControllerImpl;
import com.comp301.a09akari.model.*;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.List;

public class MessageView implements FXComponent{
    private final AlternateMvcController controller;
    public MessageView(AlternateMvcController controller) {
        this.controller = controller;
    }
    //success message when the puzzle has been completed
    @Override
    public Parent render() {
        HBox layout = new HBox();
        layout.getStyleClass().add("message-layout");
        //title for winning or losing
        Label solved = new Label(winOrLoseString());
        solved.setFont(new Font("Times New Roman", 15));
        layout.getChildren().add(solved);
        //blank space
        Label blank = new Label("                                                         ");
        layout.getChildren().add(blank);
        //button for displaying index of puzzle
        Label index = new Label(currIndex());
        index.setFont(new Font("Times New Roman", 15));
        layout.getChildren().add(index);
        return layout;
    }
    private String winOrLoseString() {
        if (controller.isSolved()) {
            return "Hooray! You've solved the puzzle!";
        } else {
            return "You still have solving to do...";
        }
    }
    private String currIndex() {
        int index = controller.getActivePuzzleIndex() + 1;
        int size = controller.getPuzzleLibrarySize();
        return "Puzzle " + index + " of " + size;
    }
}
