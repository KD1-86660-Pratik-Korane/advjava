package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entities.IPLTeam;

public interface IPLTeamDao {
      
	String signUpIPLTeam(IPLTeam iplTeam);

	List<IPLTeam> getAllTeams();

	List<IPLTeam> getSelectedTeams(int d, double e);

	List<IPLTeam> displayOwnernAbbrev(int nextInt, double nextDouble);

	String updateMaxAge(String next, int i);

	String deleteTeam(long nextLong);

	 
}
