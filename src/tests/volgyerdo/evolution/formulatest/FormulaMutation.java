/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volgyerdo.evolution.formulatest;

import volgyerdo.commons.string.StringUtils;
import volgyerdo.evolution.structure.Mutation;

/**
 *
 * @author Volgyerdo Nonprofit Kft.
 */
public class FormulaMutation implements Mutation<Formula> {

    private static final String CHARSET = "0123456789cosinta()*/-+.";

    @Override
    public void mutate(Formula formula) {
        if (formula.text.isEmpty()) {
            formula.text = StringUtils.randomString(1, CHARSET);
            return;
        }
        int pos = (int) (Math.random() * (formula.text.length() + 1));
        String original = formula.text;
        formula.text = original.substring(0, pos) + StringUtils.randomString(1, CHARSET);
        if (pos < original.length()) {
            formula.text += original.substring(pos + 1, original.length());
        }
    }

}
