package tennis;

class PlayerHasAdvantageScore implements Score {
	private final String playerName;

	public PlayerHasAdvantageScore(String playerName) {
		super();
		this.playerName = playerName;
	}


	@Override
	public Score firstPlayerWinsPoint() {
		return new PlayerWinsScore(playerName);
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
