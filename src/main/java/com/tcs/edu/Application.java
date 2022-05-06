package com.tcs.edu;

import com.tcs.edu.domain.Message;

import static com.tcs.edu.service.MessageService.print;
import static com.tcs.edu.decorator.Severity.*;
import static com.tcs.edu.service.MessageOrder.*;
import static com.tcs.edu.service.Doubling.*;

class Application {
    public static void main(String[] args) {
        Message message1 = new Message(MAJOR, "Первый");
        Message message2 = new Message(REGULAR, "Второй");
        Message message3 = new Message(MINOR, "Третий");
        Message message4 = new Message(null, null);
        print(message1, message2, message3);
        print(DESC, message1, message2, message3);
        print(DISTINCT, message2, message3, message3, message4, message2, message1);
        print(ASC, DOUBLES, null, message2, message3, message2, null);
    }
}