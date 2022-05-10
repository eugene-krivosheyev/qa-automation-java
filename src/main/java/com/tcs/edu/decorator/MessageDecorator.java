package com.tcs.edu.decorator;

import com.tcs.edu.domain.Severity;

public interface MessageDecorator {
    String decorate(Severity severity, String message);
}
