/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volgyerdo.evolution.logic;

import volgyerdo.evolution.structure.Aging;
import volgyerdo.evolution.structure.Aspect;
import volgyerdo.evolution.structure.Aspects;
import volgyerdo.evolution.structure.Division;
import volgyerdo.evolution.structure.Evaluation;
import volgyerdo.evolution.structure.Fusion;
import volgyerdo.evolution.structure.Jump;
import volgyerdo.evolution.structure.Living;
import volgyerdo.evolution.structure.Mutation;
import volgyerdo.evolution.structure.Similarity;
import volgyerdo.evolution.structure.Prototyping;

/**
 *
 * @author Volgyerdo Nonprofit Kft.
 */
public class AspectFactory {

    public static Aspects createAspects(Aspect... aspectList) {
        Aspects aspects = new Aspects();
        for (Aspect aspect : aspectList) {
            if (aspect instanceof Aging) {
                aspects.aging = (Aging) aspect;
            } else if (aspect instanceof Division) {
                aspects.division = (Division) aspect;
            } else if (aspect instanceof Evaluation) {
                aspects.evaluation = (Evaluation) aspect;
            } else if (aspect instanceof Fusion) {
                aspects.fusion = (Fusion) aspect;
            } else if (aspect instanceof Jump) {
                aspects.jump = (Jump) aspect;
            } else if (aspect instanceof Living) {
                aspects.living = (Living) aspect;
            } else if (aspect instanceof Mutation) {
                aspects.mutation = (Mutation) aspect;
                } else if (aspect instanceof Prototyping) {
                aspects.prototyping = (Prototyping) aspect;
            } else if (aspect instanceof Similarity) {
                aspects.similarity = (Similarity) aspect;
            }
        }
        return aspects;
    }

    private AspectFactory() {
    }

}
