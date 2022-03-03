/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volgyerdo.evolution.logic;

import java.util.List;
import volgyerdo.evolution.structure.Individual;

/**
 *
 * @author Volgyerdo Nonprofit Kft.
 */
public class PopulationLogic {

    public static Individual randomSelect(List<Individual> population) {
        return population.get((int) (Math.random() * population.size()));
    }

    public static Individual[] randomSelectTwo(List<Individual> population) {
        Individual[] individuals = new Individual[2];
        int i1 = (int) (Math.random() * population.size());
        int i2;
        do {
            i2 = (int) (Math.random() * population.size());
        } while (i1 == i2);
        individuals[0] = population.get(i1);
        individuals[1] = population.get(i2);
        return individuals;
    }

    private PopulationLogic() {
    }

}
