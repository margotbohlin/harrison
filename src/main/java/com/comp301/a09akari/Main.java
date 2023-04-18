package com.comp301.a09akari;

import com.comp301.a09akari.model.*;

public class Main {
  public static void main(String[] args) {
    /*Application.launch(AppLauncher.class);

    */
    int[][] puzzle1board =
        new int[][] {
          {6, 6, 6, 6, 1, 6, 6},
          {6, 6, 6, 5, 6, 6, 6},
          {0, 6, 6, 6, 6, 6, 6},
          {6, 5, 6, 6, 6, 4, 6},
          {6, 6, 6, 6, 6, 6, 5},
          {6, 6, 6, 2, 6, 6, 6},
          {6, 6, 5, 6, 6, 6, 6},
        };
    Puzzle puzzle1 = new PuzzleImpl(puzzle1board);
    int[][] puzzle2board =
        new int[][] {
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
    int[][] puzzle3board =
        new int[][] {
          {6, 6, 5, 6, 6, 6, 6},
          {6, 5, 6, 6, 6, 4, 6},
          {6, 6, 6, 6, 6, 6, 5},
          {6, 6, 6, 6, 6, 6, 6},
          {3, 6, 6, 6, 6, 6, 6},
          {6, 2, 6, 6, 6, 5, 6},
          {6, 6, 6, 6, 0, 6, 6},
        };
    Puzzle puzzle3 = new PuzzleImpl(puzzle3board);
    int[][] puzzle4board =
        new int[][] {
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
    int[][] puzzle5board =
        new int[][] {
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
    model.isSolved();
  }
}
