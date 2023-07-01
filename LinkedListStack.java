
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

class LinkedListStack
{
    Node head = null;

    public void push(int val)
    {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }

    public void pop(){
        if (head == null)
        {
            System.out.println("Stack is Empty");
        }
        else{
            System.out.println("Poped Item: " + head.key);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
    }
}