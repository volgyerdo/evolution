/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volgyerdo.evolution.logic;

import volgyerdo.commons.math.probability.ProbabilityVariable;

/**
 *
 * @author Volgyerdo Nonprofit Kft.
 */
public class EvolutionConstants {

    public static final ProbabilityVariable DEFAULT_POPULATION_SIZE 
            = new ProbabilityVariable(1.0E2, 1.0E1);
    
    public static final ProbabilityVariable DEFAULT_GENETIC_MUTATION_RATE
            = new ProbabilityVariable(1.0E-6, 1.0E-7);
    
    public static final ProbabilityVariable DEFAULT_RADIATION_MUTATION_RATE 
            = new ProbabilityVariable(1.0E-10, 1.0E-11);
    
    public static final ProbabilityVariable DEFAULT_FUSION_BLOCK_SIZE 
            = new ProbabilityVariable(1.0E6, 1.0E5);
    
    public static final ProbabilityVariable DEFAULT_JUMP_BLOCK_SIZE 
            = new ProbabilityVariable(1.0E3, 1.0E2);
    
    public static final ProbabilityVariable DEFAULT_JUMP_FREQUENCY 
            = new ProbabilityVariable(1.0E-3, 1.0E-2);
    
    private EvolutionConstants() {
    }
    
}
