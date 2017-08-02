package tennis;

public class FirstPlayerWinsScore implements Score {

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
		return "First player wins game";
	}

}
