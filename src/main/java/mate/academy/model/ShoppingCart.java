package mate.academy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "sopping_carts")
public class ShoppingCart {
    @Id
    private Long id;
    @OneToMany
    @JoinTable(joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "ticket_id"))
    private List<Ticket> tickets;
    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    public ShoppingCart() {
    }

    public ShoppingCart(User user) {
        this.user = user;
    }

    public ShoppingCart(List<Ticket> tickets, User user) {
        this.tickets = tickets;
        this.user = user;
    }

    public ShoppingCart(Long id, List<Ticket> tickets, User user) {
        this.id = id;
        this.tickets = tickets;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ShoppingCart{"
                + "id=" + id
                + ", tickets=" + tickets
                + ", user=" + user
                + '}';
    }
}
