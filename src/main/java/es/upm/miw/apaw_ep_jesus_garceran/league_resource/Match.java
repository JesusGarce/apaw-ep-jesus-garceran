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
        // empty for framework
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

    public boolean isFinished() {
        return finished;
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
            match.date = date;
            return this;
        }

        public Builder local(Team local) {
            match.local = local;
            return this;
        }

        public Builder away(Team away) {
            match.away = away;
            return this;
        }

        public Builder result(Result result) {
            match.result = result;
            return this;
        }

        public Builder finished(boolean finished) {
            match.finished = finished;
            return this;
        }

        public Match build() {
            return match;
        }

    }

}
