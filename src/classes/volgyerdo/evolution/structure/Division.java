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
public interface Division {
    
    /* Individual is devided into two individuals. The returned individual is
    a perfect copy of the original. */
    public Individual divide(Individual individual);
    
}
