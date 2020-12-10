import java.util.ArrayList;
import java.util.List;

/**
 * @author huisheng.jin
 * @date 2020/12/11.
 */
public class FramesContainer {
    private final List<Frame> frames;
    private Integer index;

    public FramesContainer() {
        frames = initFrames();
        index = 0;
    }

    private List<Frame> initFrames() {
        List<Frame> frames = new ArrayList<>();
        for (int i = 0; i < Game.FRAME_COUNT; i++) {
            frames.add(new Frame());
        }
        return frames;
    }

}
