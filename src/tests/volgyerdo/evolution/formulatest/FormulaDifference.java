/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volgyerdo.evolution.formulatest;

import volgyerdo.commons.string.StringUtils;
import volgyerdo.evolution.structure.Difference;

/**
 *
 * @author Volgyerdo Nonprofit Kft.
 */
public class FormulaDifference implements Difference<Formula>{

    @Override
    public double differ(Formula individual1, Formula individual2) {
        return Math.abs(StringUtils.levenshteinDistance(individual1.text, individual2.text));
    }
    
}
