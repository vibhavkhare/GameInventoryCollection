//package CSE205;

/**
 * Assignment #: Assignment 11
 * Name: Vibhav Khare
 * StudentID: 1224826473
 * Lecture: 1:30 - 2:45 T/Th
 * Description: For this assignment we use Binary search trees that store Game objects. This program focuses on
 * the creation of a game inventory sorted by BSTs. In the program we have to implement methods that insert, delete
 * and sort the prices of items. There are also other methods in need for implementation to help the program
 * run conveniently. 
 */
public class ZyBoxLiveStore {
	private Node root; // Binary Search Tree root node
// Constructor

	public ZyBoxLiveStore() {
		this.root = null;
	}

	public Node addGameToStore(Node node, Game gameToAdd) {
		//If the binary tree is empty (represented by a null node), create a new node with the gameToAdd object and return it.
		if (node == null) 
		{
			node = new Node(gameToAdd);
			return node;
	    } 
		//If the price of the gameToAdd object is less than the price of the game object in the current node, 
		//add the gameToAdd object to the left subtree by recursively calling the function with the left child of the current node.
		else if (gameToAdd.getPrice() < node.getGame().getPrice()) 
		{
			node.setLeft(addGameToStore(node.getLeft(), gameToAdd));
		} 
		//If the price of the gameToAdd object is greater than the price of the game object in the current node,
		//add the gameToAdd object to the right subtree by recursively calling the function with the right child of the current node.
		else if (gameToAdd.getPrice() > node.getGame().getPrice()) 
		{
			node.setRight(addGameToStore(node.getRight(), gameToAdd));
	    } 
		//If the price of the gameToAdd object is equal to the price of the game object in the current node,
		//print a message indicating that the game is already in store inventory.
		else 
		{
			System.out.println("Game at this price is in store inventory already.\n");
	    }
		//Return the updated node.
		return node;

		//throw new UnsupportedOperationException("addGameToStore(Node, Game) not yet implemented");
	}

// * removeGameFromStore(...) METHOD PROVIDED AS PART OF TEMPLATE
// Removes a game from the BST based on the game's price (the BST key)
	public void listGamesByPrice(Node node) {
		// Check if the current node is not null
		if (node != null) 
		{
			//Recursively call the method on the left subtree
			listGamesByPrice(node.getLeft());
			// Print the game information for the current node
			System.out.println(node.getGame().toString());
			//Recursively call the method on the right subtree
			listGamesByPrice(node.getRight());
        }
    }
	
	public Node removeGameFromStore(Node node, double price) {
		if (node == null) 
		{
			return null;
		}
		
		double nodePrice = node.getGame().getPrice();
		
		if (price < nodePrice) 
		{
			node.setLeft(removeGameFromStore(node.getLeft(), price));
		} 
		else if (price > nodePrice) 
		{
			node.setRight(removeGameFromStore(node.getRight(), price));
		} 
		else
		{
			if (node.getLeft() == null) 
			{
				return node.getRight();
			} 
			else if (node.getRight() == null) 
			{
				return node.getLeft();
			} 
			else 
			{
				Node successor = findMinNode(node.getRight());
				node.setGame(successor.getGame());
				node.setRight(removeGameFromStore(node.getRight(), successor.getGame().getPrice()));
			}
		}
		
		//Return the modified node
		return node;
	}

	private Node findMinNode(Node right) {
		//If the left child of the input node is null, then the input node is the smallest node in the subtree.
		if (right.getLeft() == null) 
		{
            return right;
        } 
		else //continue recursively searching for the smallest node in the left subtree.
		{
            return findMinNode(right.getLeft());
        }
		
		//throw new UnsupportedOperationException("findMinNode(Node) not yet implemented");
	}

// * searchByName(...) METHOD PROVIDED AS PART OF TEMPLATE
// Searches for a game (by name) in the store. Returns null if there are no
// games in the store or the game was not found. Otherwise, returns the Game
// object with the game's matching name
	
	public int countGamesInStore(Node node) {
		//If the node is null, there are no games in the store.
		if (node == null) 
		{
		    return 0;
		} 
		else 
		{
		    //Initialize the count to 1 to include the current node.
		    int count = 1;
		    
		    //Recursively count the number of games in the left subtree and add to the count.
		    count += countGamesInStore(node.getLeft());
		    
		    //Recursively count the number of games in the right subtree and add to the count.
		    count += countGamesInStore(node.getRight());
		    
		    //Return the total count of games in the store.
		    return count;
		}
    }
	
	public Game searchByPrice(Node root, double price) 
	{
		//If the root node is null, return null because there is no game in the tree.
		if (root == null)
		{
			return null;
		}
		
		//If the price matches the price of the game in the root node, return that game.
		else if (price == root.getGame().getPrice())
		{
			return root.getGame();
		}
		
		//If the price is less than the price of the game in the root node, search the left subtree.
		else if (price < root.getGame().getPrice())
		{
			return searchByPrice(root.getLeft(), price);
		}
		
		//If the price is greater than the price of the game in the root node, search the right subtree.
		else
		{
			return searchByPrice(root.getRight(), price);
		}
    }
	
	public double calculateStoreValue(Node node) {
		// If the current node is null, there are no items and the total value is zero
        if (node == null)
        {
            return 0;
        } 
        else //add up the price of the current item, as well as the total values of its left and right subtrees
        {
            return node.getGame().getPrice() + calculateStoreValue(node.getLeft()) + calculateStoreValue(node.getRight());
        }
    }
	
	public Game searchMostPopularGame(Node node) {
		//If the node is null, there is no game to return
	    if (node == null) {
	        return null;
	    }

	    //Recursively search for the most popular game in the left and right subtrees
	    Game maxGame = node.getGame();
	    Game leftMax = searchMostPopularGame(node.getLeft());
	    Game rightMax = searchMostPopularGame(node.getRight());

	    //If a game with more downloads is found in the left subtree, update maxGame
	    if (leftMax != null && leftMax.getDownloads() > maxGame.getDownloads()) 
	    {
	        maxGame = leftMax;
	    }

	    //If a game with more downloads is found in the right subtree, update maxGame
	    if (rightMax != null && rightMax.getDownloads() > maxGame.getDownloads()) 
	    {
	        maxGame = rightMax;
	    }

	    //Return the game with the highest number of downloads
	    return maxGame;
	}
	
	public Game searchByName(Node node, String name) {
		if (node == null) {
			return null;
		}
		Game leftResult = searchByName(node.getLeft(), name);
		if (leftResult != null) {
			return leftResult;
		}
		if (node.getGame().getName().equals(name)) {
			return node.getGame();
		}
		Game rightResult = searchByName(node.getRight(), name);
		return rightResult;
	}

// * get/setRoot(...) METHODS PROVIDED AS PART OF TEMPLATE
// getters and setters for the BST root
	public void setRoot(Node root) {
		this.root = root;
	}

	public Node getRoot() {
		return root;
	}
}
