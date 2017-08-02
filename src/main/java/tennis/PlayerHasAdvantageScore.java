package tennis;

class PlayerHasAdvantageScore implements Score {
	private final Players player;

	PlayerHasAdvantageScore(Players player) {
		super();
		this.player = player;
	}


	@Override
	public Score firstPlayerWinsPoint() {
		return playerWinsPoint(Players.FIRST);
	}


	private Score playerWinsPoint(Players winningPlayer) {
		if(player == winningPlayer)
			return new PlayerWinsScore(player);
		return new DeuceScore();
	}

	@Override
	public Score secondPlayerWinsPoint() {
		return playerWinsPoint(Players.SECOND);
	}

	@Override
	public String format() {
		return player.getPlayerName() + " player has advantage";
	}

}
