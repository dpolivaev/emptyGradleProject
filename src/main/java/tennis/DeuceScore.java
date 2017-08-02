package tennis;

public class DeuceScore implements Score {

	@Override
	public Score firstPlayerWinsPoint() {
		return null;
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
