/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volgyerdo.evolution.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import volgyerdo.evolution.structure.Aspects;
import volgyerdo.evolution.structure.Evolution;
import volgyerdo.evolution.structure.Individual;
import volgyerdo.evolution.structure.Parameters;

/**
 *
 * @author Volgyerdo Nonprofit Kft.
 */
public class EvolutionLogic {

    public static void evolve(Evolution evolution) {
        prototyping(evolution);

        Map<Individual, Double> ages = getAges(evolution);

        living(evolution);

        Map<Individual, Double> newAges = getAges(evolution);
        Map<Individual, Double> deltaAges = getDeltaAges(ages, newAges);

        ageMutation(evolution, deltaAges);

        jumping(evolution);

        division(evolution);

        fusion(evolution);
    }

    private static void prototyping(Evolution evolution) {
        List<Individual> population = evolution.population;
        Aspects aspects = evolution.aspects;
        if (population.isEmpty()) {
            population.add(aspects.prototyping.prototype());
        }
    }

    private static Map<Individual, Double> getAges(Evolution evolution) {
        List<Individual> population = evolution.population;
        Aspects aspects = evolution.aspects;
        Map<Individual, Double> ages = new HashMap<>();
        for (Individual individual : population) {
            ages.put(individual, aspects.aging.age(individual));
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

    private static void living(Evolution evolution) {
        List<Individual> population = evolution.population;
        Aspects aspects = evolution.aspects;
        for (Individual individual : population) {
            aspects.living.live(individual);
        }
    }

    private static void ageMutation(Evolution evolution, Map<Individual, Double> deltaAges) {
        List<Individual> population = evolution.population;
        Aspects aspects = evolution.aspects;
        Parameters parameters = evolution.parameters;
        for (Individual individual : population) {
            int mutationCount = (int) (Math.round(parameters.ageMutationRate.sample()) * deltaAges.get(individual));
            while (mutationCount-- > 0) {
                aspects.mutation.mutate(individual);
            }
        }
    }

    private static void jumping(Evolution evolution) {
        List<Individual> population = evolution.population;
        Aspects aspects = evolution.aspects;
        Parameters parameters = evolution.parameters;
        if (population.size() < 2) {
            return;
        }
        int jumpCount = (int) Math.round(parameters.jumpRate.sample());
        while (jumpCount-- > 0) {
            Individual[] individuals = PopulationLogic.randomSelectTwo(population);
            aspects.jumping.jump(individuals[0], individuals[1], parameters.jumpBlockSize);
        }
    }

    private static void division(Evolution evolution) {
        List<Individual> population = evolution.population;
        Aspects aspects = evolution.aspects;
        Parameters parameters = evolution.parameters;
        int divisionCount = (int) Math.round(parameters.divisionRate.sample());
        while (divisionCount-- > 0) {
            Individual individual = PopulationLogic.randomSelect(population);
            individual = aspects.division.divide(individual);
            int mutationRate = (int) Math.round(parameters.divisionMutationRate.sample());
            while (mutationRate-- > 0) {
                aspects.mutation.mutate(individual);
            }
            population.add(individual);
        }
    }

    private static void fusion(Evolution evolution) {
        List<Individual> population = evolution.population;
        Aspects aspects = evolution.aspects;
        Parameters parameters = evolution.parameters;
        int fusionCount = (int) Math.round(parameters.fusionRate.sample());
        while (fusionCount-- > 0) {
            if (population.size() < 2) {
                return;
            }
            Individual[] bestPair = getBestPair(evolution);
            Individual newIndividual = aspects.fusion.fuse(bestPair[0], bestPair[1], parameters.fusionBlockSize);
            population.add(newIndividual);
        }

    }

    private static Individual[] getBestPair(Evolution evolution) {
        Aspects aspects = evolution.aspects;
        TreeMap<Double, Individual[]> ranking = new TreeMap<>();
        List<Object[]> evaluation = getEvaluation(evolution);
        for (int i = 0; i < evaluation.size(); i++) {
            for (int j = 0; j < evaluation.size(); j++) {
                if (i != j) {
                    ranking.put(((Double) evaluation.get(i)[1])
                            * ((Double) evaluation.get(j)[1])
                            / aspects.similarity.similar((Individual) evaluation.get(i)[0],
                                    (Individual) evaluation.get(j)[0]),
                            new Individual[]{(Individual) evaluation.get(i)[0],
                                (Individual) evaluation.get(j)[0]});
                }
            }
        }
        return ranking.lastEntry().getValue();
    }

    private static List<Object[]> getEvaluation(Evolution evolution) {
        List<Individual> population = evolution.population;
        Aspects aspects = evolution.aspects;
        List<Object[]> values = new ArrayList<>();
        for (Individual individual : population) {
            values.add(new Object[]{
                individual, aspects.evaluation.evaluate(individual)});
        }
        return values;
    }

    private EvolutionLogic() {
    }

}
