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

    public LocalDateTime getDate() {
        return date;
    }

    private void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Team getLocal() {
        return local;
    }

    private void setLocal(Team local) {
        this.local = local;
    }

    public Team getAway() {
        return away;
    }

    private void setAway(Team away) {
        this.away = away;
    }

    public Result getResult() {
        return result;
    }

    private void setResult(Result result) {
        this.result = result;
    }

    public boolean isFinished() {
        return finished;
    }

    private void setFinished(boolean finished) {
        this.finished = finished;
    }

    void addResult(Result result) {
        this.result = result;
    }

    void finishMatch() {
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
