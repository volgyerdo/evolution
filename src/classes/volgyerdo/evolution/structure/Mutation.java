/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volgyerdo.evolution.structure;

import volgyerdo.commons.math.probability.Distribution;

/**
 *
 * @author Volgyerdo Nonprofit Kft.
 */
public interface Mutation {
    
    /* A dandomly selected part of the inidividual is mutated. */
    public void mutate(Individual individual, Distribution mutationRate);
    
}
