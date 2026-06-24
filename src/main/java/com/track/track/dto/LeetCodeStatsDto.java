package com.track.track.dto;

public class LeetCodeStatsDto {

    private String currentRating;
    private String highestRating;
    private String globalRank;
    private String totalSolved;
    private String contestsAttended;
    private String lastActive;
    private String easySolved;
    private String mediumSolved;
    private String hardSolved;

    public LeetCodeStatsDto() {}

    public LeetCodeStatsDto(String currentRating, String highestRating,
                            String globalRank, String totalSolved,
                            String contestsAttended, String lastActive,
                            String easySolved, String mediumSolved,
                            String hardSolved) {
        this.currentRating    = currentRating;
        this.highestRating    = highestRating;
        this.globalRank       = globalRank;
        this.totalSolved      = totalSolved;
        this.contestsAttended = contestsAttended;
        this.lastActive       = lastActive;
        this.easySolved       = easySolved;
        this.mediumSolved     = mediumSolved;
        this.hardSolved       = hardSolved;
    }

    public String getCurrentRating()    { return currentRating; }
    public void setCurrentRating(String v)    { this.currentRating = v; }
    public String getHighestRating()    { return highestRating; }
    public void setHighestRating(String v)    { this.highestRating = v; }
    public String getGlobalRank()       { return globalRank; }
    public void setGlobalRank(String v)       { this.globalRank = v; }
    public String getTotalSolved()      { return totalSolved; }
    public void setTotalSolved(String v)      { this.totalSolved = v; }
    public String getContestsAttended() { return contestsAttended; }
    public void setContestsAttended(String v) { this.contestsAttended = v; }
    public String getLastActive()       { return lastActive; }
    public void setLastActive(String v)       { this.lastActive = v; }
    public String getEasySolved()       { return easySolved; }
    public void setEasySolved(String v)       { this.easySolved = v; }
    public String getMediumSolved()     { return mediumSolved; }
    public void setMediumSolved(String v)     { this.mediumSolved = v; }
    public String getHardSolved()       { return hardSolved; }
    public void setHardSolved(String v)       { this.hardSolved = v; }
}