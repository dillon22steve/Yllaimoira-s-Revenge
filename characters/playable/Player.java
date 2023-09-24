package characters.playable;

import java.awt.image.BufferedImage;

import equipment.Equipment;
import utilz.HelperMethods;

public class Player extends Playable {

    private BufferedImage img;
    private int imgSize;

    public Player(String name, int health, int gold, int level) {
        super(name, health, gold, level);
        img = HelperMethods.LoadImage("Heart_56.png");
        imgSize = HelperMethods.CalcTileSize(48);
    } //constructor


    public void giveToPartyMember(Equipment item, PartyMember partyMember) {

    } //giveToPartyMember

    
    public BufferedImage getImg() {
        return this.img;
    } //getImg
    public int getImgSize() {
        return this.imgSize;
    } //getImgSize
    
}
