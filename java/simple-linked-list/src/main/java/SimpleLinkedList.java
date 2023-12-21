import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;

class SimpleLinkedList<T> {

    Node<T> head;
    int size;
    public static class Node<T>{
        T data;
        Node<T> next=null;
        Node(T data,Node<T> next){
            this.data=data;
            this.next=next;
        }
        Node(T data){
            this.data=data;
            this.next=null;
        }
    }
    SimpleLinkedList() {
        this.head=null;
        this.size=0;
    }

    SimpleLinkedList(T[] values) {
        for(T nodes:values){
            push(nodes);
        }
    }

    void push(T value) {
        Node<T> newNode=new Node<>(value);
        newNode.next=head;
        head=newNode;
        size++;
    }

    T pop() {
        if(size==0){
            throw new NoSuchElementException();
        }
        Node<T> popNode=head;
        head=head.next;
        size--;
        return popNode.data;
    }

    void reverse() {
        Node<T> currNode=head;
        Node<T> prevNode=null;
        while (currNode!=null){
            Node<T> nextNode=currNode.next;
            currNode.next=prevNode;
            prevNode=currNode;
            currNode=nextNode;
        }
        head=prevNode;
    }

    T[] asArray(Class<T> clazz) {
        ArrayList<T> arraylist=new ArrayList<>();
        Node<T> currHead=head;
        while (currHead!=null){
            arraylist.add(currHead.data);
            currHead=currHead.next;
        }
        T[] array=(T[]) Array.newInstance(clazz,arraylist.size());
        array=arraylist.toArray(array);
        return array;
    }

    int size() {
        return size;
    }
}
