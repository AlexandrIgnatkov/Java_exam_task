package com.stormnet.figuresfx.controller;

import com.stormnet.figuresfx.drawutils.Drawer;
import com.stormnet.figuresfx.exeption.NoFigureException;
import com.stormnet.figuresfx.figures.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import static com.stormnet.figuresfx.FiguresFxApp.logger;

public class MainScreenController implements Initializable, TypeFigure {

    private ArrayList<Figure> figures;
    private Random random;

    @FXML
    private Canvas canvas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        figures = new ArrayList<>();
        random = new Random(System.currentTimeMillis());
    }

    @FXML
    private void onMouseClicked(MouseEvent evt) {
        try {
            figures.add(createFigure(evt.getX(), evt.getY()));
        } catch (NoFigureException e) {
            logger.warn(e.getMessage(), e);
        }
        repaint();
    }

    private void repaint() {
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        Drawer<Figure> drawer = new Drawer<>(figures);
        drawer.draw(canvas.getGraphicsContext2D());
    }

    private Figure createFigure(double x, double y) throws NoFigureException {
        Figure figure = null;
        switch (random.nextInt(quantity)) {
            case Figure.FUGURE_TYPE_CIRCLE:
                figure = new Circle(x, y, random.nextInt(4),
                        Color.rgb(random.nextInt(255), random.nextInt(255) , random.nextInt(255)),
                        random.nextInt(50));
                break;
            case Figure.FUGURE_TYPE_RECT:
                figure = new Rectangle(x, y, random.nextInt(5),
                        Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(100)),
                        random.nextInt(100), random.nextInt(100));
                break;
            case Figure.FUGURE_TYPE_TRIANGLE:
                figure = new Triangle(x, y, random.nextInt(6),
                        Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255)),
                                random.nextInt(50));
                break;
            case Figure.FUGURE_TYPE_STAR:
                figure = new Star(x, y, random.nextInt(6),
                        Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255)),
                        random.nextInt(50));
                break;
            default:
                logger.error(new NoFigureException("Unknown type of figure"));
        }
        return figure;
    }


}
