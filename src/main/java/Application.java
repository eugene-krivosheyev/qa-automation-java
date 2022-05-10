import domain.Message;

import javax.print.attribute.standard.Severity;

class Application {
    public static void main(String[] args) {
        ConsolePrinter.print(new Message("Hello world!", Severity.REPORT));
    }
}