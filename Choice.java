package RPSLS;
enum Choice {
	Rock, Paper, Scissors, Lizard, Spock;
	
	public boolean win(Choice x) {
		switch (this) {
		case Rock:
			return x == Scissors || x == Lizard;
		case Scissors:
			return x == Paper || x == Lizard;
		case Paper:
			return x == Rock || x == Spock;
		case Lizard:
			return x == Spock || x == Paper;
		case Spock:
			return x == Rock || x == Scissors;
		}
		return false;
	}
	
	public String getName() {
		switch (this) {
		case Rock:
			return "Rock";
		case Scissors:
			return "Scissors";
		case Paper:
			return "Paper";
		case Lizard:
			return "Lizard";
		case Spock:
			return "Spock";
		}
		return "Error 4";
	}
}