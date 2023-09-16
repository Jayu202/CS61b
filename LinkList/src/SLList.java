public class SLList {
    private IntNode sentinel;
    private IntNode last;
    private int size;
    public SLList(int x){
        sentinel = new IntNode(x,null);
        size = 1;
    }
    public SLList(){
        sentinel = null;
        size = 0;
    }

    public void addFirst(int x){
        sentinel = new IntNode(x,sentinel);
        size++;
    }
    public void addLast(int x){
        last.next = new IntNode(x,null);
        last = last.next;
        size+=1;
    }

    public int getFirst(){
        return sentinel.item;
    }
    public int getLast(){
        return last.item;
    }
    public int size(){
        return size;
    }

    public static class IntNode{
        public int item;
        public IntNode next;
        public IntNode(int i,IntNode n){
            item = i;
            next = n;
        }
    }


}




