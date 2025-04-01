package parkinglot.factories;

import parkinglot.models.enums.SpotAssignmentStrategyType;
import parkinglot.strategies.spotAssignmentStrategy.CheaptestSpotAssignmentStrategy;
import parkinglot.strategies.spotAssignmentStrategy.RandomSpotAssignmentStrategy;
import parkinglot.strategies.spotAssignmentStrategy.SpotAssignmentStrategy;

public class SpotAssignmentStrategyFactory {
    public static SpotAssignmentStrategy getSpotAssignmentStrategy(
            SpotAssignmentStrategyType spotAssignmentStrategyType
    ) {
        if (spotAssignmentStrategyType.equals(SpotAssignmentStrategyType.CHEAPEST)) {
            return new CheaptestSpotAssignmentStrategy();
        } else if (spotAssignmentStrategyType.equals(SpotAssignmentStrategyType.RANDOM)) {
            return new RandomSpotAssignmentStrategy();
        }

        return null;
    }
}
