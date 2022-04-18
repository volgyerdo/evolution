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
public interface Jumping<T extends Individual> extends Aspect<T>{
    
    /* A randomly selected block is jumped from one individual to another. */
    public void jump(T individual1, T individual2, Distribution blockSize);
    
}
