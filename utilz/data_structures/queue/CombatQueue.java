package utilz.data_structures.queue;

public class CombatQueue<T extends Playable> {
    
    private Node<T> rear;
    private Node<T> front;

    public CombatQueue() {
        this.rear = null;
        this.front = null;
    } //constructor

    public void enqueue(Playable character) {
        Node<T> nodeToQueue = new Node<T>(character);
        if (rear == null) {
            front = nodeToQueue;
            rear = nodeToQueue;
        } else {
            rear.setNext(nodeToQueue);
            rear = nodeToQueue;
        } //if
    } //enqueue

    public T dequeue() {
        if (front == null) {
            return null;
        } else {
            T characterToReturn = front.getCharacter();
            front = front.getNext();
            if (front == null) {
                rear = null;
            } //if
            return characterToReturn;
        } //if
    } //dequeue

} //CombatQueue
