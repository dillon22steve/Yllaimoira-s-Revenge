package characters.playable;

import java.awt.image.BufferedImage;

import characters.attacks.Attack;
import equipment.Equipment;
import utilz.HelperMethods;

public class Playable {

    private String name;
    private int health;
    private int gold;
    private int level;
    private Equipment rightHand, leftHand, ring1, ring2, head, torso, legs, feet;
    private int initiative;
    private BufferedImage img;
    private int imgSize;
    private int xPos, yPos;
    private Attack[] attacks;


    public Playable(String name, int health, int gold, int level, String imgName) {
        img = HelperMethods.LoadImage(imgName);
        imgSize = HelperMethods.CalcTileSize(48);
        this.name = name;
        this.health = health;
        this.gold = gold;
        this.level = level;
        initiative = 0;
    } //constructor


    public void attack() {
        
    } //attack


    public void rollInitiative() {
        initiative = (int)(Math.random() * 20);
    } //rollInitiative


    public boolean equals(Playable character) {
        return name.equals(character.getName());
    } //equals


    public void replaceAttack(int index, Attack newAttack) {
        attacks[index] = newAttack;
    } //replaceAttack



    public BufferedImage getImg() {
        return this.img;
    } //getImg
    public int getImgSize() {
        return this.imgSize;
    } //getImgSize
    public int getYPos() {
        return this.yPos;
    } //getYPos
    public void setYPos(int yPos) {
        this.yPos = yPos;
    } //setYPos
    public int getXPos() {
        return this.xPos;
    } //getXPos
    public void setXPos(int xPos) {
        this.xPos = xPos;
    } //setXPos
    public String getName() {
        return name;
    } //getName
    public void setName(String name) {
        this.name = name;
    } //setName
    public int getHealth() {
        return health;
    } //getHealth
    public void setHealth(int health) {
        this.health = health;
    } //setHealth
    public int getGold() {
        return gold;
    } //getGold
    public void setGold(int gold) {
        this.gold = gold;
    } //setGold
    public int getLevel() {
        return level;
    } //getLevel
    public void setLevel(int level) {
        this.level = level;
    } //setLevel
    public Equipment getRightHand() {
        return rightHand;
    } //getRightHand
    public void setRightHand(Equipment rightHand) {
        this.rightHand = rightHand;
    } //setRightHand
    public Equipment getLeftHand() {
        return leftHand;
    } //getLeftHand
    public void setLeftHand(Equipment leftHand) {
        this.leftHand = leftHand;
    } //setLeftHand
    public Equipment getRing1() {
        return ring1;
    } //getRing1
    public void setRing1(Equipment ring1) {
        this.ring1 = ring1;
    } //setRing1
    public Equipment getRing2() {
        return ring2;
    } //getRing2
    public void setRing2(Equipment ring2) {
        this.ring2 = ring2;
    } //setRing2
    public Equipment getHead() {
        return head;
    } //getHead
    public void setHead(Equipment head) {
        this.head = head;
    } //setHead
    public Equipment getTorso() {
        return torso;
    } //getTorso
    public void setTorso(Equipment torso) {
        this.torso = torso;
    } //setTorso
    public Equipment getLegs() {
        return legs;
    } //getLegs
    public void setLegs(Equipment legs) {
        this.legs = legs;
    } //setLegs
    public Equipment getFeet() {
        return feet;
    } //getFeet
    public void setFeet(Equipment feet) {
        this.feet = feet;
    } //setFeet
    public int getInitiative() {
        return this.initiative;
    } //getInitiative
    public Attack[] getAttacks() {
        return this.attacks;
    } //getAttacks

} //Playable
