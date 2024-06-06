// Furkan BAYTAK 210316033

// Furkan ÖZKAYA 200316060

import java.util.*;

class Node {
    private final String name;
    private List<Node> shortestPath = new LinkedList<>();
    private Integer distance = Integer.MAX_VALUE;
    Map<Node, Integer> adjacentNodes = new HashMap<>();

    public void addDestination(Node destination, int distance) {
        adjacentNodes.put(destination, distance);
    }

    public Node(String name) {
        this.name = name;
    }

    public int getDistance() {
        return this.distance;
    }

    public void setDistance(int value) {
        this.distance = value;
    }

    public Map<Node, Integer> getAdjacentNodes() {
        return this.adjacentNodes;
    }

    public List<Node> getShortestPath() {
        return this.shortestPath;
    }

    public void setShortestPath(List<Node> value) {
        this.shortestPath = value;
    }

    public String getName() {
        return this.name;
    }
}

class Graph {
    private Set<Node> nodes = new HashSet<>();

    public void addNode(Node nodeA) {
        nodes.add(nodeA);
    }
}

public class Question4 {
    public static void calculateShortestPathFromSource(Graph graph, Node source) {
        source.setDistance(0);

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);

        while (unsettledNodes.size() != 0) {
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Map.Entry<Node, Integer> adjacencyPair :
                    currentNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        System.out.println(source.getName());
        for (Node node : settledNodes) {
            System.out.println(node.getName());
        }
    }

    private static void calculateMinimumDistance(Node evaluationNode,
                                                 Integer edgeWeigh, Node sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

    private static Node getLowestDistanceNode(Set<Node> unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node : unsettledNodes) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    public static void main(String[] args) {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");
        Node nodeH = new Node("H");

        nodeA.addDestination(nodeB, 12);
        nodeA.addDestination(nodeC, 17);
        nodeA.addDestination(nodeD, 20);

        nodeB.addDestination(nodeC, 21);
        nodeB.addDestination(nodeH, 19);

        nodeC.addDestination(nodeD, 4);
        nodeC.addDestination(nodeG, 6);
        nodeC.addDestination(nodeE, 88);

        nodeD.addDestination(nodeF, 15);
        nodeD.addDestination(nodeG, 13);

        nodeG.addDestination(nodeF, 44);
        nodeG.addDestination(nodeE, 37);

        nodeF.addDestination(nodeE, 30);

        nodeH.addDestination(nodeE, 19);

        Graph graph = new Graph();

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);
        graph.addNode(nodeG);
        graph.addNode(nodeH);

        calculateShortestPathFromSource(graph, nodeB);
    }
}
