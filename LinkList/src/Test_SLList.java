public class Test_SLList {
    public static void main(String[] args) {
        SLList L = new SLList();
        L.addFirst(4);
        L.addFirst(6);
        L.addFirst(8);
        L.addLast(999);
        System.out.println(L.getFirst());
        System.out.println(L.getLast());
    }


}
