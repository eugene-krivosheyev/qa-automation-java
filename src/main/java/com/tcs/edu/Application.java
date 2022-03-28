package com.tcs.edu;

import static com.tcs.edu.decorator.TimestampMessageDecorator.decorate;

class Application {

    public static void main(String[] args) {
        System.out.println(decorate("Hello world!"));
    }
}
