package com.tcs.edu.decorator;

public class PostfixDecorator {

    /**
     * Метод-переключатель переменной. Изменяет значение переданного параметра на необходимый
     *
     * @param severity -- одно из значений {@link Severity}
     * @return String из списка ["( )", "(!)", "(!!!)"]
     */
    public static String getPostfixSeverity(Severity severity) {
        String severityString = null;
        switch (severity) {
            case MINOR: severityString = "( )"; break;
            case REGULAR: severityString = "(!)"; break;
            case MAJOR: severityString = "(!!!)"; break;
        }
        return  severityString;
    }
}
