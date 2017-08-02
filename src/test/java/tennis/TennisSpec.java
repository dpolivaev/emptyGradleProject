package tennis;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import tennis.InitialPhaseScore.Scores;

public class TennisSpec {
	@Test
	public void initialScoreIsLoveLove() throws Exception {
		Score initialScore = InitialPhaseScore.initialScore();
		assertThat(initialScore.format()).isEqualTo("LOVE:LOVE");
	}

	@Test
	public void firstPlayerWinsOnePoint_fifteenLove() throws Exception {
		Score initialScore = InitialPhaseScore.initialScore();
		Score fifteenToLove = initialScore.firstPlayerWinsPoint();
		assertThat(fifteenToLove.format()).isEqualTo("FIFTEEN:LOVE");
	}


	@Test
	public void secondPlayerWinsTwoPoints_loveFifteen() throws Exception {
		Score initialScore = InitialPhaseScore.initialScore();
		Score fifteenToLove = initialScore.secondPlayerWinsPoint();
		assertThat(fifteenToLove.format()).isEqualTo("LOVE:FIFTEEN");
	}

	@Test
	public void eachPlayerWinsOnePoint_fifteenFifteen() throws Exception {
		Score initialScore = InitialPhaseScore.initialScore();
		Score fifteenToLove = initialScore.firstPlayerWinsPoint();
		Score fifteenToFifteen = fifteenToLove.secondPlayerWinsPoint();
		assertThat(fifteenToFifteen.format()).isEqualTo("FIFTEEN:FIFTEEN");
	}


	@Test
	public void firstPlayerWinsTwoPoints_thirtyLove() throws Exception {
		Score beforeLastPoint = new InitialPhaseScore(Scores.FIFTEEN, Scores.LOVE);
		Score result = beforeLastPoint.firstPlayerWinsPoint();
		assertThat(result.format()).isEqualTo("THIRTY:LOVE");
	}


	@Test
	public void secondPlayerWinsTwoPoints_loveThirty() throws Exception {
		Score beforeLastPoint = new InitialPhaseScore(Scores.LOVE, Scores.FIFTEEN);
		Score result = beforeLastPoint.secondPlayerWinsPoint();
		assertThat(result.format()).isEqualTo("LOVE:THIRTY");
	}


	@Test
	public void firstPlayerWinsThreePoints_fortyLove() throws Exception {
		Score beforeLastPoint = new InitialPhaseScore(Scores.THIRTY, Scores.LOVE);
		Score result = beforeLastPoint.firstPlayerWinsPoint();
		assertThat(result.format()).isEqualTo("FORTY:LOVE");
	}


	@Test
	public void firstPlayerWinsFourPoints_firstPlayerWinsGame() throws Exception {
		Score beforeLastPoint = new InitialPhaseScore(Scores.FORTY, Scores.LOVE);
		Score result = beforeLastPoint.firstPlayerWinsPoint();
		assertThat(result.format()).isEqualTo("First player wins game");
	}

	@Test
	public void secondPlayerWinsFourPoints_secondPlayerWinsGame() throws Exception {
		Score beforeLastPoint = new InitialPhaseScore(Scores.LOVE, Scores.FORTY);
		Score result = beforeLastPoint.secondPlayerWinsPoint();
		assertThat(result.format()).isEqualTo("Second player wins game");
	}

	@Test
	public void firstPlayerWinsFourPointsAndSecondPlayerWinsThreePoints_firstPlayerHasAdvantage() throws Exception {
		Score beforeLastPoint = new InitialPhaseScore(Scores.FORTY, Scores.FORTY);
		Score result = beforeLastPoint.firstPlayerWinsPoint();
		assertThat(result.format()).isEqualTo("First player has advantage");
	}

	@Test
	public void firstPlayerWinsThreePointsAndSecondPlayerWinsFourPoints_secondPlayerHasAdvantage() throws Exception {
		Score beforeLastPoint = new InitialPhaseScore(Scores.FORTY, Scores.FORTY);
		Score result = beforeLastPoint.secondPlayerWinsPoint();
		assertThat(result.format()).isEqualTo("Second player has advantage");
	}

	@Test
	public void firstPlayerWinsPointAfterHisAdvantage_firstPlayerWinsGame() throws Exception {
		Score beforeLastPoint = new PlayerHasAdvantageScore(Players.FIRST);
		Score result = beforeLastPoint.firstPlayerWinsPoint();
		assertThat(result.format()).isEqualTo("First player wins game");
	}

	@Test
	public void secondPlayerWinsPointAfterHisAdvantage_secondPlayerWinsGame() throws Exception {
		Score beforeLastPoint = new PlayerHasAdvantageScore(Players.SECOND);
		Score result = beforeLastPoint.secondPlayerWinsPoint();
		assertThat(result.format()).isEqualTo("Second player wins game");
	}

	@Test
	public void secondPlayerWinsPointAfterFirstPlayerAdvantage_deuce() throws Exception {
		Score beforeLastPoint = new PlayerHasAdvantageScore(Players.FIRST);
		Score result = beforeLastPoint.secondPlayerWinsPoint();
		assertThat(result.format()).isEqualTo("Deuce");
	}

	@Test
	public void firstPlayerWinsPointAfterSecondPlayerAdvantage_deuce() throws Exception {
		Score beforeLastPoint = new PlayerHasAdvantageScore(Players.SECOND);
		Score result = beforeLastPoint.firstPlayerWinsPoint();
		assertThat(result.format()).isEqualTo("Deuce");
	}
}
