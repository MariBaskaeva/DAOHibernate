package ru.netology.daohibernate.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;


@Data
@DynamicInsert
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Persons {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private Integer age;

    private Integer phoneNumber;

    private String cityOfLiving;
}
