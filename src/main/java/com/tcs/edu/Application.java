package com.tcs.edu;

import com.tcs.edu.decorator.MessageDecorator;
import com.tcs.edu.decorator.TimestampMessageDecorator;
import com.tcs.edu.domain.Message;
import com.tcs.edu.repository.HashMapMessageRepository;
import com.tcs.edu.repository.MessageRepository;
import com.tcs.edu.service.MessageService;
import com.tcs.edu.service.OrderedDistinctedMessageService;

import static com.tcs.edu.decorator.Severity.*;

class Application {
    public static void main(String[] args) {
        MessageDecorator decorator = new TimestampMessageDecorator();
        MessageRepository repository = new HashMapMessageRepository();
        MessageService service = new OrderedDistinctedMessageService(decorator, repository);
        //-----------------------------------------------------------------------------------------
        Message message1 = new Message(MAJOR, "Первый");
        Message message2 = new Message(REGULAR, "Второй");
        Message message3 = new Message(MINOR, "Третий");
        Message message4 = new Message();
        //-----------------------------------------------------------------------------------------
        try {
            service.process(message1, message2, message3, message4);
        } catch (Exception e) {
            System.out.println("Нештатное поведение " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Сохраненные сообщения:");
        service.findAll().forEach(message -> {
            System.out.println("Сообщение просто так: " + message);
            System.out.println("Сообщение по ключу: "
                    + message.getId() + " -> "
                    + service.findByPrimaryKey(message.getId()));
        });
        System.out.println("Сообщения только низкой критичности:");
        service.findAllBySeverity(MINOR).forEach(System.out::println);
    }
}
