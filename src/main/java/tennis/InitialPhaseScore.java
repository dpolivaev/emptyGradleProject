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

	public Score playerWinsPoint(Players player) {
		Players anotherPlayer = player.anotherPlayer();
		if(getScore(player).ordinal() + 1 < Scores.values().length) {
			Scores nextScore = Scores.values()[getScore(player).ordinal() + 1];
			scores[player.ordinal()] = nextScore;
			return this;
		}
		else if(getScore(anotherPlayer).ordinal() + 1 < Scores.values().length) {
			return new PlayerWinsScore(player);
		}
		else
			return new PlayerHasAdvantageScore(player);
	}

	private Scores getScore(Players player) {
		return scores[player.ordinal()];
	}

}
