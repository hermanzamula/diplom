package com.managehelper.model;


import java.util.List;

public interface TeamRateEvaluator {
    double evaluateIndex(int array[][], Team team);

    double evaluateGroupUnity(int array[][], Team team);

    double evaluateMedianaPlus(int array[][], Team team);

    double evaluateMedianaMinus(int array[][], Team team);

    double normalize(double min, double max, double current, boolean isMax);

    double evaluateTeamRate(Team team, double indexRate, double unityRate, double plusRate, double minusRate);
}
