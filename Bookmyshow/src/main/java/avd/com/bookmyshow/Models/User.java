package avd.com.bookmyshow.Models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "USERS")
public class User extends Auditable{
    private String name;
    private String phone;
    private String email;
    private String hashedSaltedPassword;

    Set<>
}
