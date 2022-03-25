package com.tcs.edu.printer;

/**
 * Класс {@link ConsolePrinter} используется для вывода в консоль поступающих
 * в методы и процедуры класса {@link ConsolePrinter} данных.
 * Побочные эффекты отсуствуют, т.к методы и процедуры класса никак не изменяют входящие параметры.
 * @author     Daniil Kashapov
 * @version 1.0
 */

public class ConsolePrinter {
    /**
     * Процедура {@link com.tcs.edu.printer.ConsolePrinter#print(String)} прездназначена для
     * вывода в консоль поступающего на вход параметра.
     * @param message ожидаемый на вход для исполнения процедуры, должен быть представлен типом String.
     *
     * Побочные эффекты отсуствуют, процедура {@link com.tcs.edu.printer.ConsolePrinter#print(String)}
     * не изменяет входящие параметры.
     */
    public static void print(String message) {
        System.out.println(message);
    }
}
