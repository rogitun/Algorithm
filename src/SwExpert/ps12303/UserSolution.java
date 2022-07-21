package SwExpert.ps12303;

class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class UserSolution {

    private final static int MAX_NODE = 10000;

    private Node[] node = new Node[MAX_NODE];
    private int nodeCnt = 0;
    private Node head;

    public Node getNode(int data) {
        node[nodeCnt] = new Node(data);
        return node[nodeCnt++];
    }

    public void init() {
        node = new Node[MAX_NODE];
    }

    public void addNode2Head(int data) {
        Node node = getNode(data);
        if (head != null) {
            node.next = head;
        }
        head = node;
    }

    public void addNode2Tail(int data) {
        Node node = getNode(data);
        Node tmp = head;
        while(tmp.next!=null){
               tmp = tmp.next;
        }
        tmp.next = node;
    }

    public void addNode2Num(int data, int num) {
        if(num==1){
            addNode2Head(data);
            return;
        }
        Node find = head;
        Node newNode = getNode(data);
        num -=1;
        while(num > 2){
            find = find.next;
            num--;
        }
        newNode.next = find.next;
        find.next = newNode;
    }

    public void removeNode(int data) {
        Node find = head;

        while(find.next.data != data){
            find = find.next;

            if(find.next==null) break;
            if(find.next.data == data){
                find.next = find.next.next;
                nodeCnt--;
                break;
            }
        }
    }

    public int getList(int[] output) {
        Node find = head;
        int idx = 0;
        while(find!=null){
            output[idx++] = find.data;
            find = find.next;
        }
        return nodeCnt;
    }
}