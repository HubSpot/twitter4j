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

import javax.annotation.Generated;

import java.util.Map;

@Generated(
    value = "generate-lazy-objects.sh",
    comments = "This is Tool Generated Code. DO NOT EDIT",
    date = "2020-10-14"
)
final class LazyEngagementResponse implements twitter4j.EngagementResponse {
  private twitter4j.HttpResponse res;
  private ObjectFactory factory;
  private EngagementResponse target = null;

  LazyEngagementResponse(twitter4j.HttpResponse res, ObjectFactory factory) {
    this.res = res;
    this.factory = factory;
  }

  private EngagementResponse getTarget() {
    if (target == null) {
      try {
        target = factory.createEngagementResponse(res);
      } catch (TwitterException e) {
        throw new TwitterRuntimeException(e);
      }
    }
    return target;
  }


  public Map<Long, Map<EngagementTypes, Integer>> getPerTweetMetricsUnowned() {
    return getTarget().getPerTweetMetricsUnowned();
  }

  public Map<Long, Map<EngagementTypes, Integer>> getperTweetMetricsOwned() {
    return getTarget().getperTweetMetricsOwned();
  }

  public RateLimitStatus getRateLimitStatus() {
    return getTarget().getRateLimitStatus();
  }

  public int getAccessLevel() {
    return getTarget().getAccessLevel();
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof EngagementResponse)) return false;
    return getTarget().equals(o);
  }

  @Override
  public int hashCode() {
    return getTarget().hashCode();
  }

  @Override
  public String toString() {
    return "LazyEngagementResponse{" +
        "target=" + getTarget() +
        "}";
  }
}
