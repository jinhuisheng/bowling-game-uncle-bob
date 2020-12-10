import java.util.ArrayList;
import java.util.List;

/**
 * @author huisheng.jin
 * @date 2020/12/11.
 */
public class Game {

    private static final int FRAME_COUNT = 10;
    private final List<Frame> frames;
    private Integer index;

    public Game() {
        frames = initFrames();
        index = 0;
    }

    private List<Frame> initFrames() {
        List<Frame> frames = new ArrayList<>();
        for (int i = 0; i < FRAME_COUNT; i++) {
            frames.add(new Frame());
        }
        return frames;
    }

    public void roll(int pins) {
        Frame frame = getFrame();
        frame.add(pins);
        setIndex(frame);
    }

    private void setIndex(Frame frame) {
        if (frame.isComplete()) {
            index += 1;
        }
    }

    private Frame getFrame() {
        return new Frame();
    }

    public Integer score() {
        return frames.stream().map(frame -> frame.getRollPins()).reduce(0, (x, y) -> x + y);
    }
}
