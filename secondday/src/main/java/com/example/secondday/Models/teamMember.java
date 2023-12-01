package com.example.secondday.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "teamMember")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class teamMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    public String work;
    public String groupName;
    public String totalMembers;

    //it is parent of employModel
    @OneToMany(mappedBy = "teamMember",cascade = CascadeType.ALL)
    List<EmployModel> employModels;

}
