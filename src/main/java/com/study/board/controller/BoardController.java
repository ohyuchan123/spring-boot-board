package com.study.board.controller;

import com.study.board.entity.Board;
import com.study.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
    public String boardWritePro(Board board, Model model, MultipartFile file) throws Exception{
//        System.out.println("제목 : "+title);
//        System.out.println("내용 : "+content);

//        System.out.println(board.getTitle());

        model.addAttribute("message"," 글 작성이 완료되었습니다.");
        model.addAttribute("searchUrl","/board/list");

        boardService.write(board,file);
        return "message";
    }

    @GetMapping("/board/list")
    public String boardList(Model model){

        Model list = model.addAttribute("list", boardService.boardList());

        return "boardList";
    }

    @GetMapping("/board/view")// localhost:8080/board/view?id=1
    public String boardView(Model model,Integer id){

        model.addAttribute("board",boardService.boardView(id));

        return "boardview";
    }

    @GetMapping("/board/delete")
    public String boardDelete(Integer id){
        boardService.boardDelete(id);

        return "redirect:/board/list";
    }

    @GetMapping("/board/modify/{id}")
    public String boardModify(@PathVariable("id") Integer id,Model model){
        model.addAttribute("board",boardService.boardView(id));
        return "boardmodify";
    }

    @PostMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable("id") Integer id,Board board,MultipartFile file) throws Exception{
        Board boardTemp = boardService.boardView(id);

        boardTemp.setTitle(board.getTitle());
        boardTemp.setContent(board.getContent());

        boardService.write(boardTemp,file);

        return "redirect:/board/list";
    }
}
