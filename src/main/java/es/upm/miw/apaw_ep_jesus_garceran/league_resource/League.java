package es.upm.miw.apaw_ep_jesus_garceran.league_resource;

import es.upm.miw.apaw_ep_jesus_garceran.team_resource.Team;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class League {
    private String id;
    private String name;
    private List<Team> table;
    private List<Match> calendar;

    public League(String id, String name, List<Team> table) {
        this.id = id;
        this.name = name;
        this.table = table;
        this.calendar = initializeCalendar();
    }

    public League(String name) {
        this.name = name;
        this.table = new LinkedList<>();
    }

    private List<Match> initializeCalendar() {
        List<Match> calendar = new LinkedList<>();
        for (Team teamLocal : table) {
            for (Team teamAway : table) {
                if (!teamLocal.equals(teamAway)) {
                    int day = 10;
                    calendar.add(new Match(LocalDateTime.of(2019, 10, day++, 21, 0), teamLocal, teamAway, false));
                }
            }
        }
        return calendar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public List<Team> getTable() {
        return table;
    }

    public List<Match> getCalendar() {
        return calendar;
    }

    @Override
    public String toString() {
        return "League{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", table=" + table +
                ", calendar=" + calendar +
                '}';
    }
}
