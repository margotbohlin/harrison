package com.comp301.a09akari.view;

import com.comp301.a09akari.controller.AlternateMvcController;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ControlView implements FXComponent {
  private final AlternateMvcController controller;

  public ControlView(AlternateMvcController controller) {
    this.controller = controller;
  }
  // this component displays the puzzle controls, buttons to move through the puzzle library
  @Override
  public Parent render() {
    HBox layout = new HBox();

    // resetButton
    Button resetButton = new Button("RESET");
    resetButton.setOnAction(
        (ActionEvent event) -> {
          controller.clickResetPuzzle();
        });
    resetButton.setStyle("-fx-background-color: mistyrose;");
    layout.getChildren().add(resetButton);

    // randButton
    Button randButton = new Button("RANDOM");
    randButton.setOnAction(
        (ActionEvent event) -> {
          controller.clickRandPuzzle();
        });
    randButton.setStyle("-fx-background-color: peachpuff;");
    layout.getChildren().add(randButton);

    // prevButton
    Button prevButton = new Button("PREVIOUS");
    prevButton.setOnAction(
        (ActionEvent event) -> {
          controller.clickPrevPuzzle();
        });
    prevButton.setStyle("-fx-background-color: lightgreen;");
    layout.getChildren().add(prevButton);

    // nextButton
    Button nextButton = new Button("NEXT");
    nextButton.setOnAction(
        (ActionEvent event) -> {
          controller.clickNextPuzzle();
        });
    nextButton.setStyle("-fx-background-color: lightblue;");
    layout.getChildren().add(nextButton);

    return layout;
  }
}
