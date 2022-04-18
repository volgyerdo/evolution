/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volgyerdo.evolution.formulatest;

import volgyerdo.evolution.structure.Prototyping;

/**
 *
 * @author Volgyerdo Nonprofit Kft.
 */
public class FormulaPrototyping implements Prototyping<Formula>{

    @Override
    public Formula prototype() {
        return new Formula();
    }
    
}
