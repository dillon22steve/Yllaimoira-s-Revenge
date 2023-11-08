package gamestate;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import characters.playable.enemies.Enemy;
import render.GamePanel;
import ui.bars.combat_menu.ActionMenuBar;
import ui.bars.combat_menu.RunBar;
import ui.bars.combat_menu.SelectionBar;
import utilz.HelperMethods;
import utilz.data_structures.linked_list.playable.PlayableList;
import utilz.data_structures.linked_list.playable.PlayableNode;
import utilz.data_structures.queue.CombatQueue;
import characters.playable.Playable;
import characters.playable.Player;
import render.Game;

public class Combat implements GameStateInterface {

    private Game game;
    
    private char combatState;

    private PlayableList<Enemy> enemies;
    private Enemy enemy;
    private CombatQueue<Playable> combatQueue;
    private Playable currentTurn;

    private int playerY;
    private int playerX;
    private int xOffset;
    private int partyYOffset;

    private SelectionBar selectionBar;
    private ActionMenuBar actionBar;
    private RunBar runBar;


    public Combat(Game game) {
        this.game = game;
        combatQueue = new CombatQueue<Playable>();
        enemy = null;
        currentTurn = null;
        playerY = (GamePanel.SCREEN_HEIGHT / 2) - (game.getPlayer().getImgSize() / 2);
        xOffset = (int)(GamePanel.SCREEN_WIDTH * 0.3);
        playerX = GamePanel.SCREEN_WIDTH - xOffset;
        combatState = 's';
        initBars();
    } //constructor

    private void initBars() {
        int barWidth = xOffset - (xOffset / 4);
        int barHeight = HelperMethods.calcY(250);
        int barX = (int)(playerX + game.getPlayer().getImgSize() * 1.5);

        selectionBar = new SelectionBar(barWidth, barHeight, barX, 0);
        actionBar = new ActionMenuBar(barWidth, barHeight, barX, 0);
        runBar = new RunBar(barWidth, barHeight, barX, 0);
    } //initBars



    public void initializeCombat(PlayableList<Enemy> enemies) {
        this.enemies = enemies;
        Playable[] tempArr = new Playable[game.getPlayer().getParty().getSize() + (enemies.getSize() + 1)];

        int i = 0;
        PlayableNode<Playable> temp = enemies.getHead();
        while (temp != null) {
            tempArr[i] = temp.getCharacter();
            temp = temp.getNext();
            i++;
        } //while
        tempArr[i] = game.getPlayer();

        initializeQueue(tempArr);

        //Calculates how far apart to draw the party members based off of how many members there are.
        if (game.getPlayer().getParty() != null) {
            if (game.getPlayer().getParty().isEmpty() == false) {
                //Divides the distance between the player and the top of the screen by half of the party's size.
                partyYOffset = (int)((playerY - (0.2 * GamePanel.SCREEN_HEIGHT)) / ((tempArr.length - 2) / 2));
            } //if
        } //if

        updateBarsYPos(playerY);
    } //initializeCombat



    private void initializeQueue(Playable[] tempArr) {
        for (int i = 0; i < tempArr.length; i++) {
            tempArr[i].rollInitiative();
        } //for

        //This loop enqueue's the party members, the player, and the enemy in order from the highest
        //initiative roll to the lowest, so that the FIFO order of the queue goes in descending order
        //of the initiative rolls.
        int maxIndex = 0;
        for (int i = 0; i < tempArr.length; i++) {
            for (int j = i; j < tempArr.length; j++) {
                if (tempArr[j].getInitiative() > tempArr[maxIndex].getInitiative()) {
                    maxIndex = j;
                } //if
            } //for
            combatQueue.enqueue(tempArr[maxIndex]);
            tempArr[maxIndex] = tempArr[i];
        } //for

        currentTurn = tempArr[maxIndex];
        
        //Takes the highest initiative roll and dequeues it so that when their turn is over the next
        //highest initiative will take their turn. The Playable is then enqueued to the queue's rear.
        combatQueue.enqueue(combatQueue.dequeue());
    } //initializeQueue



