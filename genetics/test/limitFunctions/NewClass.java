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
public class NewClass {

    public static void main(String[] args) {
        limit.setLim(
                (Double... x) -> x[0] + x[2] < 10,
                (Double... x) -> x[0] + x[1] > 0,
                (Double... x) -> x[0] + x[2] < 20,
                (Double... x) -> x[0] + x[2] < 50,
                (Double... x) -> x[0] + x[2] < 9
        );
        Double x[][] = new Double[][]{{1d, 2d, 3d}, {4d, 5d, 0d}, {1d, 0d, 5d}, {4d, 5d, 2d}};
        for (Double[] doubles : x) {
            System.out.println("compute x conditions " + limit.computeLim(doubles));
        }
        double d = Double.NaN;
        if (d < 0 ) {
            System.out.println("test 1");
        }
        if (d > 0) {
            System.out.println("test 2");
        }
        if (d == 0) {
            System.out.println("test 3");
        }
        if(Double.isNaN(d))
            System.out.println("test nan");
    }
}








