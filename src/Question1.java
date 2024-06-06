// Furkan BAYTAK 210316033

// Furkan ÖZKAYA 200316060

import java.util.Random;

class CustomNode {
    private CustomNode customLeftNode = null;
    private CustomNode customRightNode = null;
    int value = 0;

    public CustomNode(int value) {
        setValue(value);
    }

    public CustomNode getCustomLeftNode() {
        return customLeftNode;
    }

    public CustomNode getCustomRightNode() {
        return customRightNode;
    }

    public int getValue() {
        return value;
    }

    public void setCustomLeftNode(CustomNode n) {
        customLeftNode = n;
    }

    public void setCustomRightNode(CustomNode n) {
        customRightNode = n;
    }

    public void setValue(int d) {
        value = d;
    }
}

class BTree {
    private CustomNode root = null;

    public void insert(int data) {
        root = insert(root, data);
    }

    private CustomNode insert(CustomNode node, int data) {
        if (node == null) {
            node = new CustomNode(data);
        } else {
            if (data <= node.getValue()) {
                node.setCustomLeftNode(insert(node.getCustomLeftNode(), data));
            } else {
                node.setCustomRightNode(insert(node.getCustomRightNode(), data));
            }
        }
        return node;
    }

    public void inorder() {
        inorder(root);
    }

    private void inorder(CustomNode r) {
        if (r != null) {
            inorder(r.getCustomLeftNode());
            System.out.print(r.getValue() + " ");
            inorder(r.getCustomRightNode());
        }
    }

    public void preorder() {
        preorder(root);
    }

    private void preorder(CustomNode r) {
        if (r != null) {
            System.out.print(r.getValue() + " ");
            preorder(r.getCustomLeftNode());
            preorder(r.getCustomRightNode());
        }
    }
}

public class Question1 {
    public static int[] CreateRandomValues(int numberCount) {
        Random random = new Random();
        int[] numbers = new int[numberCount];
        for (int i = 0; i < numberCount; i++) {
            numbers[i] = Math.abs(random.nextInt(100));
        }
        return numbers;
    }

    public static void main(String[] args) {
        BTree bt = new BTree();
        int[] randomValues = CreateRandomValues(20);
        for (int randomValue : randomValues) bt.insert(randomValue);
        System.out.println("Tree Elements: ");
        bt.preorder();
        System.out.println();
        System.out.println("Sorted Version: ");
        bt.inorder();
    }
}