package es.upm.miw.apaw_ep_jesus_garceran.league_resource;

import es.upm.miw.apaw_ep_jesus_garceran.exceptions.NotFoundException;
import es.upm.miw.apaw_ep_jesus_garceran.team_data.Team;
import es.upm.miw.apaw_ep_jesus_garceran.team_data.TeamDao;
import es.upm.miw.apaw_ep_jesus_garceran.team_data.TeamDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class LeagueBusinessController {

    private LeagueDao leagueDao;
    private TeamDao teamDao;
    private EmitterProcessor<String> emitter;
    private List<String> idLeaguesToPublish;

    @Autowired
    public LeagueBusinessController(TeamDao teamDao, LeagueDao leagueDao) {
        this.teamDao = teamDao;
        this.leagueDao = leagueDao;
        this.emitter = EmitterProcessor.create();
        this.idLeaguesToPublish = new LinkedList<>();
    }

    public LeagueDto create(LeagueDto leagueDto) {
        League league = new League(leagueDto.getName(), new LinkedList<>());
        this.leagueDao.save(league);
        return new LeagueDto(league);
    }


    public void addTeam(String id, String name) {
        League league = this.findLeagueByIdAssured(id);
        Team team = this.teamDao.findByName(name);
        league.addTeam(team);
        if (idLeaguesToPublish.contains(id))
            emitter.onNext(team.getName());
        this.leagueDao.save(league);
    }

    private League findLeagueByIdAssured(String id) {
        return this.leagueDao.findById(id).orElseThrow(() -> new NotFoundException("League id: " + id));
    }

    public void changeResult(String idLeague, int idMatch, ResultDto resultDto) {
        League league = this.findLeagueByIdAssured(idLeague);
        Match match = league.getCalendar().remove(idMatch);
        match.addResult(new Result(resultDto.getLocalScore(), resultDto.getAwayScore()));
        finishMatch(league, match);
        league.getCalendar().add(idMatch, match);
        this.leagueDao.save(league);
    }

    private void finishMatch(League league, Match match) {
        match.finishMatch();
        if (match.getResult().getAwayScore() > match.getResult().getLocalScore()) {
            addPoints(league, match.getAway(), 3);
            this.teamDao.save(match.getAway());
        } else if (match.getResult().getLocalScore() > match.getResult().getAwayScore()) {
            addPoints(league, match.getLocal(), 3);
            this.teamDao.save(match.getLocal());
        } else {
            addPoints(league, match.getAway(), 1);
            addPoints(league, match.getLocal(), 1);
            this.teamDao.save(match.getLocal());
            this.teamDao.save(match.getAway());
        }
    }

    private void addPoints(League league, Team team, int points) {
        league.getTable().stream()
                .filter(object -> object.getName().equals(team.getName()))
                .forEach(object -> object.addPoints(points));
    }

    public List<MatchDto> findMatchesByDate(String idLeague, LocalDateTime localDateTime) {
        League league = this.findLeagueByIdAssured(idLeague);
        return league.getCalendar().stream()
                .filter(match -> match.getDate().equals(localDateTime))
                .map(MatchDto::new)
                .collect(Collectors.toList());
    }

    public List<TeamDto> getTable(String id) {
        League league = this.findLeagueByIdAssured(id);
        return league.getTable().stream()
                .map(TeamDto::new)
                .collect(Collectors.toList());
    }

    public Flux<String> publisher(String leagueId) {
        this.idLeaguesToPublish.add(leagueId);
        return this.emitter;
    }

}
