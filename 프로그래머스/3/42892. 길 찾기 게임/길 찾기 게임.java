import java.util.*;

class Solution {
    
    private int[][] result;
    private int idx;
    
    public int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;
        
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodes.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1, null, null));
        }
        
        nodes.sort(new Comparator<>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.y == o2.y) {
                    return o1.x - o2.x;
                }
                return o2.y - o1.y;
            }
        });
        
        Node root = nodes.get(0);
        for (int i = 1; i < n; i++) {
            insertNode(root, nodes.get(i));
        }
        
        result = new int[2][n];
        
        idx = 0;
        preOrder(root);
        
        idx = 0;
        postOrder(root);
        
        return result;
    }
    
    private void insertNode(Node parent, Node child) {
        if (parent.x > child.x) {
            if (parent.left == null) parent.left = child;
            else insertNode(parent.left, child);
        } else {
            if (parent.right == null) parent.right = child;
            else insertNode(parent.right, child);
        }
    }
    
    private void preOrder(Node node) {
        if (node != null) {
            result[0][idx++] = node.value;
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    
    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            result[1][idx++] = node.value;
        }
    }
    
    static class Node {
        
        int x;
        int y;
        int value;
        Node left;
        Node right;
        
        public Node(int x, int y, int value, Node left, Node right) {
            this.x = x;
            this.y = y;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}