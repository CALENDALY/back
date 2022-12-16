package com.example.project.user.kakao;

import com.example.project.user.repository.domain.SNSType;
import com.example.project.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
@RequestMapping("/kakao")
@RequiredArgsConstructor
@Slf4j
public class WebController {

    @Value("${client.key}")
    private String client_id;
    @Value("${client.grant_type}")
    private String grant_type;
    @Value("${client.redirect_uri}")
    private String redirect_uri;

    private final KakaoClient client;
    private final KakaoApiClient loginClient;
    private final UserService userService;

    @GetMapping("/login")
    public String login(){
        return "kakaoCI/login";
    }


    @GetMapping("/info")
    public String getCI(@RequestParam String code, Model model) throws IOException {

        log.info("CODE:: " + code);

        KakaoClient.Request req = new KakaoClient.Request(grant_type, client_id, redirect_uri, code);
        KakaoClient.TokenDto response = client.getToken(req.getModel());

        KakaoData contents = loginClient.getUserData(response.bearerTokenInfo());

        model.addAttribute("code", code);
        model.addAttribute("access_token", response.access_token());
        model.addAttribute("userInfo", contents);

       model.addAttribute("img_url", contents.kakao_account().profile().thumbnail_image_url());


       userService.createOrLoginUser(contents.kakao_account(),response.access_token() , SNSType.KAKAO);

        //ci는 비즈니스 전환후 검수신청 -> 허락받아야 수집 가능
        return "kakaoCI/index";
    }
}
