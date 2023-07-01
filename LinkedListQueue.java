
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

class LinkedListQueue{
    Node front, rear = null;

    public void enqueue(int val){
        Node newNode = new Node(val);
        if (front == null && rear == null){
            front = newNode;
            rear = newNode;
        }
        else{
            rear.next = newNode;
            rear = newNode;
        }
            
    }

    public void dequeue(){
        if (front == null){
            System.out.println("Queue is Empty");
        }
        else{
            System.out.println(front.key);
            front = front.next;

            if (front == null){
                rear = null;
            }
        }
    }

    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();
        queue.enqueue(30);
        queue.enqueue(10);
        queue.enqueue(15);
        queue.enqueue(26);
        queue.enqueue(24);

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
    }
}