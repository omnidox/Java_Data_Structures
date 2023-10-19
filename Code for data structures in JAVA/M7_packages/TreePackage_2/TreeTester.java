package TreePackage_2;

//Rafael Hidalgo

import java.util.Iterator;

public class TreeTester {

	public static void main(String[] args) {
	
		InOrderTester();
		
		PreOrderTester();
		
		PostOrderTester();
		
		LevelOrderTester();

	}
	
	private static void LevelOrderTester() {
		// Represent each leaf as a one-node tree
				BinaryTreeInterface<String> dTree = new BinaryTree<>();

				dTree.setTree("D");

				BinaryTreeInterface<String> eTree = new BinaryTree<>();

				eTree.setTree("E");

				BinaryTreeInterface<String> gTree = new BinaryTree<>();

				gTree.setTree("G");

				BinaryTreeInterface<String> emptyTree = new BinaryTree<>();

				// Form larger subtrees
				
				
				BinaryTreeInterface<String> fTree = new BinaryTree<>();

				fTree.setTree("F", emptyTree, gTree); // Subtree rooted at E

				BinaryTreeInterface<String> bTree = new BinaryTree<>();

				bTree.setTree("B", dTree, eTree); // Subtree rooted at B

				BinaryTreeInterface<String> cTree = new BinaryTree<>();

				cTree.setTree("C", fTree, emptyTree); // Subtree rooted at C

				BinaryTreeInterface<String> aTree = new BinaryTree<>();

				aTree.setTree("A", bTree, cTree); // Desired tree rooted at A

				// Display root, height, number of nodes
				System.out.println("Root of tree contains " + aTree.getRootData());
				System.out.println("Height of tree is " + aTree.getHeight());
				System.out.println("Tree has " + aTree.getNumberOfNodes() + " nodes");

				// Display nodes in Levelorder
				System.out.println("A Levelorder traversal visits nodes in this order:");
				Iterator<String> order = aTree.getLevelOrderIterator();
				while (order.hasNext())
					System.out.print(order.next() + " ");
				System.out.println();
				System.out.println();
		
	}

	private static void PostOrderTester() {
		// Represent each leaf as a one-node tree
		BinaryTreeInterface<String> dTree = new BinaryTree<>();

		dTree.setTree("D");

		BinaryTreeInterface<String> eTree = new BinaryTree<>();

		eTree.setTree("E");

		BinaryTreeInterface<String> gTree = new BinaryTree<>();

		gTree.setTree("G");

		BinaryTreeInterface<String> emptyTree = new BinaryTree<>();

		// Form larger subtrees
		
		
		BinaryTreeInterface<String> fTree = new BinaryTree<>();

		fTree.setTree("F", emptyTree, gTree); // Subtree rooted at E

		BinaryTreeInterface<String> bTree = new BinaryTree<>();

		bTree.setTree("B", dTree, eTree); // Subtree rooted at B

		BinaryTreeInterface<String> cTree = new BinaryTree<>();

		cTree.setTree("C", fTree, emptyTree); // Subtree rooted at C

		BinaryTreeInterface<String> aTree = new BinaryTree<>();

		aTree.setTree("A", bTree, cTree); // Desired tree rooted at A

		// Display root, height, number of nodes
		System.out.println("Root of tree contains " + aTree.getRootData());
		System.out.println("Height of tree is " + aTree.getHeight());
		System.out.println("Tree has " + aTree.getNumberOfNodes() + " nodes");

		// Display nodes in Postorder
		System.out.println("A Postorder traversal visits nodes in this order:");
		Iterator<String> order = aTree.getPostorderIterator();
		while (order.hasNext())
			System.out.print(order.next() + " ");
		System.out.println();
		System.out.println();
		
	}

	private static void PreOrderTester() {
		// Represent each leaf as a one-node tree
				BinaryTreeInterface<String> dTree = new BinaryTree<>();

				dTree.setTree("D");

				BinaryTreeInterface<String> eTree = new BinaryTree<>();

				eTree.setTree("E");

				BinaryTreeInterface<String> gTree = new BinaryTree<>();

				gTree.setTree("G");

				BinaryTreeInterface<String> emptyTree = new BinaryTree<>();

				// Form larger subtrees
				
				
				BinaryTreeInterface<String> fTree = new BinaryTree<>();

				fTree.setTree("F", emptyTree, gTree); // Subtree rooted at E

				BinaryTreeInterface<String> bTree = new BinaryTree<>();

				bTree.setTree("B", dTree, eTree); // Subtree rooted at B

				BinaryTreeInterface<String> cTree = new BinaryTree<>();

				cTree.setTree("C", fTree, emptyTree); // Subtree rooted at C

				BinaryTreeInterface<String> aTree = new BinaryTree<>();

				aTree.setTree("A", bTree, cTree); // Desired tree rooted at A

				// Display root, height, number of nodes
				System.out.println("Root of tree contains " + aTree.getRootData());
				System.out.println("Height of tree is " + aTree.getHeight());
				System.out.println("Tree has " + aTree.getNumberOfNodes() + " nodes");

				// Display nodes in Preorder
				System.out.println("A preorder traversal visits nodes in this order:");
				Iterator<String> order = aTree.getPreorderIterator();
				while (order.hasNext())
					System.out.print(order.next() + " ");
				System.out.println();
				System.out.println();
		
	}

	private static void InOrderTester() {
		
		// Represent each leaf as a one-node tree
		BinaryTreeInterface<String> dTree = new BinaryTree<>();

		dTree.setTree("D");

		BinaryTreeInterface<String> eTree = new BinaryTree<>();

		eTree.setTree("E");

		BinaryTreeInterface<String> gTree = new BinaryTree<>();

		gTree.setTree("G");

		BinaryTreeInterface<String> emptyTree = new BinaryTree<>();

		// Form larger subtrees
		
		
		BinaryTreeInterface<String> fTree = new BinaryTree<>();

		fTree.setTree("F", emptyTree, gTree); // Subtree rooted at E

		BinaryTreeInterface<String> bTree = new BinaryTree<>();

		bTree.setTree("B", dTree, eTree); // Subtree rooted at B

		BinaryTreeInterface<String> cTree = new BinaryTree<>();

		cTree.setTree("C", fTree, emptyTree); // Subtree rooted at C

		BinaryTreeInterface<String> aTree = new BinaryTree<>();

		aTree.setTree("A", bTree, cTree); // Desired tree rooted at A

		// Display root, height, number of nodes
		System.out.println("Root of tree contains " + aTree.getRootData());
		System.out.println("Height of tree is " + aTree.getHeight());
		System.out.println("Tree has " + aTree.getNumberOfNodes() + " nodes");

		// Display nodes in Inorder
		System.out.println("A Inorder traversal visits nodes in this order:");
		Iterator<String> order = aTree.getInorderIterator();
		while (order.hasNext())
			System.out.print(order.next() + " ");
		System.out.println();
		System.out.println();
		
		
	}
	

}
