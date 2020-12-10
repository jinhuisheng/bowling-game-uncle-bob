import java.util.ArrayList;
import java.util.List;

/**
 * @author huisheng.jin
 * @date 2020/12/11.
 */
public class Game {

    private static final int FRAME_COUNT = 10;
    private final List<Frame> frames;
    private final Integer index;
    private final Integer rollTimes;

    public Game() {
        frames = initFrames();
        index = 0;
        rollTimes = 0;
    }

    private List<Frame> initFrames() {
        List<Frame> frames = new ArrayList<>();
        for (int i = 0; i < FRAME_COUNT; i++) {
            frames.add(new Frame());
        }
        return frames;
    }

    public void roll(int pins) {

    }

    public Integer score() {
        return frames.stream().map(frame -> frame.getRollPins()).reduce(0, (x, y) -> x + y);
    }
}
