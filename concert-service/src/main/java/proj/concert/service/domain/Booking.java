package proj.concert.service.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import proj.concert.common.jackson.LocalDateTimeDeserializer;
import proj.concert.common.jackson.LocalDateTimeSerializer;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "BOOKINGS")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    private LocalDateTime date;


    // Gives booking ownership of seats, by placing it as a foreign key in the seat table.
    @OneToMany(mappedBy = "booking")
    private Set<Seat> seats = new HashSet<>();
    public Booking(){}

    public Booking(Long id, User user, Concert concert){
        this.id = id;
        this.user = user;
    }

    public Booking (User user, Concert concert){
        this(null, user, concert);

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, user, date);
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Booking)) {
            return false;
        }
        Booking other = (Booking) obj;
        return Objects.equals(id, other.id) &&
                Objects.equals(user, other.user) &&
                Objects.equals(date, other.date);
    }


}
