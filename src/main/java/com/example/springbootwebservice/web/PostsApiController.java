package com.example.springbootwebservice.web;

import com.example.springbootwebservice.service.posts.PostService;
import com.example.springbootwebservice.web.dto.request.PostsSaveRequestDto;
import com.example.springbootwebservice.web.dto.request.PostsUpdateRequestDto;
import com.example.springbootwebservice.web.dto.response.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostService postService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postService.update(id, requestDto);
    }

    @GetMapping
    public PostsResponseDto findById(@PathVariable Long id){
        return postService.findById(id);
    }
}
