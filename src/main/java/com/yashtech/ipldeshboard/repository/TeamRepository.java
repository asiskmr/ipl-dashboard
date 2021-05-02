package com.yashtech.ipldeshboard.repository;

import com.yashtech.ipldeshboard.model.Team;

import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Long> {

    Team findByTeamName(String teamName);
}
