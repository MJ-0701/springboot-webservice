package com.example.springbootwebservice.service.posts;

import com.example.springbootwebservice.domain.post.Posts;
import com.example.springbootwebservice.domain.post.PostsRepository;
import com.example.springbootwebservice.web.dto.request.PostsSaveRequestDto;
import com.example.springbootwebservice.web.dto.request.PostsUpdateRequestDto;
import com.example.springbootwebservice.web.dto.response.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당사용자가 없습니다. id =" + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당사용자가 없습니다. id =" + id));
        return new PostsResponseDto(entity);
    }
}
