package com.study.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {

    @GetMapping("/")
    @ResponseBody/*반환 값을 그대로 띄워줄 수 있게 해주는 Annotation*/
    public String main(){
        return "Hello World";
    }

}
