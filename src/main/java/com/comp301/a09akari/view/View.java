package com.comp301.a09akari.view;

import com.comp301.a09akari.controller.AltControllerImpl;
import com.comp301.a09akari.controller.AlternateMvcController;
import com.comp301.a09akari.controller.ClassicMvcController;
import com.comp301.a09akari.controller.ControllerImpl;
import com.comp301.a09akari.model.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

import java.util.List;

public class View implements FXComponent, ModelObserver{
    private final AlternateMvcController controller;
    private final Scene scene;
    public View(AlternateMvcController controller) {
        this.controller = controller;
        this.scene = new Scene(render());
        List<Puzzle> puzzles = PuzzleLibraryView.create();
        PuzzleLibrary puzzleLibrary = new PuzzleLibraryImpl();
        for (Puzzle p : puzzles) {
            puzzleLibrary.addPuzzle(p);
        }
        Model mod = new ModelImpl(puzzleLibrary);
        mod.addObserver(this);
    }

    @Override
    public Parent render() {
        VBox layout = new VBox();
        layout.getStyleClass().add("view");
        // Message view
        MessageView messageView = new MessageView(controller);
        layout.getChildren().add(messageView.render());

        //Puzzle view
        PuzzleView puzzleView = new PuzzleView(controller);
        layout.getChildren().add(puzzleView.render());

        //Controls view
        ControlView controlView = new ControlView(controller);
        layout.getChildren().add(controlView.render());

        return layout;
    }

    @Override
    public void update(Model model) {
        scene.setRoot(render());
    }
}
