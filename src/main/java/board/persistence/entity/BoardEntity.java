package board.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
public class BoardEntity {

    private Long id;
    private String name;
    @ToString.Exclude
    private List<BoardColumnEntity> boardColumns = new ArrayList<>();


}
