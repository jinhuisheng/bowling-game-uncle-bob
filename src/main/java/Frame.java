import java.util.ArrayList;
import java.util.List;

/**
 * @author huisheng.jin
 * @date 2020/12/11.
 */
public class Frame {
    public static final int ONE_BALL_PINS_MAX_COUNT = 10;
    private List<Integer> rollPins = new ArrayList<>();
    private List<Integer> extraBallsRollPins = new ArrayList<>();

    public Integer getRollPins() {
        return rollPins.stream().reduce(0, Integer::sum);
    }

    public void add(int pins) {
        if (rollPins.size() == 1 && isStrike()) {
            extraBallsRollPins.add(pins);
            return;
        }
        if (rollPins.size() < 2) {
            rollPins.add(pins);
        } else {
            extraBallsRollPins.add(pins);
        }
    }

    public boolean isComplete() {
        return rollPins.get(0) == 10 || rollPins.size() == 2;
    }

    public boolean isStrike() {
        return rollPins.get(0) == 10;
    }

    public boolean isSpare() {
        return rollPins.size() == 2 && getRollPins() == 10;
    }

    public Integer getFirstRollPin() {
        return rollPins.get(0);
    }

    public Integer getExtraFirstBallRollPins() {
        return extraBallsRollPins.get(0);
    }

    public int getExtraSecondBallRollPins() {
        return extraBallsRollPins.get(1);
    }

    public int getSecondBallRollPins() {
        return rollPins.get(1);
    }
}
