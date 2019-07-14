package com.stormnet.figuresfx.figures;
import com.stormnet.figuresfx.drawutils.Drawable;
import javafx.scene.paint.Color;

public abstract class Figure implements TypeFigure, Drawable {

    private int type;
    protected double cx;
    protected double cy;
    protected double lineWidth;
    protected Color color;

    public Figure(int type, double cx, double cy, double lineWidth, Color color) {
        this.type = type;
        this.cx = cx;
        this.cy = cy;
        this.lineWidth = lineWidth;
        this.color = color;
    }

    public Figure(double cx, double cy, double lineWidth, Color color) {
    }

    public double getCx() {
        return cx;
    }

    public void setCx(double cx) {
        this.cx = cx;
    }

    public double getCy() {
        return cy;
    }

    public void setCy(double cy) {
        this.cy = cy;
    }

    public double getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth(double lineWidth) {
        this.lineWidth = lineWidth;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getType() {
        return type;
    }

}
