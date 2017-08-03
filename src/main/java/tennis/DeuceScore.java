package tennis;

class DeuceScore implements Score {
	DeuceScore() {}

	@Override
	public Score playerWinsPoint(Players player) {
		return new PlayerHasAdvantageScore(player);
	}

	@Override
	public String format() {
		return "Deuce";
	}

}
