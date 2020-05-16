package kz.muminov.midtermrestaraunt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@ApiModel(value = "Meal")
@NoArgsConstructor
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private float price;

    @NonNull
    @Column(name = "category_id")
    @JsonIgnore
    private Long categoryId;

    @NonNull
    private String imageLink;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private MealCategory mealCategory;

    @ManyToMany(mappedBy = "meals", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Order> orders = new ArrayList<>();

    @ManyToMany(mappedBy = "meals", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Stock> stocks = new HashSet<>();

}
