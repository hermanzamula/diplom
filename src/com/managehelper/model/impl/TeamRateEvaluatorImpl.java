package com.managehelper.model.impl;

import com.managehelper.model.Team;
import com.managehelper.model.TeamRateEvaluator;

import java.util.Arrays;

public class TeamRateEvaluatorImpl implements TeamRateEvaluator {

    @Override
    public double evaluateIndex(int[][] array, Team team) {

        double n = team.getParticipants();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j==(n-1)){
                    System.out.print(array[i][j]+" "+"\n");
                }
                else{
                    System.out.print(array[i][j]+" ");
                }
            }
        }
        if (n == 0) {
            throw new IllegalArgumentException("Number of participants is null");
        }

        double VP = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((array[i][j] == array[j][i]) && (array[i][j] == 1)) {
                    VP++;
                }
            }
        }

        final double v = VP / ( n * ( n - 1));
        System.out.println(v);
        System.out.println("________");
        team.setIndex(v);
        return v;
    }

    @Override
    public double evaluateGroupUnity(int[][] array, Team team) {
        int n = team.getParticipants();
        double VO=0;
        if (n == 0) {
            throw new IllegalArgumentException("Number of participants is null");
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i==j)|(array[i][j])==-1) {
                    continue;
                }
                else{
                    VO++;
                }
            }
        }

        final double v = VO/n;
        System.out.println(v);
        System.out.println("________");
        team.setGroupUnity(v);
        return v;
    }

    @Override
    public double evaluateMedianaPlus(int[][] array, Team team) {
        double result = 0;
        int n = team.getParticipants();
        if (n == 0) {
            throw new IllegalArgumentException("Number of participants is null");
        }
        double massiv[] = new double[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i==j)
                    continue;
                if(array[j][i]!=-1){
                    massiv[i]++;
                }
            }

        }


        for (int i = 0; i < massiv.length; i++) {
            massiv[i]= massiv[i]/ 5.d;
        }
        sort(massiv);
        if (n % 2 == 0) {
            result = massiv[(massiv.length / 2) + 1];

        } else {
            result = massiv[(massiv.length + 1) / 2];

        }
        System.out.println(result);
        System.out.println("________");
        team.setMedianaPlus(result);
        return result;
    }

    @Override
    public double evaluateMedianaMinus(int[][] array, Team team) {

        double result = 0;
        int n = team.getParticipants();
        if (n == 0) {
            throw new IllegalArgumentException("Number of participants is null");
        }
        double massiv[] = new double[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i==j)
                    continue;
                if(array[i][j]!=-1){
                    massiv[i]++;
                }
            }

        }


        for (int i = 0; i < massiv.length; i++) {
            massiv[i]= massiv[i]/ 5.d;
        }
        sort(massiv);
        if (n % 2 == 0) {
            result = massiv[(massiv.length / 2) + 1];

        } else {
            result = massiv[(massiv.length + 1) / 2];

        }
        System.out.println(result);
        System.out.println("________");
        team.setMedianaMinus(result);
        return result;
    }

    @Override
    public double[][] normalize(double arrayO[][], int NumOfGroups) {

        double best;
        double worst;
        double max = arrayO[0][0];
        double min = arrayO[0][0];
        for (double[] anArrayO1 : arrayO) {
            for (int j = 0; j < arrayO.length; j++) {
                if (j == (arrayO.length - 1)) {
                    System.out.print(anArrayO1[j] + " " + "\n");
                } else {
                    System.out.print(anArrayO1[j] + " ");
                }
            }
        }
        System.out.print("_________________"+"\n");
        for (int i = 0; i < 5; i++) {
            min=arrayO[0][i];
            max=arrayO[0][i];
            for (int j = 0; j < NumOfGroups; j++) {
                if (arrayO[j][i] < min) {
                    min = arrayO[j][i];
                }
                if (arrayO[j][i] > max) {
                    max = arrayO[j][i];
                }
            }
            best = max;
            worst = min;
            System.out.println(max+" "+min+"\n");


            for (int j = 0; j < NumOfGroups; j++) {
                arrayO[j][i] = Math.rint(100.0 *norm(best, worst, arrayO[j][i])) / 100.0;
            }

        }
        for (double[] anArrayO : arrayO) {
            for (int j = 0; j < arrayO.length; j++) {
                if (j == (arrayO.length - 1)) {
                    System.out.print(anArrayO[j] + " " + "\n");
                } else {
                    System.out.print(anArrayO[j] + " ");
                }
            }
        }
        return arrayO;
    }

    @Override
    public double[] evaluateTeamRate(int NumOfGroups, double arrayAfterNormolize[][], double weights[]) {
        double kof = 0;
        double massiv[] = new double[NumOfGroups];
        for (int i = 0; i < NumOfGroups; i++) {
            for (int j = 0; j < 6; j++) {
                kof = weights[j];
                massiv[i] = massiv[i] + (kof * arrayAfterNormolize[i][j]);
            }

        }
        return massiv;
    }

    @Override
    public double[] evaluateRating(double arrayO[][], int NumOfGroups) {
        double massiv[] = new double[NumOfGroups];
        for (double[] anArrayO : arrayO) {
            for (int j = 0; j < arrayO.length; j++) {
                System.out.println(arrayO);
            }
        }
        for (int i = 0; i < NumOfGroups; i++) {
            for (int j = 0; j < 5; j++) {
                massiv[i] = massiv[i] + (1 - arrayO[i][j]);
            }

        }
        for (int i = 0; i < massiv.length; i++) {
            massiv[i] = Math.sqrt(massiv[i]);
        }
        return massiv;
    }

    private void sort(double[] mass) {
        double tempo;
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

    private double norm(double best, double worst, double current) {
        return (current - worst) / (best - worst);
    }
}
