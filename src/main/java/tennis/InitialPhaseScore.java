package tennis;

import org.assertj.core.util.VisibleForTesting;

class InitialPhaseScore implements Score {
	
	enum Scores{LOVE, FIFTEEN, THIRTY, FORTY};
	
	private final Scores firstPlayerScore;
	private final Scores secondPlayerScore;

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
		else if(secondPlayerScore.ordinal() + 1 < Scores.values().length) {
			return new PlayerWinsScore(Players.FIRST);
		}
		else
			return new PlayerHasAdvantageScore(Players.FIRST);
	}

	public Score secondPlayerWinsPoint() {
		if(secondPlayerScore.ordinal() + 1 < Scores.values().length) {
			Scores nextScore = Scores.values()[secondPlayerScore.ordinal() + 1];
			return new InitialPhaseScore(firstPlayerScore, nextScore);
		}
		else if(firstPlayerScore.ordinal() + 1 < Scores.values().length) {
			return new PlayerWinsScore(Players.SECOND);
		}
		else
			return new PlayerHasAdvantageScore(Players.SECOND);
	}

}
