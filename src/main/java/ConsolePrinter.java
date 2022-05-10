import domain.Message;

public class ConsolePrinter {
    public static void print(Message message) {
        System.out.println(message.getBody());
    }
}
