package com.example.cnExpense.jspEntities;

import org.springframework.stereotype.Component;

@Component
public class Choice {

    public String choice;

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }
}
