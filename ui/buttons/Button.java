package ui.buttons;

import java.awt.Rectangle;

import utilz.HelperMethods;

public class Button {
    protected int width, height, xPos, yPos;
    protected String txt;
    private Rectangle bounds;

    public Button(String txt, int width, int height, int xPos, int yPos) {
        this.width = HelperMethods.calcX(width);
        this.height = HelperMethods.calcY(height);
        this.xPos = xPos;
        this.yPos = yPos;
        this.txt = txt;

        initBounds();
    } //constructor

    private void initBounds() {
        this.bounds = new Rectangle(xPos, yPos, width, height);
    } //initBounds

    public Rectangle getBounds() {
        return this.bounds;
    } //getBounds

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    } //setBounds

    public int getX() {
        return this.xPos;
    } //getX
    public int getYPos() {
        return this.yPos;
    } //getY
    public void setYPos(int y) {
        this.yPos = y;
    } //setY

    public void setTxt(String txt) {
        this.txt = txt;
    } //setTxt

    public String getTxt() {
        return this.txt;
    } //getTxt

    public int getHeight() {
        return this.height;
    } //getHeight

} //Button
