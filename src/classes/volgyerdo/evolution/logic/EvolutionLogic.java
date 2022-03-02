/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volgyerdo.evolution.logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import volgyerdo.commons.math.probability.Distribution;
import volgyerdo.evolution.structure.Aging;
import volgyerdo.evolution.structure.Aspects;
import volgyerdo.evolution.structure.Evolution;
import volgyerdo.evolution.structure.Individual;
import volgyerdo.evolution.structure.Living;
import volgyerdo.evolution.structure.Mutation;
import volgyerdo.evolution.structure.Parameters;
import volgyerdo.evolution.structure.Prototyping;

/**
 *
 * @author Volgyerdo Nonprofit Kft.
 */
public class EvolutionLogic {

    public static void evolve(Evolution evolution) {
        List<Individual> population = evolution.population;
        Aspects aspects = evolution.aspects;
        Parameters parameters = evolution.parameters;
        prototyping(population, aspects.prototyping);
        Map<Individual, Double> ages = getAges(population, aspects.aging);
        living(population, aspects.living);
        Map<Individual, Double> newAges = getAges(population, aspects.aging);
        Map<Individual, Double> deltaAges = getDeltaAges(ages, newAges);
        ageMutation(population, deltaAges, aspects.mutation, parameters.ageMutationRate);
    }

    private static void prototyping(List<Individual> population, Prototyping prototyping) {
        if (population.isEmpty()) {
            population.add(prototyping.prototype());
        }
    }

    private static Map<Individual, Double> getAges(List<Individual> population, Aging aging) {
        Map<Individual, Double> ages = new HashMap<>();
        for (Individual individual : population) {
            ages.put(individual, aging.age(individual));
        }
        return ages;
    }

    private static Map<Individual, Double> getDeltaAges(Map<Individual, Double> ages, Map<Individual, Double> newAges) {
        Map<Individual, Double> delta = new HashMap<>();
        for (Individual individual : ages.keySet()) {
            delta.put(individual, newAges.get(individual) - ages.get(individual));
        }
        return delta;
    }

    private static void living(List<Individual> population, Living living) {
        for (Individual individual : population) {
            living.live(individual);
        }
    }

    private static void ageMutation(List<Individual> population, Map<Individual, Double> deltaAges, Mutation mutation, Distribution ageMutationRate) {
        for (Individual individual : population) {
            int mutationCount = (int) (Math.round(ageMutationRate.sample()) * deltaAges.get(individual));
            while (mutationCount-- > 0) {
                mutation.mutate(individual);
            }
        }
    }

    private EvolutionLogic() {
    }

}
