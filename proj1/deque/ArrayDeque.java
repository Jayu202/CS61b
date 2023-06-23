package deque;

public class ArrayDeque<T> {
    int size;
    T[] items;
    public ArrayDeque(){
        size = 0;
        items = (T[]) new Object[100];
    }

    public ArrayDeque(T x){
        size = 1;
        items = (T[]) new Object[100];
        items[0] = x;
    }

//    public void addFirst(T item)
    //: 添加一个类型的项目T到双端队列的前面。你可以假设那item是 never null。

    private void resize(int capacity){
        T[] a = (T[])new Object[capacity];
        System.arraycopy(items,0,a,0,size);
        items = a;
    }
    public void addLast(T item)
    // : 添加一个类型的项目T到双端队列的后面。你可以假设那item是 never null。
    {
        if(size == items.length){
            resize(size * 2);
        }
        items[size] = item;
        size++;
    }

    public boolean isEmpty()
    //：true如果双端队列为空则返回，false否则返回。
    {
        if(size == 0)return true;
        else return false;
    }

    public int size()
    //：返回双端队列中的项目数。
    {
        return size;
    }

    public void printDeque()
    //: 从头到尾打印双端队列中的项目，以空格分隔。打印完所有项目后，打印出新的一行。
    {
        for (int i = 0; i < size+1; i++) {
            System.out.println(items[i]);
        }
    }

//    public T removeFirst()
    //：删除并返回双端队列前面的项目。如果不存在这样的项目，则返回null。

    public T removeLast()
    //：删除并返回双端队列后面的项目。如果不存在这样的项目，则返回null。
    {
        T x = items[size-1];
        if(size == 0)return null;
        size--;
        return x;
    }

    public T get(int index)
    //: 获取给定索引处的项目，其中 0 是前面的项目，1 是下一个项目，依此类推。如果不存在这样的项目，则返回null。不能改变双端队列！
    {
        if(index > size)return null;
        return items[index];
    }
}
