/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volgyerdo.evolution.logic;

import java.util.ArrayList;
import java.util.List;
import volgyerdo.evolution.structure.Entity;
import volgyerdo.evolution.structure.Individual;

/**
 *
 * @author Volgyerdo Nonprofit Kft.
 */
public class PopulationFactory {
    
    public static final List<Entity> createEmptyPopulation(){
        List<Entity> population = new ArrayList<>();
        return population;
    }
    
    public static final List<Entity> createPopulation(List<Individual> individuals){
        List<Entity> population = new ArrayList<>();
        for(Individual individual : individuals){
            population.add(createEntity(individual));
        }
        return population;
    }
    
    public static Entity createEntity(Individual individual){
        Entity entity = new Entity();
        entity.individual = individual;
        return entity;
    }
    
}
