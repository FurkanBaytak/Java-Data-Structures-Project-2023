// Furkan BAYTAK 210316033

// Furkan ÖZKAYA 200316060

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class HashTable {
    private final int size;
    private final BinarySearchTree[] table;

    public HashTable(int size) {
        this.size = size;
        this.table = new BinarySearchTree[size];
        Arrays.fill(this.table, null);
    }

    public static int hashKey(String word) {
        int key = 0;
        char[] c = word.toCharArray();
        for (Character ss : c) {
            key += ss - 'a' + 1;
        }
        return key;
    }

    public int hashFunction(String word) {
        int key = hashKey(word);
        return key % this.size;
    }

    public static void fileIn(HashTable words, String path) {
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String word = myReader.nextLine();
                String means = myReader.nextLine();
                words.insert(word, means);
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void insert(String word, String means) {
        int index = hashFunction(word);
        int key = hashKey(word);
        if (this.table[index] == null) {
            this.table[index] = new BinarySearchTree();
        }
        this.table[index].insert(key, means);
    }

    public void search(String word) {
        int index = hashFunction(word);
        if (this.table[index] == null) {
            System.out.println("Word doesn't exist");
        } else {
            String means = this.table[index].Search(this.table[index].root, word);
            System.out.printf("%s: %s%n", word, means);
        }
    }
}

class BinarySearchTree {

    static class Node {
        int key;
        String means;
        Node left, right;

        public Node(int item, String str) {
            key = item;
            means = str;
            left = right = null;
        }
    }

    Node root;

    BinarySearchTree() {
        root = null;
    }

    BinarySearchTree(int key, String means) {
        root = new Node(key, means);
    }

    public void insert(int key, String means) {
        root = insertRec(root, key, means);
    }

    Node insertRec(Node root, int key, String means) {
        if (root == null) {
            return root = new Node(key, means);
        } else if (key < root.key) {
            root.left = insertRec(root.left, key, means);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key, means);
        }
        return root;
    }

    String Search(Node root, String word) {
        int key = HashTable.hashKey(word);
        if (root != null) {
            if (root.key == key) {
                return root.means;
            } else if (key < root.key) {
                return Search(root.left, word);
            } else {
                return Search(root.right, word);
            }
        }
        return null;
    }

}

public class Question2 {
    public static void main(String[] args) {
        HashTable words = new HashTable(18);
        HashTable.fileIn(words, "C:\\Users\\onyxe\\Desktop\\DataStructure\\src\\mywords.txt");
        //words{accoy,sigillography,caespitose,tephra,bunting,hetaerocracy,tepefaction,xebec
        //quippery,equatorium,diffrangible,divellent,frondiferous,torsiograph,tilleul
        //microsomatous,laminary,zugtrompete,toponym,waftage,ideophone,hypertrichologist
        //haemal,magnality,ballaster,refugium,rhumb,arcate,diacope,ubique}
        words.search("accoy");
        words.search("waftage");
        words.search("tilleul");
    }


}
