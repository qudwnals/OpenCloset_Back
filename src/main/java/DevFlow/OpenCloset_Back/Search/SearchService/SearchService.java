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
        List<Board> results = boardRepository.searchBoards(
                req.getTitle(),
                req.getDescription(),
                req.getSex(),
                req.getSize(),
                req.getPlace()
        );

        return results.stream()
                .map(BoardSearchResponseDto::new)
                .toList();
    }

}
