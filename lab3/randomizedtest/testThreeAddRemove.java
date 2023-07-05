package randomizedtest;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;

public class testThreeAddRemove {
    @Test
    public void testThreeAddRemove() {
        AListNoResizing a = new AListNoResizing();
        BuggyAList b = new BuggyAList();

        a.addLast(4);
        b.addLast(4);
        a.addLast(5);
        b.addLast(5);
        a.addLast(6);
        b.addLast(6);

        Assert.assertEquals(a.size(),b.size());
        Assert.assertEquals(a.removeLast(),b.removeLast());
        Assert.assertEquals(a.removeLast(),b.removeLast());
        Assert.assertEquals(a.removeLast(),b.removeLast());

    }

    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
//                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size1 = L.size();
                int size2 = B.size();
//                System.out.println("size: " + size1);
//                System.out.println("size: " + size2);
                Assert.assertEquals(size1,size2);
            }else if(operationNumber == 2){
                //getLast
                int last1 = 0,last2=0;
                if(L.size() != 0){
                    last1 = L.getLast();
//                    System.out.println("getLast(" + last1 + ")");
                }
                if(B.size() != 0){
                    last2 = B.getLast();
//                    System.out.println("getLast(" + last2 + ")");
                }
            }else if(operationNumber == 3){
                //removeLast
                int last1 = 0,last2=0;
                if(L.size() != 0) {
                    last1 = L.getLast();
                    L.removeLast();
//                    System.out.println("removeLast(" + last1 + ")");
                }
                if(B.size() != 0){
                    last2 = B.getLast();
                    B.removeLast();
//                    System.out.println("removeLast(" + last2 + ")");
                }
            }
        }
    }
}
