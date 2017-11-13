/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic_data_structures;

/**
 *
 * @author AnhTu
 * 
 * This code has been contributed by Mayank Jaiswal
 */

/*

a) Left Left Case: if (balance(z) > 1 && key < z.left.data)  //với key là thằng vừa đc insert = T1 hoặc T2

T1, T2, T3 and T4 are subtrees.
         z                                      y 
        / \                                   /   \
       y   T4      Right Rotate (z)          x      z
      / \          - - - - - - - - ->      /  \    /  \ 
     x   T3                               T1  T2  T3  T4
    / \
  T1   T2
b) Left Right Case: if (balance(z) > 1 && key > z.left.data)  //với key là thằng vừa đc insert = T2 hoặc T3

     z                               z                           x
    / \                            /   \                        /  \ 
   y   T4  Left Rotate (y)        x    T4  Right Rotate(z)    y      z
  / \      - - - - - - - - ->    /  \      - - - - - - - ->  / \    / \
T1   x                          y    T3                    T1  T2 T3  T4
    / \                        / \
  T2   T3                    T1   T2
c) Right Right Case: if (balance(z) < -1 && key > z.left.data)  //với key là thằng vừa đc insert = T3 hoặc T4

  z                                y
 /  \                            /   \ 
T1   y     Left Rotate(z)       z      x
    /  \   - - - - - - - ->    / \    / \
   T2   x                     T1  T2 T3  T4
       / \
     T3  T4
d) Right Left Case; if (balance(z) < -1 && key < z.left.data)  //với key là thằng vừa đc insert = T2 hoặc T3

   z                            z                            x
  / \                          / \                          /  \ 
T1   y   Right Rotate (y)    T1   x      Left Rotate(z)   z      y
    / \  - - - - - - - - ->     /  \   - - - - - - - ->  / \    / \
   x   T4                      T2   y                  T1  T2  T3  T4
  / \                              /  \
T2   T3                           T3   T4

*/

//Tóm lại: cách quay left-left hoặc right-right:
//    T1, T2 and T3 are subtrees of the tree rooted with y (on left side)
//    or x (on right side)
//                    y                               x
//                   / \     Right Rotation          /  \
//                  x   T3   – – – – – – – >        T1   y
//                 / \       < - - - - - - -            / \
//                T1  T2     Left Rotation            T2  T3
//    Keys in both of the above trees follow the following order
//          keys(T1) < key(x) < keys(T2) < key(y) < keys(T3)

public class AVLTree {
    Node root;

    // A utility function to get height of the tree
    public int getHeight(Node N) {
        if (N == null)
            return 0;
        return N.height;
    }

    // A utility function to get maximum of two integers
    public int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public Node rightRotate(Node z) {
        /*
                T1, T2, T3 and T4 are subtrees.
                 z                                      y 
                / \                                   /   \
               y   T4      Right Rotate (z)          x      z
              / \          - - - - - - - - ->      /  \    /  \ 
             x   T3        return y               T1  T2  T3  T4
            / \
          T1   T2
        */
        
        Node y = z.left;
        z.left = y.right;   //=T3
        y.right = z;

        //update height: note that x's height is not changed
        //CHÚ Ý PHẢI UPDATE CHIỀU CAO CỦA z TRƯỚC, NẾU KO LÀ SAI:
        z.height = max(getHeight(z.left), getHeight(z.right)) + 1;
        y.height = max(getHeight(y.left), getHeight(y.right)) + 1;
        
        return y;   //return new node that replaced z's old position
    }

    public Node leftRotate(Node z) {
        /*
          A                                A
         /                                /
        z                                y
       /  \                            /   \ 
      T1   y     Left Rotate(z)       z      x
          /  \   - - - - - - - ->    / \    / \
         T2   x    return y         T1  T2 T3  T4
             / \
           T3  T4
        */
        
        //trông giống như việc hoán vị z.right và y.left
        Node y = z.right;
        z.right = y.left;   //T2
        y.left = z;   

        //CHÚ Ý PHẢI UPDATE CHIỀU CAO CỦA z TRƯỚC, NẾU KO LÀ SAI:
        z.height = max(getHeight(z.left), getHeight(z.right)) + 1;
        y.height = max(getHeight(y.left), getHeight(y.right)) + 1;
        
        return y;
        
    }
    
