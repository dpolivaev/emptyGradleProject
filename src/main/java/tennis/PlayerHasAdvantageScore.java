package tennis;

class PlayerHasAdvantageScore implements Score {
	private final String playerName;

	public PlayerHasAdvantageScore(String playerName) {
		super();
		this.playerName = playerName;
	}


	@Override
	public Score firstPlayerWinsPoint() {
		return null;
	}

	@Override
	public Score secondPlayerWinsPoint() {
		return null;
	}

	@Override
	public String format() {
		return playerName + " player has advantage";
	}

}
