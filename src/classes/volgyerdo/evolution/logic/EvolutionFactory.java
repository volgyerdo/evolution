/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volgyerdo.evolution.logic;

import java.util.ArrayList;
import volgyerdo.evolution.structure.Aspect;
import volgyerdo.evolution.structure.Evolution;

/**
 *
 * @author Volgyerdo Nonprofit Kft.
 */
public class EvolutionFactory {

    public static Evolution createEvolution(Aspect... aspectList) {
        Evolution evolution = new Evolution();
        evolution.aspects = AspectFactory.createAspects(aspectList);
        evolution.parameters = ParameterFactory.createDefaultParameters();
        evolution.population = new ArrayList<>();
        return evolution;
    }

    private EvolutionFactory() {
    }

}
