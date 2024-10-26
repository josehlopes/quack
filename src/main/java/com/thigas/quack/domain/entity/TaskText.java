package com.thigas.quack.domain.entity;

public class TaskText {
    private String title;
    private String description;
    private String text;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "TaskText{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
