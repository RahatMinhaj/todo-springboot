package com.minhaz.todoapp_backend.DTM;

import lombok.*;

@Getter
@Setter
public class DeleteMessage {
    private String Message;

    public DeleteMessage(String message) {
        Message = message;
    }
}
