package DevFlow.OpenCloset_Back.Search.SearchController;

import DevFlow.OpenCloset_Back.Search.Dto.req.BoardSearchRequestDto;
import DevFlow.OpenCloset_Back.Search.Dto.res.BoardSearchResponseDto;
import DevFlow.OpenCloset_Back.Search.SearchService.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/search")
public class SearchController {
    private final SearchService searchService;

    @PostMapping
    public ResponseEntity<List<BoardSearchResponseDto>> searchBoards(@RequestBody BoardSearchRequestDto request) {
        System.out.println("SearchController 호출됨: " + request.getTitle());
      List<BoardSearchResponseDto> result = searchService.searchBoards(request);
      return ResponseEntity.ok(result);
    }


}
