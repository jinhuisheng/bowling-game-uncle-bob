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
        if (index < 9) {
            if (frame.isComplete()) {
                index += 1;
            }
        }
    }

    private Frame getFrame() {
        return frames.get(index);
    }

    public Integer score() {
        int score = 0;
        for (int index = 0; index < 10; index++) {
            score += countFrameScore(index);
        }
        return score;
    }

    private int countFrameScore(int index) {
        if (frames.get(0).getFirstRollPin() == 10) {
            return 30;
        }
        if (frames.get(index).isSpare()) {
            return frames.get(index).getRollPins() + getNextRollPin();
        } else if (frames.get(index).isStrike()) {
            return 30;
        } else {
            return frames.get(index).getRollPins();
        }
    }

    private Integer getNextRollPin() {
        if (index < 9) {
            return frames.get(index + 1).getFirstRollPin();
        } else {
            return frames.get(index).getExtraFirstBallRollPins();
        }
    }

}
