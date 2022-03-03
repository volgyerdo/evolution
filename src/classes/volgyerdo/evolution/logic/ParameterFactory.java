/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volgyerdo.evolution.logic;

import volgyerdo.evolution.structure.Parameters;

/**
 *
 * @author Volgyerdo Nonprofit Kft.
 */
public class ParameterFactory {

    public static Parameters createDefaultParameters(){
        Parameters parameters = new Parameters();
        
        parameters.maxPopulationSize = EvolutionConstants.DEFAULT_MAX_POPULATION_SIZE;
        parameters.divisionRate = EvolutionConstants.DEFAULT_DIVISION_RATE;
        parameters.divisionMutationRate = EvolutionConstants.DEFAULT_DIVISION_MUTATION_RATE;
        parameters.ageMutationRate = EvolutionConstants.DEFAULT_AGE_MUTATION_RATE;
        parameters.fusionRate = EvolutionConstants.DEFAULT_FUSION_RATE;
        parameters.fusionBlockSize = EvolutionConstants.DEFAULT_FUSION_BLOCK_SIZE;
        parameters.jumpBlockSize = EvolutionConstants.DEFAULT_JUMP_BLOCK_SIZE;
        parameters.jumpRate = EvolutionConstants.DEFAULT_JUMP_RATE;
        
        return parameters;
    }
    
    private ParameterFactory() {
    }
    
}
