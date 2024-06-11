package HomeworkHibernateModule30.HibernateModule.repository;

import HomeworkHibernateModule30.HibernateModule.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
