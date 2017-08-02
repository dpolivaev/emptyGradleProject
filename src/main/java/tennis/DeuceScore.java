package tennis;

public class DeuceScore implements Score {

	@Override
	public Score firstPlayerWinsPoint() {
		return new PlayerHasAdvantageScore(Players.FIRST);
	}

	@Override
	public Score secondPlayerWinsPoint() {
		return null;
	}

	@Override
	public String format() {
		return "Deuce";
	}

}
