package com.example.socialapi.service.serviceimpl;

import com.example.socialapi.constant.AppConstant;
import com.example.socialapi.exception.BadRequestException;
import com.example.socialapi.model.AppUserDetails;
import com.example.socialapi.model.UserPost;
import com.example.socialapi.response.ApiResponse;
import com.example.socialapi.response.PageResponse;
import com.example.socialapi.service.PostService;

public class PostServiceImpl implements PostService {

    @Override
    public PageResponse<UserPost> getAllPosts(int page, int size) {
        return null;
    }

    @Override
    public PageResponse<UserPost> getPostsByCreatedBy(String username, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<UserPost> getPostsByCategory(Long id, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<UserPost> getPostsByTag(Long id, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<UserPost> updatePost(Long id, int page, int size) {
        return null;
    }

    @Override
    public ApiResponse deletePost(Long id, AppUserDetails currentUser) {
        return null;
    }

    @Override
    public PostService getPost(Long id) {
        return null;
    }
    private void validatePageAndSize(int page, int size){

        if (page < 0){
            throw new BadRequestException("Page number cannot be less than zero");
        }

        if (size < 0){
            throw new BadRequestException("Size cannot be less than zero.");
        }

        if (size > AppConstant.MAX_PAGE_SIZE){

            throw new BadRequestException("Page Size must be greater than the " + AppConstant.MAX_PAGE_SIZE);
        }
    }
}
