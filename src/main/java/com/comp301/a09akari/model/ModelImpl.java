package com.comp301.a09akari.model;

import java.util.ArrayList;
import java.util.List;

public class ModelImpl implements Model{
    private final PuzzleLibrary library;
    private List<int[][]> lampStorage; //0 means no lamp, 1 means lamp and lit, 2 means no lamp but lit
    private int i;
    private boolean[] solved;
    private List<ModelObserver> observers;
    private int litSpots;

    public ModelImpl(PuzzleLibrary library) {
        if (library == null) {
            throw new IllegalArgumentException();
        }
        this.library = library;
        this.i = 0;
        this.solved = new boolean[this.library.size()];
        for (int s = 0; s < library.size(); s++) {
            solved[s] = false;
        }
        this.observers = new ArrayList<>();
        this.litSpots = 0;
    }

    @Override
    public void addLamp(int r, int c) {
        if (r < 0 || c < 0 || r > library.getPuzzle(i).getWidth() - 1 || c > library.getPuzzle(i).getHeight() - 1) {
            throw new IndexOutOfBoundsException();
        }
        if (!isLampIllegal(r, c)) {
            CellType puzzleType = library.getPuzzle(i).getCellType(r, c);
            if (puzzleType != CellType.CORRIDOR) {
                throw new IllegalArgumentException();
            }
            lampStorage.get(i)[r][c] = 1;
            int rStorage = r;
            int cStorage = c;
            r = r + 1;
            while(library.getPuzzle(i).getCellType(r, c) == CellType.CORRIDOR) { //lights up the row of lamp
                lampStorage.get(i)[r][c] = 2;
                r = r + 1;
            }
            c = c + 1;
            while (library.getPuzzle(i).getCellType(r, c) == CellType.CORRIDOR) { //lights up the column of lamp
                lampStorage.get(i)[r][c] = 2;
                c = c + 1;
            }
            r = rStorage - 1;
            while(library.getPuzzle(i).getCellType(r, c) == CellType.CORRIDOR) { //lights up the row of lamp
                lampStorage.get(i)[r][c] = 2;
                r = r - 1;
            }
            c = cStorage - 1;
            while (library.getPuzzle(i).getCellType(r, c) == CellType.CORRIDOR) { //lights up the column of lamp
                lampStorage.get(i)[r][c] = 2;
                c = c - 1;
            }
        }
        for (ModelObserver o : observers) {
            o.update(this);
        }
    }

    @Override
    public void removeLamp(int r, int c) {
       if (r < 0 || c < 0 || r > library.getPuzzle(i).getWidth() - 1 || c > library.getPuzzle(i).getHeight() - 1) {
            throw new IndexOutOfBoundsException();
       }
       if (library.getPuzzle(i).getCellType(r, c) != CellType.CORRIDOR) {
            throw new IllegalArgumentException();
       }
        if (library.getPuzzle(i).getCellType(r, c) == null) {
            throw new NullPointerException();
        }
       if (isLamp(r, c)) {
           lampStorage.get(i)[r][c] = 0;
           for (ModelObserver o : observers) {
               o.update(this);
           }
       }
    }

    @Override
    public boolean isLit(int r, int c) {
        if (r < 0 || c < 0 || r > library.getPuzzle(i).getWidth() - 1 || c > library.getPuzzle(i).getHeight() - 1) {
            throw new IndexOutOfBoundsException();
        }
        if (library.getPuzzle(i).getCellType(r, c) != CellType.CORRIDOR) {
            throw new IllegalArgumentException();
        }
        return this.isLamp(r, c) || lampStorage.get(i)[r][c] == 2;
    }

    @Override
    public boolean isLamp(int r, int c) {
        if (r < 0 || c < 0 || r > library.getPuzzle(i).getWidth() - 1 || c > library.getPuzzle(i).getHeight() - 1) {
            throw new IndexOutOfBoundsException();
        }
        if (library.getPuzzle(i).getCellType(r, c) == null) {
            throw new NullPointerException();
        }
        if (library.getPuzzle(i).getCellType(r, c) != CellType.CORRIDOR) {
            throw new IllegalArgumentException();
        }
        return lampStorage.get(i)[r][c] == 1;
    }

