/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volgyerdo.evolution.structure;

import volgyerdo.commons.math.probability.ProbabilityVariable;

/**
 *
 * @author Volgyerdo Nonprofit Kft.
 */
public class EvolutionParameters implements Individual{
    
    public ProbabilityVariable populationSize;
    public ProbabilityVariable geneticMutationRate;
    public ProbabilityVariable radiationMutationRate;
    public ProbabilityVariable fusionBlockSize;
    public ProbabilityVariable jumpBlockSize;
    public ProbabilityVariable jumpFrequency;
    
}
