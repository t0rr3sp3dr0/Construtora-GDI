package systems.singularity.buildware.util;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by pedro on 7/14/16.
 * © 2016 Singularity Systems
 */
public class AsyncTimeline {
    private static int preDelay = 250;
    private static int postDelay = 250;
    private final List<Timeline> preTimelineList = new ArrayList<>();
    private final List<Callable> callableList = new ArrayList<>();
    private final List<Timeline> postTimelineList = new ArrayList<>();
    private List<Timeline> timelineList = new ArrayList<>();

    public static void setPreDelay(int preDelay) {
        AsyncTimeline.preDelay = preDelay;
    }

    public static void setPostDelay(int postDelay) {
        AsyncTimeline.postDelay = postDelay;
    }

    public static void setDelay(int delay) {
        setPreDelay(delay);
        setPostDelay(delay);
    }

    public void add(EventHandler<ActionEvent> preEventHandler, Integer preDelay, Callable callable, EventHandler<ActionEvent> postEventHandler, Integer postDelay) {
        preTimelineList.add(new Timeline(new KeyFrame(Duration.millis(preDelay == null ? AsyncTimeline.preDelay : preDelay), preEventHandler)));
        callableList.add(callable);
        postTimelineList.add(new Timeline(new KeyFrame(Duration.millis(postDelay == null ? AsyncTimeline.postDelay : postDelay), postEventHandler)));
    }

    public void add(EventHandler<ActionEvent> preEventHandler, Integer preDelay, Callable callable, EventHandler<ActionEvent> postEventHandler) {
        this.add(preEventHandler, preDelay, callable, postEventHandler, null);
    }

    public void add(EventHandler<ActionEvent> preEventHandler, Integer preDelay, Callable callable, Integer postDelay) {
        this.add(preEventHandler, preDelay, callable, event -> {
        }, postDelay);
    }

    public void add(EventHandler<ActionEvent> preEventHandler, Integer preDelay, EventHandler<ActionEvent> postEventHandler, Integer postDelay) {
        this.add(preEventHandler, preDelay, () -> null, postEventHandler, postDelay);
    }

    public void add(EventHandler<ActionEvent> preEventHandler, Callable callable, EventHandler<ActionEvent> postEventHandler, Integer postDelay) {
        this.add(preEventHandler, null, callable, postEventHandler, postDelay);
    }

    public void add(Integer preDelay, Callable callable, EventHandler<ActionEvent> postEventHandler, Integer postDelay) {
        this.add(event -> {
        }, preDelay, callable, postEventHandler, postDelay);
    }

    public void add(EventHandler<ActionEvent> preEventHandler, Integer preDelay, Callable callable) {
        this.add(preEventHandler, preDelay, callable, event -> {
        }, null);
    }

    public void add(EventHandler<ActionEvent> preEventHandler, Integer preDelay, EventHandler<ActionEvent> postEventHandler) {
        this.add(preEventHandler, preDelay, () -> null, postEventHandler, null);
    }

    public void add(EventHandler<ActionEvent> preEventHandler, Callable callable, EventHandler<ActionEvent> postEventHandler) {
        this.add(preEventHandler, null, callable, postEventHandler, null);
    }

    public void add(Integer preDelay, Callable callable, EventHandler<ActionEvent> postEventHandler) {
        this.add(event -> {
        }, preDelay, callable, postEventHandler, null);
    }

    public void add(EventHandler<ActionEvent> preEventHandler, Integer preDelay, Integer postDelay) {
        this.add(preEventHandler, preDelay, () -> null, event -> {
        }, postDelay);
    }

    public void add(EventHandler<ActionEvent> preEventHandler, Callable callable, Integer postDelay) {
        this.add(preEventHandler, null, callable, event -> {
        }, postDelay);
    }

    public void add(Integer preDelay, Callable callable, Integer postDelay) {
        this.add(event -> {
        }, preDelay, callable, event -> {
        }, postDelay);
    }

    public void add(EventHandler<ActionEvent> preEventHandler, EventHandler<ActionEvent> postEventHandler, Integer postDelay) {
        this.add(preEventHandler, null, () -> null, postEventHandler, postDelay);
    }

    public void add(Integer preDelay, EventHandler<ActionEvent> postEventHandler, Integer postDelay) {
        this.add(event -> {
        }, preDelay, () -> null, postEventHandler, postDelay);
    }

    public void add(Callable callable, EventHandler<ActionEvent> postEventHandler, Integer postDelay) {
        this.add(event -> {
        }, null, callable, postEventHandler, postDelay);
    }

    public void add(EventHandler<ActionEvent> preEventHandler, Integer preDelay) {
        add(preEventHandler, preDelay, () -> null, event -> {
        }, null);
    }

    public void add(EventHandler<ActionEvent> preEventHandler, Callable callable) {
        add(preEventHandler, null, callable, event -> {
        }, null);
    }

    public void add(EventHandler<ActionEvent> preEventHandler, EventHandler<ActionEvent> postEventHandler) {
        add(preEventHandler, null, () -> null, postEventHandler, null);
    }

    public void add(Integer preDelay, Callable callable) {
        add(event -> {
        }, preDelay, callable, event -> {
        }, null);
    }

    public void add(Integer preDelay, EventHandler<ActionEvent> postEventHandler) {
        add(event -> {
        }, preDelay, () -> null, postEventHandler, null);
    }

    public void add(Integer preDelay, Integer postDelay) {
        add(event -> {
        }, preDelay, () -> null, event -> {
        }, postDelay);
    }

    public void add(Callable callable, EventHandler<ActionEvent> postEventHandler) {
        add(event -> {
        }, null, callable, postEventHandler, null);
    }

    public void add(Callable callable, Integer postDelay) {
        add(event -> {
        }, null, callable, event -> {
        }, postDelay);
    }

    public void add(EventHandler<ActionEvent> preEventHandler) {
        add(preEventHandler, null, () -> null, event -> {
        }, null);
    }

    public void add(Integer preDelay) {
        add(event -> {
        }, preDelay, () -> null, event -> {
        }, null);
    }

    public void add(Callable callable) {
        add(event -> {
        }, null, callable, event -> {
        }, null);
    }

    private Timeline recursive(int i) {
        if (i == callableList.size() - 1)
            preTimelineList.get(i).setOnFinished(preEvent -> new AsyncCallable(callableList.get(i), false, () -> {
            }, () -> postTimelineList.get(i).play()).start());
        else
            preTimelineList.get(i).setOnFinished(preEvent -> new AsyncCallable(callableList.get(i), false, () -> {
            }, () -> {
                postTimelineList.get(i).setOnFinished(postEvent -> recursive(i + 1).play());
                postTimelineList.get(i).play();
            }).start());

        return preTimelineList.get(i);
    }

    public void start() {
        recursive(0).play();
    }
}
