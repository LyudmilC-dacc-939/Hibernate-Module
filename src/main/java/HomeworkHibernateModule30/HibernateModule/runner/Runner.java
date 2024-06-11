package HomeworkHibernateModule30.HibernateModule.runner;

import HomeworkHibernateModule30.HibernateModule.model.Order;
import HomeworkHibernateModule30.HibernateModule.model.Product;
import HomeworkHibernateModule30.HibernateModule.model.ProductType;
import HomeworkHibernateModule30.HibernateModule.model.User;
import HomeworkHibernateModule30.HibernateModule.repository.OrderRepository;
import HomeworkHibernateModule30.HibernateModule.repository.ProductRepository;
import HomeworkHibernateModule30.HibernateModule.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class Runner implements CommandLineRunner {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Autowired
    public Runner(UserRepository userRepository,
                  OrderRepository orderRepository,
                  ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        User user = new User();
        user.setEMail("test@gmail.com");
        user.setFirstName("Mihail");
        user.setLastName("Petlechkov");
        user.setPassword("123456789");
        User savedUser = userRepository.save(user);

        Product product1 = new Product();
        product1.setProductName("Borchvor Bulgarian Yoghurt");
        product1.setIsDiscounted(false);
        product1.setProductUID("M244A21");
        product1.setProductType(ProductType.DAIRY);
        product1.setPrice(2.41);

        Product product2 = new Product();
        product2.setProductName("Tomatoes");
        product2.setIsDiscounted(true);
        product2.setProductUID("A2000V14");
        product2.setProductType(ProductType.FRUITS_AND_VEGETABLES);
        product2.setPercentageDiscount(10);
        product2.setPrice(3.30);

        Product product3 = new Product();
        product3.setProductName("Simid Bread");
        product3.setIsDiscounted(false);
        product3.setProductUID("H7G822");
        product3.setProductType(ProductType.CORE_PRODUCTS);
        product3.setPrice(1.23);

        Product product4 = new Product();
        product4.setProductName("Can Of Beans Mixed");
        product4.setIsDiscounted(false);
        product4.setProductUID("JG6E3297");
        product4.setProductType(ProductType.CANNED);
        product4.setPrice(4.79);

        Set<Product> products = new HashSet<>(2);
        products.add(product1);
        products.add(product2);
        double finalPrice = 0;
        for (Product product: products){
            finalPrice = product.getPrice()+finalPrice;
        }

        Set<Product> products2 = new HashSet<>(2);
        products2.add(product3);
        products2.add(product4);
//git commit -m "first commit"


        productRepository.saveAll(products);
        productRepository.saveAll(products2);

        Order order = new Order();
        order.setNumberOfProducts(products.size());
        order.setProducts(products);
        order.setUser(savedUser);
        order.setFinalPrice(finalPrice);

        Order order2 = new Order();
        order2.setNumberOfProducts(products2.size());
        order2.setProducts(products2);
        order2.setUser(savedUser);
        order2.setFinalPrice(product3.getPrice()+product4.getPrice());

        orderRepository.save(order);
        orderRepository.save(order2);

        User currentUser = userRepository.findById(1L).get();

        Set<Order> userOrders = currentUser.getOrders();
        Order savedOrder = orderRepository.findById(1L).get();
        System.out.println(currentUser.toString());


    }
}
