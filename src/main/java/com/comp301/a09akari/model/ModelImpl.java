package com.comp301.a09akari.model;

import java.util.ArrayList;
import java.util.List;

public class ModelImpl implements Model{
    private final PuzzleLibrary library;
    private int[][] lampStorage; //0 means no lamp, 1 means lamp and lit
    private int i;
    private final List<ModelObserver> observers;
    private int litSpots;

    public ModelImpl(PuzzleLibrary library) {
        if (library == null) {
            throw new IllegalArgumentException();
        }
        this.library = library;
        this.i = 0;
        this.observers = new ArrayList<>();
        this.litSpots = 0;
        Puzzle puzzle = getActivePuzzle();
        this.lampStorage = new int[puzzle.getWidth()][puzzle.getHeight()];
    }

    @Override
    public void addLamp(int r, int c) {
        Puzzle puzzle = getActivePuzzle();
        if (r < 0 || c < 0 || r > puzzle.getWidth()|| c > puzzle.getHeight()) {
            throw new IndexOutOfBoundsException();
        }
        CellType puzzleType = puzzle.getCellType(r, c);
        if (puzzleType != CellType.CORRIDOR) {
            throw new IllegalArgumentException();
        } else if (!isLamp(r, c)) {
            lampStorage[r][c] = 1;
            for (ModelObserver o : observers) {
                o.update(this);
            }
        }
    }

    @Override
    public void removeLamp(int r, int c) {
        Puzzle puzzle = getActivePuzzle();
       if (r < 0 || c < 0 || r > puzzle.getWidth()|| c > puzzle.getHeight()) {
            throw new IndexOutOfBoundsException();
       }
       if (puzzle.getCellType(r, c) != CellType.CORRIDOR) {
            throw new IllegalArgumentException();
       } else if (isLamp(r, c)) {
           lampStorage[r][c] = 0;
           for (ModelObserver o : observers) {
               o.update(this);
           }
       }
    }

    @Override
    public boolean isLit(int r, int c) {
        return this.isLamp(r, c) || isLampIllegal(r, c);
    }

    @Override
    public boolean isLamp(int r, int c) {
        Puzzle puzzle = getActivePuzzle();
        if (r < 0 || c < 0 || r > puzzle.getWidth()|| c > puzzle.getHeight()) {
            throw new IndexOutOfBoundsException();
        }
        if (library.getPuzzle(i).getCellType(r, c) != CellType.CORRIDOR) {
            throw new IllegalArgumentException();
        }
        return lampStorage[r][c] == 1;
    }

    @Override
    public boolean isLampIllegal(int r, int c) {
        Puzzle puzzle = getActivePuzzle();
        if (r < 0 || c < 0 || r > puzzle.getWidth()|| c > puzzle.getHeight()) {
            throw new IndexOutOfBoundsException();
        }
        if (puzzle.getCellType(r, c) != CellType.CORRIDOR) {
            throw new IllegalArgumentException();
        }
        boolean flag = false;
        int rRight = r + 1;
        while (rRight < puzzle.getWidth()) {
            if (puzzle.getCellType(rRight, c) != CellType.WALL && puzzle.getCellType(rRight, c) != CellType.CLUE) {
                if (isLamp(rRight, c)) {
                    flag = true;
                    break;
                }
            } else {
                break;
            }
            rRight++;
        }
        int rLeft = r - 1;
        while (rLeft >= 0) {
            if (puzzle.getCellType(rLeft, c) != CellType.WALL && puzzle.getCellType(rLeft, c) != CellType.CLUE) {
                if (isLamp(rLeft, c)) {
                    flag = true;
                    break;
                }
            } else {
                break;
            }
            rLeft--;
        }
        int cUp = c + 1;
        while (cUp < puzzle.getHeight()) {
            if (puzzle.getCellType(r, cUp) != CellType.WALL && puzzle.getCellType(r, cUp) != CellType.CLUE) {
                if (isLamp(r, cUp)) {
                    flag = true;
                    break;
                }
            } else {
                break;
            }
            cUp++;
        }
        int cDown = c - 1;
        while (cDown >= 0) {
            if (puzzle.getCellType(r, cDown) != CellType.WALL && puzzle.getCellType(r, cDown) != CellType.CLUE) {
                if (isLamp(r, cDown)) {
                    flag = true;
                    break;
                }
            } else {
                break;
            }
            cDown--;
        }
        return flag;
    }

