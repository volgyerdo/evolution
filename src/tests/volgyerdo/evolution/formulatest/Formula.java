/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volgyerdo.evolution.formulatest;

import volgyerdo.evolution.structure.Individual;

/**
 *
 * @author Volgyerdo Nonprofit Kft.
 */
public class Formula implements Individual{
    
    public long age = 0;
    public String text;

    public Formula() {
        this.text = "";
    }
    
    public Formula(String text) {
        this.text = text;
    }

    public Formula(Formula formula){
        this.text = formula.text;
        this.age = formula.age;
    }
}
