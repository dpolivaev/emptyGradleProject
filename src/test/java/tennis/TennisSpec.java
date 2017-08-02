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
		Score oneFifteenToZero = initialScore.firstPlayerWinsPoint();
		assertThat(oneFifteenToZero.format()).isEqualTo("FIFTEEN:LOVE");
	}
}
