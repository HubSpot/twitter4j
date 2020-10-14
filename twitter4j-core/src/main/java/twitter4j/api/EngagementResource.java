package twitter4j.api;

import twitter4j.EngagementResponse;
import twitter4j.EngagementTotalsRequest;
import twitter4j.TwitterException;

public interface EngagementResource {

  /**
   * Retrieve total impressions and engagements for a collection of Tweets.
   *
   * @return
   * @throws TwitterException
   */
  EngagementResponse getTotals(EngagementTotalsRequest engagementTotalsRequest) throws TwitterException;

  /**
   * Retrieve impressions and engagements for a collection of Tweets for a period up to 4 weeks in duration, back to September 1, 2014.
   *
   * @return
   * @throws TwitterException
   */
  EngagementResponse getLast28Hours() throws TwitterException;

  /**
   * Retrieve impressions and engagements for a collection of Tweets for the past 28 hours.
   *
   * @return
   * @throws TwitterException
   */
  EngagementResponse getHistorical() throws TwitterException;
}
