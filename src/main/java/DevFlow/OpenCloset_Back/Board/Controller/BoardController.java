package DevFlow.OpenCloset_Back.Board.Controller;

import DevFlow.OpenCloset_Back.Board.Service.BoardService;
import DevFlow.OpenCloset_Back.Board.dto.req.BoardCreateRequestDto;
import DevFlow.OpenCloset_Back.Board.dto.res.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/All")   //모든 게시물 조회
    public List<BoardCreateResponsetDto> getPosts() {
        return boardService.getPosts();
    }

    @PostMapping("/create")
    public BoardCreateResponsetDto createBoard(@RequestBody BoardCreateRequestDto requestDto) {
        return boardService.createBoard(requestDto);
    }

    @GetMapping("/{id}")  //게시물 지정 조회
    public BoardCreateResponsetDto getPost(@PathVariable Long id) {
        return boardService.getPost(id);
    }
    @GetMapping("/top")
    public List<TopsResponseDto> getTops(){
        return boardService.getTops();
    }
    @GetMapping("/bottom")
    public List<BottomsReponseDto> getBottoms(){
        return boardService.getBottoms();
    }
    @GetMapping("/outher")
    public List<OutherResponseDto> getOuter(){
        return boardService.getOuters();
    }
    @GetMapping("/onepiece")
    public List<One_pieceResponseDto> getOnePieces(){
        return boardService.getOnePieces();
    }
    @GetMapping("/jewelry")
    public List<JewelryResponseDto> getJewelry(){
        return boardService.getJewelry();
    }
    @GetMapping("/shoes")
    public List<ShoesResponseDto> getShoes(){
        return boardService.getShoes();
    }
}
