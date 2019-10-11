package es.upm.miw.apaw_ep_jesus_garceran.league_resource;

public class ResultDto {
    private int localScore;
    private int awayScore;

    public ResultDto() {
        //empty for framework
    }

    public ResultDto (Result result){
        this.localScore = result.getLocalScore();
        this.awayScore = result.getAwayScore();
    }

    public ResultDto(int localScore, int awayScore) {
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
