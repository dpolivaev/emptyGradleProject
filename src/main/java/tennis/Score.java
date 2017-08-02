package tennis;

public interface Score {

	Score firstPlayerWinsPoint();
	
	Score secondPlayerWinsPoint();

	String format();

	static Score initialScore() {
		return new InitialPhaseScore(InitialPhaseScore.Scores.LOVE, InitialPhaseScore.Scores.LOVE);
	}
}