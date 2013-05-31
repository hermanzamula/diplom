package com.managehelper.ui;

import java.util.ArrayList;
import java.util.List;

public final class FrameManager {
    private static final List<ManageFrame> FRAMES = new ArrayList<ManageFrame>(){
        {
            add(new InputFrame());
            add(new TableFrame());
            add(new FinalFrame());
        }
    };

    public void nextFrame(){
    }

    public void previousFrame(){

    }

    private static class ManageFrameArrayList extends ArrayList<ManageFrame> {
        {
            add(new InputFrame());
            add(new TableFrame());
            add(new FinalFrame());
        }
    }
}