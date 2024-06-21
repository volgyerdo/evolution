/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volgyerdo.evolution.logic;

import java.util.ArrayList;
import java.util.List;
import volgyerdo.evolution.structure.Aspects;
import volgyerdo.evolution.structure.Entity;
import volgyerdo.evolution.structure.Evolution;
import volgyerdo.evolution.structure.Parameters;

/**
 *
 * @author Volgyerdo Nonprofit Kft.
 */
public class EvolutionLogic {

    public static void evolve(Evolution evolution) {
        prototyping(evolution);

        ageMutation(evolution);

        jumping(evolution);

        division(evolution);

        List<Object[]> evaluation = getEvaluation(evolution);

        fusion(evolution, evaluation);

        death(evolution, evaluation);

        aging(evolution);
    }

    private static void prototyping(Evolution evolution) {
        List<Entity> population = evolution.population;
        Aspects aspects = evolution.aspects;
        if (population.isEmpty()) {
            population.add(PopulationFactory.createEntity(aspects.prototyping.prototype()));
        }
    }

    private static void aging(Evolution evolution) {
        List<Entity> population = evolution.population;
        for (Entity individual : population) {
            individual.age++;
        }
    }

    private static void ageMutation(Evolution evolution) {
        List<Entity> population = evolution.population;
        Aspects aspects = evolution.aspects;
        Parameters parameters = evolution.parameters;
        for (Entity entity : population) {
            int mutationCount = (int) (Math.round(parameters.ageMutationRate.sample()));
            while (mutationCount-- > 0) {
                aspects.mutation.mutate(entity.individual);
            }
        }
    }

    private static void jumping(Evolution evolution) {
        List<Entity> population = evolution.population;
        Aspects aspects = evolution.aspects;
        Parameters parameters = evolution.parameters;
        if (population.size() < 2) {
            return;
        }
        int jumpCount = (int) Math.round(parameters.jumpRate.sample());
        while (jumpCount-- > 0) {
            Entity[] entities = PopulationLogic.randomSelectTwo(population);
            aspects.jumping.jump(entities[0].individual, entities[1].individual,
                    parameters.jumpBlockSize);
        }
    }

    private static void division(Evolution evolution) {
        List<Entity> population = evolution.population;
        Aspects aspects = evolution.aspects;
        Parameters parameters = evolution.parameters;
        int divisionCount = (int) Math.round(parameters.divisionRate.sample());
        while (divisionCount-- > 0) {
            Entity entity = PopulationLogic.randomSelect(population);
            entity = PopulationFactory.createEntity(aspects.division.divide(entity.individual));
            int mutationRate = (int) Math.round(parameters.divisionMutationRate.sample());
            while (mutationRate-- > 0) {
                aspects.mutation.mutate(entity.individual);
            }
            population.add(entity);
        }
    }

    private static void fusion(Evolution evolution, List<Object[]> evaluation) {
        List<Entity> population = evolution.population;
        Aspects aspects = evolution.aspects;
        Parameters parameters = evolution.parameters;
        int fusionCount = (int) Math.round(parameters.fusionRate.sample());
        while (fusionCount-- > 0) {
            if (population.size() < 2) {
                return;
            }
            Entity[] bestPair = getBestPair(evolution, evaluation);
            Entity newEntity = PopulationFactory.createEntity(
                    aspects.fusion.fuse(bestPair[0].individual, bestPair[1].individual,
                    parameters.fusionBlockSize));
            population.add(newEntity);
        }

    }

    private static Entity[] getBestPair(Evolution evolution, List<Object[]> evaluation) {
        Aspects aspects = evolution.aspects;
        double rank, bestRank = 0;
        Entity[] bestPair = new Entity[]{(Entity) evaluation.get(0)[0],
            (Entity) evaluation.get(1)[0]};
        for (int i = 0; i < evaluation.size(); i++) {
            for (int j = 0; j < evaluation.size(); j++) {
                if (i != j) {
                    rank = ((Double) evaluation.get(i)[1])
                            * ((Double) evaluation.get(j)[1])
                            * aspects.difference.differ(
                                    ((Entity) evaluation.get(i)[0]).individual,
                                    ((Entity) evaluation.get(j)[0]).individual);
                    if (rank > bestRank) {
                        bestRank = rank;
                        bestPair = new Entity[]{(Entity) evaluation.get(i)[0],
                            (Entity) evaluation.get(j)[0]};
                    }
                }
            }
        }
        return bestPair;
    }

    private static List<Object[]> getEvaluation(Evolution evolution) {
        List<Entity> population = evolution.population;
        Aspects aspects = evolution.aspects;
        List<Object[]> values = new ArrayList<>();
        for (Entity entity : population) {
            values.add(new Object[]{
                entity, aspects.evaluation.evaluate(entity.individual)});
        }
        return values;
    }

    private static void death(Evolution evolution, List<Object[]> evaluation) {
        List<Entity> population = evolution.population;
        Parameters parameters = evolution.parameters;
        int maxSize = (int) parameters.maxPopulationSize.sample();
        while (population.size() > maxSize) {
            kill(evolution, evaluation);
        }
    }

    private static void kill(Evolution evolution, List<Object[]> evaluation) {
        List<Entity> population = evolution.population;
        Entity worstEntity = population.get(0);
        int worstIndex = 0;
        double worstValue = Double.MAX_VALUE;
        for (int i = 0; i < evaluation.size(); i++) {
            if (worstValue > (Double) evaluation.get(i)[1]) {
                worstIndex = i;
                worstValue = (Double) evaluation.get(i)[1];
                worstEntity = (Entity) evaluation.get(i)[0];
            }
        }
        population.remove(worstEntity);
        evaluation.remove(worstIndex);
    }

    private EvolutionLogic() {
    }

}
