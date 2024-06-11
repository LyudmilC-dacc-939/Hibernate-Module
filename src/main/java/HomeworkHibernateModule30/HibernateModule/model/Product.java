package HomeworkHibernateModule30.HibernateModule.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_name", nullable = false)
    private String productName;
    @Column(name = "product_store_id", nullable = false)
    //това е вътрешно ID за магазина, сектор, стелаж, позиция, бройка
    private String productUID;
    private ProductType productType;
    @Column(name = "is_discounted")
    private Boolean isDiscounted;
    @Column(name = "percentage_discount")
    private Integer percentageDiscount;
    private Double price;
}
