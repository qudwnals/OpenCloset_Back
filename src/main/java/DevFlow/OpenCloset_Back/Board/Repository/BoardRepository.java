package DevFlow.OpenCloset_Back.Board.Repository;

import DevFlow.OpenCloset_Back.Board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findAllByOrderByModifiedAtDesc();

    @Query("SELECT b FROM Board b " +
            "WHERE (:title IS NULL OR b.title LIKE %:title%) " +
            "AND (:description IS NULL OR b.description LIKE %:description%) " +
            "AND (:sex IS NULL OR b.sex = :sex) " +
            "AND (:size IS NULL OR b.size = :size) " +
            "AND (:place IS NULL OR b.place LIKE %:place%) " +
            "ORDER BY b.createdAt DESC")
    List<Board> searchBoards(
            @Param("title") String title,
            @Param("description") String description,
            @Param("sex") String sex,
            @Param("size") String size,
            @Param("place") String place
    );
}