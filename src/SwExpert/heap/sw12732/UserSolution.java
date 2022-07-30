package SwExpert.heap.sw12732;

public class UserSolution {

    static class Node {
        int uid;
        int income;

        public Node(int uid, int income) {
            this.uid = uid;
            this.income = income;
        }
    }

    Node[] heap;
    Node trash;
    int cnt;

    public void init() {
        heap = new Node[100001];
        cnt = 1;
        trash = new Node(-1,-1);
    }

    public void addUser(int uID, int income) {
        heap[cnt] = new Node(uID, income);
        sort(cnt);
        cnt++;
    }

    private void sort(int idx) {
        if (idx == 1) return;
        if (heap[idx].income > heap[idx / 2].income) {//부모의 income보다 크면
            Node tmp = heap[idx];
            heap[idx] = heap[idx / 2];
            heap[idx / 2] = tmp;
            sort(idx / 2);
        } else if (heap[idx].income == heap[idx / 2].income) {
            if (heap[idx].uid < heap[idx / 2].uid) {
                Node tmp = heap[idx];
                heap[idx] = heap[idx / 2];
                heap[idx / 2] = tmp;
                sort(idx / 2);
            }
        }
    }


    int getTop10(int[] result) {
        int max = (cnt > 10) ? 10 : cnt - 1;

        Node tmp[] = new Node[max];
        for (int i = 0; i < max; i++) {
            Node top = heap[1];
            result[i] = top.uid;
            tmp[i] = top;
            pop();
        }
        for (Node node : tmp) {
            addUser(node.uid, node.income);
        }
        return max;
    }

    private void pop() {
        if (cnt - 1 < 1) return;

        heap[1] = heap[cnt - 1];
        heap[cnt - 1] = trash;
        cnt--;
        int idx = 1;
        while ((idx * 2) < cnt) {
            Node max = heap[idx * 2];
            int maxPos = idx * 2;

            if (idx * 2 + 1 < cnt && max.income < heap[idx * 2 + 1].income) {
                max = heap[idx * 2 + 1];
                maxPos = idx * 2 + 1;
            }
            if (idx * 2 + 1 < cnt && max.income == heap[idx * 2 + 1].income) {
                if (max.uid > heap[idx * 2 + 1].uid) {
                    max = heap[idx * 2 + 1];
                    maxPos = idx * 2 + 1;
                }
            }


            if (heap[idx].income > max.income) break;

            Node tmp = heap[idx];
            heap[idx] = max;
            heap[maxPos] = tmp;
            idx = maxPos;
        }
    }
}