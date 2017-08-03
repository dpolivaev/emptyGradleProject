package tennis;

public interface Score {

	
	default public Score firstPlayerWinsPoint() {
		return playerWinsPoint(Players.FIRST);
	}

	default
	public Score secondPlayerWinsPoint() {
		return playerWinsPoint(Players.SECOND);
	}

	
	Score playerWinsPoint(Players player);

	String format();

	static Score initialScore() {
		return new InitialPhaseScore(InitialPhaseScore.Scores.LOVE, InitialPhaseScore.Scores.LOVE);
	}
}