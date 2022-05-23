package com.tcs.edu;

import com.tcs.edu.decorator.MessageDecorator;
import com.tcs.edu.decorator.TimestampMessageDecorator;
import com.tcs.edu.domain.Message;
import com.tcs.edu.printer.ConsolePrinter;
import com.tcs.edu.printer.MessagePrinter;
import com.tcs.edu.service.LogException;
import com.tcs.edu.service.MessageService;
import com.tcs.edu.service.OrderedDistinctedMessageService;

import static com.tcs.edu.decorator.Severity.*;
import static com.tcs.edu.service.Doubling.DISTINCT;
import static com.tcs.edu.service.Doubling.DOUBLES;
import static com.tcs.edu.service.Order.ASC;
import static com.tcs.edu.service.Order.DESC;

class Application {
    public static void main(String[] args) {
        MessagePrinter printer = new ConsolePrinter();
        MessageDecorator decorator = new TimestampMessageDecorator();
        MessageService service = new OrderedDistinctedMessageService(decorator, printer);
        //-----------------------------------------------------------------------------------------
        Message message1 = new Message(MAJOR, "Первый");
        Message message2 = new Message(REGULAR, "Второй");
        Message message3 = new Message(MINOR, "Третий");
        Message message4 = new Message();
        //-----------------------------------------------------------------------------------------
        try {
            service.process(message1, message2, message3);
            service.process(DESC, message1, message2, message3);
            service.process(ASC, DOUBLES, message2, message3, message2);
            service.process(DISTINCT, message2, message3, message3, message4, message2);
        } catch (Exception e) {
            System.out.println("Нештатное поведение " + e.getMessage());
            e.printStackTrace();
        }
        //-----------------------------------------------------------------------------------------
        try {
            service.process();
        } catch (LogException e) {
            testExceptionLog(e);
        }
        try {
            service.process(DESC, message1, new Message(""), message2, message3);
        } catch (LogException e) {
            testExceptionLog(e);
        }
        try {
            service.process(ASC, DOUBLES, null, message2, message3, message2);
        } catch (LogException e) {
            testExceptionLog(e);
        }
        try {
            service.process(ASC, DOUBLES, new Message(null, "Тест"), message2, message3, message2);
        } catch (LogException e) {
            testExceptionLog(e);
        }
    }

    private static void testExceptionLog(Exception e) {
        System.out.println(e.getMessage() + " -> " + e.getCause().getMessage());
    }
}
