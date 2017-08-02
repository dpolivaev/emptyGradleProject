package tennis;

class PlayerHasAdvantageScore implements Score {
	private final Players player;

	public PlayerHasAdvantageScore(Players player) {
		super();
		this.player = player;
	}


	@Override
	public Score firstPlayerWinsPoint() {
		if(player == Players.FIRST)
			return new PlayerWinsScore(player);
		return new DeuceScore();
	}

	@Override
	public Score secondPlayerWinsPoint() {
		if(player == Players.SECOND)
			return new PlayerWinsScore(player);
		return new DeuceScore();
	}

	@Override
	public String format() {
		return player.getPlayerName() + " player has advantage";
	}

}
