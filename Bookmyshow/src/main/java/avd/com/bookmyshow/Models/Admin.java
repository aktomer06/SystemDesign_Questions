package avd.com.bookmyshow.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table
public class Admin {
    @Id
    Long id;

    private String designation;
    private String department;

    private List<Role> roles = new ArrayList<>();

    @OneToOne
    private User user;
}
