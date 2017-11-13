/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic_data_structures;


/**
 *
 * @author AnhTu
 */
//vẫn quy ước ký hiệu: p = root = current node (if has the statement: p=p.next), p1 = new Node
    
//    Operations:
//    Insert(int n) : Add a node the tree with value n. Its O(lgn)
//    Find(int n) : Find a node the tree with value n. Its O(lgn)
//    Delete (int n) : Delete a node the tree with value n. Its O(lgn)
//    Display(): Prints the entire tree in increas­ing order. O(n).


//    Find(int n):
//    Its very simple operation to perform.
//    start from the root and compare root.data with n
//    if root.data is greater than n that means we need to go to the left of the root.
//    if root.data is smaller than n that means we need to go to the right of the root.
//    if any point of time root.data is equal to the n then we have found the node, return true.
//    if we reach to the leaves (end of the tree) return false, we didn’t find the element
//
//    Insert(int n):
//    Very much similar to find() operation.
//    To insert a node our first task is to find the place to insert the node.
//    Take current = root .
//    start from the current and compare root.data with n
//    if current.data is greater than n that means we need to go to the left of the root.
//    if current.data is smaller than n that means we need to go to the right of the root.
//    if any point of time cur­rent is null that means we have reached to the leaf node, insert your node here with the help of parent node. 

//    for more details: visit at http://algorithms.tutorialhorizon.com/binary-search-tree-complete-implementation/

public class BinarySearchTree {
    Node root;
    
    Node prev = null;  //node này dùng cho hàm isBST_method2(); // To keep tract of previous node in Inorder Traversal
    public BinarySearchTree() {
        this.root = null;
    }
    
    public boolean find_recursion(Node root, int d) {  //using recursion
        if(root == null) return false;
        
        if(root.data == d) return true;
        if(root.data < d) return find_recursion(root.right, d);
        if(root.data > d) return find_recursion(root.left, d);
        
        return false;
    }
    
    public boolean find(int d) {
        Node p = root;
        while(p!=null) {
            if(p.data == d) return true;
            else if(p.data < d) p = p.right;
            else if(p.data > d) p = p.left;
        }
        return false;  //nếu ko tìm đc phần tử nào = d thì return false
    }
    
    public void insert(int d) {
        Node p1 = new Node(d);
        if(root == null) root = p1;
        else {
            Node p = root;
            Node parent = null;
            
            while(p!=null) {
                if(p.data == d) {
                    System.out.println(d+" already exist in tree, so can't insert this one!");
                    return;
                }
                else if(p.data < d) {
                    parent = p;
                    p = p.right;
                }
                else if(p.data > d) {
                    parent = p;
                    p = p.left;
                }
            }
            //sau vòng while ở trên, ta đã tìm đc vị trí là con của con trỏ parent để chèn thêm node p1: chú ý rằng parent chắc chắn là nút lá (parent là lá), và vị trí cần chèn là con của parent, nghĩa là chèn ở parent.left hoặc parent.right
            if(parent.data < d) parent.right = p1;
            else if(parent.data > d) parent.left = p1;
        }
    }
    
    public void insert_betterWay(int id) {  //cải tiến hơn so với hàm insert(int id) ở trên
        Node p1 = new Node(id);
        if (root == null) {
            root = p1;
            return;
        }
        Node current = root;
        Node parent = null;
        while (true) {
            parent = current;
            if (id < current.data) {
                current = current.left;
                if (current == null) {
                    parent.left = p1;
                    return;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parent.right = p1;
                    return;
                }
            }
        }
    }
    
    public Node minValueNode(Node node) {   //giả sử tìm minValueNode(18) trong hình vẽ
        Node p1= node, parent=node;
        while(p1.left!=null) {
            parent = p1;
            p1=p1.left;
        }
        if(parent == p1) {  //nếu như node ko có con trái
            return p1;
        } else {
            parent.left = p1.right;
            p1.right=null;
            return p1;
        }
    }
    
