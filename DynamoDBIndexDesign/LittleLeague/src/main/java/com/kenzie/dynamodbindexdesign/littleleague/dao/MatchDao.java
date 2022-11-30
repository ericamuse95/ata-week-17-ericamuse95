package com.kenzie.dynamodbindexdesign.littleleague.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.kenzie.dynamodbindexdesign.littleleague.model.Match;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.kenzie.dynamodbindexdesign.littleleague.utilities.DynamoDbClientProvider;

import java.util.*;
import javax.inject.Inject;

import static com.kenzie.dynamodbindexdesign.littleleague.model.Match.HOME_TEAM_MATCHES_INDEX;
import static com.kenzie.dynamodbindexdesign.littleleague.model.Match.AWAY_TEAM_MATCHES_INDEX;
public class MatchDao {
    private DynamoDBMapper mapper;

    /**
     * Allows access to and manipulation of Match objects from the data store.
     * @param mapper Access to DynamoDB
     */
    @Inject
    public MatchDao(DynamoDBMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * Retrieves all home matches for the given team between startDate and endDate, inclusive.
     * @param team The name of the team to fetch matches for
     * @param startDate The first date to return matches for
     * @param endDate The last date to return matches for
     * @return A list of the matches for the given team between the given dates
     */
    public List<Match> getHomeMatchesForTeam(String team, String startDate, String endDate) {
        // PARTICIPANTS: Implement.
        //               use DynamoDBMapper's query method to retrieve all home games
        //               for the given team in the given date range.
        Map<String, AttributeValue> valueMap = new HashMap<>();
        valueMap.put(":team", new AttributeValue().withS(team));
        valueMap.put(":start_date", new AttributeValue().withS(startDate));
        valueMap.put(":end_date", new AttributeValue().withS(endDate));
        DynamoDBQueryExpression<Match> queryExpression = new DynamoDBQueryExpression<Match>().withIndexName("HomeTeamMatchesIndex")
                .withConsistentRead(false)
                .withKeyConditionExpression("homeTeam = :team and matchDate between :start_date and :end_date")
                .withExpressionAttributeValues(valueMap);

        PaginatedQueryList<Match> matches = mapper.query(Match.class, queryExpression);
        return matches;
    }

    /**
     * Retrieves all away matches for the given team between startDate and endDate, inclusive.
     * @param team The name of the team to fetch matches for
     * @param startDate The first date to return matches for
     * @param endDate The last date to return matches for
     * @return A list of the matches for the given team between the given dates
     */
    public List<Match> getAwayMatchesForTeam(String team, String startDate, String endDate) {
        // PARTICIPANTS: Implement.
        //               use DynamoDBMapper's query method to retrieve all away games
        //               for the given team in the given date range.
        Map<String, AttributeValue> valueMap = new HashMap<>();
        valueMap.put(":team", new AttributeValue().withS(team));
        valueMap.put(":start_date", new AttributeValue().withS(startDate));
        valueMap.put(":end_date", new AttributeValue().withS(endDate));
        DynamoDBQueryExpression<Match> queryExpression = new DynamoDBQueryExpression<Match>().withIndexName("AwayTeamMatchesIndex")
                .withConsistentRead(false)
                .withKeyConditionExpression("awayTeam = :team and matchDate between :start_date and :end_date")
                .withExpressionAttributeValues(valueMap);
        PaginatedQueryList<Match> matches = mapper.query(Match.class, queryExpression);
        return matches;

    }

    /**
     * Retrieves all matches for the given team between startDate and endDate, inclusive.
     * @param team The name of the team to fetch matches for
     * @param startDate The first date to return matches for
     * @param endDate The last date to return matches for
     * @return A list of the matches for the given team between the given dates
     */
    public List<Match> getAllMatchesForTeam(String team, String startDate, String endDate) {
        // PARTICIPANTS: Implement.
        //               use DynamoDBMapper's query method to retrieve all away games
        //               and home games for the given team in the given date range.
        //               Then combine the two into one list.

        //home games
        Map<String, AttributeValue> valueMap = new HashMap<>();
        valueMap.put(":team", new AttributeValue().withS(team));
        valueMap.put(":start_date", new AttributeValue().withS(startDate));
        valueMap.put(":end_date", new AttributeValue().withS(endDate));
        DynamoDBQueryExpression<Match> queryExpression = new DynamoDBQueryExpression<Match>().withIndexName("HomeTeamMatchesIndex")
                .withConsistentRead(false)
                .withKeyConditionExpression("homeTeam = :team and matchDate between :start_date and :end_date")
                .withExpressionAttributeValues(valueMap);
        //away team
        valueMap.put(":team", new AttributeValue().withS(team));
        valueMap.put(":start_date", new AttributeValue().withS(startDate));
        valueMap.put(":end_date", new AttributeValue().withS(endDate));
        DynamoDBQueryExpression<Match> queryExpression1 = new DynamoDBQueryExpression<Match>().withIndexName("AwayTeamMatchesIndex")
                .withConsistentRead(false)
                .withKeyConditionExpression("awayTeam = :team and matchDate between :start_date and :end_date")
                .withExpressionAttributeValues(valueMap);
        PaginatedQueryList<Match> matches = mapper.query(Match.class, queryExpression);
        PaginatedQueryList<Match> matches1 = mapper.query(Match.class, queryExpression1);

        List<Match> matchList = new ArrayList<>();
        matchList.addAll(matches1);
        matchList.addAll(matches);
        return matchList;

    }
}
