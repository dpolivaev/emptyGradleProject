package tennis;

import org.assertj.core.util.VisibleForTesting;

class InitialPhaseScore implements Score {
	
	enum Scores{LOVE, FIFTEEN, THIRTY, FORTY};
	private final Scores[] scores;

	@VisibleForTesting
	InitialPhaseScore(Scores firstPlayerScore, Scores secondPlayerScore) {
		super();
		this.scores = new Scores[] {firstPlayerScore, secondPlayerScore};
	}


	public String format() {
		return getScore(Players.FIRST).name() + ':' + getScore(Players.SECOND).name();
	}

	public Score firstPlayerWinsPoint() {
		if(getScore(Players.FIRST).ordinal() + 1 < Scores.values().length) {
			Scores nextScore = Scores.values()[getScore(Players.FIRST).ordinal() + 1];
			return new InitialPhaseScore(nextScore, getScore(Players.SECOND));
		}
		else if(getScore(Players.SECOND).ordinal() + 1 < Scores.values().length) {
			return new PlayerWinsScore(Players.FIRST);
		}
		else
			return new PlayerHasAdvantageScore(Players.FIRST);
	}

	public Score secondPlayerWinsPoint() {
		if(getScore(Players.SECOND).ordinal() + 1 < Scores.values().length) {
			Scores nextScore = Scores.values()[getScore(Players.SECOND).ordinal() + 1];
			return new InitialPhaseScore(getScore(Players.FIRST), nextScore);
		}
		else if(getScore(Players.FIRST).ordinal() + 1 < Scores.values().length) {
			return new PlayerWinsScore(Players.SECOND);
		}
		else
			return new PlayerHasAdvantageScore(Players.SECOND);
	}

	private Scores getScore(Players player) {
		return scores[player.ordinal()];
	}

}
