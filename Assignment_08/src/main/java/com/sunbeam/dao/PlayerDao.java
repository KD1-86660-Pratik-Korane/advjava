package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entities.Player;

public interface PlayerDao {

	 String addPlayerToTeam(Player player, Long teamId);

	List<Player> getAllPlayers(Long teamId);

	String deletePlayerFromTeam(Long playerId, Long teamId);  

}