    public void delete(int d) {
        //firstly, we need to find the node we wanna delete:
        Node p = root;
        Node parent = root;
        
        while(p.data != d) {
            if(p.data < d) {
                parent = p;
                p = p.right;
            }
            else if(p.data > d) {
                parent = p;
                p = p.left;
            }
            if(p == null) {
                System.out.println("Can't found this node, can't delete anything!");
                return;
            }
        }
        
        //bây giờ p.data == d && p!=null, p chính là node mà ta cần xóa
        
        //case 1: p has no chird
        if(p.left == null && p.right == null) {
            if(p == root) {
                p = null;
                return;
            }
            parent.left = null;
            parent.right = null;
        }
        
        //case 2: p has 1 child:
        else if(p.left != null && p.right == null) {  //nếu p có con trái
            if(p == root) {
                root = p.left;  //xóa root đó đi là đc (thay root mới = con trái)
                return;
            }
            
            if(parent.left == p) {  //p is parent's leftChild
                parent.left = p.left;
            } else {    //if(parent.right == p)
                parent.right = p.left;
            }
        } else if(p.left == null && p.right != null) {   //nếu p có con phải
            if(p == root) {  //xóa root đó đi là đc (thay root mới = con phải)
                root = p.right;
                return;
            }
            if(parent.left == p) {  //p is parent's leftChild
                parent.left = p.right;
            } else {    //if(parent.right == p)
                parent.right = p.right;
            }
        }
        
        //case 3: p has 2 children:
        else { //p.left!=null && p.right!=null: xem hình vẽ để dễ hiểu hơn
            Node successor = minValueNode(p.right);
            if(p.right.left == null) { //p.right ko có con trái: thay thằng p bằng thằng con phải của nó
                p.data = successor.data;
                p.right = successor.right;
            } 
            else p.data = successor.data;
        }
    }
    
    public int countDepth(Node root) {  //note: tree's depth = tree's height
        if(root == null) return 0;
        int leftDepth = countDepth(root.left);
        int rightDepth = countDepth(root.right);
        return 1+ (leftDepth > rightDepth ? leftDepth : rightDepth);
    }
    
