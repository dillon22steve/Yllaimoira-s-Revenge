package characters.playable;

import utilz.data_structures.linked_list.MyList;
import equipment.Equipment;

public class Player extends Playable {

    private MyList<PartyMember> party;

    public Player(String name, int health, int gold, int level, String imgName) {
        super(name, health, gold, level, imgName);
        party = new MyList<PartyMember>();
    } //constructor


    public void giveToPartyMember(Equipment item, PartyMember partyMember) {

    } //giveToPartyMember

    
    
    public MyList<PartyMember> getParty() {
        return this.party;
    } //getParty
    public void addToParty(PartyMember partyMember) {
        party.add(partyMember);
    } //addToParty
    
}
