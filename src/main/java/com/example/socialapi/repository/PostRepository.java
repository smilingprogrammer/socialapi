package com.example.socialapi.repository;

import com.example.socialapi.model.UserPost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<UserPost, Long>{

    Page<UserPost> findByCreatedBy(Long userId, Pageable pageable);

    Page<UserPost> findByCategory(Long categoryId, Pageable pageable);

//    Page<UserPost> findByTags(List<Tag> tags, Pageable pageable);

    Long countByCreatedBy(Long userId);
}
