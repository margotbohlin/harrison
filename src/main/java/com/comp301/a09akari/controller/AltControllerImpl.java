package com.comp301.a09akari.controller;

import com.comp301.a09akari.model.CellType;
import com.comp301.a09akari.model.Model;
import com.comp301.a09akari.model.Puzzle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AltControllerImpl implements AlternateMvcController {
  private final Model model;

  public AltControllerImpl(Model model) {
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
    List<Integer> indexList = new ArrayList<>();
    for (int i = 0; i < this.model.getPuzzleLibrarySize(); i++) {
      indexList.add(i);
    }
    Random rand = new Random();
    int index = rand.nextInt(indexList.size());
    int randomInt = indexList.get(index);
    while (randomInt == model.getActivePuzzleIndex()) {
      randomInt = indexList.get(rand.nextInt(indexList.size()));
    }
    this.model.setActivePuzzleIndex(randomInt);
  }

  @Override
  public void clickResetPuzzle() {
    this.model.resetPuzzle();
  }

  @Override
  public void clickCell(int r, int c) {
    if (model.getActivePuzzle().getCellType(r, c) == CellType.CORRIDOR) {
      if (model.isLamp(r, c)) {
        this.model.removeLamp(r, c);
      } else {
        this.model.addLamp(r, c);
      }
    }
  }

  @Override
  public boolean isLit(int r, int c) {
    return model.isLit(r, c);
  }

  @Override
  public boolean isLamp(int r, int c) {
    return model.isLamp(r, c);
  }

  @Override
  public boolean isClueSatisfied(int r, int c) {
    return model.isClueSatisfied(r, c);
  }

  @Override
  public boolean isSolved() {
    return model.isSolved();
  }

  @Override
  public Puzzle getActivePuzzle() {
    return model.getActivePuzzle();
  }

  @Override
  public int getActivePuzzleIndex() {
    return model.getActivePuzzleIndex();
  }

  @Override
  public int getPuzzleLibrarySize() {
    return model.getPuzzleLibrarySize();
  }

  @Override
  public void addLamp(int r, int c) {
    model.addLamp(r, c);
  }

  @Override
  public void removeLamp(int r, int c) {
    model.removeLamp(r, c);
  }

  @Override
  public boolean isLampIllegal(int r, int c) {
    return model.isLampIllegal(r, c);
  }
}
