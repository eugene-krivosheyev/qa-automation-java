import com.tcs.edu.decorator.Severity;
import com.tcs.edu.printer.MessageService;


class Application {
    public static void main(String[] args) {
        MessageService.print(Severity.MINOR, "Hello world!", "Hello world!", "Hello world!",
                "Hello world!", "Hello world!", "Hello world!");
        MessageService.print(Severity.REGULAR, "Hello world!");
        MessageService.print(Severity.REGULAR);
    }
}