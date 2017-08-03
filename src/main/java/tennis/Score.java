package tennis;

public interface Score {
	Score playerWinsPoint(Players player);

	String format();

	static Score initialScore() {
		return new InitialPhaseScore(InitialPhaseScore.Scores.LOVE, InitialPhaseScore.Scores.LOVE);
	}
}