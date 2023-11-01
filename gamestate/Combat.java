package gamestate;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import characters.playable.enemies.Enemy;

public class Combat implements GameStateInterface {

    private ArrayList<Enemy> enemies;

    public Combat() {
        enemies = null;
    } //constructor


    public void render(Graphics g) {
        
    } //render



    @Override
    public void update() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    } //update

    

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
    } //keyPressed

    @Override
    public void mouseClicked(int x, int y) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    } //mouseClicked

    @Override
    public void mouseMoved(int x, int y) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseMoved'");
    } //mouseMoved

    public void mouseWheelMoved(int wheelRotation) {
    } //mouseWheelMoved


    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    } //addEnemy
    
} //CombatMenu
