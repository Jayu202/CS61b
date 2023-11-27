package bstmap;

import java.awt.image.Kernel;
import java.util.Iterator;
import java.util.Set;

public class BSTMap<S extends Comparable, S1> implements Map61B{


    private class Node{
        private S s;
        private S1 s1;
        private Node left,right;

        public Node(S s,S1 s1){
            this.s = s;
            this.s1 = s1;
            this.left = null;
            this.right = null;
        }

    }
    private int N=0;

    private Node root;

    @Override
    public void clear() {
        N = 0;
        root = null;
    }


    @Override
    public boolean containsKey(Object key) {
        if (containsKey(root, (S) key) == null){return false;}
        else return true;
    }
    private Node containsKey(Node x,S key){
        if(x==null)return null;
        int cmp = key.compareTo(x.s);
        if(cmp<0){x.left = containsKey(x.left,key);return x;}
        else if(cmp>0){ x.right = containsKey(x.right,key);return x;}
        else if(cmp==0)return x;
        else {
            return null;
        }
    }


    @Override
    public Object get(Object key) {
        return get(root, (S) key);
    }
    public S1 get(Node x,S key){
        if(x==null)return null;
        int cmp = key.compareTo(x.s);
        if(cmp<0){return get(x.left,key);}
        else if(cmp>0){return get(x.right,key);}
        else return x.s1;
    }

    @Override
    public int size() {
        return this.N;
    }


    @Override
    public void put ( Object key, Object value ) {
//        root = put(root, (S) key, (S1) value);
        if (this.root == null) {
            this.root = new Node((S) key, (S1) value);
            this.N++;
            return;
        }
        Node node = this.root;
        Object[] obj = bSearch(node, (S) key);
        node = (Node) obj[1];
        if (obj[2].equals(-1)) {
            node.left = new Node((S) key, (S1) value);
        } else {
            node.right = new Node((S) key, (S1) value);
        }
        this.N++;
    }
//    public Node put(Node x,S key,S1 value){

//        if(x == null){
//                N+=1;
//            return new Node(key,value);
//        }
//        int cmp = key.compareTo(x.s);
//        if (cmp < 0) {x.left = put(x.left,key,value);return x.left;}
//        if (cmp > 0) {x.right =put(x.right,key,value);return x.right;}
//        else return null;
//        }

    private Object[] bSearch ( Node node, S key ) {
        Node prev = null;
        while (true) {
            if (node.s.compareTo(key) > 0) {
                if (node.left != null) {
                    prev = node;
                    node = node.left;
                } else {
                    //下一个将是left
                    return new Object[]{prev, node, -1};
                }
            } else if (node.s.compareTo(key) < 0) {
                if (node.right != null) {
                    prev = node;
                    node = node.right;
                } else {//下一个是右节点
                    return new Object[]{prev, node, 1};
                }
            } else {//到达目标
                return new Object[]{prev, node, 0};
            }
        }
    }


    @java.lang.Override
    public Set<S> keySet () {
        return null;
    }

    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public Object remove(Object key, Object value) {
        return null;
    }


    @Override
    public Iterator iterator() {
        return null;
    }

    public static void main ( String[] args ) {
        BSTMap b = new BSTMap();
        b.put("a",1);
        b.put("b",2);
        b.put("c",3);
        b.put("d",4);
    }
}
