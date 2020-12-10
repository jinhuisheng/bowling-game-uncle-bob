import java.util.ArrayList;
import java.util.List;

/**
 * @author huisheng.jin
 * @date 2020/12/11.
 */
public class Frame {
    private List<Integer> rollPins = new ArrayList<>();

    public Integer getRollPins() {
        return rollPins.stream().reduce(0, (x, y) -> x + y);
    }

    public void add(int pins) {
        rollPins.add(pins);
    }

    public boolean isComplete() {
        return rollPins.size() == 2;
    }
}
