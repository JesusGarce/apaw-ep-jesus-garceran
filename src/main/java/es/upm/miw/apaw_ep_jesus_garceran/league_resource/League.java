package es.upm.miw.apaw_ep_jesus_garceran.league_resource;

import es.upm.miw.apaw_ep_jesus_garceran.team_data.Team;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Document
public class League {
    @Id
    private String id;
    private String name;
    private List<Team> table;
    private List<Match> calendar;

    public League(String name, List<Team> table) {
        this.name = name;
        this.table = table;
    }

    public void initializeCalendar() {
        this.calendar = new LinkedList<>();
        for (Team teamLocal : table) {
            int day = 10;
            for (Team teamAway : table) {
                if (!teamLocal.equals(teamAway)) {
                    this.calendar.add(new Match.Builder().date(LocalDateTime.of(2019, 10, day++, 21, 0))
                                                         .local(teamLocal)
                                                         .away(teamAway)
                                                         .finished(false)
                                                         .build());
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
