/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volgyerdo.evolution.formulatest;

import org.junit.Test;
import volgyerdo.commons.math.probability.NormalDistribution;
import volgyerdo.evolution.logic.EvolutionFactory;
import volgyerdo.evolution.logic.EvolutionLogic;
import volgyerdo.evolution.logic.ParameterFactory;
import volgyerdo.evolution.structure.Aspects;
import volgyerdo.evolution.structure.Entity;
import volgyerdo.evolution.structure.Evolution;
import volgyerdo.evolution.structure.Parameters;

/**
 *
 * @author Volgyerdo Nonprofit Kft.
 */
public class FormulaTest {

    public FormulaTest() {
    }

    @Test
    public void fusionTest() {
        Formula a = new Formula("000000000000000000000000000000");
        Formula b = new Formula("1111111111111111111111111");
        for (int i = 0; i < 100; i++) {
            Formula c = new FormulaFusion().fuse(a, b, new NormalDistribution(1.5, 0.5));
            System.out.println("Fusion: " + c.text);
        }
    }

    @Test
    public void jumpingTest() {
        for (int i = 0; i < 100; i++) {
            Formula a = new Formula("000000000000000000000000000000");
            Formula b = new Formula("1111111111111111111111111");
            new FormulaJumping().jump(a, b, new NormalDistribution(1.5, 0.5));
            System.out.println("Jumping: " + b.text);
        }
    }

    @Test
    public void mutationTest() {
        Formula a = new Formula("");
        for (int i = 0; i < 100; i++) {
            new FormulaMutation().mutate(a);
            System.out.println("Mutating: " + a.text);
        }
    }

    @Test
    public void formulaTest() {
        Parameters parameters = ParameterFactory.createDefaultParameters();
        parameters.ageMutationRate = new NormalDistribution(0, 0);
        parameters.divisionMutationRate = new NormalDistribution(1.0, 0.5);
        parameters.divisionRate = new NormalDistribution(0.5, 0.5);
        parameters.fusionBlockSize = new NormalDistribution(1.5, 0.5);
        parameters.fusionRate = new NormalDistribution(0.2, 0.5);
        parameters.jumpBlockSize = new NormalDistribution(1.5, 0.5);
        parameters.jumpRate = new NormalDistribution(0, 0);
        parameters.maxPopulationSize = new NormalDistribution(100, 10);

        Aspects aspects = new Aspects();
        aspects.division = new FormulaDivision();
        aspects.evaluation = new FormulaEvaluation();
        aspects.fusion = new FormulaFusion();
        aspects.jumping = new FormulaJumping();
        aspects.mutation = new FormulaMutation();
        aspects.prototyping = new FormulaPrototyping();
        aspects.difference = new FormulaDifference();

        Evolution<Formula> evolution = EvolutionFactory.createEvolution(aspects, parameters);

        for (int i = 0; i < 1000; i++) {
            EvolutionLogic.evolve(evolution);
        }
        int maxId = 0;
        double max = 0;
        int id = 0;
        for (Entity<Formula> entity : evolution.population) {
            double value = aspects.evaluation.evaluate(entity.individual);
            System.out.println(entity.individual.text + " (" + entity.age + ") >>> " + value);
            if(value > max){
                max = value;
                maxId = id;
            }
            id++;
        }
        System.out.println("--------------");
        Formula best = evolution.population.get(maxId).individual;
        System.out.println("MAX: " + best.text + " >> " + max);
    }

}
