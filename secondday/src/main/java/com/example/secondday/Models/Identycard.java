package com.example.secondday.Models;

import com.example.secondday.Models.EmployModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ID_card")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Identycard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    public String name;
    //it is child of employModel
    @OneToOne
    @JoinColumn(name = "employ")
    EmployModel employModel;
}
