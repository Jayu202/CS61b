package deque;

public class LinkedListDeque<T> {
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
    int size = 0;

    Node sentF;
    Node sentB;
    public T LinkedListDeque(T x){
        sentF = new Node(null,x,null);
        sentB = sentF;
        size = 1;
        return (T) sentB.item;
    }

//    public T getrecursive(int index){
//    //递归的get
//
//    }

    public void addFirst(T item){
        sentF = new Node(null,item,sentF);
        size++;

    }

    public void addLast(T item){
        sentB = new Node(sentB,item,null);
        size++;

    }

    public boolean isEmpty(){
        if(sentB==sentF)
            return true;
        else return false;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        Node p =sentF;
        while (p!=null){
            System.out.println(p.item);
            p = p.next;
        }
    }

    public T removeFirst(){
        T x = (T) sentF.item;
        sentF = sentF.next;
        sentF.last = null;
        return x;
    }

    public T removeLast(){
        T x = (T) sentB.item;
        sentB = sentB.last;
        sentB.next =null;
        return x;
    }

    public T get(int index){
        Node p = sentF;
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


}
