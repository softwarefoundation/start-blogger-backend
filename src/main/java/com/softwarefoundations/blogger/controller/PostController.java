package com.softwarefoundations.blogger.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/post")
public class PostController extends AbstractController {

    @GetMapping
    public String listarPosts() {
        return "Shopping Araguaína";
    }

}
