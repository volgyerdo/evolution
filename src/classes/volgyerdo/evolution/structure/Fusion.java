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
public interface Fusion<T extends Individual> extends Aspect<T>{
    
    /* Fusion of two individuals. The individuals are separated into blocks
    and the blocks are randomly merged into a new individual. */
    public Individual fuse(T individual1, T individual2, Distribution blockSize);
    
}