    @Override
    public boolean isLampIllegal(int r, int c) {
        if (r < 0 || c < 0 || r > library.getPuzzle(i).getWidth() - 1|| c > library.getPuzzle(i).getHeight() - 1) {
            throw new IndexOutOfBoundsException();
        }
        if (library.getPuzzle(i).getCellType(r, c) == null) {
            throw new NullPointerException();
        }
        if (this.isLamp(r + 1, c) || this.isLamp(r - 1, c) || this.isLamp(r, c + 1) || this.isLamp(r, c - 1)) {
            return true;
        }
        return false;
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
        for (ModelObserver o : observers) {
            o.update(this);
        }
    }

    @Override
    public int getPuzzleLibrarySize() {
        return library.size();
    }

    @Override
    public void resetPuzzle() {
        for (int k = 0; k < library.getPuzzle(i).getWidth(); k++) {
            for (int j = 0; j < library.getPuzzle(i).getHeight(); j++) {
                if (library.getPuzzle(i).getCellType(k, j) == CellType.CORRIDOR) {
                    if (this.isLamp(k, j)) {
                        lampStorage.get(i)[k][j] = 0;
                    }
                }
            }
        }
        for (ModelObserver o : observers) {
            o.update(this);
        }
    }

    @Override
    public boolean isSolved() {
        if (solved[i]) {
            return true;
        }
        int totalSpots = 0;
        litSpots = 0;
        for (int k = 0; k < library.getPuzzle(i).getWidth(); k++) { //algorithm for checking the lit corridors
            for (int j = 0; j < library.getPuzzle(i).getHeight(); j++) {
                if (library.getPuzzle(i).getCellType(k, j) == CellType.CORRIDOR) {
                    totalSpots++;
                    if (this.isLit(k, j)) {
                        litSpots++;
                    }
                }
            }
        }
        for (int k = 0; k < library.getPuzzle(i).getWidth(); k++) { //algorithm that checks none of the lamps are illegal
            for (int j = 0; j < library.getPuzzle(i).getHeight(); j++) {
                if (this.lampStorage.get(i)[k][j] == 1) {
                    if (this.isLampIllegal(k, j)) {
                        litSpots = 0;
                        return false;
                    }
                }
            }
        }
        for (int k = 0; k < library.getPuzzle(i).getWidth(); k++) { //algorithm for checking if each clue is satisfied
            for (int j = 0; j < library.getPuzzle(i).getHeight(); j++) {
                if (library.getPuzzle(i).getCellType(k, j) == CellType.CLUE) {
                    if (!this.isClueSatisfied(k, j)) {
                        litSpots = 0;
                        return false;
                    }
                }
            }
        }
        if (litSpots == totalSpots) {
            solved[i] = true;
            litSpots = 0;
            return true;
        }
        litSpots = 0;
        return false;
    }

    @Override
    public boolean isClueSatisfied(int r, int c) {
        if (r < 0 || c < 0 || r > library.getPuzzle(i).getWidth() || c > library.getPuzzle(i).getHeight()) {
            throw new IndexOutOfBoundsException();
        }
        CellType puzzleType = library.getPuzzle(i).getCellType(r, c);
        if (puzzleType != CellType.CLUE) {
            throw new IllegalArgumentException();
        }

        int clueAmount = library.getPuzzle(i).getClue(r, c);
        int lampCount = 0;
        if (r < library.getPuzzle(i).getWidth()) {
            if (lampStorage.get(i)[r + 1][c] == 1) { //checks right
                lampCount++;
            }
        }
        if (r > 0) {
            if (lampStorage.get(i)[r - 1][c] == 1) { //checks left
                lampCount++;
            }
        }
        if (c < library.getPuzzle(i).getHeight()) {
            if (lampStorage.get(i)[r][c - 1] == 1) { //checks up
                lampCount++;
            }
        }
        if (c > 0) {
            if (lampStorage.get(i)[r][c + 1] == 1) { //checks down
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
