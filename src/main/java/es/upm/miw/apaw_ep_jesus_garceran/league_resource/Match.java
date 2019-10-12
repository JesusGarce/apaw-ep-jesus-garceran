package es.upm.miw.apaw_ep_jesus_garceran.league_resource;

import es.upm.miw.apaw_ep_jesus_garceran.team_data.Team;

import java.time.LocalDateTime;

public class Match {
    private LocalDateTime date;
    private Team local;
    private Team away;
    private Result result;
    private boolean finished;

    public Match() {
    }

    public Match(LocalDateTime date, Team local, Team away, boolean finished) {
        this.date = date;
        this.local = local;
        this.away = away;
        this.finished = finished;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Team getLocal() {
        return local;
    }

    public void setLocal(Team local) {
        this.local = local;
    }

    public Team getAway() {
        return away;
    }

    public void setAway(Team away) {
        this.away = away;
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

    public void setFinished(boolean finished) {
        this.finished = finished;
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


    public static class Builder {
        private Match match;

        public Builder() {
            this.match = new Match();
        }

        public Builder date(LocalDateTime date) {
            match.setDate(date);
            return this;
        }

        public Builder local(Team local) {
            match.setLocal(local);
            return this;
        }

        public Builder away(Team away) {
            match.setAway(away);
            return this;
        }

        public Builder result(Result result) {
            match.setResult(result);
            return this;
        }

        public Builder finished(boolean finished) {
            match.setFinished(finished);
            return this;
        }

        public Match build() {
            return match;
        }

    }

}
