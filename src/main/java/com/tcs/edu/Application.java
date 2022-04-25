package com.tcs.edu;

import static com.tcs.edu.service.MessageService.print;
import static com.tcs.edu.decorator.Severity.*;
import static com.tcs.edu.service.MessageOrder.*;
import static com.tcs.edu.service.Doubling.*;

class Application {
    public static void main(String[] args) {
        print(MAJOR, "Privet", "Salut", null);
        print(null, "Nihao!", "Hey!");
        print(MINOR, ASC, "Hello!", "Hi!", "Howdy!");
        print(REGULAR, DESC, "Zdravstvuite", null, null, "Ciao");
        print(REGULAR, DISTINCT, "Repeat", null, "Unique", "Repeat", "Repeat", null);
        print(MINOR, DESC, DISTINCT, "Double", "Distinct", "Distinct", "Double", "Test");
        print(MINOR, DESC, DISTINCT, null);
        print(MAJOR, ASC, DISTINCT, "1", "2", "2", "3", "1");
        print(MAJOR, ASC, DOUBLES, "*", "*");
    }
}