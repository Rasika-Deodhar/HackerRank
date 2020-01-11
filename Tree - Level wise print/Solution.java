import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

	/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static void levelOrder(Node root) {
      
      Queue<Node> queue = new LinkedList<>();
      Node n = root;

      if(n==null){
          return;
      }
        queue.add(n);
      do{            
          n = queue.remove();

          if(n!=null){
              System.out.print( n.data + " ");
          }
          else{
              break;
          }

          //enqueue children of dequed node
            if(n.left!=null){queue.add(n.left);}
            if(n.right!=null){queue.add(n.right);}

      } while(!queue.isEmpty());
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }	
}