package HomeworkHibernateModule30.HibernateModule.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", nullable = false, length = 40)
    private String firstName;
    @Column(name = "last_name",nullable = false, length = 50)
    private String lastName;
    @Column(name = "e_mail_address", nullable = false, length = 150)
    private String eMail;
    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user",
            //пишейки mappedBy му казваме в класа Order по какво ще мапва
            cascade = CascadeType.ALL,
            //определя какво става с orders ако трием User-а
            fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<Order> orders = new HashSet<>();


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", eMail='" + eMail + '\'' +
                ", password='" + password + '\'' +
                ", orders=" + orders +
                '}';
    }
}

