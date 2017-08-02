package tennis;


public class Score {
	
	enum Scores{LOVE, FIFTEEN};
	
	private final Scores firstPlayerScore;
	private final Scores secondPlayerScore;

	public static Score initialScore() {
		return new Score(Scores.LOVE, Scores.LOVE);
	}
	

	private Score(Scores firstPlayerScore, Scores secondPlayerScore) {
		super();
		this.firstPlayerScore = firstPlayerScore;
		this.secondPlayerScore = secondPlayerScore;
	}


	public String format() {
		return firstPlayerScore.name() + ':' + secondPlayerScore.name();
	}

	public Score firstPlayerWinsPoint() {
		return new Score(Scores.FIFTEEN, secondPlayerScore);
	}

	public Score secondPlayerWinsPoint() {
		return new Score(firstPlayerScore, Scores.FIFTEEN);
	}

}
