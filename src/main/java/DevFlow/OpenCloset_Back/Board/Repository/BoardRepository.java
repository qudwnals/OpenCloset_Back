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
            "WHERE (:title IS NULL OR LOWER(b.title) LIKE LOWER(CONCAT('%', :title, '%'))) " +
            "AND (:description IS NULL OR LOWER(b.description) LIKE LOWER(CONCAT('%', :description, '%'))) " +
            "AND (:size IS NULL OR b.size = :size) " +
            "AND (:place IS NULL OR LOWER(b.place) LIKE LOWER(CONCAT('%', :place, '%'))) " +
            "ORDER BY b.createdAt DESC")
    List<Board> searchBoards(
            @Param("title") String title,
            @Param("description") String description,
            @Param("size") String size,
            @Param("place") String place
    );
}