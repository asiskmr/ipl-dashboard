package com.yashtech.ipldeshboard.controller;

import com.yashtech.ipldeshboard.model.Team;
import com.yashtech.ipldeshboard.repository.MatchRepository;
import com.yashtech.ipldeshboard.repository.TeamRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {
    
    private final TeamRepository teamRepository;
    private final MatchRepository matchRepository;

    

    public TeamController(TeamRepository teamRepository, MatchRepository matchRepository) {

        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }



    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName){

        Team team = this.teamRepository.findByTeamName(teamName);
       
        if(team != null)
            team.setMatches(this.matchRepository.findLatestMatchesByTeam(teamName, 4));
        return team;
    }
}
