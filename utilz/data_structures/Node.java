package utilz.data_structures;

public class Node<Playable> {
    
    private Node<Playable> next;
    private Playable character;

    public Node(Playable character) {
        this.character = character;
    } //constructor

    public Node<Playable> getNext() {
        return this.next;
    } //getNext

    public void setNext(Node<Playable> next) {
        this.next = next;
    } //setNext

    public Playable getCharacter() {
        return this.character;
    } //getCharacter

    public void setCharacter(Playable character) {
        this.character = character;
    } //setCharacter

} //Node
