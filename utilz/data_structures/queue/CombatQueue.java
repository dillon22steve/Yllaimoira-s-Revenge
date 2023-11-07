package utilz.data_structures.queue;

import characters.playable.Playable;
import utilz.data_structures.Node;

public class CombatQueue<T extends Playable> {
    
    private Node<Playable> rear;
    private Node<Playable> front;

    public CombatQueue() {
        this.rear = null;
        this.front = null;
    } //constructor

    public void enqueue(Playable character) {
        Node<Playable> nodeToQueue = new Node<Playable>(character);
        if (rear == null) {
            front = nodeToQueue;
            rear = nodeToQueue;
        } else {
            rear.setNext(nodeToQueue);
            rear = nodeToQueue;
        } //if
    } //enqueue

    public Playable dequeue() {
        if (front == null) {
            return null;
        } else {
            Playable characterToReturn = front.getCharacter();
            front = front.getNext();
            if (front == null) {
                rear = null;
            } //if
            return characterToReturn;
        } //if
    } //dequeue

} //CombatQueue
