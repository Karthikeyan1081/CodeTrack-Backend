package com.track.track.dto;

public class CodeforcesStatsDto {

    private String currentRating;
    private String highestRating;
    private String globalRank;
    private String totalSolved;
    private String contestsAttended;
    private String lastActive;

    public CodeforcesStatsDto() {
    }

    public CodeforcesStatsDto(String currentRating, String highestRating,
                              String globalRank, String totalSolved,
                              String contestsAttended, String lastActive) {
        this.currentRating = currentRating;
        this.highestRating = highestRating;
        this.globalRank = globalRank;
        this.totalSolved = totalSolved;
        this.contestsAttended = contestsAttended;
        this.lastActive = lastActive;
    }

    public String getCurrentRating() {
        return currentRating;
    }

    public void setCurrentRating(String currentRating) {
        this.currentRating = currentRating;
    }

    public String getHighestRating() {
        return highestRating;
    }

    public void setHighestRating(String highestRating) {
        this.highestRating = highestRating;
    }

    public String getGlobalRank() {
        return globalRank;
    }

    public void setGlobalRank(String globalRank) {
        this.globalRank = globalRank;
    }

    public String getTotalSolved() {
        return totalSolved;
    }

    public void setTotalSolved(String totalSolved) {
        this.totalSolved = totalSolved;
    }

    public String getContestsAttended() {
        return contestsAttended;
    }

    public void setContestsAttended(String contestsAttended) {
        this.contestsAttended = contestsAttended;
    }

    public String getLastActive() {
        return lastActive;
    }

    public void setLastActive(String lastActive) {
        this.lastActive = lastActive;
    }
}