package deque;

public class ArrayDeque<T> {
    int size;
    T[] items;
    int nextFirst;
    int nextLast;
    public ArrayDeque(){
        size = 0;
        items = (T[]) new Object[8];
        nextFirst = 4;
        nextLast = 5;
    }

    public ArrayDeque(T x){
        size = 1;
        items = (T[]) new Object[8];
        items[5] = x;
        nextFirst = 4;
        nextLast = 6;
    }

    public void resize(int capacity){
        T[] a = (T[])new Object[capacity];
//        System.arraycopy(items,0,a,0,items.length);
//        items = a;

        int ind = 0;
        for (int i = 0; i < size; i += 1) {
            ind = arrayInd(i);
            a[capacity / 4 + i] = items[ind];
        }
        items = a;
        nextFirst = capacity / 4 - 1;
        nextLast = nextFirst + size + 1;

    }

    public int arrayInd(int ind){
        if(nextFirst+1+ind>= items.length){
            return nextFirst+1+ind- items.length;
        }
        else {
            return nextFirst+1+ind;
        }
    }

    public void addFirst(T item){
        if(size == items.length-2)resize(items.length*2);
        if(nextFirst == 0){
            items[nextFirst] = item;
            nextFirst = items.length-1;
        }
        else {
            items[nextFirst] = item;
            nextFirst -= 1;
        }
        size++;
    }
    //: 添加一个类型的项目T到双端队列的前面。你可以假设那item是 never null。
    public T removeFirst(){
        if(isEmpty())return null;

        T x = items[arrayInd(0)];
        items[arrayInd(0)] = null;
        size--;
        nextFirst = arrayInd(0);
        return  x;
    }
        //：删除并返回双端队列前面的项目。如果不存在这样的项目，则返回null。
    public void addLast(T item)
    {
        if(size == items.length - 2)resize(items.length * 2);
        items[nextLast] = item;
        if(nextLast == items.length-1){
            nextLast = 0;
        }
        else {
            nextLast +=1;
        }
        size++;
    }
    public T removeLast()
    {
        if(isEmpty())return null;

        T x = items[arrayInd(size-1)];
        items[arrayInd(size-1)] = null;
        nextLast = arrayInd(size-1);
        size--;
        return x;
    }

    public boolean isEmpty()
    {
        if(size == 0)return true;
        else return false;
    }

    public int size()
    {
        return size;
    }

    public void printDeque()
    //: 从头到尾打印双端队列中的项目，以空格分隔。打印完所有项目后，打印出新的一行。
    {
        for (int i = 0; i < size+1; i++) {
            System.out.println(items[arrayInd(i)]);
        }
    }



    public T get(int index)
    {
        if(index > size)return null;
        return items[index];
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> ll = new ArrayDeque<>(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(4);
        ll.addFirst(4);
        ll.addFirst(4);
        ll.removeFirst();
        ll.removeFirst();
        ll.removeFirst();
        ll.addFirst(4);
        ll.addFirst(4);
        ll.addFirst(4);
        System.out.println(ll);

    }
}