    @Override
    public Puzzle getActivePuzzle() {
        return library.getPuzzle(i);
    }

    @Override
    public int getActivePuzzleIndex() {
        return i;
    }

    @Override
    public void setActivePuzzleIndex(int index) {
        if (index < 0 || index > getPuzzleLibrarySize() - 1) {
            throw new IndexOutOfBoundsException();
        }
        i = index;
        resetPuzzle();
    }

    @Override
    public int getPuzzleLibrarySize() {
        return library.size();
    }

    @Override
    public void resetPuzzle() {
        lampStorage = new int[getActivePuzzle().getWidth()][getActivePuzzle().getHeight()];
        for (ModelObserver o : observers) {
            o.update(this);
        }
    }

    @Override
    public boolean isSolved() {
        Puzzle puzzle = getActivePuzzle();
        int totalSpots = 0;
        litSpots = 0;
        for (int k = 0; k < puzzle.getHeight(); k++) { //algorithm for checking the lit corridors
            for (int j = 0; j < puzzle.getWidth(); j++) {
                if (puzzle.getCellType(k, j) == CellType.CORRIDOR) {
                    totalSpots++;
                    if (this.isLit(k, j)) {
                        litSpots++;
                    }
                }
            }
        }
        for (int k = 0; k < puzzle.getHeight(); k++) { //algorithm that checks none of the lamps are illegal
            for (int j = 0; j < puzzle.getWidth(); j++) {
                if (puzzle.getCellType(k, j) == CellType.CORRIDOR) {
                    if (isLamp(k, j)) {
                        if (isLampIllegal(k, j)) {
                            litSpots = 0;
                            return false;
                        }
                    }
                }
            }
        }
        for (int k = 0; k < puzzle.getHeight(); k++) { //algorithm for checking if each clue is satisfied
            for (int j = 0; j < puzzle.getWidth(); j++) {
                if (library.getPuzzle(i).getCellType(k, j) == CellType.CLUE) {
                    if (!isClueSatisfied(k, j)) {
                        litSpots = 0;
                        return false;
                    }
                }
            }
        }
        if (litSpots == totalSpots) {
            litSpots = 0;
            return true;
        }
        litSpots = 0;
        return false;
    }

    @Override
    public boolean isClueSatisfied(int r, int c) {
        Puzzle puzzle = getActivePuzzle();
        if (r < 0 || c < 0 || r > puzzle.getWidth() || c > puzzle.getHeight()) {
            throw new IndexOutOfBoundsException();
        }
        CellType puzzleType = puzzle.getCellType(r, c);
        if (puzzleType != CellType.CLUE) {
            throw new IllegalArgumentException();
        }
        int clueAmount = puzzle.getClue(r, c);
        int lampCount = 0;
        //go right
        if (r < puzzle.getWidth() - 1) {
            if (lampStorage[r + 1][c] == 1) { //checks right
                lampCount++;
            }
        }
        if (r > 0) {
            if (lampStorage[r - 1][c] == 1) { //checks left
                lampCount++;
            }
        }
        if (c < puzzle.getHeight() - 1) {
            if (lampStorage[r][c + 1] == 1) { //checks up
                lampCount++;
            }
        }
        if (c > 0) {
            if (lampStorage[r][c - 1] == 1) { //checks down
                lampCount++;
            }
        }
        return lampCount == clueAmount;
    }

    @Override
    public void addObserver(ModelObserver observer) {
        if (observer == null) {
            throw new IllegalArgumentException();
        }
        observers.add(observer);
    }

    @Override
    public void removeObserver(ModelObserver observer) {
        if (observer == null) {
            throw new IllegalArgumentException();
        }
        observers.remove(observer);
    }

}
