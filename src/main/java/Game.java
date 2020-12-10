import java.util.List;

/**
 * @author huisheng.jin
 * @date 2020/12/11.
 */
public class Game {
    public static final int FRAME_COUNT = 10;
    private final List<Frame> frames;
    private Integer index;
    private FramesContainer framesContainer;

    public Game() {
        framesContainer = new FramesContainer();
        frames = framesContainer.getFrames();
        index = 0;
    }

    public void roll(int pins) {
        Frame frame = framesContainer.getCurrentFrame();
        frame.add(pins);
        setIndex(frame);
    }

    private void setIndex(Frame frame) {
        framesContainer.updateIndex(frame);
    }

    public Integer score() {
        int score = 0;
        for (int index = 0; index < 10; index++) {
            int temp = countFrameScore(index);
            score += temp;
            System.out.println(temp);
        }
        return score;
    }

    private int countFrameScore(int index) {
        if (frames.get(index).isSpare()) {
            return frames.get(index).getRollPins() + getNextRollPin(index);
        } else if (frames.get(index).isStrike()) {
            return frames.get(index).getRollPins() + getNextRollPin(index) + getNextNextRollPins(index);
        } else {
            return frames.get(index).getRollPins();
        }
    }

    private Integer getNextRollPin(int index) {
        if (index < 9) {
            return frames.get(index + 1).getFirstRollPin();
        } else {
            return frames.get(index).getExtraFirstBallRollPins();
        }
    }

    private int getNextNextRollPins(int index) {
        if (index < 8) {
            Frame nextFrame = frames.get(index + 1);
            if (nextFrame.isStrike()) {
                return frames.get(index + 2).getFirstRollPin();
            } else {
                return frames.get(index + 1).getSecondBallRollPins();
            }
        } else if (index == 8) {
            return frames.get(index + 1).getExtraFirstBallRollPins();
        }
        return frames.get(index).getExtraSecondBallRollPins();
    }

}
