package com.managehelper.test;


import com.managehelper.model.TeamRateEvaluator;
import com.managehelper.model.impl.TeamRateEvaluatorImpl;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;

public class EvaluateTeamRateTest {

    public static final double[][] DOUBLES = {{0.0833333, 2.25, 0.6, 0.6, 13.0}, {0.0333333, 2.25, 0.1, 0.1, 23.0}};
    TeamRateEvaluator evaluator = new TeamRateEvaluatorImpl();

    @Test
    public void testNormilize() {
        double array[][] = {{0.0833333, 2.25, 0.6, 0.6, 13.0}, {0.0333333, 2.25, 0.1, 0.1, 23.0}};

        evaluator.normalize(array, 2);
        assertFalse(Double.isNaN(array[0][0]));
    }

    @Test
    public void testEvluateRaiting() {

        final double[] result = evaluator.evaluateRating(DOUBLES, 2);
        assertFalse(Double.isNaN(result[0]));
    }
}
