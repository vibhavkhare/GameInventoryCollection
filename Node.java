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
public class Node {
// Declare instance variables
	private Game game;
	private Node left, right;

// Define constructor
	public Node(Game game) {
		this.game = game;
		left = null;
		right = null;
	}

// Define accessors/mutators
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}
}
