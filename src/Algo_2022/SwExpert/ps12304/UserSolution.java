package Algo_2022.SwExpert.ps12304;

class Node {
    public int data;
    public Node prev;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class UserSolution {

    private final static int MAX_NODE = 10000;

    private Node[] node;
    private int nodeCnt;
    private Node head;

    public Node getNode(int data) {
        node[nodeCnt] = new Node(data);
        return node[nodeCnt++];
    }

    public void init() {
        node = new Node[MAX_NODE];
        nodeCnt = 0;
        head = null;
    }

    public void addNode2Head(int data) {
        Node newNode = getNode(data);
        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
    }

    public void addNode2Tail(int data) {
        Node newNode = getNode(data);
        Node find = head;

        while(find.next != null){
            find = find.next;
        }
        find.next = newNode;
        newNode.prev = find;
    }

    public void addNode2Num(int data, int num) {
        if(num==1){
            addNode2Head(data);
            return;
        }
        if(num > nodeCnt){
            addNode2Tail(data);
            return;
        }
        Node newNode = getNode(data);

        num-=1; //6 & 1 2 3 4 5 7
        // num = 1
        Node find = head;
        while(num > 1){
            find = find.next;
            num--;
        }
        //10을 9번위치에 넣겠다.
        //2 3 4 5 6 7 8 9
        find.next.prev = newNode;
        newNode.next = find.next; // 6 - 7
        newNode.prev = find; // 5 - 6 - 7
        find.next = newNode;

    }

    public int findNode(int data) {
        //순서
        int idx = 1;

        Node find = head;
        while(find !=null){
            if(find.data == data) return idx;
            find = find.next;
            idx++;
        }
        return 0;
    }

    public void removeNode(int data) {
        Node find = head;
        while(find != null){
            if(find.data == data){
                if(find==head){
                    head = find.next;
                    head.prev = null;
                }
                else if(find.next == null){
                    find.prev.next = null;
                }
                else{
                    find.prev.next = find.next;
                    find.next.prev = find.prev;
                }
                nodeCnt--;
                return;
            }
            find = find.next;
        }
    }
    //1 2 3 4 5 6 7 8
    //5, 1
    //2 3 5 7 9


    public int getList(int[] output) {
        Node find = head;
        for(int i=0;i<nodeCnt;i++){
            output[i] = find.data;
            find = find.next;
        }
        return nodeCnt;
    }

    public int getReversedList(int[] output) {
        Node find = head;
        while(find.next !=null){
            find = find.next;
        }

        for(int i=0;i<nodeCnt;i++){
            output[i] = find.data;
            find = find.prev;
        }
        return nodeCnt;
    }
}