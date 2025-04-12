package DevFlow.OpenCloset_Back.Board.Service;

import DevFlow.OpenCloset_Back.Board.Repository.BoardRepository;
import DevFlow.OpenCloset_Back.Board.Repository.BottomRepository;
import DevFlow.OpenCloset_Back.Board.Repository.OuterRepository;
import DevFlow.OpenCloset_Back.Board.Repository.TopRepository;
import DevFlow.OpenCloset_Back.Board.dto.req.BoardCreateRequestDto;
import DevFlow.OpenCloset_Back.Board.dto.res.BoardCreateResponsetDto;
import DevFlow.OpenCloset_Back.Board.entity.Board;
import DevFlow.OpenCloset_Back.Board.entity.Bottom;
import DevFlow.OpenCloset_Back.Board.entity.Outer;
import DevFlow.OpenCloset_Back.Board.entity.Top;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {

    private final BoardRepository boardRepository;
    private final TopRepository topRepository;
    private final BottomRepository bottomRepository;
    private final OuterRepository outerRepository;

    public BoardService(BoardRepository boardRepository, TopRepository topRepository, BottomRepository bottomRepository, OuterRepository outerRepository) {
        this.boardRepository = boardRepository;
        this.topRepository = topRepository;
        this.bottomRepository = bottomRepository;
        this.outerRepository = outerRepository;
    }

    @Transactional(readOnly = true)
    public List<BoardCreateResponsetDto> getPosts(){
        return boardRepository.findAllByOrderByModifiedAtDesc().stream().map(BoardCreateResponsetDto::new).toList();
    }

    @Transactional
    public BoardCreateResponsetDto createBoard(BoardCreateRequestDto req){
        Board board = new Board(req);
        boardRepository.save(board);

        if (req.getCategory().equals("top")){   //상의
            Top top = new Top(board);
            topRepository.save(top);
        }
        if (req.getCategory().equals("bottom")){    //하의
            Bottom bottom = new Bottom(board);
            bottomRepository.save(bottom);
        }
        if (req.getCategory().equals("outer")){ //outer
            Outer outer = new Outer(board);
            outerRepository.save(outer);
        }
        
        return new BoardCreateResponsetDto(board);
    }
    @Transactional
    public BoardCreateResponsetDto getPost(Long id){
        return boardRepository.findById(id).map(BoardCreateResponsetDto::new).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지않습니다.")
        );
    }
}
