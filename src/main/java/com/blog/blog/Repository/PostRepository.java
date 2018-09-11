package com.blog.blog.Repository;

import com.blog.blog.models.Post;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

//    Post findByTitle(String title);

    List<Post> findAll();
//
//    List<Post> findByTitleContainingOrDescriptionContaining(String string1, String string2);
//
//    @Query("from Post p where p.id > ?1")
//    List<Post> findCustom(long id);

}
