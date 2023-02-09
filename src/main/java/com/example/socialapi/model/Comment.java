package com.example.socialapi.model;

//public class Comment {
//
//    private static final long serialVersionUID = 1L;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "name")
//    @NotBlank
//    @Size(min = 4, max = 50)
//    private String name;
//
//    @Column(name = "email")
//    @NotBlank
//    @Email
//    @Size(min = 4, max = 50)
//    private String email;
//
//    @Column(name = "body")
//    @NotBlank
//    @Size(min = 10, message = "Comment body must be minimum 10 characters")
//    private String body;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "post_id")
//    private Post post;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    public Comment(@NotBlank @Size(min = 10, message = "Comment body must be minimum 10 characters") String body) {
//        this.body = body;
//    }
//
//    @JsonIgnore
//    public Post getPost() {
//        return post;
//    }
//
//    @JsonIgnore
//    public User getUser() {
//        return user;
//    }
//}
