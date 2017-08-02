package tennis;

class PlayerHasAdvantageScore implements Score {
	private final String playerName;

	public PlayerHasAdvantageScore(String playerName) {
		super();
		this.playerName = playerName;
	}


	@Override
	public Score firstPlayerWinsPoint() {
		if(playerName.equals("First"))
			return new PlayerWinsScore(playerName);
		return new DeuceScore();
	}

	@Override
	public Score secondPlayerWinsPoint() {
		if(playerName.equals("Second"))
			return new PlayerWinsScore(playerName);
		return new DeuceScore();
	}

	@Override
	public String format() {
		return playerName + " player has advantage";
	}

}
