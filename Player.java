package RPSLS;

public abstract class Player {
	private String myName;
	private Choice myChoice;
	
	/////////////////////
	// Getters/Setters
	/////////////////////
	public String getName() {
		return myName;
	}
	public void setName(String name) {
		myName = name;
	}
	public Choice getChoice() {
		return myChoice;
	}
	public void setChoice(Choice choice) {
		myChoice = choice;
	}
	
	/////////////////
	// Constructors
	/////////////////
	public Player() {
		myName = null;
		myChoice = null;
	}
	public Player(String name, Choice choice) {
		myName = name;
		myChoice = choice;
	}
	
}
