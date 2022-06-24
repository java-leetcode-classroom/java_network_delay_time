import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
  final private Solution sol = new Solution();
  @Test
  void networkDelayTimeExample1() {
    assertEquals(2, sol.networkDelayTime(new int[][]{
        {2,1,1},
        {2,3,1},
        {3,4,1}
    }, 4, 2));
  }

  @Test
  void networkDelayTimeExample2() {
    assertEquals(1, sol.networkDelayTime(new int[][]{
        {1,2,1},
    }, 2, 1));
  }
  @Test
  void networkDelayTimeExample3() {
    assertEquals(-1, sol.networkDelayTime(new int[][]{
        {1,2,1},
    }, 2, 2));
  }
}