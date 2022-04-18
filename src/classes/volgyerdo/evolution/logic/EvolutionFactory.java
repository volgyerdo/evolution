/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volgyerdo.evolution.logic;

import java.util.List;
import volgyerdo.evolution.structure.Aspects;
import volgyerdo.evolution.structure.Evolution;
import volgyerdo.evolution.structure.Individual;
import volgyerdo.evolution.structure.Parameters;

/**
 *
 * @author Volgyerdo Nonprofit Kft.
 */
public class EvolutionFactory {

    public static Evolution createEvolution(Aspects aspects) {
        Evolution evolution = new Evolution();
        evolution.aspects = aspects;
        evolution.parameters = ParameterFactory.createDefaultParameters();
        evolution.population = PopulationFactory.createEmptyPopulation();
        return evolution;
    }
    
    public static Evolution createEvolution(Aspects aspects, Parameters parameters) {
        Evolution evolution = new Evolution();
        evolution.aspects = aspects;
        evolution.parameters = parameters;
        evolution.population = PopulationFactory.createEmptyPopulation();
        return evolution;
    }
    
    public static Evolution createEvolution(Aspects aspects, Parameters parameters, List<Individual> individuals) {
        Evolution evolution = new Evolution();
        evolution.aspects = aspects;
        evolution.parameters = parameters;
        evolution.population = PopulationFactory.createPopulation(individuals);
        return evolution;
    }

    private EvolutionFactory() {
    }

}
