package com.managehelper.model;


public interface TeamRateEvaluator {
    double evaluateIndex(int array[][], Team team);

    double evaluateGroupUnity(int array[][], Team team);

    double evaluateMedianaPlus(int array[][], Team team);

    double evaluateMedianaMinus(int array[][], Team team);

    double[][] normalize(double arrayO[][], int NumOfGroups);

    double[] evaluateRating(double arrayO[][], int NumOfGroups);

    double[] evaluateTeamRate(int NumOfGroups, double arrayAfterNormolize[][], double weights[]);

}
