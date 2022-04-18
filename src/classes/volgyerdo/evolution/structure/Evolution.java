/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volgyerdo.evolution.structure;

import java.util.List;

/**
 *
 * @author Volgyerdo Nonprofit Kft.
 */
public class Evolution<T extends Individual> implements Individual<T>{
    
    public List<Entity<T>> population;
    
    public Parameters parameters;
    
    public Aspects aspects;
    
}
