import com.tcs.edu.decorator.Severity;
import com.tcs.edu.printer.MessageService;


class Application {
    public static void main(String[] args) {
        MessageService.process(Severity.MINOR, "Hello world!", "Hello world!", "Hello world!",
                "Hello world!", "Hello world!", "Hello world!");
    }
}