import java.util.*;

public class Solution {
  static class AdjacentNode {
    final private int Weight;
    final private int Node;
    public AdjacentNode(int weight, int node) {
      this.Weight = weight;
      this.Node = node;
    }
  }
  public int networkDelayTime(int[][] times, int n, int k) {
    HashSet<Integer> visit = new HashSet<>();
    HashMap<Integer, List<AdjacentNode>> adjacentMap = new HashMap<>();
    for (int[] t : times) {
      int source = t[0];
      int target = t[1];
      int weight = t[2];
      if (!adjacentMap.containsKey(source)) {
        adjacentMap.put(source, new ArrayList<>());
      }
      adjacentMap.get(source).add(new AdjacentNode(weight, target));
    }
    // Dijkstra Algorithm
    PriorityQueue<AdjacentNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.Weight));
    // add init k
    queue.add(new AdjacentNode(0, k));
    int time = 0;
    while(queue.size() != 0) {
      AdjacentNode node = queue.poll();
      if (node != null) {
        if (visit.contains(node.Node)) {
          continue;
        }
        visit.add(node.Node);
        time = Math.max(time, node.Weight);
        List<AdjacentNode> adjList = adjacentMap.get(node.Node);
        if (adjList != null) {
          for (AdjacentNode adjNode : adjList) {
            if (!visit.contains(adjNode.Node)) {
              queue.add(new AdjacentNode(node.Weight + adjNode.Weight, adjNode.Node));
            }
          }
        }
      }
    }
    if (visit.size() == n) {
      return time;
    }
    return -1;
  }
}
