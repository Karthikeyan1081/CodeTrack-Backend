package com.track.track.dto;

public class CodeChefStatsDto {

    private String currentRating;
    private String highestRating;
    private String globalRank;
    private String countryRank;
    private String totalSolved;
    private String contestsAttended;
    private String lastActive;
    private String stars;
    private String division;

    public CodeChefStatsDto() {}

    public CodeChefStatsDto(String currentRating, String highestRating,
                            String globalRank, String countryRank,
                            String totalSolved, String contestsAttended,
                            String lastActive, String stars,
                            String division) {
        this.currentRating    = currentRating;
        this.highestRating    = highestRating;
        this.globalRank       = globalRank;
        this.countryRank      = countryRank;
        this.totalSolved      = totalSolved;
        this.contestsAttended = contestsAttended;
        this.lastActive       = lastActive;
        this.stars            = stars;
        this.division         = division;
    }

    public String getCurrentRating()    { return currentRating; }
    public void setCurrentRating(String v)    { this.currentRating = v; }
    public String getHighestRating()    { return highestRating; }
    public void setHighestRating(String v)    { this.highestRating = v; }
    public String getGlobalRank()       { return globalRank; }
    public void setGlobalRank(String v)       { this.globalRank = v; }
    public String getCountryRank()      { return countryRank; }
    public void setCountryRank(String v)      { this.countryRank = v; }
    public String getTotalSolved()      { return totalSolved; }
    public void setTotalSolved(String v)      { this.totalSolved = v; }
    public String getContestsAttended() { return contestsAttended; }
    public void setContestsAttended(String v) { this.contestsAttended = v; }
    public String getLastActive()       { return lastActive; }
    public void setLastActive(String v)       { this.lastActive = v; }
    public String getStars()            { return stars; }
    public void setStars(String v)            { this.stars = v; }
    public String getDivision()         { return division; }
    public void setDivision(String v)         { this.division = v; }
}