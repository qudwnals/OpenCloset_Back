package DevFlow.OpenCloset_Back.Board.Controller;

import DevFlow.OpenCloset_Back.Board.Service.BoardService;
import DevFlow.OpenCloset_Back.Board.dto.req.BoardCreateRequestDto;
import DevFlow.OpenCloset_Back.Board.dto.res.BoardCreateResponsetDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoarController {
    private final BoardService boardService;

    @GetMapping("/board/All")   //모든 게시물 조회
    public List<BoardCreateResponsetDto> getPosts() {
        return boardService.getPosts();
    }

    @PostMapping("/board/create")
    public BoardCreateResponsetDto createBoard(@RequestBody BoardCreateRequestDto requestDto) {
        return boardService.createBoard(requestDto);
    }

    @GetMapping("/board/{id}")  //게시물 지정 조회
    public BoardCreateResponsetDto getPost(@PathVariable Long id) {
        return boardService.getPost(id);
    }
}
