package com.tcs.edu;
import com.tcs.edu.domain.Message;
import com.tcs.edu.domain.Doubling;
import com.tcs.edu.domain.MessageOrder;
import com.tcs.edu.domain.Severity;
import com.tcs.edu.service.MessageService;
import com.tcs.edu.service.OrderedDistinctedMessageService;

class Application {
    public static void main(String[] args) {

        MessageService messageService = new OrderedDistinctedMessageService();
        messageService.print(MessageOrder.ASC,
                Doubling.DISTINCT,
                new Message("Hello world! 0", Severity.MINOR),
                new Message("Hello world! 0", Severity.MINOR),
                new Message("Hello world! 1", Severity.MINOR),
                new Message("Hello world! 2", Severity.MINOR),
                null,
                new Message("Hello world! 3", Severity.MINOR),
                new Message("Hello world!", Severity.REGULAR),
                new Message("Hello world!", Severity.MAJOR));
    }
}