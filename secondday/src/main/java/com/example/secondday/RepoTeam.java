package com.example.secondday;

import com.example.secondday.Models.teamMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoTeam extends JpaRepository<teamMember,Integer> {
}
