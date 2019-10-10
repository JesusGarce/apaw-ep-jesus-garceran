package es.upm.miw.apaw_ep_jesus_garceran.league_resource;

import es.upm.miw.apaw_ep_jesus_garceran.team_data.Team;

import java.time.LocalDateTime;

public class Match {
    private LocalDateTime date;
    private Team local;
    private Team away;
    private Result result;
    private boolean finished;

    public Match(LocalDateTime date, Team local, Team away, boolean finished) {
        this.date = date;
        this.local = local;
        this.away = away;
        this.finished = finished;
    }


    public LocalDateTime getDate() {
        return date;
    }

    public Team getLocal() {
        return local;
    }

    public Team getAway() {
        return away;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public boolean isFinished() {
        return finished;
    }

    public void finishMatch() {
        this.finished = true;
    }

    @Override
    public String toString() {
        return "Match{" +
                "date=" + date +
                ", local=" + local +
                ", away=" + away +
                ", result=" + result +
                ", finished=" + finished +
                '}';
    }

}
