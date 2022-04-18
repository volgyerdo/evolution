/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volgyerdo.evolution.formulatest;

import volgyerdo.commons.math.formula.SimpleFormulaEvaluator;
import volgyerdo.evolution.structure.Evaluation;

/**
 *
 * @author Volgyerdo Nonprofit Kft.
 */
public class FormulaEvaluation implements Evaluation<Formula> {

    @Override
    public double evaluate(Formula formula) {
        final double expected = 128;
        try {
            double error = Math.abs(expected - SimpleFormulaEvaluator.eval(formula.text));
            return error == 0 ? Double.MAX_VALUE : (1 / error);
        } catch (Exception e) {
            return 0;
        }
    }

}
