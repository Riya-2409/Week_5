package com.ipl_and_censor_analyzer;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class IPLJSONProcessor {

    public static void processJson(String inputFile, String outputFile)throws IOException{
        // Read input JSON data
        ObjectMapper mapper = new ObjectMapper();
        List<IPLMatch> matches = mapper.readValue(new File(inputFile), mapper.getTypeFactory().constructCollectionType(List.class, IPLMatch.class));

        // Apply censorship
        for (IPLMatch match : matches) {
            match.setTeam1(com.ipl_and_censor_analyzer.Censorship.maskTeamName(match.getTeam1()));
            match.setTeam2(com.ipl_and_censor_analyzer.Censorship.maskTeamName(match.getTeam2()));
            match.setPlayerOfMatch(com.ipl_and_censor_analyzer.Censorship.redactPlayerOfMatch(match.getPlayerOfMatch()));
            // Masking score if needed (for this case, we assume only the teams need masking).
        }
        // Write the sanitized JSON data to a new file
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputFile), matches);
    }
}