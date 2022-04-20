import java.util.*;
import java.io.*;
import java.lang.Math;

class TreeNode {
		public int val,height=1;
		public TreeNode left, right;
		TreeNode(int val){
			this.val=val;
			height=1;
		}
}

class AVLTree {
	public TreeNode treeRoot;
	int height(TreeNode node){
		if(node==null)
			return 0;
		return node.height;
	}
	
	int findBalance(TreeNode node){
		if(node==null)
			return 0;
		return height(node.left) - height(node.right);
	}
	
	TreeNode rightRotate(TreeNode root) {
		TreeNode x = root.left;
		TreeNode T1 = x.right;
		
		//rotation
		x.right = root;
		root.left = T1;
		
		//update height
		x.height = 1+Math.max(height(x.left), height(x.right));
		root.height = 1+ Math.max(height(root.left), height(root.right));
		
		return x;
	}
	
	TreeNode leftRotate(TreeNode root) {
		TreeNode x = root.right;
		TreeNode T1 = x.left;
		
		//rotation
		x.left = root;
		root.right = T1;
		
		//update height
		x.height = 1+Math.max(height(x.left), height(x.right));
		root.height = 1+ Math.max(height(root.left), height(root.right));
		
		return x;
	}
	
	public TreeNode insert(TreeNode root, int key){
		if(root == null)
			return new TreeNode(key);
		else if(root.val>key) {
			root.left = insert(root.left, key);
		} else if(root.val<key) {
			root.right = insert(root.right, key);
		} else {
			 return root;
		}
		
		root.height = 1+Math.max(height(root.left), height(root.right));
		
		int balance = findBalance(root);
		
		if(balance > 1 && key < root.left.val) {
			root = rightRotate(root);
		}
		
		if(balance < -1 && key > root.right.val) {
			root = leftRotate(root);
		}
		
		if(balance > 1 && key > root.left.val) {
			root.left = leftRotate(root.left);
			root = rightRotate(root);
		}
		
		if(balance < -1 && key < root.right.val) {
			root.right = rightRotate(root.right);
			root = leftRotate(root);
		}
		
		return root;
	}
	
	
	void preOrder(TreeNode root) {
		if(root == null)
			return;
		System.out.println(root.val);
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public static void main(String args[]) {
		AVLTree avlTree=new AVLTree();
		avlTree.treeRoot = avlTree.insert(avlTree.treeRoot,10);	
		//System.out.println(avlTree.treeRoot.val);
		avlTree.treeRoot = avlTree.insert(avlTree.treeRoot,20);
		avlTree.treeRoot = avlTree.insert(avlTree.treeRoot,30);
		avlTree.treeRoot =avlTree.insert(avlTree.treeRoot,40);	
		avlTree.treeRoot =avlTree.insert(avlTree.treeRoot,50);	
		avlTree.treeRoot =avlTree.insert(avlTree.treeRoot,25);	
		avlTree.preOrder(avlTree.treeRoot);
	
	}

}