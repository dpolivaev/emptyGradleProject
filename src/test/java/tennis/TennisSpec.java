package tennis;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class TennisSpec {
	@Test
	public void initialScoreIsLoveLove() throws Exception {
		Score initialScore = Score.initialScore();
		assertThat(initialScore.format()).isEqualTo("LOVE:LOVE");
	}

	@Test
	public void firstPlayerWinsOnePoint_scoreIsFifteenLove() throws Exception {
		Score initialScore = Score.initialScore();
		Score fifteenToZero = initialScore.firstPlayerWinsPoint();
		assertThat(fifteenToZero.format()).isEqualTo("FIFTEEN:LOVE");
	}


	@Test
	public void secondPlayerWinsTwoPoints_scoreIsLoveFifteen() throws Exception {
		Score initialScore = Score.initialScore();
		Score fifteenToZero = initialScore.secondPlayerWinsPoint();
		assertThat(fifteenToZero.format()).isEqualTo("LOVE:FIFTEEN");
	}

	@Test
	public void eachPlayerWinsOnePoint_scoreIsFifteenFifteen() throws Exception {
		Score initialScore = Score.initialScore();
		Score fifteenToZero = initialScore.firstPlayerWinsPoint();
		Score fifteenToFifteen = fifteenToZero.secondPlayerWinsPoint();
		assertThat(fifteenToFifteen.format()).isEqualTo("FIFTEEN:FIFTEEN");
	}

}
