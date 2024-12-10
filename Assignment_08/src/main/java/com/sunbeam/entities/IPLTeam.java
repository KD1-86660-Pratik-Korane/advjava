package com.sunbeam.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="teams")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper=true,exclude={"players"})
public class IPLTeam extends BaseEntity{
	
	   @Column(length=100,unique=true)
       private String name;
	   @Column(length=10,unique=true)
       private String abbreviation;
	   @Column(length=20,nullable=false)
       private String owner;
	   @Column(name="max_player_age")
       private int maxPlayerAge;
	   @Column(name="batting_avg")
       private double battingAvg;
	   @Column(name="wickets_taken")
       private int wicketsTaken;
       @OneToMany (mappedBy="playerTeam")
	   private List<Player> players=new ArrayList<>();
	   
	
	public IPLTeam(String owner, String  abbreviation) {
		super();
		this.abbreviation = abbreviation;
		this.owner = owner;
	}



	public IPLTeam(String name, String abbreviation, String owner, int maxPlayerAge, double battingAvg,
			int wicketsTaken) {
		super();
		this.name = name;
		this.abbreviation = abbreviation;
		this.owner = owner;
		this.maxPlayerAge = maxPlayerAge;
		this.battingAvg = battingAvg;
		this.wicketsTaken = wicketsTaken;
	}
     
	 public void addPlayer(Player player) {
		 this.players.add(player);
		 player.setPlayerTeam(this);
	 }
	 
	 public void removePlayer(Player player) {
			this.removePlayer(player);
			player.setPlayerTeam(null);
		}
	 
	
       
}