    private void updateBarsYPos(int characterY) {
        selectionBar.updateYPos(characterY - (selectionBar.getHeight() / 2));
        actionBar.updateYPos(characterY - (actionBar.getHeight() / 2));
        runBar.updateYPos(characterY - (runBar.getHeight() / 2));
    } //updateBarsYPos



    public void nextPlayerTurn() {
        currentTurn = combatQueue.dequeue();
        combatQueue.enqueue(currentTurn);

        if (currentTurn != enemy) {
            updateBarsYPos(currentTurn.getYPos());
        } else {
            //This is where I will code the enemy's attack or healing.
        } //if
    } //nextPlayerTurn


    public void rollToRunAway() {
        int playerRoll = (int)(Math.random() * 20);
        int enemyRoll = (int)(Math.random() * 20);
        if (playerRoll > enemyRoll) {
            GameStates.GameState = GameStates.PLAYING;
        } else {
            //I need to draw the text telling the player whether they successfully ran away.
        } //if
    } //rollToRunAway



    public void render(Graphics g) {
        //Does not draw the menu bars if it is not the player or a party member's turn.
        if (currentTurn != enemy) {
            switch (combatState) {
                case 's':
                    selectionBar.draw(g);
                    break;
                case 'a':
                    actionBar.draw(g);
                    break;
                case 'p':
                    actionBar.draw(g);
                    break;
                case 'r':
                    runBar.draw(g);
                    break;
            } //switch
        } //if

        g.drawImage(enemy.getImg(), xOffset, playerY, enemy.getImgSize(), enemy.getImgSize(), null);
        drawParty(g);
    } //render

    private void drawParty(Graphics g) {
        Player player = game.getPlayer();
        PlayableNode<Playable> temp = player.getParty().getHead();
        int y = partyYOffset;
        int i = 1;

        //draws the player
        g.drawImage(player.getImg(), playerX, playerY, player.getImgSize(), player.getImgSize(), null);

        while (temp != null) {
            Playable partyMember = temp.getCharacter();
            int yPlusOffset = (y + partyYOffset * i);

            //Prevents the party member from being drawn on top of the player. If the party member's y
            //is going to be on top of the player, the party member's y coordinate will be bumped by one
            //more offset
            if ((yPlusOffset >= playerY) && (yPlusOffset <= (playerY + partyYOffset))) {
                i++;
                yPlusOffset = yPlusOffset + partyYOffset;
            } //if
            g.drawImage(partyMember.getImg(), playerX, yPlusOffset, null);

            i++;
            temp = temp.getNext();
        } //while
    } //drawParty



    @Override
    public void update() {
        
    } //update



    @Override
    public void keyPressed(KeyEvent e) {
        switch (combatState) {
            case 's':
                selectionBar.keyPressed(e, this);
                break;
            case 'a':
                actionBar.keyPressed(e, this);
                break;
            case 'p':
                actionBar.keyPressed(e, this);
                break;
            case 'r':
                runBar.keyPressed(e, this);
                break;
        } //switch
    } //keyPressed

    @Override
    public void mouseClicked(int x, int y) {
        switch (combatState) {
            case 's':
                selectionBar.mouseClicked(x, y, this);
                break;
            case 'a':
                actionBar.mouseClicked(x, y, this);
                break;
            case 'p':
                actionBar.mouseClicked(x, y, this);
                break;
            case 'r':
                runBar.mouseClicked(x, y, this);
                break;
        } //switch
    } //mouseClicked

    @Override
    public void mouseMoved(int x, int y) {
        switch (combatState) {
            case 's':
                selectionBar.mouseMoved(x, y);
                break;
            case 'a':
                actionBar.mouseMoved(x, y);
                break;
            case 'p':
                actionBar.mouseMoved(x, y);
                break;
            case 'r':
                runBar.mouseMoved(x, y, this);
                break;
        } //switch
    } //mouseMoved

    public void mouseWheelMoved(int wheelRotation) {
    } //mouseWheelMoved


    public char getCombatState() {
        return this.combatState;
    } //getCombatState
    public void setCombatState(char combatState) {
        this.combatState = combatState;
    } //setCombatState

    public ActionMenuBar getActionBar() {
        return actionBar;
    } //getActionBar

    public Playable getCurrentTurn() {
        return this.currentTurn;
    } //getCurrentTurn

} //Combat
