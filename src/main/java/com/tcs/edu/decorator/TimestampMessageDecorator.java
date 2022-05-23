package com.tcs.edu.decorator;

import java.time.Instant;

/**
 * Класс {@link TimestampMessageDecorator} предназначен для хранения декорирующих процедур по добавлению к входящим
 * данным времени.
 * Побочные эффекты отсуствуют, т.к методы и процедуры класса никак не изменяют входящие параметры, а возвращают
 * новые данные.
 * @author     Daniil Kashapov
 * @version 1.0
 */

public class TimestampMessageDecorator {

    /**
     * Процедура {@link com.tcs.edu.decorator.TimestampMessageDecorator#decorate(String)} возвращает новую строку
     * состоящую из текущего времени, которое берётся
     * из метода {@link Instant#now()} и входящего параметра
     * @param message ожидаемый на вход для исполнения процедуры, должен быть представлен типом String.
     *
     * Побочные эффекты отсуствуют, процедура {@link com.tcs.edu.decorator.TimestampMessageDecorator#decorate(String)}
     * не изменяет входящие параметры.
     *
     * В процедуре используется поясняющая переменная decoratedMessage для повешыния читабельности.
     * Глобальная переменная messageCount нужна для фиксации колиества вызова процедуры decorate
     */

    static Integer messageCount = 0;
    static final Integer PAGE_SIZE = 2;

    public static String decorate(String message) {
        messageCount++;

        if (messageCount % PAGE_SIZE == 0) {
            final var decoratedMessage = String.format("%d %s %s\n---", messageCount, Instant.now(), message);
            return decoratedMessage;
        }

        final var decoratedMessage = String.format("%d %s %s", messageCount, Instant.now(), message);
        return decoratedMessage;
    }
}
