import org.junit.jupiter.api.Test;

/**
 * @author huisheng.jin
 * @date 2020/12/11.
 */
public class GameTest {
    @Test
    void should_score_0_when_all_rolls_are_zero() {
        Game game = new Game();
        game.roll(0);
    }
}
