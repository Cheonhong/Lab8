/*
* Binary search tree data structure
* @author : 
*/

public class BST <T extends Comparable<T>> // public class BST <T extends Comparable<T>>T data;  // instead of Comparable<T> data
{
    /* 
    * The root of the BST
    */
    Node<T> root;

    /*
    * Node class for a BST
    */
    private class Node<T>
    {
        Comparable<T> data;
        Node<T> left;
        Node<T> right;
        int instance;

        Node(Comparable<T> item)
        {
            data = item;
            instance = 1;
        }
    }

    public BST()
    {
        root = null;
    }

    /*
    * Find function that finds an item in the BST
    * @param item to be found
    * @return boolean if the item was found
    */
    public boolean find(Comparable<T> item)
    {
        return find(item, root);
    }

    /*
    * Function override of the find function
    * @param item to be found
    * @param node the current node you are at
    * @return boolean if the item was found
    */
    private boolean find(Comparable<T> item, Node<T> node)
    {
        //TODO FILL IN FUNCITON
        if(node == null) {
            return false;
        }
        if (item == node.data) {
            return true;
        } else if (item.compareTo((T)node.data) < 0) { 
            return find(item, node.left);
        } else {
            return find(item, node.right);
        }
    }

    /*
    * Insert an item to the tree
    * @param item to insert
    */
    public void insert(Comparable<T> item)
    {
        root = insert(item, root);
    }

    /*
    * Helper function for insert
    * @param item to add
    * @param node you are at
    * @return node you traverse to
    */
    private Node<T> insert(Comparable<T> item, Node<T> node)
    {
        //TODO FILL IN FUNCITON
        if (node == null) {
            return new Node(item);
        }
        if (item.compareTo((T)node.data) < 0) 
            node.left = insert(item, node.left);
        else
            node.right = insert(item, node.right);
        return node;
    }

    /*
    * Function for deletion of a node
    * @param item to delete
    */
    public void delete(Comparable<T> item)
    {
        root = delete(item, root);
    }

    /*
    * Helper function for deletion of a node
    * @param item to delete
    * @param node you are at
    * @return node you traverse to
    */
    private Node<T> delete(Comparable<T> item, Node<T> node)
    {
        //TODO FILL IN FUNCITON
       if (node == null) {
        return null;
       }
       if(node.data.compareTo((T)item) < 0) {
            node.right = delete(item, node.right);
            return node;
       } else if (node.data.compareTo((T)item) > 0) {
            node.left = delete(item, node.left);
            return node;
       }else {
            if(node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                if(node.right.left == null) {
                    node.data = node.right.data;
                    node.right = node.right.right;
                } else {
                    node.data = removeSmallest(node.right);
                }
                return node;
            }
        }
    }

    Comparable<T> removeSmallest(Node<T> node) {
        if (node.left.left == null) {
            Comparable<T> smallest = node.left.data;
            node.left = node.left.right;
            return smallest;
        } else {
            return removeSmallest(node.left);
        }
    }

    /*
    * Function to find the range sum of the binary tree
    * @param L the left bound
    * @param R the right bound
    * @return The sum of the range in the binary tree
    */
    public int rangeSum(int L, int R)
    {
        //TODO FILL IN FUNCITON
        return rangeSum(root, L, R, 0);
    }
    private int rangeSum(Node<T> root, int L, int R, int sum) {
        Comparable<T> x = root.data;
        int head = Integer.parseInt((String)x);

        if(root.data == null) {
            return sum;
        } else {
            if(root.left != null)
                sum += rangeSum(root.left, L, R, sum);
            if(root.right != null)
                sum += rangeSum(root.right, L, R, sum);
            if(head >= L && head <= R) {
                    sum += head;
            }
            return sum;
        }
    }

    /*
    * Function to print the Binary tree
    */
    public void print()
    {
        print(root);
        System.out.println();
    }

    /*
    * Helper Function to print the Binary tree
    * @param root the root of the tree
    */
    private void print(Node<T> root)
    {
        //TODO FILL IN FUNCITON
        if(root.data == null) {
            return;
        } else {
            if(root.left != null)
                print(root.left);
            if(root.right != null)
                print(root.right);

            System.out.print(root.data + " ");
            return;
        }
    }
}