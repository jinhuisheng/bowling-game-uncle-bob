import java.util.List;

/**
 * @author huisheng.jin
 * @date 2020/12/11.
 */
public class Game {
    public static final int FRAME_COUNT = 10;
    private final List<Frame> frames;
    private FramesContainer framesContainer;

    public Game() {
        framesContainer = new FramesContainer();
        frames = framesContainer.getFrames();
    }

    public void roll(int pins) {
        framesContainer.roll(pins);
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
        if (framesContainer.getFrame(index).isSpare()) {
            return framesContainer.getFrame(index).getRollPins() + getNextRollPin(index);
        } else if (framesContainer.getFrame(index).isStrike()) {
            return framesContainer.getFrame(index).getRollPins() + getNextRollPin(index) + getNextNextRollPins(index);
        } else {
            return framesContainer.getFrame(index).getRollPins();
        }
    }

    private Integer getNextRollPin(int index) {
        if (index < 9) {
            return framesContainer.getFrame(index + 1).getFirstRollPin();
        } else {
            return framesContainer.getFrame(index).getExtraFirstBallRollPins();
        }
    }

    private int getNextNextRollPins(int index) {
        if (index < 8) {
            Frame nextFrame = framesContainer.getFrame(index + 1);
            if (nextFrame.isStrike()) {
                return framesContainer.getFrame(index + 2).getFirstRollPin();
            } else {
                return framesContainer.getFrame(index + 1).getSecondBallRollPins();
            }
        } else if (index == 8) {
            return framesContainer.getFrame(index + 1).getExtraFirstBallRollPins();
        }
        return framesContainer.getFrame(index).getExtraSecondBallRollPins();
    }

}
