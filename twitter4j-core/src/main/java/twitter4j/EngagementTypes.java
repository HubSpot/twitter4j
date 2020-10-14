package twitter4j;

public enum EngagementTypes {
  IMPRESSIONS("impressions"),
  ENGAGEMENTS("engagements"),
  FAVORITES("favorites"),
  RETWEETS("retweets"),
  QUOTE_TWEETS("quote_tweets"),
  REPLIES("replies"),
  VIDEO_VIEWS("video_views")
  ;

  private final String engagementName;

  EngagementTypes(String engagementName) {
    this.engagementName = engagementName;
  }

  public String getEngagementName() {
    return engagementName;
  }

  public static EngagementTypes from(String name) {
    return EngagementTypes.valueOf(name.toUpperCase());
  }
}
