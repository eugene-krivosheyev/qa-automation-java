import com.tcs.edu.printer.ConsolePrinter;
import com.tcs.edu.decorator.TimestampMessageDecorator;

class Application {
    public static void main(String[] args) {
        ConsolePrinter.print(TimestampMessageDecorator.decorate("Hello world!"));
    }
}