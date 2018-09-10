package com.blog.blog.services;

import com.blog.blog.Post;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class PostService {
    private List<Post> posts;

    public PostService() {
        posts = new ArrayList<>();
        createPost();
    }

    public Post save(Post post){
        post.setId(( (long) posts.size()+1));
        posts.add(post);
        return post;
    }

    public Post findOne(long id){
        return posts.get((int) id - 1);
    }

    public List<Post> findAll(){
        return posts;
    }

    private void createPost(){
        posts.add(new Post("Kushala Daora","Arch Tempered Kushula Daora released!"));
        posts.add(new Post("Behemoth","Extreme Behemoth released"));
        posts.add(new Post("Teostra","Arch Tempered Teostra released!"));

    }

}
