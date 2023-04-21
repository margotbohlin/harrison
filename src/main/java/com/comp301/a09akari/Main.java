package com.comp301.a09akari;

import com.comp301.a09akari.model.*;
import com.comp301.a09akari.view.AppLauncher;
import javafx.application.Application;

public class Main {
  public static int[][] PUZZLE = {
          {6, 6, 6, 6, 1, 6, 6},
          {6, 6, 6, 5, 6, 6, 6},
          {0, 6, 6, 6, 6, 6, 6},
          {6, 5, 6, 6, 6, 4, 6},
          {6, 6, 6, 6, 6, 6, 5},
          {6, 6, 6, 2, 6, 6, 6},
          {6, 6, 5, 6, 6, 6, 6},
  };

  public static int[][] PUZZLE2 = {
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

  public static int[][] PUZZLE3 = {
          {6, 6, 5, 6, 6, 6, 6},
          {6, 5, 6, 6, 6, 4, 6},
          {6, 6, 6, 6, 6, 6, 5},
          {6, 6, 6, 6, 6, 6, 6},
          {3, 6, 6, 6, 6, 6, 6},
          {6, 2, 6, 6, 6, 5, 6},
          {6, 6, 6, 6, 0, 6, 6},
  };

  public static int[][] PUZZLE4 = {
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

  public static int[][] PUZZLE5 = {
          {6, 6, 5, 6, 6, 6},
          {6, 5, 6, 6, 6, 3},
          {6, 6, 6, 6, 6, 6},
          {6, 6, 6, 6, 6, 6},
          {3, 6, 6, 6, 6, 6},
          {6, 2, 6, 6, 6, 6},
          {6, 6, 6, 6, 0, 6},
  };

  public static void make() {
    PuzzleLibrary lib = new PuzzleLibraryImpl();
    Puzzle puz = new PuzzleImpl(PUZZLE);
    Puzzle puz2 = new PuzzleImpl(PUZZLE2);
    Puzzle puz3 = new PuzzleImpl(PUZZLE3);
    Puzzle puz4 = new PuzzleImpl(PUZZLE4);
    Puzzle puz5 = new PuzzleImpl(PUZZLE5);
    lib.addPuzzle(puz);
    lib.addPuzzle(puz2);
    lib.addPuzzle(puz3);
    lib.addPuzzle(puz4);
    lib.addPuzzle(puz5);
    Model mod = new ModelImpl(lib);
  }

  public static void main(String[] args) {
    Application.launch(AppLauncher.class);
  }
}
