package be.vdab;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


@Embeddable
public class PassengerId implements Serializable {
    @Column(nullable = false, updatable = false)
    private String ssn;
    @Column(length = 50)
    private String lastName;

}
