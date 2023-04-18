package com.comp301.a09akari.controller;

import com.comp301.a09akari.model.CellType;
import com.comp301.a09akari.model.Model;
import com.comp301.a09akari.model.PuzzleLibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ControllerImpl implements ClassicMvcController{
    private Model model;
    public ControllerImpl(Model model) {
        if (model == null) {
            throw new IllegalArgumentException();
        }
        this.model = model;
    }
    @Override
    public void clickNextPuzzle() {
        int puzzleLibrarySize = this.model.getPuzzleLibrarySize();
        int index = this.model.getActivePuzzleIndex();
        if (index < puzzleLibrarySize - 1) {
            this.model.setActivePuzzleIndex(index + 1);
        }
    }

    @Override
    public void clickPrevPuzzle() {
        int index = this.model.getActivePuzzleIndex();
        if (index > 0) {
            this.model.setActivePuzzleIndex(index - 1);
        }
    }

    @Override
    public void clickRandPuzzle() {
        List<Integer> indexList = new ArrayList<Integer>();
        for (int i = 0; i < this.model.getPuzzleLibrarySize(); i++) {
            indexList.add(i);
        }
        Random rand = new Random();
        int index = rand.nextInt(indexList.size());
        int randomInt = indexList.get(index);
        this.model.setActivePuzzleIndex(randomInt);
    }

    @Override
    public void clickResetPuzzle() {
        this.model.resetPuzzle();
    }

    @Override
    public void clickCell(int r, int c) {
        this.model.addLamp(r, c);
    }
}
