package com.ipl_and_censor_analyzer;


import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;


public class IPLMatch {

    @JsonProperty("match_id")   // Map "match_id" from JSON to "matchId" in Java
    private int matchId;

    @JsonProperty("team1")
    private String team1;

    @JsonProperty("team2")
    private String team2;

    @JsonProperty("score")
    private Map<String, Integer> score;

    @JsonProperty("winner")
    private String winner;

    @JsonProperty("player_of_match")
    private String playerOfMatch;

    // Getters and setters

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public Map<String, Integer> getScore() {
        return score;
    }

    public void setScore(Map<String, Integer> score) {
        this.score = score;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
    public String getPlayerOfMatch() {
        return playerOfMatch;
    }

    public void setPlayerOfMatch(String playerOfMatch) {
        this.playerOfMatch = playerOfMatch;
    }
}
