/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volgyerdo.evolution.formulatest;

import volgyerdo.evolution.structure.Division;
import volgyerdo.evolution.structure.Individual;

/**
 *
 * @author Volgyerdo Nonprofit Kft.
 */
public class FormulaDivision implements Division<Formula>{

    @Override
    public Individual divide(Formula formula) {
        Formula newFormula = new Formula(formula);
        return newFormula;
    }
    
}
