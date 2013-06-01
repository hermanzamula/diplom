package com.managehelper.model.impl;

import com.managehelper.model.Team;
import com.managehelper.model.TeamRateEvaluator;

public class TeamRateEvaluatorImpl implements TeamRateEvaluator {

    @Override
    public double evaluateIndex(int[][] array, Team team) {
        int n = team.getParticipants();
        if (n == 0) {
            throw new IllegalArgumentException("Number of participants is null");
        }

        int VP = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((array[i][j] == array[j][i]) && (array[i][j] == 1)) {
                    VP = +1;
                }
            }
        }
        return VP / (double) n * ((double) n - 1.d);
    }

    @Override
    public double evaluateGroupUnity(int[][] array, Team team) {
        int n = team.getParticipants();
        if (n == 0) {
            throw new IllegalArgumentException("Number of participants is null");
        }

        int VP = 0;
        int VO = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((array[i][j] == array[j][i]) && (array[i][j] == 1)) {
                    VP = +1;
                }
                if ((array[i][j] == array[j][i]) && (array[i][j] == 0)) {
                    VO = +1;
                }
            }
        }
        return (VP - VO) / (double) n * ((double) n - 1.d);
    }

    @Override
    public double evaluateMedianaPlus(int[][] array, Team team) {
        int resoult = 0;
        int n = team.getParticipants();
        if (n == 0) {
            throw new IllegalArgumentException("Number of participants is null");
        }
        int massiv[] = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] == 1) {
                    massiv[i] = +1;
                }

            }
        }
        sort(massiv);
        if (n % 2 == 0) {
            resoult = massiv[(massiv.length / 2) + 1];

        } else {
            resoult = massiv[(massiv.length + 1) / 2];

        }
        return resoult;
    }

    @Override
    public double evaluateMedianaMinus(int[][] array, Team team) {

        int resoult = 0;
        int n = team.getParticipants();
        if (n == 0) {
            throw new IllegalArgumentException("Number of participants is null");
        }
        int massiv[] = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] == 0) {
                    massiv[i] = +1;
                }

            }
        }
        sort(massiv);
        if (n % 2 == 0) {
            resoult = massiv[(massiv.length / 2) + 1];

        } else {
            resoult = massiv[(massiv.length + 1) / 2];

        }
        return resoult;
    }

    @Override
    public double[][] normalize(double array[][], boolean isMax, int NumOfGroups) {
        int n = NumOfGroups;
        double best;
        double worst;
        double max = array[0][0];
        double min = array[0][0];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < n; j++) {
                if (array[j][i] < min) {
                    min = array[j][i];
                }
                if (array[j][i] > max) {
                    max = array[j][i];
                }
            }
            best = max;
            worst = min;
            // тут нужно будет указать, best,worst под соответствующее условие;


            for (int j = 0; j < n; j++) {

                array[j][i] = norm(best, worst, array[j][i]);
            }
        }
        return array;
    }

    @Override
    public double[] evaluateTeamRate(int NumOfGroups, double arrayAfterNormolize[][], double indexRate,
                                     double unityRate, double plusRate, double minusRate, double ratingRate) {
        int n = NumOfGroups;
        double kof = 0;
        double massiv[] = new double[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                if (j == 0) {
                    kof = indexRate;
                }
                if (j == 1) {
                    kof = unityRate;
                }
                if (j == 2) {
                    kof = plusRate;
                }
                if (j == 3) {
                    kof = minusRate;
                }
                if (j == 4) {
                    kof = ratingRate;
                }

                massiv[i] = massiv[i] + (kof * arrayAfterNormolize[i][j]);
            }

        }
        return massiv;
    }

    public double[] evaluateRating(double arrayBeforNormolize[][], int NumOfGroups) {
        int n = NumOfGroups;
        double sum = 0;
        double massiv[] = new double[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                massiv[i] = massiv[i] + (1 - arrayBeforNormolize[i][j]);
            }

        }
        for (int i = 0; i < massiv.length; i++) {
            massiv[i] = Math.sqrt(massiv[i]);
        }
        return massiv;
    }

    public void sort(int[] mass) {
        int tempo = 0;
        for (int i = 0; i < mass.length - 1; i++) {
            for (int j = i + 1; j < mass.length; j++) {
                if (mass[i] > mass[j]) {
                    tempo = mass[j];
                    mass[j] = mass[i];
                    mass[i] = tempo;
                }
            }
        }

    }

    public double norm(double best, double worst, double current) {

        return (current - worst) / (best - worst);

    }
}
