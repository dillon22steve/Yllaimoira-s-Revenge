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
    }

    public void attack() {
        
    }





    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getGold() {
        return gold;
    }
    public void setGold(int gold) {
        this.gold = gold;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public Equipment getRightHand() {
        return rightHand;
    }
    public void setRightHand(Equipment rightHand) {
        this.rightHand = rightHand;
    }
    public Equipment getLeftHand() {
        return leftHand;
    }
    public void setLeftHand(Equipment leftHand) {
        this.leftHand = leftHand;
    }
    public Equipment getRing1() {
        return ring1;
    }
    public void setRing1(Equipment ring1) {
        this.ring1 = ring1;
    }
    public Equipment getRing2() {
        return ring2;
    }
    public void setRing2(Equipment ring2) {
        this.ring2 = ring2;
    }
    public Equipment getHead() {
        return head;
    }
    public void setHead(Equipment head) {
        this.head = head;
    }
    public Equipment getTorso() {
        return torso;
    }
    public void setTorso(Equipment torso) {
        this.torso = torso;
    }
    public Equipment getLegs() {
        return legs;
    }
    public void setLegs(Equipment legs) {
        this.legs = legs;
    }
    public Equipment getFeet() {
        return feet;
    }
    public void setFeet(Equipment feet) {
        this.feet = feet;
    }
}
