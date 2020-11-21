/*
* Main testing class for BST
* @author: USFCACS 245
*/
public class BSTtest
{
    public static void main(String[] args)
    {
        //TODO CHANGE CLASS AS NEEDED TO TEST CODE
        BST<String> tree = new BST<String>();

        int L = Integer.parseInt(args[0]);
        int R = Integer.parseInt(args[1]);
        for(int i=2; i < args.length; i++)
        {
            tree.insert(args[i]);

        }

        tree.print();
        tree.delete(args[3]);
        System.out.println(tree.find(args[4]));
        tree.print();
        
        System.out.println(tree.rangeSum(L, R));
    }
}
