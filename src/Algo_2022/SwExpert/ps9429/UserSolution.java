package Algo_2022.SwExpert.ps9429;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

class UserSolution {
    DirectoryTree tree;

    void init(int n) {
        tree = new DirectoryTree();

    }

    void cmd_mkdir(char[] path, char[] name) {
        String file = new String(name, 0, name.length - 1);
        String dir = new String(path, 0, path.length - 1);
//		System.out.println(dir + "하위 디렉토리에 " + file + "을 저장");
        Node newNode = new Node(file);
        if (path[1] == '\0') { // 루트노드에 추가할 때 , 입력이 "/" 뿐일 떄
            tree.root.childrenList.add(newNode);
            newNode.parent = tree.root;
            tree.root.count += 1;
        } else {
            Node node = tree.findNode(dir, tree.root); // node에 path노드를 찾아 저장한다.
            node.childrenList.add(newNode); // node의 childList에 추가.
            newNode.parent = node;
            while (node != null) {
                node.count++;
                node = node.parent;
            }
        }

    }

    void cmd_rm(char[] path) {
        String target = new String(path, 0, path.length - 1);
//		System.out.println(target + "을 rm");
        String[] dirs = target.split("/");
        String rmFile = dirs[dirs.length - 1];
        Node rmNode = tree.findNode(target, tree.root); // 그 디렉토리를 찾는다
        rmNode.parent.childrenList.remove(new Node(rmFile));

        int rmCount = rmNode.count + 1; // 삭제 될 노드의 하위 디렉토리 수를 저장한다
        Node parent = rmNode.parent; //삭제될노드의 부모를 저장

        while (parent != null) { // 부모노드를 쭉 따라 올라가며 count의 수를 조정
            parent.count -= rmCount;
            parent = parent.parent;
        }

    }

    void cmd_cp(char[] srcPath, char[] dstPath) {
        String src = new String(srcPath, 0, srcPath.length - 1); // 널문자 제거
        String dst = new String(dstPath, 0, dstPath.length - 1); // 널문자 제거
//		System.out.println(src + "에서 " + dst + "로 cp");
        Node srcNode = tree.findNode(src, tree.root);
        Node dstNode = tree.findNode(dst, tree.root);

        Node cpyNode = new Node(srcNode.name); //일단 복사될 노드의 최 상위 노드를 만든다.
        cpyNode.count = srcNode.count; // 복사

        dstNode.childrenList.add(cpyNode); // 그것을 dst에 일단 저장한다.

        cpyNode.parent = dstNode; // 그 하위노드부터 쭉 재귀를 통해 탐색하며 복사한다
        treeCopy(srcNode, cpyNode);// 재귀함수

        int srcCount = srcNode.count + 1;
        while (dstNode != null) {// 복사된 노드의 수만큼 모든 부모의 count에 추가시킨다.
            dstNode.count += srcCount;
            dstNode = dstNode.parent;
        }

    }

    void treeCopy(Node src, Node dst) {
        if (src.childrenList.isEmpty())
            return;

        for (int i = 0; i < src.childrenList.size(); i++) {
            Node cpyNode = new Node(src.childrenList.get(i).name);
            cpyNode.count = src.childrenList.get(i).count;
            dst.childrenList.add(cpyNode);
            cpyNode.parent = dst;
            treeCopy(src.childrenList.get(i), dst.childrenList.get(i));
        }

    }

    void cmd_mv(char[] srcPath, char[] dstPath) {
        String src = new String(srcPath, 0, srcPath.length - 1); // 널문자 제거
        String dst = new String(dstPath, 0, dstPath.length - 1); // 널문자 제거
//		System.out.println(src + "에서 " + dst + "로 mv");
        Node srcNode = tree.findNode(src, tree.root);
        Node dstNode = tree.findNode(dst, tree.root);
        int srcCount = srcNode.count + 1;
        while (srcNode.parent != null) { // 카운트 계산
            srcNode.parent.count -= srcCount;
            srcNode = srcNode.parent;
        }
        while (dstNode != null) { // 카운트 계산
            dstNode.count += srcCount;
            dstNode = dstNode.parent;
        }

        srcNode = tree.findNode(src, tree.root);
        dstNode = tree.findNode(dst, tree.root);
        dstNode.childrenList.add(srcNode);
        srcNode.parent.childrenList.remove(srcNode);

        srcNode.parent = dstNode;

    }

    int cmd_find(char[] path) {
        String str = new String(path, 0, path.length - 1);
//		System.out.println(str + "의 find");
        if (path[1] == '\0') { // path가 루트노드일때
            return tree.root.count;
        }
        Node node = tree.findNode(new String(path, 0, path.length - 1), tree.root);
        return node.count;
    }
}

class DirectoryTree {
    Node root;

    public DirectoryTree() {
        root = new Node("/");
    }

    public Node findNode(String target, Node root) {
        if (target.equals("/")) {
            return this.root;
        }
        target = target.substring(1, target.length());
        String[] dirs = target.split("/");
        Node node = root;
        for (int i = 0; i < dirs.length; i++) {
            int idx = node.childrenList.indexOf(new Node(dirs[i]));
            node = node.childrenList.get(idx);
        }
        return node;
    }
}

class Node {
    String name;
    ArrayList< Node > childrenList;
    Node parent; // 부모노드 저장
    int count = 0; // 하위 디렉토리의 노드 수 저장하는 변수

    public Node() {
        name = "";
        childrenList = new ArrayList<>();
    }

    public Node(String name) {
        this.name = name;
        childrenList = new ArrayList<>();
    }

    @Override
    public boolean equals(Object obj) {
        Node node = (Node) obj;
        return node.name.equals(this.name);

    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }

}

