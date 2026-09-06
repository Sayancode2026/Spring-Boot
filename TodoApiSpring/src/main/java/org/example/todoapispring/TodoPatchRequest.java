package org.example.todoapispring;


//Why create a separate TodoPatchRequest?
//This is actually a professional practice.The
// Todo class represents the stored object,while TodoPatchRequest represents the incoming request.
// It also solves the primitive-type problem because Integer and Boolean can be null.


public class TodoPatchRequest {
    private Boolean completed;
    private String title;
    private Integer userId;

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}