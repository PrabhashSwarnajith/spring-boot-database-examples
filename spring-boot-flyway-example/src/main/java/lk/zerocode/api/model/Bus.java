package lk.zerocode.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "buses")
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reg_no", unique = true)
    private String regNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private BusOwner owner;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "bus_routes", joinColumns = {
            @JoinColumn(name = "bus_id")
    }, inverseJoinColumns = {@JoinColumn(name = "route_id")})
    private List<Route> routes = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bus")
    private List<BusEmployee> employees = new ArrayList<>();
}
