package tennis;

public class DeuceScore implements Score {

	@Override
	public Score firstPlayerWinsPoint() {
		return new PlayerHasAdvantageScore(Players.FIRST);
	}

	@Override
	public Score secondPlayerWinsPoint() {
		return new PlayerHasAdvantageScore(Players.SECOND);
	}

	@Override
	public String format() {
		return "Deuce";
	}

}
