package kz.muminov.midtermrestaraunt.entity;

import kz.muminov.midtermrestaraunt.enums.OrderStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "orders")
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private LocalDate orderDate = LocalDate.now();

    @NonNull
    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.NOT_PAYED;

    @NonNull
    @Column(name = "user_id")
    private Long pickerId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User orderPicker;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "order_items",
               joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")},
               inverseJoinColumns = {@JoinColumn(name = "meal_id", referencedColumnName = "id")}
    )
    private List<Meal> meals = new ArrayList<>();

}