    // Get Balance factor of node N
    public int getBalance(Node N) {
        if(N == null) return 0;
        return getHeight(N.left) - getHeight(N.right);
    }

    public Node insert(Node node, int d) {     //chèn d vào vị node, nói cách khác: node là vị trí cần chèn. ban đầu node = root:gốc của cây,
        //sau đó travel xuống. chú ý node đã chỉ rõ vị trí cần chèn là con trái(hoặc con phải) của node's parent
        //chẳng hạn ta sẽ chèn d vào node.left hoặc node.right, hoặc travel xuống nữa thì ta sẽ chèn vào, ví dụ: node.right.left.left,... chú ý vị trí node.right.left.left = null

        Node p1 = new Node(d);
        
        /* 1.  Perform the normal BST insertion */
        if(node == null) return (p1);
        if(d < node.data) node.left = insert(node.left, d);
        else if(d > node.data) node.right = insert(node.right, d);
        
        //sau lệnh trên d đã đc chèn vào vị trí và là 1 lá, bây giờ cần cân = cây:
        
        /* 2. Update height of this ancestor node */
        node.height = max(getHeight(node.left), getHeight(node.right)) + 1;
        
        /* 3. Get the balance factor of this ancestor
              node to check whether this node became
              unbalanced */
        int balance = getBalance(node);
        
        // If this node becomes unbalanced, then there
        // are 4 cases:
        
        //Left Left Case
        if(balance > 1 && d < node.left.data) { //
            return rightRotate(node);
        }
        // Right Right Case
        if(balance < -1 && d > node.right.data) return leftRotate(node);
        // Left Right Case
        if(balance > 1 && d > node.left.data) {
            /*
            chú ý rằng d có thể ở cả vị trí T2, T3
               A                                A                                A
              /                                /                                /
            node                             node                              d
           /    \                            /   \                            /  \ 
          y      T4  Left Rotate (y)        d    T4  Right Rotate(node)     y    node
         / \        - - - - - - - - ->     /  \      - - - - - - - ->      / \    / \
       T1   d                             y    T3                        T1  T2 T3  T4
           / \                           / \
         T2   T3                       T1   T2
            */
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // Right Left Case
        if(balance < -1 && d < node.right.data) {
            /*
            chú ý rằng d có thể ở cả vị trí T2, T3
           node                        node                               d
           / \                          / \                             /  \ 
         T1   y   Right Rotate (y)    T1   d      Left Rotate(node)   node    y
             / \  - - - - - - - - ->     /  \   - - - - - - - ->      / \    / \
            d   T4                      T2   y                      T1  T2  T3  T4
           / \                              /  \
         T2   T3                           T3   T4

            */
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        /* return the (unchanged) node pointer */
        return node;
    }
    
    public Node minValueNode(Node node) {
        Node p1= node, parent=node;
        while(p1.left!=null) {
            parent = p1;
            p1=p1.left;
        }
        if(parent == p1) {  //nếu như p1 ko có con trái
            return p1;
        } else {
            parent.left = p1.right;
            p1.right=null;
            return p1;
        }
    }
    
    public Node minValueNode2(Node node) {
        Node p1= node;
        while(p1.left!=null) {
            p1=p1.left;
        }
        return p1;
    }
    
    public Node delete(Node node, int d) {
        // STEP 1: PERFORM STANDARD BST DELETE
        if(node == null) return node;
        if(d < node.data) node.left = delete(node.left, d);
        if(d > node.data) node.right = delete(node.right, d);
        else {  //d = node.data, => node is the one to be deleted
            //xóa như bài binary search tree. cách làm giống hệt, nhưng code hơi khác ở chỗ node cần xóa có 2 con, vì dùng đệ quy để xóa thằng successor, với successor là con trái nhỏ nhất của node cần xóa
            // node with only one child or no child:
            if((node.left == null) || (node.right == null)) {
                Node temp=null;
                if(node.left==null) temp=node.right;
                else temp=node.left;
                
                if(temp==null) {    //no child
                    temp=node;  //sao phai can lenh nay?
                    node=null;
                } else {  //one child
                    node=temp;
                }
            } else {    //two children
//                Node temp = minValueNode(node.right);   //get successor:
//                node.data = temp.data;  // Copy the inorder successor's data to this node
//                node.right = delete(node.right, temp.data); // Delete the inorder successor
                Node successor = minValueNode(node.right);
                if(node.right.left == null) {
                    //node = successor;: làm như vậy là sai!
                    node.data = successor.data;
                    node.right = successor.right;
                } //thay thằng p bằng thằng con phải của nó
                else node.data = successor.data;
//              
            }
        }
        if (node == null) {
            return node; // If the tree had only one node after deleting then return
        }            //else: we have to balance it:

        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
        node.height = max(getHeight(node.left), getHeight(node.right)) + 1;

        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
        //  this node became unbalanced)
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there are 4 cases
        //Left Left Case
        if (balance > 1 && getBalance(node.left) >= 0) {
            return rightRotate(node);
        }
        // Right Right Case
        if (balance < -1 && getBalance(node.right) <= 0) {
            return leftRotate(node);
        }
        // Left Right Case
        if (balance > 1 && getBalance(node.left) < 0) {
            /*
            chú ý rằng d có thể ở cả vị trí T2, T3
               A                                A                                A
              /                                /                                /
            node                             node                              d
           /    \                            /   \                            /  \ 
          y      T4  Left Rotate (y)        d    T4  Right Rotate(node)     y    node
         / \        - - - - - - - - ->     /  \      - - - - - - - ->      / \    / \
       T1   d                             y    T3                        T1  T2 T3  T4
           / \                           / \
         T2   T3                       T1   T2
             */
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // Right Left Case
        if (balance < -1 && getBalance(node.right) > 0) {
            /*
            chú ý rằng d có thể ở cả vị trí T2, T3
           node                        node                               d
           / \                          / \                             /  \ 
         T1   y   Right Rotate (y)    T1   d      Left Rotate(node)   node    y
             / \  - - - - - - - - ->     /  \   - - - - - - - ->      / \    / \
            d   T4                      T2   y                      T1  T2  T3  T4
           / \                              /  \
         T2   T3                           T3   T4

             */
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        
        //CHÚ Ý: LÀM NHƯ SAU GIỐNG VỚI BÀI BST LÀ SAI:
        //ĐƠN GIẢN VÌ TA VẪN CHƯA UPDATE height CỦA CON TRÁI VÀ PHẢI NÊN NẾU DÙNG LỆNH d < node.left.data THÌ SAI KQ
//        if (balance > 1 && d < node.left.data) {
//            return rightRotate(node);
//        }
//        // Right Right Case
//        if (balance < -1 && d > node.right.data) {
//            return leftRotate(node);
//        }
//        // Left Right Case
//        if (balance > 1 && d > node.left.data) {
//            node.left = leftRotate(node.left);
//            return rightRotate(node);
//        }
//        // Right Left Case
//        if (balance < -1 && d < node.right.data) {
//            node.right = rightRotate(node.right);
//            return leftRotate(node);
//        }
//        
        /* return the (unchanged) node pointer */
        return node;
           
    }

    Node deleteNode(Node root, int key) {
        // STEP 1: PERFORM STANDARD BST DELETE
        if (root == null)
            return root;
 
        // If the key to be deleted is smaller than
        // the root's key, then it lies in left subtree
        if (key < root.data)
            root.left = deleteNode(root.left, key);
 
        // If the key to be deleted is greater than the
        // root's key, then it lies in right subtree
        else if (key > root.data)
            root.right = deleteNode(root.right, key);
 
        // if key is same as root's key, then this is the node
        // to be deleted
        else
        {
            // node with only one child or no child
            if ((root.left == null) || (root.right == null))
            {
                Node temp = null;
                if (temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;
 
                // No child case
                if (temp == null)
                {
                    temp = root;
                    root = null;
                }
                else   // One child case
                    root = temp; // Copy the contents of
                                 // the non-empty child
            }
            else
            {
 
                // node with two children: Get the inorder
                // successor (smallest in the right subtree)
                Node temp = minValueNode2(root.right);
 
                // Copy the inorder successor's data to this node
                root.data = temp.data;
 
                // Delete the inorder successor
                root.right = deleteNode(root.right, temp.data);
            }
        }
 
        // If the tree had only one node then return
        if (root == null)
            return root;
 
        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
        root.height = max(getHeight(root.left), getHeight(root.right)) + 1;
 
        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
        //  this node became unbalanced)
        int balance = getBalance(root);
 
        // If this node becomes unbalanced, then there are 4 cases
        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);
 
        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0)
        {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
 
        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);
 
        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0)
        {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
 
        return root;
    }
    
    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    
    public void inOrder(Node node) {
        if(node != null) {
            inOrder(node.left);
            System.out.print(node.data+" ");
            inOrder(node.right);
        }
    }
    
    
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        /* Constructing tree given in the above figure */
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);

        /* The constructed AVL Tree would be
             30
            /  \
          20   40
         /  \     \
        10  25    50
        */
        System.out.println("\nTree1:\nPreorder traversal" + " of constructed tree is : ");
        tree.preOrder(tree.root);
        System.out.println("\nInOrder traversal" + " of constructed tree is : ");
        tree.inOrder(tree.root);
        
        
        AVLTree tree2 = new AVLTree();
        tree2.root = tree2.insert(tree2.root, 10);
        tree2.root = tree2.insert(tree2.root, 5);
        tree2.root = tree2.insert(tree2.root, 13);
        tree2.root = tree2.insert(tree2.root, 4);
        tree2.root = tree2.insert(tree2.root, 7);
        tree2.root = tree2.insert(tree2.root, 17);
        tree2.root = tree2.insert(tree2.root, 6);
        tree2.root = tree2.insert(tree2.root, 8);
        tree2.root = tree2.insert(tree2.root, 9);
        System.out.println("\n\nTree2:\nPreorder traversal" + " of constructed tree is : ");
        tree2.preOrder(tree2.root);
        System.out.println("\nInOrder traversal" + " of constructed tree is : ");
        tree2.inOrder(tree2.root);
        tree2.root = tree2.delete(tree2.root, 7);
        System.out.println("\nPreorder traversal after delete(7)" + " of constructed tree is : ");
        tree2.preOrder(tree2.root);
        
        AVLTree tree3 = new AVLTree();
        tree3.root = tree3.insert(tree3.root, 9);
        tree3.root = tree3.insert(tree3.root, 5);
        tree3.root = tree3.insert(tree3.root, 10);
        tree3.root = tree3.insert(tree3.root, 0);
        tree3.root = tree3.insert(tree3.root, 6);
        tree3.root = tree3.insert(tree3.root, 11);
        tree3.root = tree3.insert(tree3.root, -1);
        tree3.root = tree3.insert(tree3.root, 1);
        tree3.root = tree3.insert(tree3.root, 2);
 
        System.out.println("\n\nTree3:\nPreorder traversal of constructed tree is : ");
        tree3.preOrder(tree3.root);
 
        tree3.root = tree3.delete(tree3.root, 10);
 
        System.out.println("\nPreorder traversal of constructed tree after delete(10) is : ");
        tree3.preOrder(tree3.root);
    }
}


class Node {
    int data, height;
    Node left, right;

    Node(int d) {
        data = d;
        height = 1;
    }
}

//    kết quả chạy:

//    Tree1:
//    Preorder traversal of constructed tree is : 
//    30 20 10 25 40 50 
//    InOrder traversal of constructed tree is : 
//    10 20 25 30 40 50 
//
//    Tree2:
//    Preorder traversal of constructed tree is : 
//    10 7 5 4 6 8 9 13 17 
//    InOrder traversal of constructed tree is : 
//    4 5 6 7 8 9 10 13 17 
//    Preorder traversal after delete(7) of constructed tree is : 
//    10 8 5 4 6 9 13 17 
//
//    Tree3:
//             9
//           /  \
//          1    10
//        /  \     \
//       0    5     11
//      /    /  \
//     -1   2    6
//    Preorder traversal of constructed tree is : 
//    9 1 0 -1 5 2 6 10 11 
//    Preorder traversal of constructed tree after delete(10) is : 
//    1 0 -1 9 5 2 6 11