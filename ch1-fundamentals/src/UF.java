import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @date 06/03/2019
 * @author Junhao Wang
 */

public class UF {
  private int[] id;  // access to component id (site indexed)
  private int count; // number of component

  public UF(int n) {
    count = n;
    id = new int[n];
    for (int i = 0; i < n; ++i) {
      id[i] = i;
    }
  }

  public int count() {
    return count;
  }

  public boolean connected(int p, int q) {
    return find(p) == find(q);
  }

  /**
   * Quick-Find
   */

  public int find_qf(int p) {
    return id[p];
  }

  public void union_qf(int p, int q) {
    int pID = find(p);
    int qID = find(q);

    if (pID == qID) return;

    for (int i = 0; i < id.length; ++i) {
      if (id[i] == pID) id[i] = qID;
    }
    count -= 1;
  }

  /** --------------------------------------------- */


  /**
   * Quick-Union
   */

  public int find_qu(int p) {
    while (p != id[p]) {
      p = id[p];
    }
    return p;
  }

  public void union_qu(int p, int q) {
    int pRoot = find_qu(p);
    int qRoot = find_qu(q);

    if (pRoot == qRoot) return;

    id[pRoot] = qRoot;
    count -= 1;
  }


  /** --------------------------------------------- */

  public int find(int p ) {
    return 0;
  }

  public int union(int p, int q) {
    return 0;
  }

  public static void main(String[] args) {
    int n = StdIn.readInt();
    UF uf = new UF(n);
    while (!StdIn.isEmpty()) {
      int p = StdIn.readInt();
      int q = StdIn.readInt();
      if (uf.connected(p, q)) continue;
      uf.union(p, q);
      StdOut.println(p + " " + q);
    }
    StdOut.println(uf.count() +  " components");
  }
}
