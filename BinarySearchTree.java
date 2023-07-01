
class Node
{
    int key;
    Node left;
    Node right;
    Node(int val)
    {
        key = val;
        left = null;
        right = null;
    }
}

class BinarySearchTree
{
    Node root;

    public Node makeHeightBalanceTree(int nums[], int l, int r)
    {
        if (l > r){
            return null;
        }

        int mid = (l + r)/2;
        System.out.println("Mid point" + mid);
        Node node = new Node(nums[mid]);
        node.left = makeHeightBalanceTree(nums,l, mid - 1);
        node.right = makeHeightBalanceTree(nums, mid + 1, r);
        return node;
    }

    public Node insert(Node root, int val)
    {
        if (root == null)
        {
            return new Node(val);
        }
        else if (root.key > val)
        {
            root.left = insert(root.left, val);
        }
        else if (root.key < val)
        {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public void inorder(Node root)
    {
        if (root == null)
        {
            return;
        }
        inorder(root.left);
        System.out.println(root.key + " ");
        inorder(root.right);
    }

    public boolean search(Node root, int key)
    {
        if (root == null)
        {
            return false;
        }
        if (root.key == key)
        {
            return true;
        }
        if (root.key > key)
        {
            return search(root.left, key);
        }
        else
        {
            return search(root.right, key);
        }
    }

    public Node removeNode(Node root, int key)
    {
        if (root == null)
        {
            return null;
        }
        else if (root.key > key)
        {
            root.left = removeNode(root.left, key);
        }
        else if (root.key < key)
        {
            root.right = removeNode(root.right, key);
        }
        else
        {
            if (root.right == null && root.left == null)
            {
                return null;
            }
            else if (root.left == null)
            {
                return root.right;
            }
            else if (root.right == null)
            {
                return root.left;
            }
            else
            {
                int rightMin = getRightMin(root.right);
                root.key = rightMin;
                root.right = removeNode(root.right, rightMin);
            }
        }
        return root;
    }

    public int getRightMin(Node root)
    {
        Node temp = root;
        while(temp.left != null){
            temp = temp.left;
        }
        return temp.key;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        // System.out.println("Inserting + 100");
        // bst.root = bst.insert(bst.root, 100);
        // System.out.println("Inserting + 50");
        // bst.root = bst.insert(bst.root, 50);
        // System.out.println("Inserting + 150");
        // bst.root = bst.insert(bst.root, 150);
        // System.out.println("Inserting + 125");
        // bst.root = bst.insert(bst.root, 125);
        
        // System.out.println("Inorder Traversal");
        // bst.inorder(bst.root);

        // boolean isFound = bst.search(bst.root, 10);
        // System.out.println(isFound);

        // bst.removeNode(bst.root, 125);
        // bst.inorder(bst.root);

        int[] n={-10,-3,0,5,9};   
        bst.root = bst.makeHeightBalanceTree(n, 0, 4);
        bst.inorder(bst.root);

    }
}

