package DevFlow.OpenCloset_Back.Search.SearchService;

import DevFlow.OpenCloset_Back.Board.Repository.BoardRepository;
import DevFlow.OpenCloset_Back.Board.entity.Board;
import DevFlow.OpenCloset_Back.Search.Dto.req.BoardSearchRequestDto;
import DevFlow.OpenCloset_Back.Search.Dto.res.BoardSearchResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SearchService {
    private final BoardRepository boardRepository;

    public SearchService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public List<BoardSearchResponseDto> searchBoards(BoardSearchRequestDto req) {
        System.out.println("title: '" + req.getTitle() + "'");
        System.out.println("desc : '" + req.getDescription() + "'");
        System.out.println("sex: '" + req.getSex() + "'");
        System.out.println("size: '" + req.getSize() + "'");
        System.out.println("place: '" + req.getPlace() + "'");

        List<Board> results = boardRepository.searchBoards(
                emptyToNull(req.getTitle()),
                emptyToNull(req.getDescription()),
                emptyToNull(req.getSex()),
                emptyToNull(req.getSize()),
                emptyToNull(req.getPlace())
        );

        return results.stream()
                .map(BoardSearchResponseDto::new)
                .toList();
    }
    private String emptyToNull(String input) {
        return (input == null || input.trim().isEmpty() || input.equalsIgnoreCase("null")) ? null : input;
    }

}
