class Node
{
    int key;
    Node next;
    Node(int val)
    {
        key = val;
        next = null;
    }
}

class AdjacencyList{
    static final int numberOfNodes = 5;
    Node adjList[] = new Node[numberOfNodes];

    /**
     * @param source
     * @param destination
     */
    public void adEdgeV2(int source, int destination)
    {
        Node destNode = new Node(destination);
        if (adjList[source] == null){
            adjList[source] = destNode;
        }
        else{
            Node lastNode = adjList[source];
            while(lastNode.next != null){
                lastNode = lastNode.next;
            }
            lastNode.next = destNode;
        }
    }

    public void adEdgeV2V2(int source, int destination)
    {
        Node destNode = new Node(destination);
        destNode.next = adjList[source];
        adjList[source] = destNode;
    }

    public void printAdjacencyList()
    {
        int i;
        for (i = 0; i< adjList.length ; i++) {
            Node firsNode = adjList[i];
            String adjacencyString = new String();
            adjacencyString = i + "->";
            while (firsNode != null){
                adjacencyString = adjacencyString +  firsNode.key + "->";
                firsNode = firsNode.next;
            }
            System.out.println(adjacencyString);
        }
    }

    public static void main(String[] args) {
        AdjacencyList adjacencyList = new AdjacencyList();
        adjacencyList.adEdgeV2(0, 1);
        adjacencyList.adEdgeV2(0, 2);
        adjacencyList.adEdgeV2(0, 3);
        adjacencyList.adEdgeV2(1, 4);
        adjacencyList.adEdgeV2(2, 3);
        adjacencyList.adEdgeV2(2, 1);
        adjacencyList.adEdgeV2(3, 4);

        adjacencyList.printAdjacencyList();
    }
}