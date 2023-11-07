package utilz.data_structures.linked_list;

import characters.playable.Playable;
import utilz.data_structures.Node;

public class MyList<T extends Playable> {
    
    private Node<Playable> head;

    public MyList() {
        head = null;
    } //constructor

    public void add(Playable character) {
        Node<Playable> newNode = new Node<Playable>(character);
        if (head == null) {
            head = newNode;
            return;
        } else {
            newNode.setNext(head);
            head = newNode;
        } //if
    } //add

    public void remove(Playable character) {
        if (head == null) {
            return;
        } else {
            if (head.getCharacter().getName().equals(character.getName())) {
                head = head.getNext();
            } else {
                Node<Playable> temp = head;
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

    public Playable get(int index) {
        if (head == null) {
            return null;
        } else {
            int i = 0;
            Node<Playable> temp = head;
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
        Node<Playable> temp = head;
        while (temp != null) {
            count++;
            temp = temp.getNext();
        } //while
        return count;
    } //getSize

    public Node<Playable> getHead() {
        return this.head;
    } //getHead

} //MyList
