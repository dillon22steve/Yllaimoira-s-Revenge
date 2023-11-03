package characters.playable;

import java.awt.image.BufferedImage;
import utilz.data_structures.linked_list.MyList;
import equipment.Equipment;
import utilz.HelperMethods;

public class Player extends Playable {

    private BufferedImage img;
    private int imgSize;
    private MyList<PartyMember> party;

    public Player(String name, int health, int gold, int level) {
        super(name, health, gold, level);
        img = HelperMethods.LoadImage("Heart_56.png");
        imgSize = HelperMethods.CalcTileSize(48);
        party = null;
    } //constructor


    public void giveToPartyMember(Equipment item, PartyMember partyMember) {

    } //giveToPartyMember

    
    public BufferedImage getImg() {
        return this.img;
    } //getImg
    public int getImgSize() {
        return this.imgSize;
    } //getImgSize
    public MyList<PartyMember> getParty() {
        return this.party;
    } //getParty
    public void addToParty(PartyMember partyMember) {
        party.add(partyMember);
    } //addToParty
    
}
