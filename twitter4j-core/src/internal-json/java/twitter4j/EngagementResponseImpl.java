package twitter4j;

import twitter4j.conf.Configuration;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*package*/ public class EngagementResponseImpl extends TwitterResponseImpl implements EngagementResponse, java.io.Serializable {

  Map<Long, Map<EngagementTypes, Integer>> perTweetMetricsOwned;
  Map<Long, Map<EngagementTypes, Integer>> perTweetMetricsUnowned;

  public EngagementResponseImpl(HttpResponse res, Configuration conf) throws TwitterException {
    super(res);
    JSONObject json = res.asJSONObject();
    init(json);
    if (conf.isJSONStoreEnabled()) {
      TwitterObjectFactory.clearThreadLocalMap();
      TwitterObjectFactory.registerJSONObject(this, json);
    }
  }

  public EngagementResponseImpl(JSONObject json) throws TwitterException {
    init(json);
  }

  private void init(JSONObject json) throws TwitterException {

    perTweetMetricsOwned = buildMap(json, "perTweetMetricsOwned");
    perTweetMetricsUnowned = buildMap(json, "perTweetMetricsUnowned");
  }

  private Map<Long, Map<EngagementTypes, Integer>> buildMap(JSONObject json, String object) throws TwitterException {
    Map<Long, Map<EngagementTypes, Integer>> perTweetMetricsOwnedBuilder = new HashMap<>();
    try {
      if (json.has(object)) {
        JSONObject perTweetMetricsOwned = json.getJSONObject(object);
        Iterator perTweetMetricsOwnedKeys = perTweetMetricsOwned.keys();
        while (perTweetMetricsOwnedKeys.hasNext()) {
          String tweetName = (String) perTweetMetricsOwnedKeys.next();
          JSONObject tweet = perTweetMetricsOwned.getJSONObject(tweetName);
          Iterator tweetKeys = tweet.keys();
          Map<EngagementTypes, Integer> perTweetMap = new HashMap<>();
          while (tweetKeys.hasNext()) {
            String tweetKey = (String) tweetKeys.next();
            int total = tweet.getInt(tweetKey);

            perTweetMap.put(EngagementTypes.from(tweetKey), total);
          }
          perTweetMetricsOwnedBuilder.put(Long.valueOf(tweetName), perTweetMap);
        }
      }
    } catch (JSONException jsone) {
      throw new TwitterException(jsone);
    }
    return Collections.unmodifiableMap(perTweetMetricsOwnedBuilder);
  }

  @Override
  public Map<Long, Map<EngagementTypes, Integer>> getPerTweetMetricsUnowned() {
    return null;
  }

  @Override
  public Map<Long, Map<EngagementTypes, Integer>> getperTweetMetricsOwned() {
    return null;
  }

  @Override
  public RateLimitStatus getRateLimitStatus() {
    return null;
  }

  @Override
  public int getAccessLevel() {
    return 0;
  }
}
