package tennis;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import tennis.Score.Scores;

public class TennisSpec {
	@Test
	public void initialScoreIsLoveLove() throws Exception {
		Score initialScore = Score.initialScore();
		assertThat(initialScore.format()).isEqualTo("LOVE:LOVE");
	}

	@Test
	public void firstPlayerWinsOnePoint_scoreIsFifteenLove() throws Exception {
		Score initialScore = Score.initialScore();
		Score fifteenToLove = initialScore.firstPlayerWinsPoint();
		assertThat(fifteenToLove.format()).isEqualTo("FIFTEEN:LOVE");
	}


	@Test
	public void secondPlayerWinsTwoPoints_scoreIsLoveFifteen() throws Exception {
		Score initialScore = Score.initialScore();
		Score fifteenToLove = initialScore.secondPlayerWinsPoint();
		assertThat(fifteenToLove.format()).isEqualTo("LOVE:FIFTEEN");
	}

	@Test
	public void eachPlayerWinsOnePoint_scoreIsFifteenFifteen() throws Exception {
		Score initialScore = Score.initialScore();
		Score fifteenToLove = initialScore.firstPlayerWinsPoint();
		Score fifteenToFifteen = fifteenToLove.secondPlayerWinsPoint();
		assertThat(fifteenToFifteen.format()).isEqualTo("FIFTEEN:FIFTEEN");
	}


	@Test
	public void firstPlayerWinsTwoPoints_scoreIsThirtyLove() throws Exception {
		Score fifteenToLove = new Score(Scores.FIFTEEN, Scores.LOVE);
		Score thirtyToLove = fifteenToLove.firstPlayerWinsPoint();
		assertThat(thirtyToLove.format()).isEqualTo("THIRTY:LOVE");
	}


	@Test
	public void secondPlayerWinsTwoPoints_scoreIsLoveThirty() throws Exception {
		Score fifteenToLove = new Score(Scores.LOVE, Scores.FIFTEEN);
		Score thirtyToLove = fifteenToLove.secondPlayerWinsPoint();
		assertThat(thirtyToLove.format()).isEqualTo("LOVE:THIRTY");
	}


	@Test
	public void firstPlayerWinsThreePoints_scoreIsFortyLove() throws Exception {
		Score fifteenToLove = new Score(Scores.THIRTY, Scores.LOVE);
		Score thirtyToLove = fifteenToLove.firstPlayerWinsPoint();
		assertThat(thirtyToLove.format()).isEqualTo("FORTY:LOVE");
	}
}
