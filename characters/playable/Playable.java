package characters.playable;

import equipment.Equipment;

public class Playable {
    private String name;
    private int health;
    private int gold;
    private int level;
    private Equipment rightHand, leftHand, ring1, ring2, head, torso, legs, feet;


    public Playable(String name, int health, int gold, int level) {
        this.name = name;
        this.health = health;
        this.gold = gold;
        this.level = level;
    } //constructor

    public void attack() {
        
    } //attack





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
    } //getRing1
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
} //Playable
