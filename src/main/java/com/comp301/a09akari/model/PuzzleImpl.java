package com.comp301.a09akari.model;

public class PuzzleImpl implements Puzzle{
    private final int[][] board;
    public PuzzleImpl(int[][] board) {
        this.board = board;
    }

    @Override
    public int getWidth() {
        return board.length;
    }

    @Override
    public int getHeight() {
        return board[0].length;
    }

    @Override
    public CellType getCellType(int r, int c) {
        if (r < 0 || c < 0 || r > this.getWidth() || c > this.getHeight()) {
            throw new IndexOutOfBoundsException();
        }
        int cell = board[r][c];
        if (cell < 5) {
            return CellType.CLUE;
        }
        if (cell == 5) {
            return CellType.WALL;
        }
        if (cell == 6) {
            return CellType.CORRIDOR;
        }
        return null;
    }

    @Override
    public int getClue(int r, int c) {
        if (r < 0 || c < 0 || r > this.getWidth() || c > this.getHeight()) {
            throw new IndexOutOfBoundsException();
        }
        if (this.getCellType(r, c) != CellType.CLUE) {
            throw new IllegalArgumentException();
        }
        return board[r][c];
    }

}
