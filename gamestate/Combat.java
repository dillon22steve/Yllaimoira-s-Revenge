package gamestate;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import characters.playable.enemies.Enemy;
import render.GamePanel;
import ui.bars.combat_menu.SelectionBar;

public class Combat implements GameStateInterface {

    private char combatState;
    private Enemy enemy;
    private Game game;
    private CombatQueue<Playable> combatQueue;
    private Playable currentTurn;
    private int playerY;
    private int xOffset;
    private int partyYOffset;
    private SelectionBar selectionBar;

    public Combat(Game game) {
        this.game = game;
        combatQueue = null;
        enemy = null;
        currentTurn = null;
        playerY = (GamePanel.SCREEN_HEIGHT / 2) - (game.getPlayer().getImgSize() / 2);
        xOffset = (int)(GamePanel.SCREEN_WIDTH * 0.3);
        combatState = 's';
        initBars();
    } //constructor

    private void initBars() {
        int barWidth = xOffset - (xOffset / 4);
        selectionBar = new SelectionBar(barWidth, 0, 0, 0);
    } //initBars


    public void initializeCombat(Enemy enemy) {
        this.enemy = enemy;
        Playable[] tempArr = new Playable[game.getPlayer().getParty().getSize() + 2];
        tempArr[0] = enemy;
        tempArr[1] = game.getPlayer();
        for (int i = 0; i < tempArr.length; i++) {
            tempArr[i].rollInitiative();
        } //for

        //This loop enqueue's the party members, the player, and the enemy in order from the highest
        //initiative roll to the lowest, so that the FIFO order of the queue goes in descending order
        //of the initiative rolls.
        for (int i = 0; i < tempArr.length; i++) {
            int maxIndex = 0;
            for (int j = i; j < tempArr.length; j++) {
                if (tempArr[j].getInitiative() > tempArr[maxIndex].getInitiative()) {
                    maxIndex = j;
                } //if
            } //for
            combatQueue.enqueue(tempArr[maxIndex]);
        } //for

        //Calculates how far apart to draw the party members based off of how many members there are.
        if (game.getPlayer().getParty() != null) {
            if (game.getPlayer().getParty().isEmpty() == false) {
                partyYOffset = (int)((playerY - (0.2 * GamePanel.SCREEN_HEIGHT)) / ((tempArr.length - 2) / 2));
            } //if
        } //if

        updateBarsHeight();
    } //initializeCombat

    private void updateBarsHeight() {
        selectionBar.setHeight(partyYOffset);
    } //updateBarsHeight

    private void updateBarsYPos() {
        selectionBar.setYPos(currentTurn.yPos - (partyYOffset / 2));
    } //updateBarsYPos


    public void render(Graphics g) {
        Player player = game.getPlayer();
        g.drawImage(player.getImg(), GamePanel.SCREEN_WIDTH - xOffset, playerY, player.getImgSize(), player.getImgSize());
        g.drawImage(enemy.getImg(), 0 + xOffset, playerY, enemy.getImgSize(), enemy.getImgSize());
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


    public char getCombatState() {
        return this.combatState;
    } //getCombatState
    public void setCombatState(char combatState) {
        this.combatState = combatState;
    } //setCombatState
    
} //Combat
