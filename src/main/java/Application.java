import com.tcs.edu.printer.ConsolePrinter;
import static com.tcs.edu.decorator.TimestampMessageDecorator.decorate;

class Application {
    public static void main(String[] args) {
        ConsolePrinter.print(decorate("Hello world!"));
    }
}