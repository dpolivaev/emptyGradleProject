package tennis;


public class Score {
	
	enum Scores{LOVE, FIFTEEN};
	
	private Scores firstPlayerScore = Scores.LOVE;
	private Scores secondPlayerScore = Scores.LOVE;

	public static Score initialScore() {
		return new Score();
	}

	public String format() {
		return firstPlayerScore.name() + ':' + secondPlayerScore.name();
	}

	public Score firstPlayerWinsPoint() {
		firstPlayerScore = Scores.FIFTEEN;
		return this;
	}

	public Score secondPlayerWinsPoint() {
		secondPlayerScore = Scores.FIFTEEN;
		return this;
	}

}
