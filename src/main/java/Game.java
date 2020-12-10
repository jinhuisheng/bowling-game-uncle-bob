import java.util.ArrayList;
import java.util.List;

/**
 * @author huisheng.jin
 * @date 2020/12/11.
 */
public class Game {

    private List<Frame> frames;

    public Game() {
        frames = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            frames.add(new Frame());
        }
    }

    public void roll(int pins) {

    }

    public Integer score() {
        return frames.stream().map(frame -> frame.getRollPins()).reduce(0, (x, y) -> x + y);
    }
}
