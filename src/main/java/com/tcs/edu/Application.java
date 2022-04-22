package com.tcs.edu;

import static com.tcs.edu.service.MessageService.print;
import static com.tcs.edu.decorator.Severity.*;
import static com.tcs.edu.service.MessageOrder.*;


class Application {
    public static void main(String[] args) {
        //1 параметр не может быть нулом
        print(MAJOR, "Privet", "Salut", null);
        print(null, "Nihao!", "Hey!");
        print(MINOR, ASC,"Hello!", "Hi!", "Howdy!");
        print(REGULAR, DESC,"Zdravstvuite", null, "Ciao", "Qu");
    }
}