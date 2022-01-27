/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volgyerdo.evolution.logic;

import volgyerdo.evolution.structure.EvolutionParameters;

/**
 *
 * @author Volgyerdo Nonprofit Kft.
 */
public class EvolutionParametersFactory {

    public static EvolutionParameters createDefaultParameters(){
        EvolutionParameters parameters = new EvolutionParameters();
        
        parameters.populationSize = EvolutionConstants.DEFAULT_POPULATION_SIZE;
        parameters.geneticMutationRate = EvolutionConstants.DEFAULT_GENETIC_MUTATION_RATE;
        parameters.radiationMutationRate = EvolutionConstants.DEFAULT_RADIATION_MUTATION_RATE;
        parameters.fusionBlockSize = EvolutionConstants.DEFAULT_FUSION_BLOCK_SIZE;
        parameters.jumpBlockSize = EvolutionConstants.DEFAULT_JUMP_BLOCK_SIZE;
        parameters.jumpFrequency = EvolutionConstants.DEFAULT_JUMP_FREQUENCY;
        
        return parameters;
    }
    
    private EvolutionParametersFactory() {
    }
    
}
