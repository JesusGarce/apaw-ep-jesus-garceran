package es.upm.miw.apaw_ep_jesus_garceran.league_resource;

public class MatchDto {

    private String date;
    private String local;
    private String away;
    private Result result;
    private boolean finished;

    public MatchDto() {
        //empty for framework
    }

    public MatchDto(Match match) {
        this.date = match.getDate().toString();
        this.local = match.getLocal().getName();
        this.away = match.getAway().getName();
        this.result = match.getResult();
        this.finished = match.isFinished();
    }

    public String getDate() {
        return date;
    }

    public String getLocal() {
        return local;
    }

    public String getAway() {
        return away;
    }

    public Result getResult() {
        return result;
    }

    public boolean isFinished() {
        return finished;
    }

    @Override
    public String toString() {
        return "MatchDto{" +
                "date=" + date +
                ", local=" + local +
                ", away=" + away +
                ", result=" + result +
                ", finished=" + finished +
                '}';
    }
}
