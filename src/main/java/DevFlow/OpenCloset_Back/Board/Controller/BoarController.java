package DevFlow.OpenCloset_Back.Board.Controller;

import DevFlow.OpenCloset_Back.Board.Service.BoardService;
import DevFlow.OpenCloset_Back.Board.dto.req.BoardCreateRequestDto;
import DevFlow.OpenCloset_Back.Board.dto.res.BoardCreateResponsetDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoarController {
    private final BoardService boardService;

    @GetMapping("/board/All")
    public List<BoardCreateResponsetDto> getPosts() {
        return boardService.getPosts();
    }

    @PostMapping("/board/create")
    public BoardCreateResponsetDto createBoard(@RequestBody BoardCreateRequestDto requestDto) {
        return boardService.createBoard(requestDto);
    }
}
