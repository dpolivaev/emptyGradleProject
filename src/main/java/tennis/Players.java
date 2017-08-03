package tennis;

enum Players {
	FIRST("First"), SECOND("Second");
	
	final private String playerName;

	private Players(String playerName) {
		this.playerName = playerName;
		
	}

	public String getPlayerName() {
		return playerName;
	}

	public Players anotherPlayer() {
		return Players.values()[1 - ordinal()];
	}
}
