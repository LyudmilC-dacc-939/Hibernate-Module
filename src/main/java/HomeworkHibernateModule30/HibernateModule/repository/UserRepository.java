package HomeworkHibernateModule30.HibernateModule.repository;

import HomeworkHibernateModule30.HibernateModule.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
