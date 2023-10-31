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
public class Game {
// Declare instance variables
	private String name;
	private String description;
	private double price;
	private int downloads;

// Define constructor
	public Game(String name, String description, double price, int downloads) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.downloads = downloads;
	}

// Define accessor methods
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public int getDownloads() {
		return downloads;
	}

// Define string representation of Game objects
	@Override
	public String toString() {
		return name + "\n" + description + "\nZyBox Price: $" + String.format("%.2f", price) + "\n" + downloads
				+ " downloads\n";
	}
}
