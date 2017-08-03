package tennis;

class PlayerHasAdvantageScore implements Score {
	private final Players player;

	PlayerHasAdvantageScore(Players player) {
		super();
		this.player = player;
	}

	public Score playerWinsPoint(Players winningPlayer) {
		if(player == winningPlayer)
			return new PlayerWinsScore(player);
		return new DeuceScore();
	}

	@Override
	public String format() {
		return player.getPlayerName() + " player has advantage";
	}

}
