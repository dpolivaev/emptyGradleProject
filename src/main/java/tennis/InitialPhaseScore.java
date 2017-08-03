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
		return getFirstPlayerScore().name() + ':' + getSecondPlayerScore().name();
	}

	public Score firstPlayerWinsPoint() {
		if(getFirstPlayerScore().ordinal() + 1 < Scores.values().length) {
			Scores nextScore = Scores.values()[getFirstPlayerScore().ordinal() + 1];
			return new InitialPhaseScore(nextScore, getSecondPlayerScore());
		}
		else if(getSecondPlayerScore().ordinal() + 1 < Scores.values().length) {
			return new PlayerWinsScore(Players.FIRST);
		}
		else
			return new PlayerHasAdvantageScore(Players.FIRST);
	}

	public Score secondPlayerWinsPoint() {
		if(getSecondPlayerScore().ordinal() + 1 < Scores.values().length) {
			Scores nextScore = Scores.values()[getSecondPlayerScore().ordinal() + 1];
			return new InitialPhaseScore(getFirstPlayerScore(), nextScore);
		}
		else if(getFirstPlayerScore().ordinal() + 1 < Scores.values().length) {
			return new PlayerWinsScore(Players.SECOND);
		}
		else
			return new PlayerHasAdvantageScore(Players.SECOND);
	}


	private Scores getFirstPlayerScore() {
		return scores[Players.FIRST.ordinal()];
	}


	private Scores getSecondPlayerScore() {
		return scores[Players.SECOND.ordinal()];
	}

}
