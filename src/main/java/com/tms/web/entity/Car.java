package com.tms.web.entity;



import com.sun.istack.Nullable;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private Integer number;
    @Enumerated(EnumType.STRING)
    private BRAND brand;
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

    public Car() {
    }

    public Car(Integer number, BRAND brand, Date release, Boolean isInStore) {
        this.number = number;
        this.brand = brand;
        this.release = release;
        this.isInStore = isInStore;
    }
}