package com.ipl_and_censor_analyzer;
public class Censorship {

    // Mask team names by replacing part of the name with "*"
    public static String maskTeamName(String teamName){
        int spaceIndex = teamName.indexOf(' ');
        if(spaceIndex != -1){
            return teamName.substring(0, spaceIndex+1)+ "*";
        }
        return teamName;
    }

    // Redact player names by replacing with "REDACTED"
    public static String redactPlayerOfMatch(String playerName) {
        return "REDACTED";
    }

}