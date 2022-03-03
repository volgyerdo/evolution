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
public class Parameters{
    
    /* Maximum number of individuals */
    public Distribution maxPopulationSize;
    
    /* [Division probability / cycle] */
    public Distribution divisionRate;
    
    /* [Mutation probability / base unit] */
    public Distribution divisionMutationRate;
    
    /* [Mutation probability / base unit / age] */
    public Distribution ageMutationRate;
    
    /* Size of blocks in fusion */
    public Distribution fusionBlockSize;
    
    /* [Fusion probability / cycle] for one pair of individuals */
    public Distribution fusionRate;
    
    /* Size of blocks in jump */
    public Distribution jumpBlockSize;
    
    /* [Jump probability / cycle] for one pair of individuals */
    public Distribution jumpRate;
    
}
