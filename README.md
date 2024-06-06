# Java Data Structures Project 2023

## Project Overview

This repository contains the solutions to the Data Structures Fall Semester Project, including the implementation of a B-Tree sorting machine, a dictionary using a hash table with binary search trees, multiple stacks using a single array, and a graph pathfinding algorithm.

### Contents:
- `Question1.java`: B-Tree Sorting Machine
- `Question2.java`: Dictionary with Hash Table
- `Question3.java`: Multiple Stacks with Single Array
- `Question4.java`: Graph Pathfinding Algorithm
- `Data Structures Fall Semester Project Report.pdf`: Detailed project report

## Question 1: B-Tree Sorting Machine

**Files:**
- `Question1.java`

**Description:**
This program sorts an array of key values using a B-Tree. The keys are inserted into the B-Tree, and then the tree is traversed in inorder to obtain the sorted order.

**Usage:**
1. Create an array of integers.
2. Insert the array elements into the B-Tree.
3. Print the sorted array using inorder traversal.

```java
// Example usage
int[] keys = {5, 6, 4, 8, 10, 22, 35, 46, 15, 52};
BTree btree = new BTree();
for (int key : keys) {
    btree.insert(key);
}
btree.inorderTraversal();
```

## Question 2: Dictionary with Hash Table

**Files:**
- `Question2.java`
- `mywords.txt`

**Description:**
This program creates a dictionary of at least 30 words using a hash table where each bucket is a binary search tree. The words and their meanings are read from a file (`mywords.txt`).

**Usage:**
1. Read words and meanings from `mywords.txt`.
2. Insert the words into the hash table.
3. Search for word meanings using the hash table.

```java
// Example usage
HashTable dictionary = new HashTable();
dictionary.readFromFile("mywords.txt");
dictionary.search("computer");
```

## Question 3: Multiple Stacks with Single Array

**Files:**
- `Question3.java`

**Description:**
This program implements multiple stacks using a single array. The stacks support standard stack operations (push, pop, peek) and are distinguished by their stack number.

**Usage:**
1. Initialize the stack array.
2. Push and pop elements from specific stacks.

```java
// Example usage
MultipleStacks stacks = new MultipleStacks(3);
stacks.push('A', 0);
stacks.push('B', 1);
stacks.pop(1);
```

## Question 4: Graph Pathfinding Algorithm

**Files:**
- `Question4.java`

**Description:**
This program finds the shortest path in a graph that connects all vertices together, without any cycles, using the minimum possible total edge weight. The graph is represented as an adjacency list.

**Usage:**
1. Create nodes and edges for the graph.
2. Use the shortest path algorithm to find the minimum path.

```java
// Example usage
Graph graph = new Graph();
Node nodeA = new Node("A");
Node nodeB = new Node("B");
// Add nodes and edges
graph.addEdge(nodeA, nodeB, 12);
graph.calculateShortestPathFromSource(nodeA);
```

## Project Report

The detailed project report is available in the file [`Data Structures Fall Semester Project Report.pdf`](https://markummitchell.github.io/engauge-digitizer/). It includes explanations of the implementations, methods used, and challenges faced.

## Contributors
- [Furkan BAYTAK](https://github.com/FurkanBaytak)
- [Furkan ÖZKAYA](https://github.com/Elhier0)
