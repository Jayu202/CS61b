package deque;

import jh61b.junit.In;
import net.sf.saxon.functions.Minimax;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque{

    Comparator cmp;
    public MaxArrayDeque(Comparator<T> c){
        super();
        cmp = c;
    }

    public MaxArrayDeque(Comparable<T> c){
        //使用给定Comparable创建MaxArrayDeque

    }
    public T max(){
        if(this.isEmpty())return null;
        T maxValue = (T)items[arrayInd(0)];
        for (int i = 1; i < size; i++) {
            if(cmp.compare((T)items[arrayInd(i)],maxValue)>0){
                maxValue = (T) items[arrayInd(i)];
            }
        }
        return maxValue;
    }
    public T max(Comparator<T> c){
        if(this.isEmpty())return null;
        T maxValue = (T)items[arrayInd(0)];
        for (int i = 1; i < size; i++) {
            if(c.compare((T)items[arrayInd(i)],maxValue)>0){
                maxValue = (T)items[arrayInd(i)];
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        Comparator<Integer> cmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return 1;
                } else if (o1 < o2) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };
        MaxArrayDeque mad = new MaxArrayDeque(cmp);
        int n = 99;

        for (int i = n; i >= 0; i--) {
            mad.addFirst(i);
        }

        System.out.println(mad.max());
        System.out.println(mad.max(cmp));

    }
}
