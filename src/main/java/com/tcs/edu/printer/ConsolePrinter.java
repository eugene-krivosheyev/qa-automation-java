package com.tcs.edu.printer;
/**
 * Class is for printing message in console
 * @author k.m.averyanova
 */
public class ConsolePrinter implements Printer {
    /**
     * Method for printing message in console
     * @param message message to print in console
     */
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
