package com.comp301.a09akari.view;

import com.comp301.a09akari.model.Puzzle;
import com.comp301.a09akari.model.PuzzleImpl;
import com.comp301.a09akari.model.PuzzleLibrary;
import com.comp301.a09akari.model.PuzzleLibraryImpl;

import java.util.ArrayList;
import java.util.List;

public class PuzzleLibraryView {
    private static List<Puzzle> puzzles;

    public static List<Puzzle> create(){
        puzzles = new ArrayList<>();
        int[][] PUZZLE = {
                {6, 6, 6, 6, 1, 6, 6},
                {6, 6, 6, 5, 6, 6, 6},
                {0, 6, 6, 6, 6, 6, 6},
                {6, 5, 6, 6, 6, 4, 6},
                {6, 6, 6, 6, 6, 6, 5},
                {6, 6, 6, 2, 6, 6, 6},
                {6, 6, 5, 6, 6, 6, 6},
        };
        int[][] PUZZLE2 = {
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
        int[][] PUZZLE3 = {
                {6, 6, 5, 6, 6, 6, 6},
                {6, 5, 6, 6, 6, 4, 6},
                {6, 6, 6, 6, 6, 6, 5},
                {6, 6, 6, 6, 6, 6, 6},
                {3, 6, 6, 6, 6, 6, 6},
                {6, 2, 6, 6, 6, 5, 6},
                {6, 6, 6, 6, 0, 6, 6},
        };
        int[][] PUZZLE4 = {
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
        int[][] PUZZLE5 = {
                {6, 6, 5, 6, 6, 6},
                {6, 5, 6, 6, 6, 3},
                {6, 6, 6, 6, 6, 6},
                {6, 6, 6, 6, 6, 6},
                {3, 6, 6, 6, 6, 6},
                {6, 2, 6, 6, 6, 6},
                {6, 6, 6, 6, 0, 6},
        };
        Puzzle puz = new PuzzleImpl(PUZZLE);
        Puzzle puz2 = new PuzzleImpl(PUZZLE2);
        Puzzle puz3 = new PuzzleImpl(PUZZLE3);
        Puzzle puz4 = new PuzzleImpl(PUZZLE4);
        Puzzle puz5 = new PuzzleImpl(PUZZLE5);
        puzzles.add(puz);
        puzzles.add(puz2);
        puzzles.add(puz3);
        puzzles.add(puz4);
        puzzles.add(puz5);
        return puzzles;
    }
}
