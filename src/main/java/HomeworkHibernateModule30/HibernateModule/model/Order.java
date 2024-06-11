package HomeworkHibernateModule30.HibernateModule.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "number_of_products", nullable = false)
    private Integer numberOfProducts;
    @Column(name = "Discount_percentage")
    private Double discountPercentage;
    @Column(name = "checkout_price")
    private Double finalPrice;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "order_products",
            joinColumns = @JoinColumn (name = "order_id"),
            inverseJoinColumns = @JoinColumn (name = "product_id")
    )
    private Set<Product> products = new HashSet<>();

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", numberOfProducts=" + numberOfProducts +
                ", discountPercentage=" + discountPercentage +
                ", finalPrice=" + finalPrice +
//                ", user=" + user +
                '}';
    }
}
