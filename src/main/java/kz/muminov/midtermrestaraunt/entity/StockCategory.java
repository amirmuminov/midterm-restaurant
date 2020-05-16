package kz.muminov.midtermrestaraunt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kz.muminov.midtermrestaraunt.enums.StockCategoryName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class StockCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Enumerated(EnumType.STRING)
    private StockCategoryName name;

    @OneToMany(mappedBy = "stockCategory")
    @JsonIgnore
    private Set<Stock> stockSet = new HashSet<>();

}
