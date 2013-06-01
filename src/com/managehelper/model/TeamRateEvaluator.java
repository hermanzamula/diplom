package com.managehelper.model;


public interface TeamRateEvaluator {
    double evaluateIndex(int array[][], Team team);

    double evaluateGroupUnity(int array[][], Team team);

    int evaluateMedianaPlus(int array[][], Team team);

    int evaluateMedianaMinus(int array[][], Team team);

    double[][] normalize(double array[][], boolean isMax, int NumOfGroups);

    double[] evaluateRating(double arrayBeforNormolize[][], int NumOfGroups);

    double[] evaluateTeamRate(int NumOfGroups, double arrayAfterNormolize[][], double weights[]);

}
