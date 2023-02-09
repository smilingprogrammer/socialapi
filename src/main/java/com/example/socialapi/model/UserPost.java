package com.example.socialapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
@Entity
public class UserPost {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "body")
    private String body;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private AppUser user;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "category_id")
//    private Category category;

//    @JsonIgnore
//    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Comment> comments;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "post_tag", joinColumns = @JoinColumn(name = "post_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
//    private List<Tag> tags;

//    @JsonIgnore
//    public AppUser getUser() {
//        return user;
//    }
//
//    public void setUser(AppUser user) {
//        this.user = user;
//    }

//    public List<Comment> getComments() {
//        return comments == null ? null : new ArrayList<>(comments);
//    }

//    public void setComments(List<Comment> comments) {
//        if (comments == null) {
//            this.comments = null;
//        } else {
//            this.comments = Collections.unmodifiableList(comments);
//        }
//    }

//    public List<Tag> getTags() {
//        return tags == null ? null : new ArrayList<>(tags);
//    }

//    public void setTags(List<Tag> tags) {
//        if (tags == null) {
//            this.tags = null;
//        } else {
//            this.tags = Collections.unmodifiableList(tags);
//        }
//    }
}
