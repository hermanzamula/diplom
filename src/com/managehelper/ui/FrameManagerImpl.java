package com.managehelper.ui;

import com.managehelper.model.ApplicationContext;
import com.managehelper.ui.frames.FinalFrame;
import com.managehelper.ui.frames.InputFrame;
import com.managehelper.ui.frames.TableFrame;

import java.util.ArrayList;
import java.util.List;

public final class FrameManagerImpl implements FrameManager<ApplicationContext> {

    private static final List<ManageFrame> FRAMES = new ArrayList<ManageFrame>() {
        {
            add(new InputFrame());
            add(new TableFrame());
            add(new FinalFrame());
        }
    };
    private int current = 0;

    public void next(ApplicationContext context) {
        FRAMES.get(current).close();
        current++;
        FRAMES.get(current).open(context);
    }

    @Override
    public void init(ApplicationContext context) {
        FRAMES.get(0).open(context);
    }

    public void previous(ApplicationContext context) {
        FRAMES.get(current).close();
        current--;
        FRAMES.get(current).open(context);
    }

}