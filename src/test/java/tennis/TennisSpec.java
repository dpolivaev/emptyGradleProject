package tennis;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Ignore;
import org.junit.Test;

import tennis.InitialPhaseScore.Scores;

public class TennisSpec {
	@Test
	public void initialScoreIsLoveLove() throws Exception {
		Score initialScore = InitialPhaseScore.initialScore();
		assertThat(initialScore.format()).isEqualTo("LOVE:LOVE");
	}

	@Test
	public void firstPlayerWinsOnePoint_scoreIsFifteenLove() throws Exception {
		Score initialScore = InitialPhaseScore.initialScore();
		Score fifteenToLove = initialScore.firstPlayerWinsPoint();
		assertThat(fifteenToLove.format()).isEqualTo("FIFTEEN:LOVE");
	}


	@Test
	public void secondPlayerWinsTwoPoints_scoreIsLoveFifteen() throws Exception {
		Score initialScore = InitialPhaseScore.initialScore();
		Score fifteenToLove = initialScore.secondPlayerWinsPoint();
		assertThat(fifteenToLove.format()).isEqualTo("LOVE:FIFTEEN");
	}

	@Test
	public void eachPlayerWinsOnePoint_scoreIsFifteenFifteen() throws Exception {
		Score initialScore = InitialPhaseScore.initialScore();
		Score fifteenToLove = initialScore.firstPlayerWinsPoint();
		Score fifteenToFifteen = fifteenToLove.secondPlayerWinsPoint();
		assertThat(fifteenToFifteen.format()).isEqualTo("FIFTEEN:FIFTEEN");
	}


	@Test
	public void firstPlayerWinsTwoPoints_scoreIsThirtyLove() throws Exception {
		Score beforeLastPoint = new InitialPhaseScore(Scores.FIFTEEN, Scores.LOVE);
		Score result = beforeLastPoint.firstPlayerWinsPoint();
		assertThat(result.format()).isEqualTo("THIRTY:LOVE");
	}


	@Test
	public void secondPlayerWinsTwoPoints_scoreIsLoveThirty() throws Exception {
		Score beforeLastPoint = new InitialPhaseScore(Scores.LOVE, Scores.FIFTEEN);
		Score result = beforeLastPoint.secondPlayerWinsPoint();
		assertThat(result.format()).isEqualTo("LOVE:THIRTY");
	}


	@Test
	public void firstPlayerWinsThreePoints_scoreIsFortyLove() throws Exception {
		Score beforeLastPoint = new InitialPhaseScore(Scores.THIRTY, Scores.LOVE);
		Score result = beforeLastPoint.firstPlayerWinsPoint();
		assertThat(result.format()).isEqualTo("FORTY:LOVE");
	}


	@Test
	public void firstPlayerWinsFourPoints_scoreIsFirstPlayerWinsGame() throws Exception {
		Score beforeLastPoint = new InitialPhaseScore(Scores.FORTY, Scores.LOVE);
		Score result = beforeLastPoint.firstPlayerWinsPoint();
		assertThat(result.format()).isEqualTo("First player wins game");
	}

	@Test
	public void secondPlayerWinsFourPoints_scoreIsSecondPlayerWinsGame() throws Exception {
		Score beforeLastPoint = new InitialPhaseScore(Scores.LOVE, Scores.FORTY);
		Score result = beforeLastPoint.secondPlayerWinsPoint();
		assertThat(result.format()).isEqualTo("Second player wins game");
	}
}
