
public class BinarySortTree {
    private static Node root;

    static class Node {
        public int val;
        public Node left;
        public Node right;


        public Node(int val) {
            this.val = val;
        }
    }

    //构造二叉树
    public static Node create(int key) {
        Node node = new Node(key);
        if(root == null) {
            return node;
        }
        Node parent = null;
        Node cur = root;
        while (cur != null) {
            if(cur.val < key) {
                parent = cur;
                cur = cur.right;
            }else if(cur.val > key) {
                parent = cur;
                cur = cur.left;
            }else {
                break;
            }
        }
        //cur == null parent = cur的父亲
        if(parent.val < key) {
            parent.right = node;
        }else {
            parent.left = node;
        }
        return node;
    }

    //查找
    public Node find(int key) {
        Node cur = root;

        while (cur != null) {
            if (key < cur.val) {
                cur = cur.left;
            } else if (key > cur.val) {
                cur = cur.right;
            } else {
                return cur;
            }
        }
        return null;
    }

    //插入
    public boolean insert(int key) {
        Node cur = root;
        Node parent = null;
        if (root == null) {
            root.val = key;
            return true;
        }
        while(cur != null) {
            if (cur.val < key) {
                parent = cur;
                cur = cur.right;
            } else if (cur.val > key) {
                parent = cur;
                cur = cur.left;
            } else {
                return false;
            }
        }

        Node node = new Node(key);
        if (key < parent.val) {
            parent.left = node;
        }else {
            parent.right = node;
        }
        return true;
    }

    //删除
    public boolean remove(int key) {

        return true;
    }

    //中序遍历
    public static void inorder(Node root) {
        if (root == null) {return;}
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }

    //前序遍历
    public static void preorder(Node root) {
        if (root == null) {return;}
        System.out.println(root.val);
        preorder(root.left);
        preorder(root.right);
    }


    public static void main(String[] args) {
        int[] array = {13,34,52,23,15,79};
        for (int i = 0; i < array.length; i++) {
            create(array[i]);
        }
        inorder(root);
        preorder(root);
    }


}
