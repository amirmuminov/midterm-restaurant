package kz.muminov.midtermrestaraunt.entity;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String description;

    @NonNull
    private Date beginningDate;

    @NonNull
    private Date endingDate;

    @NonNull
    private String imageLink;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "stock_category_id")
    private StockCategory stockCategory;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "stock_meals",
                joinColumns = {@JoinColumn(name = "stock_id", referencedColumnName = "id")},
                inverseJoinColumns = {@JoinColumn(name = "meal_id", referencedColumnName = "id")}
    )
    @Fetch(value= FetchMode.SELECT)
    private Set<Meal> meals = new HashSet<>();

}
