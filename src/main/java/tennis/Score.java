package tennis;


public class Score {
	private String currentScore = "LOVE:LOVE";

	public static Score initialScore() {
		return new Score();
	}

	public String format() {
		return currentScore;
	}

	public Score firstPlayerWinsPoint() {
		currentScore = "FIFTEEN:LOVE";
		return this;
	}

	public Score secondPlayerWinsPoint() {
		if(currentScore.equals("FIFTEEN:LOVE"))
			currentScore = "FIFTEEN:FIFTEEN";
		else
			currentScore = "LOVE:FIFTEEN";
		return this;
	}

}
