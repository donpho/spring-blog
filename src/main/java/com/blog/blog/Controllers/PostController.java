package com.blog.blog.Controllers;

import com.blog.blog.Repository.UserRepository;
import com.blog.blog.models.Post;
import com.blog.blog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostService postService;
    UserRepository userRepository;

    //List<Post> posts = new ArrayList<>();

    public PostController(PostService postService, UserRepository userRepository){
        this.postService = postService;
        this.userRepository = userRepository;
    }

    @GetMapping("/posts")
    public String postsIndex(Model viewModel){
        viewModel.addAttribute("posts", postService.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postId(@PathVariable long id, Model viewModel){
        Post post = postService.findOne(id);
        viewModel.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String createPost(Model model){
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String newPost(@ModelAttribute Post post){
        post.setUser(userRepository.findOne(1L));
        postService.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable long id){
        postService.delete(id);
        return "redirect:/posts";
    }


}
