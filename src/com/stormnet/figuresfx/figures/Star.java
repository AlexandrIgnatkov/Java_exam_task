package com.stormnet.figuresfx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Star extends Figure {
    private double size;

    private Star(double cx, double cy, double lineWidth, Color color) {
        super(Figure.FUGURE_TYPE_STAR, cx, cy, lineWidth, color);
    }

    public Star(double cx, double cy, double lineWidth, Color color, double size) {
        this(cx, cy, lineWidth, color);
        this.size = size < 10 ? 10 : size;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWidth);
        gc.setStroke(color);
        gc.strokePolygon(new double[]{
                cx - 1.5 * size,
                cx - 0.5 * size,
                cx,
                cx + 0.5 * size,
                cx + 1.5 * size,
                cx + 0.5 * size,
                cx,
                cx - 0.5 * size
        }, new double[]{
                cy,
                cy - 0.5 * size,
                cy - 1.5 * size,
                cy - 0.5 * size,
                cy,
                cy + 0.5 * size,
                cy + 1.5 * size,
                cy + 0.5 * size

        }, 8);


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Star star = (Star) o;
        return Double.compare(star.size, size) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size);
    }
}
