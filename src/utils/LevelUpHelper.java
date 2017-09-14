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
        System.out.println("You have 1 point");
        System.out.println("Please choose your stat to increase");
        printer.printClassStatsWithNums(stats);

        statInput = Integer.parseInt(scan.next());

        if (checkStat(statInput)) {
            return statInput;
        } else {
            return statChooser(stats);
        }
    }

    /**
     * Checks for valid stat number Invalid stats are 'Level - 1' and
     * 'Experience poitns - 2'
     *
     * @param stat stat to check
     * @return true if valid stat
     */
    private boolean checkStat(int stat) {

        //TODO - Health points to set max hp instead of adding to current
        //Idea - Strenght give +hp? eg. 1str = 5hp
        
        switch (stat) {
            case 1:
                System.out.println("You cannot use stat point to increase level"
                        + "\nPlease choose another stat");
                return false;
            case 2:
                System.out.println("You cannot use stat point to increase experience points"
                        + "\nPlease choose something else");
                return false;
            default:
                return true;
        }

    }

}
