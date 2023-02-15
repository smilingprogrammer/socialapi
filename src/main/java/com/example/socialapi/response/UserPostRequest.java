package com.example.socialapi.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class UserPostRequest {

    private String title;

    private String body;

    private Long categoryId;

    private List<String> tags;

    public List<String> getTags() {

        return tags == null ? Collections.emptyList() : new ArrayList<>(tags);
    }

    public void setTags(List<String> tags) {

        if (tags == null) {
            this.tags = null;
        } else {
            this.tags = Collections.unmodifiableList(tags);
        }
    }
}

