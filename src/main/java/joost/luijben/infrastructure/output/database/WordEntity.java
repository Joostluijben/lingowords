package joost.luijben.infrastructure.output.database;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class WordEntity {
    @GeneratedValue
    @Id
    private Integer id;
    private String word;
}
