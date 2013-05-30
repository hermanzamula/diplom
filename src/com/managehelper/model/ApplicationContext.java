package com.managehelper.model;

import com.managehelper.model.impl.TeamRateEvaluatorImpl;

import java.util.ArrayList;
import java.util.List;

public class ApplicationContext {

    int numOfGroups = 0;
    int numOfParticipants = 0;
    private TeamRateEvaluator evaluator = new TeamRateEvaluatorImpl();

    private final List<Team> teams = new ArrayList<Team>();

    private final double weights[] = new double[5];

    private boolean isError = false;

    private boolean unfinishedState = true;

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

    public boolean isUnfinishedState() {
        return unfinishedState;
    }

    public void setUnfinishedState(boolean unfinishedState) {
        this.unfinishedState = unfinishedState;
    }

    public double[] getWeights() {
        return weights;
    }

    public List<Team> getTeams() {
        return teams;
    }
}
