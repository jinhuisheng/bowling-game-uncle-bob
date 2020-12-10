import java.util.ArrayList;
import java.util.List;

/**
 * @author huisheng.jin
 * @date 2020/12/11.
 */
public class Game {
    public void roll(int pins) {

    }

    public Integer score() {
        List<Frame> frames = new ArrayList<>();
        return frames.stream().map(frame -> frame.getRollPins()).reduce(0, (x, y) -> x + y);
    }
}
