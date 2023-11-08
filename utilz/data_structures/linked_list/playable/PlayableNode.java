package utilz.data_structures.linked_list.playable;

public class PlayableNode<Playable> {
    
    private PlayableNode<Playable> next;
    private Playable character;

    public PlayableNode(Playable character) {
        this.character = character;
    } //constructor

    public PlayableNode<Playable> getNext() {
        return this.next;
    } //getNext

    public void setNext(PlayableNode<Playable> next) {
        this.next = next;
    } //setNext

    public Playable getCharacter() {
        return this.character;
    } //getCharacter

    public void setCharacter(Playable character) {
        this.character = character;
    } //setCharacter

} //Node
