package com.sunbeam.entities;

import javax.persistence.*;

@Entity
@Table(name="teams")
public class IPLTeam {
	
	   @Id
	   @Column(name="team_id")
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
       private Long teamId;
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

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getMaxPlayerAge() {
		return maxPlayerAge;
	}

	public void setMaxPlayerAge(int maxPlayerAge) {
		this.maxPlayerAge = maxPlayerAge;
	}

	public double getBattingAvg() {
		return battingAvg;
	}

	public void setBattingAvg(double battingAvg) {
		this.battingAvg = battingAvg;
	}

	public int getWicketsTaken() {
		return wicketsTaken;
	}

	public void setWicketsTaken(int wicketsTaken) {
		this.wicketsTaken = wicketsTaken;
	}

	@Override
	public String toString() {
		return "IPLTeam [teamId=" + teamId + ", name=" + name + ", abbreviation=" + abbreviation + ", owner=" + owner
				+ ", maxPlayerAge=" + maxPlayerAge + ", battingAvg=" + battingAvg + ", wicketsTaken=" + wicketsTaken
				+ "]";
	}
       
	
       
}
