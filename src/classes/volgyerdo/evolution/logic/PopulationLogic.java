/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volgyerdo.evolution.logic;

import java.util.List;
import volgyerdo.evolution.structure.Entity;

/**
 *
 * @author Volgyerdo Nonprofit Kft.
 */
public class PopulationLogic {
    
    public static Entity randomSelect(List<Entity> population) {
        return population.get((int) (Math.random() * population.size()));
    }

    public static Entity[] randomSelectTwo(List<Entity> population) {
        Entity[] entities = new Entity[2];
        int i1 = (int) (Math.random() * population.size());
        int i2;
        do {
            i2 = (int) (Math.random() * population.size());
        } while (i1 == i2);
        entities[0] = population.get(i1);
        entities[1] = population.get(i2);
        return entities;
    }

    private PopulationLogic() {
    }

}
