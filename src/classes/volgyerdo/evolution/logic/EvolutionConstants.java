/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volgyerdo.evolution.logic;

import volgyerdo.commons.math.probability.Distribution;
import volgyerdo.commons.math.probability.NormalDistribution;

/**
 *
 * @author Volgyerdo Nonprofit Kft.
 */
public class EvolutionConstants {

    public static final Distribution DEFAULT_MAX_POPULATION_SIZE 
            = new NormalDistribution(1.0E2, 1.0E1);
    
    public static final Distribution DEFAULT_DIVISION_MUTATION_RATE
            = new NormalDistribution(1.0E-6, 1.0E-7);
    
    public static final Distribution DEFAULT_AGE_MUTATION_RATE 
            = new NormalDistribution(1.0E-10, 1.0E-11);
    
    public static final Distribution DEFAULT_FUSION_BLOCK_SIZE 
            = new NormalDistribution(1.0E6, 1.0E5);
    
    public static final Distribution DEFAULT_JUMP_BLOCK_SIZE 
            = new NormalDistribution(1.0E3, 1.0E2);
    
    public static final Distribution DEFAULT_JUMP_RATE 
            = new NormalDistribution(1.0E-3, 1.0E-2);
    
    private EvolutionConstants() {
    }
    
}
