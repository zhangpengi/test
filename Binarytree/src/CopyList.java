import java.util.HashMap;
import java.util.Map;

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyList {
    //复制随机链表结构，不改变结果
    public Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            Node node = new Node(cur.val);
            map.put(cur,node);
            cur = cur.next;
        }
        // 将 新老结点映射到 Map 中
        cur = head;

        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }

    String str = "jisjdij";
    char[] a = str.toCharArray();
}
