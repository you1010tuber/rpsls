package RPSLS;
public class Opponent extends Player{
	private String myIcon;

	public Opponent() {
		super(null, null);
		myIcon = null;
	}

	public String getIcon() {
		return myIcon;
	}

	public void setMyIcon(String icon) {
		myIcon = icon;
	}

	public Opponent(String name, Choice choice, String icon) {
		super(name, choice);
		myIcon = icon;
	}
	
	
}
