package deque;

public class LinkedListDeque<T> {
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

    public void addFirst(T item){
        sent.next = new Node(sent,item,sent.next);
        sent.next.next.last = sent.next;
        size++;
    }

    public void addLast(T item){
        sent.last = new Node(sent.last,item,sent);
        sent.last.last.next = sent.last;
        size++;

    }

    public boolean isEmpty(){
        if(size == 0)
            return true;
        else return false;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        Node p =sent.next;
        while (p!=sent){
            System.out.println(p.item);
            p = p.next;
        }
    }

    public T removeFirst(){
        if(size == 0){return null;}
        T x = (T) sent.next.item;
        sent.next = sent.next.next;
        sent.next.last = sent;
        size--;
        return x;
    }

    public T removeLast(){
        if(size == 0){return null;}
        T x = (T) sent.last.item;
        sent.next = null;
        sent.last = sent.last.last;
        sent.last.next = sent;
        size--;
        return x;
    }

    public T get(int index){
        Node p = sent;
        while (index>0){
            p = p.next;
            index--;
        }
        return (T) p.item;
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
