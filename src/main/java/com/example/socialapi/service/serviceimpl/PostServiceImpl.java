package com.example.socialapi.service.serviceimpl;

import com.example.socialapi.constant.AppConstant;
import com.example.socialapi.constant.AppUtils;
import com.example.socialapi.exception.BadRequestException;
import com.example.socialapi.exception.ResourceNotFoundException;
import com.example.socialapi.exception.UnauthorizedException;
import com.example.socialapi.model.AppUserDetails;
import com.example.socialapi.model.UserPost;
import com.example.socialapi.model.userrole.RoleName;
import com.example.socialapi.repository.PostRepository;
import com.example.socialapi.repository.UserRepository;
import com.example.socialapi.response.ApiResponse;
import com.example.socialapi.response.PageResponse;
import com.example.socialapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;

import static com.example.socialapi.constant.AppConstant.*;

public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public PageResponse<UserPost> getAllPosts(int page, int size) {
        validatePageAndSize(page, size);

        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, CREATED_AT);
        Page<UserPost> post = postRepository.findAll(pageable);
        List<UserPost> content = post.getNumberOfElements() == 0? Collections.emptyList() : post.getContent();

        return new PageResponse<>(content, post.getNumber(), post.getSize(), post.getTotalElements(),
                post.getTotalPages(), post.isLast());
    }

    @Override
    public PageResponse<UserPost> getPostsByCreatedBy(String username, int page, int size) {
        validatePageAndSize(page, size);
        AppUserDetails appUserDetails = userRepository.getUserByName(username);
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, CREATED_AT);
        Page<UserPost> post = postRepository.findByCreatedBy(appUserDetails.getId(), pageable);
        List<UserPost> content = post.getNumberOfElements() == 0 ? Collections.emptyList() :
                post.getContent();

        return new PageResponse<>(content, post.getNumber(), post.getSize(), post.getTotalElements(),
                post.getTotalPages(), post.isLast());
    }

    @Override
    public PageResponse<UserPost> getPostsByCategory(Long id, int page, int size) {
        AppUtils.validatePageNumberAndSize(page, size);
        validatePageAndSize(page, size);
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
        UserPost post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(POST, ID, id));

        if (post.getUser().equals(currentUser.getId()) || currentUser.getAuthorities().contains(
                new SimpleGrantedAuthority(RoleName.ROLE_ADMIN.toString()))){
            postRepository.deleteById(id);
            return new ApiResponse(Boolean.TRUE, "You successfully deleted post");
        }

        ApiResponse apiResponse =
                new ApiResponse(Boolean.FALSE, "You have no authority to delete this post");
        throw new UnauthorizedException(apiResponse);
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
