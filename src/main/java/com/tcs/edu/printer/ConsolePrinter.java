package com.tcs.edu.printer;

import static com.tcs.edu.decorator.MessageService.process;

import com.tcs.edu.decorator.Severity;

/**
 * ConsolePrinter class prints variable at console
 * <p>
 * This class always print text at console
 *
 * @author Alexey Fomin
 */
public class ConsolePrinter {

    /**
     * Method print variable at console
     * <p>
     * Print method print any string variable at console
     *
     * //@param message -- text to print
     */
    public static void print(Severity severity, String decoratedMessage) {
        System.out.println(process(severity, decoratedMessage));
    }
}
