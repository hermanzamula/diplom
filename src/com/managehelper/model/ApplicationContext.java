package com.managehelper.model;

import com.managehelper.model.impl.TeamRateEvaluatorImpl;

import java.util.ArrayList;
import java.util.List;

public class ApplicationContext {

    List<Integer> tableValues = new ArrayList<Integer>();
    int numOfGroups = 0;
    int numOfParticipants = 0;
    private TeamRateEvaluator evaluator = new TeamRateEvaluatorImpl();

    private boolean isError = false;

    public int getNumOfParticipants() {
        return numOfParticipants;
    }

    public void setNumOfParticipants(int numOfParticipants) {
        this.numOfParticipants = numOfParticipants;
    }

    public int getNumOfGroups() {
        return numOfGroups;
    }

    public void setNumOfGroups(int numOfGroups) {
        this.numOfGroups = numOfGroups;
    }

    public TeamRateEvaluator getEvaluator() {
        return evaluator;
    }

    public boolean isError() {
        return isError;
    }

    public void setError(boolean error) {
        isError = error;
    }
}
