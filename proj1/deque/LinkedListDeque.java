package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>,Iterable<T>{
    private int size = 0;
    private final Node<T> sent = new Node<>(null,null,null);

    public LinkedListDeque(){
        sent.next = sent;
        sent.last = sent;
        size = 0;
    }
    public LinkedListDeque(T x){
        sent.last = new Node(sent,x,sent);
        sent.next = sent.last;
        size = 1;
    }

    @Override
    public void addFirst(T item){
        sent.next = new Node(sent,item,sent.next);
        sent.next.next.last = sent.next;
        size++;
    }

    @Override
    public void addLast(T item){
        sent.last = new Node(sent.last,item,sent);
        sent.last.last.next = sent.last;
        size++;

    }

    @Override
    public boolean isEmpty(){
        if(size == 0)
            return true;
        else return false;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public void printDeque(){
        Node p =sent.next;
        while (p!=sent){
            System.out.println(p.item);
            p = p.next;
        }
    }

    @Override
    public T removeFirst(){
        if(size == 0){return null;}
        T x = (T) sent.next.item;
        sent.next = sent.next.next;
        sent.next.last = sent;
        size--;
        return x;
    }

    @Override
    public T removeLast(){
        if(size == 0){return null;}
        T x = (T) sent.last.item;
        sent.next = null;
        sent.last = sent.last.last;
        sent.last.next = sent;
        size--;
        return x;
    }

    @Override
    public T get(int index){
        Node p = sent;
        while (index>0){
            p = p.next;
            index--;
        }
        return (T) p.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new linklistIterator();
    }

    private class linklistIterator implements Iterator<T>{
        int wizPos = 0;
         public boolean hasNext(){
            return wizPos < size;
         }
        public T next(){
            T returnItem = (T) get(wizPos);
            wizPos += 1;
            return  returnItem;
         }

    }

//    public Iterator<T> iterator(){
//
//    }
//
//    public boolean equals(Object o){
//
//    }


    //    public T getrecursive(int index){
//    //递归的get
//
//    }

    public class Node<T>{
    Node<T> last;
    T item;
    Node<T> next;
    public  Node(Node last,T i,Node next){
        this.last = last;
        item = i;
        this.next = next;
    }
    }

}
