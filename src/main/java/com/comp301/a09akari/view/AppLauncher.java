package com.comp301.a09akari.view;

import com.comp301.a09akari.controller.AltControllerImpl;
import com.comp301.a09akari.controller.AlternateMvcController;
import com.comp301.a09akari.controller.ClassicMvcController;
import com.comp301.a09akari.controller.ControllerImpl;
import com.comp301.a09akari.model.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class AppLauncher extends Application {
  public static void main(String[] args) {
    launch();
  }
  @Override
  public void start(Stage stage) {
    List<Puzzle> puzzles = PuzzleLibraryView.create();
    PuzzleLibrary puzzleLibrary = new PuzzleLibraryImpl();
    for (Puzzle p : puzzles) {
      puzzleLibrary.addPuzzle(p);
    }
    Model model = new ModelImpl(puzzleLibrary);
    AlternateMvcController controller = new AltControllerImpl(model);
    View view = new View(controller);

    Scene scene = new Scene(view.render());
    scene.getStylesheets().add("main.css");
    stage.setScene(scene);

    // Refresh view when model changes
    model.addObserver((Model m) -> {
      scene.setRoot(view.render());
      stage.sizeToScene();
    });

    // Show the stage
    stage.setTitle("Play Akari");
    scene.getStylesheets().add("main.css");
    stage.setWidth(500);
    stage.setHeight(500);
    stage.show();

    // TODO: Create your Model, View, and Controller instances and launch your GUI
  }
}
