package com.stormnet.figuresfx.drawutils;

import com.stormnet.figuresfx.figures.Figure;
import javafx.scene.canvas.GraphicsContext;
import org.apache.log4j.Logger;
import java.util.List;

public class Drawer<T extends Figure> implements Drawable {
    private List<Figure> figures;
    private static final Logger logger = Logger.getLogger(Drawer.class);
    public Drawer(List<Figure> figures) {
        this.figures = figures;
    }

    @Override
    public void draw(GraphicsContext gc) {
        for (Figure figure : figures) {
            if (figure != null)
                figure.draw(gc);
                else logger.warn("Figure = null");
        }
    }
}