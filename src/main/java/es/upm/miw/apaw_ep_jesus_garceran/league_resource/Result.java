package es.upm.miw.apaw_ep_jesus_garceran.league_resource;


public class Result {
    private int localScore;
    private int awayScore;

    public Result(int localScore, int awayScore) {
        this.localScore = localScore;
        this.awayScore = awayScore;
    }

    public int getLocalScore() {
        return localScore;
    }

    public int getAwayScore() {
        return awayScore;
    }
}
