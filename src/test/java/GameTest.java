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


    @Test
    void should_score_150_when_all_rolls_are_spare() {
        Game game = new Game();
        for (int i = 0; i < 9; i++) {
            game.roll(5);
            game.roll(5);
        }
        game.roll(5);
        game.roll(5);
        game.roll(5);
        assertThat(game.score()).isEqualTo(150);
    }

    @Test
    void should_score_300_when_all_rolls_are_strike() {
        Game game = new Game();
        for (int i = 0; i < 9; i++) {
            game.roll(10);
        }
        game.roll(10);
        game.roll(10);
        game.roll(10);
        assertThat(game.score()).isEqualTo(300);
    }

}
