package utilz.data_structures.linked_list;

public class MyList<T extends Playable> {
    
    private Node<T> head;

    public MyList() {
        head = null;
    } //constructor

    public void add(T character) {
        Node<T> newNode = new Node<T>(character);
        if (head == null) {
            head = newNode;
            return;
        } else {
            newNode.setNext(head);
            head = newNode;
        } //if
    } //add

    public void remove(T character) {
        if (head == null) {
            return;
        } else {
            if (head.getCharacter().getName().equals(character.getName())) {
                head = head.getNext();
            } else {
                Node<T> temp = head;
                while (temp.getNext() != null) {
                    if (temp.getNext().getCharacter().getName().equals(character.getName())) {
                        temp.setNext(temp.getNext().getNext());
                        return;
                    } else {
                        temp = temp.getNext();
                    } //if
                } //while
            } //if
        } //if
    } //remove

    public T get(int index) {
        if (head == null) {
            return null;
        } else {
            int i = 0;
            Node<T> temp = head;
            while (i < index && temp != null) {
                temp = temp.getNext();
            } //while
            if (temp != null) {
                return temp.getCharacter();
            } else {
                return null;
            } //if
        } //if
    } //get

    public boolean isEmpty() {
        return head == null;
    } //isEmpty

    public int getSize() {
        int count = 0;
        Node<T> temp = head;
        while (temp != null) {
            count++;
            temp = temp.getNext();
        } //while
        return count;
    } //getSize

} //MyList
