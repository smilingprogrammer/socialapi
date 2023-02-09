package com.example.socialapi.service;

import com.example.socialapi.model.AppUserDetails;
import com.example.socialapi.model.UserPost;
import com.example.socialapi.response.ApiResponse;
import com.example.socialapi.response.PageResponse;

public interface PostService {

    PageResponse<UserPost> getAllPosts(int page, int size);

    PageResponse<UserPost> getPostsByCreatedBy(String username, int page, int size);

    PageResponse<UserPost> getPostsByCategory(Long id, int page, int size);

    PageResponse<UserPost> getPostsByTag(Long id, int page, int size);

    PageResponse<UserPost> updatePost(Long id, int page, int size);

    ApiResponse deletePost(Long id, AppUserDetails currentUser);

    PostService getPost(Long id);
}
