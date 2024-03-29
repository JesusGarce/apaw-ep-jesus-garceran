package es.upm.miw.apaw_ep_jesus_garceran.team_resource;

import es.upm.miw.apaw_ep_jesus_garceran.team_data.Team;
import es.upm.miw.apaw_ep_jesus_garceran.team_data.TeamDao;
import es.upm.miw.apaw_ep_jesus_garceran.team_data.TeamDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TeamBusinessController {

    private TeamDao teamDao;

    @Autowired
    public TeamBusinessController(TeamDao teamDao) {
        this.teamDao = teamDao;
    }

    public TeamDto create(TeamDto teamDto) {
        Team team = new Team(teamDto.getName(), teamDto.getCity(), teamDto.getBadge(), 0);
        this.teamDao.save(team);
        return new TeamDto(team);
    }

    public List<TeamDto> getAll() {
        return this.teamDao.findAll()
                .stream()
                .map(TeamDto::new)
                .collect(Collectors.toList());
    }
}
