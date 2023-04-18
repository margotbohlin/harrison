package com.comp301.a09akari.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppLauncher extends Application {
  public static void main(String[] args) {
    launch();
  }

  @Override
  public void start(Stage stage) {
    stage.setTitle("Play Akari");
    Pane layout = new VBox();
    Pane scorePane = new HBox();
    layout.getChildren().add(scorePane);

    Label instructions = new Label("Join the numbers to get to 2048!");
    layout.getChildren().add(instructions);
    GridPane board = new GridPane();
    layout.getChildren().add(board);
    Scene scene = new Scene(layout, 350, 450);
    stage.setScene(scene);
    stage.show();
    /*int[][] puzzle1board = new int[][]{
            {6, 6, 6, 6, 1, 6, 6},
            {6, 6, 6, 5, 6, 6, 6},
            {0, 6, 6, 6, 6, 6, 6},
            {6, 5, 6, 6, 6, 4, 6},
            {6, 6, 6, 6, 6, 6, 5},
            {6, 6, 6, 2, 6, 6, 6},
            {6, 6, 5, 6, 6, 6, 6},
    };
    Puzzle puzzle1 = new PuzzleImpl(puzzle1board);
    int[][] puzzle2board = new int[][]{
            {5, 6, 6, 5, 6, 6, 6, 6, 6, 5},
            {6, 6, 6, 6, 6, 6, 6, 5, 6, 6},
            {6, 3, 6, 6, 6, 6, 0, 6, 6, 6},
            {6, 6, 2, 6, 6, 5, 6, 6, 6, 1},
            {6, 6, 6, 1, 0, 5, 6, 6, 6, 6},
            {6, 6, 6, 6, 1, 5, 5, 6, 6, 6},
            {5, 6, 6, 6, 2, 6, 6, 2, 6, 6},
            {6, 6, 6, 5, 6, 6, 6, 6, 5, 6},
            {6, 6, 1, 6, 6, 6, 6, 6, 6, 6},
            {0, 6, 6, 6, 6, 6, 1, 6, 6, 0},
    };
    Puzzle puzzle2 = new PuzzleImpl(puzzle2board);
    int[][] puzzle3board = new int[][]{
            {6, 6, 5, 6, 6, 6, 6},
            {6, 5, 6, 6, 6, 4, 6},
            {6, 6, 6, 6, 6, 6, 5},
            {6, 6, 6, 6, 6, 6, 6},
            {3, 6, 6, 6, 6, 6, 6},
            {6, 2, 6, 6, 6, 5, 6},
            {6, 6, 6, 6, 0, 6, 6},
    };
    Puzzle puzzle3 = new PuzzleImpl(puzzle3board);
    int[][] puzzle4board = new int[][]{
            {6, 1, 6, 6, 6, 6, 5, 6, 6, 6},
            {6, 6, 6, 6, 6, 6, 6, 6, 6, 5},
            {6, 6, 5, 5, 6, 6, 6, 2, 6, 6},
            {2, 6, 6, 5, 6, 6, 1, 5, 6, 6},
            {6, 6, 6, 6, 6, 6, 6, 6, 6, 6},
            {6, 6, 6, 6, 6, 6, 6, 6, 6, 6},
            {6, 6, 5, 2, 6, 6, 0, 6, 6, 1},
            {6, 6, 2, 6, 6, 6, 5, 1, 6, 6},
            {2, 6, 6, 6, 6, 6, 6, 6, 6, 6},
            {6, 6, 6, 5, 6, 6, 6, 6, 5, 6},
    };
    Puzzle puzzle4 = new PuzzleImpl(puzzle4board);
    int[][] puzzle5board = new int[][]{
            {6, 6, 5, 6, 6, 6},
            {6, 5, 6, 6, 6, 3},
            {6, 6, 6, 6, 6, 6},
            {6, 6, 6, 6, 6, 6},
            {3, 6, 6, 6, 6, 6},
            {6, 2, 6, 6, 6, 6},
            {6, 6, 6, 6, 0, 6},
    };
    Puzzle puzzle5 = new PuzzleImpl(puzzle5board);
    PuzzleLibrary puzzleLibrary = new PuzzleLibraryImpl();
    puzzleLibrary.addPuzzle(puzzle1);
    puzzleLibrary.addPuzzle(puzzle2);
    puzzleLibrary.addPuzzle(puzzle3);
    puzzleLibrary.addPuzzle(puzzle4);
    puzzleLibrary.addPuzzle(puzzle5);
    Model model = new ModelImpl(puzzleLibrary);
    ControllerImpl controller = new ControllerImpl(model);
    */
    // TODO: Create your Model, View, and Controller instances and launch your GUI
  }
}
