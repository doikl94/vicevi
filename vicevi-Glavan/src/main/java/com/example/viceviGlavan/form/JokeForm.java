package com.example.viceviGlavan.form;

import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Repository
public class JokeForm {

    @NotEmpty
    @NotNull
    @Size(max = 10000)
    private String content;

    @NotNull
    private Integer categoryId;

    public String getContent() {
        return content;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

}
