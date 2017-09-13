/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import character.Stat;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mio
 */
public class LevelUpHelper {

    PrintHelper printer;
    Scanner scan;

    public LevelUpHelper(PrintHelper printer, Scanner scan) {
        this.printer = printer;
        this.scan = scan;
    }

    /**
     * Method to let user decide what stat to increase
     *
     * @param stats - class stats
     * @return stat index to increase
     */
    public int statChooser(List<Stat> stats) {
        int statInput;
        System.out.println("Choose your stat to change");
        scan = new Scanner(System.in, "UTF-8");
        System.out.println("You have 1 point");
        System.out.println("Please choose your stat to increase");
        printer.printClassStatsWithNums(stats);
        statInput = Integer.parseInt(scan.next());

        return statInput;
    }

}
