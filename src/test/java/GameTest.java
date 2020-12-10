import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author huisheng.jin
 * @date 2020/12/11.
 */
public class GameTest {
    @Test
    void should_score_0_when_all_rolls_are_zero() {
        Game game = new Game();
        for (int i = 0; i < 10; i++) {
            game.roll(0);
            game.roll(0);
        }
        assertThat(game.score()).isEqualTo(0);
    }

    @Test
    void should_score_90_when_all_rolls_are_miss() {
        Game game = new Game();
        for (int i = 0; i < 10; i++) {
            game.roll(5);
            game.roll(4);
        }
        assertThat(game.score()).isEqualTo(90);
    }

}
