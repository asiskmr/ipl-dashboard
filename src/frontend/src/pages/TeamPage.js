import { React, useEffect, useState } from 'react';
import { MatchDetailCard } from '../component/MatchDetailCard';
import { MatchSmallCard } from '../component/MatchSmallCard';

export const Teampage = () => {

     const [team, setTeam] = useState({matches: []})

    
    useEffect(   
       
        () => {

            const fetchMatches = async () => {
                console.log('test');
                const response = await fetch('http://localhost:8080/team/Delhi%20Capitals');
                const data = await response.json();
                console.log(data);
                setTeam(data);
            };

           fetchMatches();
        }, []
    );

  return (
    <div className="TeamPage">
      <h1> {team.teamName}</h1>     
      <MatchDetailCard match={team.matches[0]}/>

      {team.matches.slice(1).map(match => <MatchSmallCard match = {match}/>)}
     
    </div>
  );
}


