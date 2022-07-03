package ibragim.project.core.orm.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "t_cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="model", columnDefinition = "TEXT")
    private String model;

    @Column(name="price")
    private int price;

    @Column(name = "year")
    private int year;

    @ManyToOne(fetch = FetchType.LAZY)
    Country country;




}
