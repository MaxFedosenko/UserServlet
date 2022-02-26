package com.tms.web.entities;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private Integer number;
    @Enumerated(EnumType.STRING)
    private BRAND brand;
    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "cars_regions",
//            joinColumns = {@JoinColumn(name = "car_id")},
//            inverseJoinColumns = {@JoinColumn(name = "region_id")}
//    )
    private List<Region> regions;
    @ManyToOne(cascade = CascadeType.ALL)
    private Client client;
    @Temporal(TemporalType.DATE)
    @Column(name = "presentation")
    private Date release;
    private Boolean isInStore;
    @CreationTimestamp
    private Date creationTime;
    @UpdateTimestamp
    private Date lastUpdateTime;
    @Version
    private Long version;

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", number=" + number +
                ", brand=" + brand +
                ", regions=" + regions +
                ", release=" + release +
                ", isInStore=" + isInStore +
                ", creationTime=" + creationTime +
                ", lastUpdateTime=" + lastUpdateTime +
                ", version=" + version +
                '}';
    }
}