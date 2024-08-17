package com.softwarefoundations.blogger.controller;

import com.softwarefoundations.blogger.entity.dto.PostDto;
import com.softwarefoundations.blogger.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/v1/post")
public class PostController extends AbstractController {


    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> listarPosts() {
        return new ResponseEntity(new ArrayList<>(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PostDto> cadastrarPost(@RequestBody PostDto postDto)  {
        System.out.println(postDto.getTitulo());
        postService.cadastrarPost(postDto);
        return new ResponseEntity(postDto, HttpStatus.OK);
    }

}
