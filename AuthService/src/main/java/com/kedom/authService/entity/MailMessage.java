package com.kedom.authService.entity;

import lombok.Data;

@Data
public class MailMessage {
    private String to;
    private String subject;
    private String text;
    private Integer type;

    public void setType(String type) {
        switch (type) {
            case "register":
                this.type = 1;
                break;
            case "forget":
                this.type = 2;
                break;
            case "change":
                this.type = 3;
                break;
        }
    }
}
