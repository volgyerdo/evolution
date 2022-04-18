/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volgyerdo.evolution.formulatest;

import volgyerdo.commons.math.probability.Distribution;
import volgyerdo.evolution.structure.Jumping;

/**
 *
 * @author Volgyerdo Nonprofit Kft.
 */
public class FormulaJumping implements Jumping<Formula> {

    @Override
    public void jump(Formula individual1, Formula individual2, Distribution blockSize) {
        int size = Math.max(1, (int) blockSize.sample());
        int start = (int) (Math.random() * (Math.max(0, individual1.text.length() - size)));
        if(individual1.text.length() < start + size){
            return;
        }
        if (individual1.text.length() <= individual2.text.length()) {
            individual2.text = individual2.text.substring(0, start)
                    + individual1.text.substring(start, start + size)
                    + individual2.text.substring(start + size, individual2.text.length());
        } else if (individual2.text.length() > start + size) {
            individual2.text = individual2.text.substring(0, Math.min(individual2.text.length(), start))
                    + individual1.text.substring(start, start + size)
                    + individual2.text.substring(start + size, individual2.text.length());
        } else {
            individual2.text = individual2.text.substring(0, Math.min(individual2.text.length(), start))
                    + individual1.text.substring(start, start + size);
        }
    }

}
