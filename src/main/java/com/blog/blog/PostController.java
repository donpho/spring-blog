package com.blog.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String postsIndex(){
        return "Post index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String postId(@PathVariable int id){
        return "View the individual post of ID: " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createPost(){
        return "View the form for creating a post.";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String newPost(){
        return "create new post";
    }
}
