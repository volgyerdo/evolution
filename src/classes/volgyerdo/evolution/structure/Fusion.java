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
public interface Fusion {
    
    public Individual fuse(Individual individual1, Individual individual2, double blockSize);
    
}