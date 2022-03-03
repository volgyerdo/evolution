/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volgyerdo.evolution.structure;

import volgyerdo.commons.math.probability.Distribution;

/**
 *
 * @author Volgyerdo Nonprofit Kft.
 */
public interface Jumping extends Aspect{
    
    /* A randomly selected block is jumped from one individual to another. */
    public void jump(Individual individual1, Individual individual2, Distribution blockSize);
    
}
