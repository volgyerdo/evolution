/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volgyerdo.evolution.formulatest;

import volgyerdo.commons.math.probability.Distribution;
import volgyerdo.evolution.structure.Fusion;

/**
 *
 * @author Volgyerdo Nonprofit Kft.
 */
public class FormulaFusion implements Fusion<Formula> {

    @Override
    public Formula fuse(Formula formula1, Formula formula2, Distribution blockSize) {
        String result = "";
        int pos = 0;
        int end = 0;
        String source;
        do {
            int size = (int) blockSize.sample();
            end = pos + size;
            source = Math.random() < 0.5 ? formula1.text : formula2.text;
            end = Math.min(end, source.length());
            if (end - pos > 0) {
                result += source.substring(pos, end);
            }
            pos = end;
        } while (pos < source.length());
        return new Formula(result);
    }


}
