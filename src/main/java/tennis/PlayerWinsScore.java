package tennis;

class PlayerWinsScore implements Score {
	private final String playerName;

	public PlayerWinsScore(String playerName) {
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
		return playerName + " player wins game";
	}

}
