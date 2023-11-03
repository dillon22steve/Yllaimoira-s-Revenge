package gamestate;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import characters.playable.enemies.Enemy;

public class Combat implements GameStateInterface {

    private Enemy enemy;
    private Game game;
    private CombatQueue<Playable> combatQueue;

    public Combat(Game game) {
        this.game = game;
        combatQueue = null;
    } //constructor

    public void render(Graphics g) {
        
    } //render

    @Override
    public void update() {
        
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

    public void initializeCombat(Enemy enemy) {
        this.enemy = enemy;
        Playable[] tempArr = new Playable[game.getPlayer().getParty().getSize() + 2];
        tempArr[0] = enemy;
        tempArr[1] = game.getPlayer();
        for (int i = 0; i < tempArr.length; i++) {
            tempArr[i].rollInitiative();
        } //for
        for (int i = 0; i < tempArr.length; i++) {
            int minIndex = 0;
            for (int j = i; j < tempArr.length; j++) {
                if (tempArr[j].getInitiative() < tempArr[minIndex].getInitiative()) {
                    minIndex = j;
                } //if
            } //for
            combatQueue.enqueue(tempArr[minIndex]);
        } //for
    } //setEnemy
    
} //Combat
