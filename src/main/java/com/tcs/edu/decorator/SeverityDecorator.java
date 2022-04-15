package com.tcs.edu.decorator;

import java.time.Instant;

/**
 * Класс {@link SeverityDecorator} предназначен для хранения процедур по добавлению к входящим данным уровня серьёзности.
 * Побочные эффекты отсуствуют, т.к методы и процедуры класса никак не изменяют входящие параметры, а возвращают
 * новые данные.
 * @author     Daniil Kashapov
 * @version 1.0
 */

public class SeverityDecorator {

    /**
     * Процедура {@link com.tcs.edu.decorator.SeverityDecorator#decorate(Severity, String)} возвращает новую строку
     * состоящую из сообщения поступившего на вход в параметре message и уровня серьёзности поступившего на вход
     * в параметре severity
     *
     * @param message ожидаемый на вход для исполнения процедуры, должен быть представлен типом String.
     * @param severity ожидаемый на вход для исполнения процедуры, должен быть представлен типом Severity.
     *
     * Побочные эффекты отсуствуют, процедура {@link com.tcs.edu.decorator.SeverityDecorator#decorate(Severity, String)}
     * не изменяет входящие параметры.
     * При поступлении в качестве severity значения MINOR происходит возврат сообщения message и строки "()"
     * При поступлении в качестве severity значения REGULAR происходит возврат сообщения message и строки "(!)"
     * При поступлении в качестве severity значения MAJOR происходит возврат сообщения message и строки "(!!!)"
     */

    public static String decorate(Severity severity, String message) {
        String severityString = null;

        switch (severity) {
            case MINOR:
                severityString = "()";
                break;
            case REGULAR:
                severityString = "(!)";
                break;
            case MAJOR:
                severityString = "(!!!)";
                break;
            default:
                severityString = "(not found severity)";
        }

        return String.format("%s %s", message, severityString);
    }
}
