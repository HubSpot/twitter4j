package twitter4j;

import java.io.Serializable;
import java.util.List;

public class Groupings implements Serializable {

  private String groupingName;
  private List<String> groupBy;

  Groupings(
      String groupingName,
      List<String> groupBy
  ) {
    this.groupingName = groupingName;

    this.groupBy = groupBy;
  }

  public String getGroupingName() {
    return groupingName;
  }

  public void setGroupingName(String groupingName) {
    this.groupingName = groupingName;
  }

  public List<String> getGroupBy() {
    return groupBy;
  }

  public void setGroupBy(List<String> groupBy) {
    this.groupBy = groupBy;
  }

  @Override
  public String toString() {
    return "\"groupings\": { " +
        String.format("\"%s\"= { ", groupingName) +
        "groupBy= [" + StringUtil.join((String[]) groupBy.toArray()) +
        "] " +
        "}" +
        "}";
  }
}
