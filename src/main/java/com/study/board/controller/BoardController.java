package com.study.board.controller;

import com.study.board.entity.Board;
import com.study.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

//    @GetMapping("/")
//    @ResponseBody/*반환 값을 그대로 띄워줄 수 있게 해주는 Annotation*/
//    public String main(){
//        return "Hello World";
//    }

    @GetMapping("/board/write") //localhost:8080/board/write
    public String boardwriteForm(){
        return "boardwrite";
    }

    @PostMapping("/board/writepro")
    public String boardWritePro(Board board){
//        System.out.println("제목 : "+title);
//        System.out.println("내용 : "+content);

//        System.out.println(board.getTitle());
        boardService.write(board);
        return "";
    }
}