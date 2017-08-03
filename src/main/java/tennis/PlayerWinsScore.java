package tennis;

class PlayerWinsScore implements Score {
	private final Players player;

	PlayerWinsScore( Players player) {
		super();
		this.player = player;
	}

	@Override
	public Score playerWinsPoint(Players winningPlayer) {
		return null;
	}

	@Override
	public String format() {
		return player.getPlayerName() + " player wins game";
	}

}
