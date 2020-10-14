/*
 * Copyright 2007 Yusuke Yamamoto
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package twitter4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class EngagementTotalsRequest implements java.io.Serializable {

  private static final long serialVersionUID = 7422094739799350035L;
  private long[] tweets;
  private Set<EngagementTypes> engagementTypes;
  private Groupings groupings;

  public EngagementTotalsRequest(long[] tweets,
                                 Set<EngagementTypes> engagementTypes,
                                 Groupings groupings) {
    this.tweets = tweets;
    this.engagementTypes = engagementTypes;
    this.groupings = groupings;
  }

  /*package*/ HttpParameter[] asHttpParameterArray() {
    ArrayList<HttpParameter> params = new ArrayList<HttpParameter>();

    appendParameter("tweet_ids", StringUtil.join(tweets), params);
    appendParameter("engagement_types", StringUtil.join((String[]) engagementTypes.stream().map(EngagementTypes::getEngagementName).toArray()), params);
    appendParameter("groupings", groupings.toString(), params);

    HttpParameter[] paramArray = new HttpParameter[params.size()];
    return params.toArray(paramArray);
  }

  private void appendParameter(String name, String value, List<HttpParameter> params) {
    if (value != null) {
      params.add(new HttpParameter(name, value));
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    EngagementTotalsRequest that = (EngagementTotalsRequest) o;

    if (engagementTypes != that.engagementTypes) return false;
    if (tweets != that.tweets) return false;
    if (groupings != that.groupings) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = engagementTypes != null ? engagementTypes.hashCode() : 0;
    result = 31 * result + (tweets != null ? tweets.hashCode() : 0);
    result = 31 * result + (groupings != null ? groupings.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "EngagementTotalsRequest{" +
        "tweets='" + tweets + '\'' +
        ", engagementTypes=" + engagementTypes +
        ", groupings=" + groupings +
        '}';
  }

  public long[] getTweets() {
    return tweets;
  }

  public void setTweets(long[] tweets) {
    this.tweets = tweets;
  }


  public Set<EngagementTypes> getEngagementTypes() {
    return engagementTypes;
  }

  public void setEngagementTypes(Set<EngagementTypes> engagementTypes) {
    this.engagementTypes = engagementTypes;
  }

  public Groupings getGroupings() {
    return groupings;
  }

  public void setGroupings(Groupings groupings) {
    this.groupings = groupings;
  }
}
