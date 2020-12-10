import java.util.ArrayList;
import java.util.List;

/**
 * @author huisheng.jin
 * @date 2020/12/11.
 */
public class Frame {
    private List<Integer> rollPins = new ArrayList<>();
    private List<Integer> extraBallsRollPins = new ArrayList<>();

    public Integer getRollPins() {
        return rollPins.stream().reduce(0, (x, y) -> x + y);
    }

    public void add(int pins) {
        if (rollPins.size() == 1 && rollPins.get(0) == 10) {
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

    public boolean isSpare() {
        return rollPins.size() == 2 && getRollPins() == 10;
    }

    public Integer getFirstRollPin() {
        return rollPins.get(0);
    }

    public Integer getExtraFirstBallRollPins() {
        return extraBallsRollPins.get(0);
    }

    public boolean isStrike() {
        return rollPins.get(0) == 10;
    }
}
