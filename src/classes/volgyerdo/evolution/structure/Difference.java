/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volgyerdo.evolution.structure;

/**
 *
 * @author Volgyerdo Nonprofit Kft.
 */
public interface Difference<T extends Individual> extends Aspect<T>{
    
    public double differ(T individual1, T individual2);
    
}
