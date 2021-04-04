package kz.test.practice1.domain.competitor;

import kz.test.practice1.domain.enums.CompetitorType;

public abstract class Competitor {

    private final CompetitorType competitorType;

    public Competitor(CompetitorType competitorType) {
        this.competitorType = competitorType;
    }

    public CompetitorType getCompetitorType() {
        return competitorType;
    }
}
