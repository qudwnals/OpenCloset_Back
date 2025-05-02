package DevFlow.OpenCloset_Back.Board.Service;

<<<<<<< HEAD
import DevFlow.OpenCloset_Back.Board.Repository.*;
import DevFlow.OpenCloset_Back.Board.dto.req.BoardCreateRequestDto;
import DevFlow.OpenCloset_Back.Board.dto.res.BoardCreateResponsetDto;
import DevFlow.OpenCloset_Back.Board.entity.*;
=======
import DevFlow.OpenCloset_Back.Board.Repository.BoardRepository;
import DevFlow.OpenCloset_Back.Board.dto.req.BoardCreateRequestDto;
import DevFlow.OpenCloset_Back.Board.dto.res.BoardCreateResponsetDto;
import DevFlow.OpenCloset_Back.Board.entity.Board;
>>>>>>> origin/bang-part
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {

    private final BoardRepository boardRepository;
<<<<<<< HEAD
    private final TopRepository topRepository;
    private final BottomRepository bottomRepository;
    private final OuterRepository outerRepository;
    private final JewelryRepossitory jewelryRepossitory;
    private final One_pieceRepository onePieceRepository;
    private final ShoesRepository shoesRepository;

    public BoardService(BoardRepository boardRepository, TopRepository topRepository, BottomRepository bottomRepository, OuterRepository outerRepository, JewelryRepossitory jewelryRepossitory, One_pieceRepository onePieceRepository, ShoesRepository shoesRepository) {
        this.boardRepository = boardRepository;
        this.topRepository = topRepository;
        this.bottomRepository = bottomRepository;
        this.outerRepository = outerRepository;
        this.jewelryRepossitory = jewelryRepossitory;
        this.onePieceRepository = onePieceRepository;
        this.shoesRepository = shoesRepository;
=======

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
>>>>>>> origin/bang-part
    }

    @Transactional(readOnly = true)
    public List<BoardCreateResponsetDto> getPosts(){
        return boardRepository.findAllByOrderByModifiedAtDesc().stream().map(BoardCreateResponsetDto::new).toList();
    }

    @Transactional
    public BoardCreateResponsetDto createBoard(BoardCreateRequestDto req){
        Board board = new Board(req);
        boardRepository.save(board);
<<<<<<< HEAD

        if (req.getCategory().equals("top")){   //상의
            Top top = new Top(board);
            topRepository.save(top);
        }
        if (req.getCategory().equals("bottom")){    //하의
            Bottom bottom = new Bottom(board);
            bottomRepository.save(bottom);
        }
        if (req.getCategory().equals("outer")){     //아우터
            Outer_ outer = new Outer_(board);
            outerRepository.save(outer);
        }
        if (req.getCategory().equals("jewelry")){   //주얼리
            Jewelry jewelry = new Jewelry(board);
            jewelryRepossitory.save(jewelry);
        }
        if (req.getCategory().equals("one piece")){   //원피스
            One_Piece one_piece = new One_Piece(board);
            onePieceRepository.save(one_piece);
        }
        if (req.getCategory().equals("shoes")){
            Shoes shoes = new Shoes();
            shoesRepository.save(shoes);
        }

=======
>>>>>>> origin/bang-part
        return new BoardCreateResponsetDto(board);
    }
    @Transactional
    public BoardCreateResponsetDto getPost(Long id){
        return boardRepository.findById(id).map(BoardCreateResponsetDto::new).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지않습니다.")
        );
    }


}
