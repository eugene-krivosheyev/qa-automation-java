import com.tcs.edu.decorator.MessageDecorator;
import com.tcs.edu.decorator.TimestampMessageDecorator;
import com.tcs.edu.domain.Message;
import com.tcs.edu.printer.ConsolePrinter;
import com.tcs.edu.printer.MessagePrinter;
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
        service.process(message1, message2, message3);
        service.process(new Message(), null);
        service.process(DESC, message1, null, message2, message3);
        service.process(DISTINCT, message2, message3, message3, message4, message2, message1);
        service.process(ASC, DOUBLES, null, message2, message3, message2, null);
    }
}