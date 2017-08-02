package tennis;

public class SecondPlayerWinsScore implements Score {

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
		return "Second player wins game";
	}

}
