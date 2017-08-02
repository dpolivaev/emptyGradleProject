package tennis;

public interface Score {

	Score firstPlayerWinsPoint();
	
	Score secondPlayerWinsPoint();

	String format();
}