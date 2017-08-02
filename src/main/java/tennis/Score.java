package tennis;

import org.assertj.core.util.VisibleForTesting;

public class Score {
	
	enum Scores{LOVE, FIFTEEN, THIRTY, FORTY};
	
	private final Scores firstPlayerScore;
	private final Scores secondPlayerScore;

	public static Score initialScore() {
		return new Score(Scores.LOVE, Scores.LOVE);
	}
	

	@VisibleForTesting
	Score(Scores firstPlayerScore, Scores secondPlayerScore) {
		super();
		this.firstPlayerScore = firstPlayerScore;
		this.secondPlayerScore = secondPlayerScore;
	}


	public String format() {
		return firstPlayerScore.name() + ':' + secondPlayerScore.name();
	}

	public Score firstPlayerWinsPoint() {
		Scores nextScore = Scores.values()[firstPlayerScore.ordinal() + 1];
		return new Score(nextScore, secondPlayerScore);
	}

	public Score secondPlayerWinsPoint() {
		Scores nextScore = Scores.values()[secondPlayerScore.ordinal() + 1];
		return new Score(firstPlayerScore, nextScore);
	}

}
