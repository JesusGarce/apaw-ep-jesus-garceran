package es.upm.miw.apaw_ep_jesus_garceran.league_resource;

import es.upm.miw.apaw_ep_jesus_garceran.team_data.Team;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Document
public class League {

    private static final int LEAGUE_YEAR = 2019;
    private static final int LEAGUE_MONTH = 10;
    private static final int MATCH_DAY = 10;
    private static final int MATCH_HOUR = 21;
    private static final int MATCH_MINUTE = 0;

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
            table.stream()
                    .filter(teamAway -> !teamLocal.equals(teamAway))
                    .forEach(teamAway -> this.calendar.add(new Match.Builder().date(LocalDateTime.of(LEAGUE_YEAR, LEAGUE_MONTH, MATCH_DAY + (table.indexOf(teamAway) - table.indexOf(teamLocal)), MATCH_HOUR, MATCH_MINUTE))
                            .local(teamLocal)
                            .away(teamAway)
                            .finished(false)
                            .build()));
        }
    }

    public void addTeam(Team team) {
        this.table.add(team);
        if (this.table.size() > 1)
            initializeCalendar();
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