    public boolean isBST() {
//    this solution looks at each node only once. The trick is to write a utility helper function
//    isBSTUtil(struct node* node, int min, int max) that traverses down the tree keeping track of
//    the narrowing min and max allowed values as it goes, looking at each node only once.
//    The initial values for min and max should be INT_MIN and INT_MAX — they narrow from there.
//    Time Complexity: O(n)
//    Auxiliary Space : O(1) if Function Call Stack size is not considered, otherwise O(n)
//    see more: http://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
        return isBST_Utility(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean isBST_Utility(Node root, int min, int max) {   //this method using recursion
        if(root == null) return true;
        if(root.data <= min || root.data >= max) return false;
        return isBST_Utility(root.left, min, root.data) && isBST_Utility(root.right, root.data, max);
    }
    
    public boolean isBST_method2() {
//        Do In-Order Traversal of the given tree and store the result in a temp array.
//        Check if the temp array is sorted in ascending order, if it is, then the tree is BST.
//        Time Complexity: O(n)
        prev = null;
        return isBST_method2(root);
    }
    
    private boolean isBST_method2(Node root) {
        // traverse the tree in inorder fashion and
        // keep a track of previous node
        if(root != null) {
            if(!isBST_method2(root.left)) return false;
            
            if(prev != null && root.data <= prev.data) return false;
            prev = root;
            return isBST_method2(root.right);
        }
        return true;
    }
    
    public int nearestCommonAncestor(int a, int b) {
        QueueList q1 = new QueueList();
        QueueList q2 = new QueueList();
        
        Node p = root;
        
        //find node that has data = a:
        while(p.data != a) {
            if(p.data < a) {
                q1.insert(p.data);
                p = p.right;
            } else if(p.data > a) {
                q1.insert(p.data);
                p=p.left;
            }
        }  //bây giờ q1 chứa tất cả các nút tổ tiên của a
        
        p=root;
        while(p.data != b) {
            if(p.data < b) {
                q2.insert(p.data);
                p = p.right;
            } else if(p.data > b) {
                q2.insert(p.data);
                p=p.left;
            }
        }  //bây giờ q2 chứa tất cả các nút tổ tiên của b
        
        int m = 0,n=0;
        int temp = m;
        while(m==n) {
            temp = m;
            m = q1.get();
            n = q2.get();
        }
        return temp;
    }
    
    public static boolean isEquivalent(Node root1, Node root2) {
        if(root1==null && root2==null) return true;
        if((root1==null && root2!=null) || (root1!=null && root2!=null)) return false;
        return isEquivalent(root1.left, root2.left) && isEquivalent(root1.right, root2.right);
    }
    
    public void printTree(Node root) { //of course, this method print tree in InOrder, because in this order we will have sorted list after print
        if(root == null) return;
        printTree(root.left);
        System.out.print(root.data+" ");
        printTree(root.right);
    }
    
    
    public void printPreOrder(Node node) {
        if(node == null) return;
        System.out.print(node.data+" ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }
    
    public void printPostOrder(Node node) {
        if(node == null) return;
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.data+" ");
    }
    
    public static void main(String[] args) {
        BinarySearchTree b = new BinarySearchTree();
        b.insert(3);
        b.insert(8);
        b.insert(1);
        b.insert(4);
        b.insert(6);
        b.insert(2);
        b.insert(10);
        b.insert(9);
        b.insert(20);
        b.insert(25);
        b.insert(15);
        b.insert(16);
        b.insert(9);
        
        BinarySearchTree b2 = b;
        System.out.println("Original Tree : ");     //1 2 3 4 6 8 9 10 15 16 20 25 
        b.printTree(b.root);
        System.out.println("\nIs this tree is a Binary search tree: "+b.isBST());
        System.out.println("\nIs this tree is a Binary search tree: "+b.isBST_method2());
        System.out.println("\nTree's depthh = "+b.countDepth(b.root));
        System.out.println("\nTổ tiên gần nhất của 6 và 16 là: "+b.nearestCommonAncestor(6, 16));
        System.out.println("\nTổ tiên gần nhất của 9 và 16 là: "+b.nearestCommonAncestor(9, 16));
        System.out.println("\nTổ tiên gần nhất của 2 và 25 là: "+b.nearestCommonAncestor(2, 25));
        
        System.out.println("");
        System.out.println("Check whether Node with value 4 exists : " + b.find(4));
        System.out.println("Check whether Node with value 8 exists, using recurison : " + b.find_recursion(b.root, 8));
        System.out.println("Check whether Node with value 7 exists, using recurison : " + b.find_recursion(b.root, 7));
        
        //System.out.println("Delete Node with no children (2) : " + b.delete(2));		
        b.printTree(b.root);
        b.delete(1);
        System.out.println("\n Delete Node with one child (1) : ");
        b.printTree(b.root);
        b.delete(10);
        System.out.println("\n Delete Node with Two children (10) : ");	
        b.printTree(b.root);
        
        System.out.println("\nb2 and b is equivalent? "+BinarySearchTree.isEquivalent(b.root, b2.root));
        
        BinarySearchTree b3 = new BinarySearchTree();
        b3.insert(10);
        b3.insert(20);
        b3.insert(30);
        b3.insert(40);
        b3.insert(50);
        b3.insert(25);
        
        System.out.println("b3 in InOrder: ");
        b3.printTree(b3.root);
        System.out.println("\nb3 inPreOrder: ");
        b3.printPreOrder(b3.root);
        
        BinarySearchTree b4 = new BinarySearchTree();
        b4.insert(10);
        b4.insert(7);
        b4.insert(13);
        b4.insert(5);
        b4.insert(8);
        b4.insert(17);
        b4.insert(4);
        b4.insert(6);
        b4.insert(9);
        
        b4.delete(7);
        System.out.println("\nb4 in InOrder:");
        b4.printTree(b4.root);
        System.out.println("\nb4 in PreOrder:");
        b4.printPreOrder(b4.root);
        
    }

    int getheight(Node root) {
        return countDepth(root);
    }

    
    ///inner class for Tree Node
    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
}
    
    
