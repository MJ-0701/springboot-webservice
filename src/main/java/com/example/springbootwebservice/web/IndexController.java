package com.example.springbootwebservice.web;


import com.example.springbootwebservice.config.auth.LoginUser;
import com.example.springbootwebservice.config.auth.dto.SessionUser;
import com.example.springbootwebservice.domain.user.User;
import com.example.springbootwebservice.game.Lotto;
import com.example.springbootwebservice.service.posts.PostsService;
import com.example.springbootwebservice.web.dto.response.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
//    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){

        if (user != null){ // 현재 로그인만 하면 게시판의 정보를 볼수있고 수정할수 있는데 추후에 해당 사용자만 내용을 수정,삭제할 수 있게 리팩토링 해야함.
            model.addAttribute("clientName", user.getName());
            model.addAttribute("posts",postsService.findAllDesc());
        }
        else{

        }
//        model.addAttribute("posts",postsService.findAllDesc());
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }

    @GetMapping("/get/lottoCall")
    public String lottoCall(Model model){
        Lotto lotto = new Lotto();
        model.addAttribute("lotto", lotto.lotto());
        return "lotto";
    }
}
