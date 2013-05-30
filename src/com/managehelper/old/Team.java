package com.managehelper.old;

import static java.lang.System.*;

public class Team {

	private int a;
	static private double ZatratiNaObychenie;
	private int matrix[][];

	Team(int a) {
		this.a = a;
		matrix = new int[a][a];
		
	}

	public void method() {
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < a; j++) {
				out.print(matrix[i][j] + "\n");
			}
		}
	}

	public void setA(int number) {
		a = number;
	}

	public int getA() {
		return a;
	}

	public void setZatratiNaObychenie(int number) {
		ZatratiNaObychenie = number;
	}

	public double getZatratiNaObychenie() {
		return ZatratiNaObychenie;
	}
	public void setMatrix(int massiv[][]) {
		for (int i = 0; i < massiv.length; i++) {
            arraycopy(massiv[i], 0, matrix[i], 0, massiv.length);
		}

	}

	public void getMatrix() {
        for (int[] aMatrix : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                out.println(aMatrix[j]);

            }
        }
	}
}