package kz.test.practice1.domain.competitor;

import java.util.Collections;
import java.util.List;

public class Team {

    private List<Competitor> competitors;

    public Team() {
        this.competitors = Collections.emptyList();
    }

    public Team(List<Competitor> competitors) {
        this.competitors = competitors;
    }

    public List<Competitor> getCompetitors() {
        return competitors;
    }

    public void setCompetitors(List<Competitor> competitors) {
        this.competitors = competitors;
    }
}
