/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limitFunctions;

/**
 *
 * @author Mahmud
 */
public abstract class limit {

    public static limits<Double> lim[];

    public static void setLim(limits<Double>... lim) {
        limit.lim = lim;
    }

    public static boolean computeLim(Double... x) {

        for (int i = 0; i < lim.length; i++) {
            if (!lim[i].compute(x)) {
                return false;
            }
        }
        return true;
    }

}

