package com.blog.blog.services;

import com.blog.blog.Repository.PostRepository;
import com.blog.blog.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class PostService {

    private final PostRepository postDao;

    public PostService(PostRepository postDao){
        this.postDao = postDao;
    }

    public List<Post> findAll(){
        return postDao.findAll();
    }

    private List<Post> posts;

//    public PostService() {
//        posts = new ArrayList<>();
//        createPost();
//    }

    public Post save(Post post){
        //post.setId(( (long) posts.size()+1));
//        posts.add(post);
//        return post;
        return postDao.save(post);
    }

    public Post findOne(long id){
        return postDao.findOne(id);
    }

    public void delete(long id){
        postDao.delete(id);
    }

//    public List<Post> findAll(){
//        return posts;
//    }
//
//    private void createPost(){
//        posts.add(new Post("Kushala Daora","Arch Tempered Kushula Daora released!"));
//        posts.add(new Post("Behemoth","Extreme Behemoth released"));
//        posts.add(new Post("Teostra","Arch Tempered Teostra released!"));
//
//    }

}
