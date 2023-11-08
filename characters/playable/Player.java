package characters.playable;

import equipment.Equipment;
import utilz.data_structures.linked_list.playable.PlayableList;

public class Player extends Playable {

    private PlayableList<PartyMember> party;

    public Player(String name, int health, int gold, int level, String imgName) {
        super(name, health, gold, level, imgName);
        party = new PlayableList<PartyMember>();
    } //constructor


    public void giveToPartyMember(Equipment item, PartyMember partyMember) {

    } //giveToPartyMember

    
    
    public PlayableList<PartyMember> getParty() {
        return this.party;
    } //getParty
    public void addToParty(PartyMember partyMember) {
        party.add(partyMember);
    } //addToParty
    
}
