package tennis;

import org.assertj.core.util.VisibleForTesting;

class InitialPhaseScore implements Score {
	
	enum Scores{LOVE, FIFTEEN, THIRTY, FORTY};
	
	private final Scores firstPlayerScore;
	private final Scores secondPlayerScore;

	public static InitialPhaseScore initialScore() {
		return new InitialPhaseScore(Scores.LOVE, Scores.LOVE);
	}
	

	@VisibleForTesting
	InitialPhaseScore(Scores firstPlayerScore, Scores secondPlayerScore) {
		super();
		this.firstPlayerScore = firstPlayerScore;
		this.secondPlayerScore = secondPlayerScore;
	}


	public String format() {
		return firstPlayerScore.name() + ':' + secondPlayerScore.name();
	}

	public Score firstPlayerWinsPoint() {
		if(firstPlayerScore.ordinal() + 1 < Scores.values().length) {
			Scores nextScore = Scores.values()[firstPlayerScore.ordinal() + 1];
			return new InitialPhaseScore(nextScore, secondPlayerScore);
		}
		else
			return new PlayerWinsScore("First");
	}

	public Score secondPlayerWinsPoint() {
		if(secondPlayerScore.ordinal() + 1 < Scores.values().length) {
			Scores nextScore = Scores.values()[secondPlayerScore.ordinal() + 1];
			return new InitialPhaseScore(firstPlayerScore, nextScore);
		}
		else
			return new PlayerWinsScore("Second");
	}

}
