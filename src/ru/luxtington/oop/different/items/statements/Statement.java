package ru.luxtington.oop.different.items.statements;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Statement {
    final String authorName;
    String text;
    List<String> captions = new ArrayList<>();
    boolean status;

    public Statement(@NotNull String authorName, @NotNull String text) {
        if (authorName.isBlank() || text.isBlank())
            throw new IllegalArgumentException("Author's name and text shouldn't be empty");
        this.authorName = authorName;
        this.text = text;
    }

    @Override
    public String toString() {
        return "Statement by " + authorName
                + ", with text: " + text
                + ", status = " + status;
    }
}
