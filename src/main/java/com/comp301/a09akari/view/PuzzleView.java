package com.comp301.a09akari.view;

import com.comp301.a09akari.controller.AlternateMvcController;
import com.comp301.a09akari.model.CellType;
import com.comp301.a09akari.model.Puzzle;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;

public class PuzzleView implements FXComponent {
  // this component displays the clues and game board inside a grid panel
  private final AlternateMvcController controller;

  public PuzzleView(AlternateMvcController controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {

    GridPane board = new GridPane(); // main grid
    board.setHgap(10);
    board.setVgap(10);

    GridPane buttonBoard = new GridPane(); // button grid
    buttonBoard.setHgap(10);
    buttonBoard.setVgap(10);

    ImageView tile;
    Puzzle puzzle = controller.getActivePuzzle();
    int rStorage = 0;
    int cStorage = 0;
    for (int r = 0; r < puzzle.getHeight(); r++) {
      for (int c = 0; c < puzzle.getWidth(); c++) {
        if (puzzle.getCellType(r, c) == CellType.CORRIDOR) {
          Button button = new Button();
          button.setPrefHeight(50);
          button.setPrefWidth(50);
          int finalR = r;
          int finalC = c;
          button.setOnMousePressed(
              (MouseEvent event) -> {
                controller.clickCell(finalR, finalC);
              });
          ImageView imageView =
              new ImageView("https://www.iconsdb.com/icons/preview/black/square-outline-xxl.png");
          if (controller.isLamp(r, c)) {
            if (controller.isLampIllegal(r, c)) {
              imageView.setImage(
                  new Image(
                      "https://imagelive.scentsy.com/cmsimages/products/accessorybulb20wattredrafw21.png"));
            } else {
              imageView.setImage(
                  new Image("https://cdn-icons-png.flaticon.com/512/2988/2988036.png"));
            }
          } else if (controller.isLit(r, c)) {
            imageView.setImage(
                new Image("https://www.clker.com/cliparts/A/I/8/t/J/m/yellow-square-2-hi.png"));
          }
          imageView.setFitHeight(50);
          imageView.setFitWidth(50);
          button.setBackground(Background.EMPTY);
          board.add(imageView, c, r);
          board.add(button, c, r);
        } else if (puzzle.getCellType(r, c) == CellType.WALL) {
          tile =
              new ImageView(
                  "https://e7.pngegg.com/pngimages/145/567/png-clipart-red-block-new-super-mario-bros-2-new-super-mario-bros-2-new-super-mario-bros-u-brick-angle-brown.png");
          tile.setFitHeight(50);
          tile.setFitWidth(50);
          board.add(tile, c, r);
        } else if (puzzle.getCellType(r, c) == CellType.CLUE) {
          int clue = puzzle.getClue(r, c);
          if (clue == 0) {
            if (controller.isClueSatisfied(r, c)) {
              tile =
                  new ImageView(
                      "https://cdn.pixabay.com/photo/2012/04/23/15/08/zero-38418_960_720.png");
            } else {
              tile =
                  new ImageView(
                      "https://img.freepik.com/free-psd/number-0-made-from-neon-light_35913-1965.jpg?size=626&ext=jpg");
            }
            tile.setFitHeight(50);
            tile.setFitWidth(50);
            board.add(tile, c, r);
          } else if (clue == 1) {
            if (controller.isClueSatisfied(r, c)) {
              tile = new ImageView("https://www.techguruit.com/wp-content/uploads/1-green.png");
            } else {
              tile =
                  new ImageView(
                      "https://img.freepik.com/free-psd/number-1-made-from-neon-light_35913-1966.jpg?size=626&ext=jpg");
            }
            tile.setFitHeight(50);
            tile.setFitWidth(50);
            board.add(tile, c, r);
          } else if (clue == 2) {
            if (controller.isClueSatisfied(r, c)) {
              tile =
                  new ImageView(
                      "https://p.kindpng.com/picc/s/11-113022_number-1-2-3-icon-1-2-3.png");
            } else {
              tile =
                  new ImageView(
                      "https://img.freepik.com/free-psd/number-2-made-from-neon-light_35913-1967.jpg?size=626&ext=jpg");
            }
            tile.setFitHeight(50);
            tile.setFitWidth(50);
            board.add(tile, c, r);
          } else if (clue == 3) {
            if (controller.isClueSatisfied(r, c)) {
              tile =
                  new ImageView(
                      "https://cdn.pixabay.com/photo/2012/04/23/17/07/three-39116_640.png");
            } else {
              tile =
                  new ImageView(
                      "https://img.freepik.com/free-psd/number-3-made-from-neon-light_35913-1968.jpg?size=626&ext=jpg");
            }
            tile.setFitHeight(50);
            tile.setFitWidth(50);
            board.add(tile, c, r);
          } else if (clue == 4) {
            if (controller.isClueSatisfied(r, c)) {
              tile =
                  new ImageView(
                      "https://www.clker.com/cliparts/p/q/0/t/5/v/number-4-round-green-md.png");
            } else {
              tile =
                  new ImageView(
                      "https://img.freepik.com/free-psd/number-4-made-from-neon-light_35913-1969.jpg?size=626&ext=jpg");
            }
            tile.setFitHeight(50);
            tile.setFitWidth(50);
            board.add(tile, c, r);
          }
        }
      }
    }

    return board;
  }
}
