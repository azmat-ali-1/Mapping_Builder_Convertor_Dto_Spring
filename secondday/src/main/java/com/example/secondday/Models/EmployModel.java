package com.example.secondday.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employTable")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EmployModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String name;
    public String department;
    public int income;
    //it is parent class of identity card
    @OneToOne(mappedBy = "employModel",cascade = CascadeType.ALL)
    Identycard identycard;

    //it is child of team member
    @ManyToOne
    @JoinColumn(name = "IdOfTeam")
    com.example.secondday.Models.teamMember teamMember;
}
