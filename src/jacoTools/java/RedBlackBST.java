package jacoTools.java;

/**
 * Created by Jaco on 14-10-19.
 * 2-3 tree
 */
public class RedBlackBST<Key extends Comparable<Key>,Value> {
        private Node root;
        private static final boolean RED = true;
        private static final boolean BLACK = false;

        private class Node {
            Key key;
            Value val;
            Node left, right;
            int N;
            boolean color;

            public Node(Key key, Value val, int N, boolean color) {
                this.key = key;
                this.val = val;
                this.N = N;
                this.color = color;
            }
        }

        private int size(Node h){
            if(h == null) return 0;
            else return h.N;
        }

        private boolean isRed(Node x){
            if(x == null) return false;
            else return x.color;
        }

        private Node rotateLeft(Node h){
            Node x = h.right;
            x.color = h.color;
            x.N = h.N;
            x.left = h;
            h.color = RED;     //!
            h.right = x.left;
            h.N = size(h.left) + size(h.right) + 1;
            return x;
        }
        //出现两条左红链接在一起时，形成一个 4- 节点，要对其进行右旋转
        private Node rotateRight(Node h){
            Node x = h.left;
            x.color = h.color;
            x.N = h.N;
            x.right = h;
            h.left = x.right;
            h.N = 1 + size(h.left)
                    + size(h.right);
            return x;
        }
        // 把一个4- 节点的中间节点插入父节点中
        private void flipColors(Node h){
            h.color = RED;
            h.left.color = BLACK;
            h.right.color = BLACK;
        }

        public void put(Key key,Value val){
            root = put(root, key, val);
            root.color = BLACK;
        }

        private Node put(Node h, Key key, Value val){
            if ( h == null)
                return new Node(key, val, 1, RED);

            int cmp = key.compareTo(h.key);
            if  (cmp < 0) h.left = put(h.left, key, val);
            else if(cmp > 0) h.right = put(h.right, key, val);
            else h.val = val;

            if (isRed(h.right) && !isRed(h.left))  h = rotateLeft(h);
            if (isRed(h.left) && isRed(h.left.left))   h = rotateRight(h);
            if (isRed(h.left) && isRed(h.right))      flipColors(h);

            h.N = size(h.left) + size(h.right) + 1;
            return h;
        }

}
