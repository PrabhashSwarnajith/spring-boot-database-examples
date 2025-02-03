package lk.zerocode.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "bus_employees",
        indexes = {
                @Index(name = "idx_emp_type", columnList = "employment_type")
        })
public class BusEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private EmploymentType employmentType;

    @ManyToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;
}
