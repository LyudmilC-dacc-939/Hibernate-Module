package HomeworkHibernateModule30.HibernateModule.repository;

import HomeworkHibernateModule30.HibernateModule.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
