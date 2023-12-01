package com.example.secondday;

import com.example.secondday.Models.EmployModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Reposetory extends JpaRepository<EmployModel,Integer> {
}
