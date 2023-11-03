package utilz.data_structures;

public class Node<T extends Playable> {
    
    private Node<T> next;
    private Playable character;

    public Node(Playable character) {
        this.character = character;
    } //constructor

    public Node<T> getNext() {
        return this.next;
    } //getNext

    public void setNext(Node<T> next) {
        this.next = next;
    } //setNext

    public Playable getCharacter() {
        return this.character;
    } //getCharacter

    public void setCharacter(Playable character) {
        this.character = character;
    } //setCharacter

} //Node
