package es.upm.miw.apaw_ep_jesus_garceran.league_resource;

import es.upm.miw.apaw_ep_jesus_garceran.team_data.Team;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class League {
    private String id;
    private String name;
    private List<Team> table;
    private List<Match> calendar;

    public League() {
        // empty for framework
    }

    public League(String id, String name, List<Team> table) {
        this.id = id;
        this.name = name;
        this.table = table;
        initializeCalendar();
    }

    public League(String id, String name) {
        this.id = id;
        this.name = name;
        this.table = new LinkedList<>();
    }

    private void initializeCalendar() {
        this.calendar = new LinkedList<>();
        for (Team teamLocal : table) {
            int day = 10;
            for (Team teamAway : table) {
                if (!teamLocal.equals(teamAway)) {
                    this.calendar.add(new Match(LocalDateTime.of(2019, 10, day++, 21, 0), teamLocal, teamAway, false));
                }
            }
        }
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
