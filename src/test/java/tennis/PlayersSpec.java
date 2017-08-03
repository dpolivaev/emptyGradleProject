package tennis;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class PlayersSpec {
	@Test
	public void firstsAnotherPlayerIsSecond() throws Exception {
		assertThat(Players.FIRST.anotherPlayer()).isEqualTo(Players.SECOND);
	}
}
