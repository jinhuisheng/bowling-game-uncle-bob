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

    public void updateIndex(Frame frame) {
        if (index < 9) {
            if (frame.isComplete()) {
                index += 1;
            }
        }
    }

    public List<Frame> getFrames() {
        return frames;
    }

    public Frame getCurrentFrame() {
        return frames.get(index);
    }

    public Frame getFrame(Integer index) {
        return frames.get(index);
    }


    public void roll(int pins) {
        Frame frame = getCurrentFrame();
        frame.add(pins);
        updateIndex(frame);
    }
}
