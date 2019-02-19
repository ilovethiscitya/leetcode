import java.util.Arrays;

/**
 * Created by jianzhe on 2/18/19.
 */
public class KruskalMinimumSpanningTree {
    class Edge implements Comparable<Edge> {
        int src, dest, weight;
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }
    class subset {
        int parent, rank;
    }
    int V, E;
    Edge edge[];
    KruskalMinimumSpanningTree(int v, int e) {
        this.V = v;
        this.E = e;
        edge = new Edge[E];
        for (int i = 0; i < e; i++) {
            edge[i] = new Edge();
        }
    }
    int find(subset subsets[], int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }
    void Union(subset subsets[], int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);
        if (subsets[xroot].rank < subsets[yroot].rank) {
            subsets[xroot].parent = yroot;
        } else if (subsets[xroot].rank > subsets[yroot].rank) {
            subsets[yroot].parent = xroot;
        } else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }
    void KruskalMst() {
        Edge result[] = new Edge[V];
        int e = 0;
        int i = 0;
        for (i = 0; i < V; i++) {
            result[i] = new Edge();
        }
        // Step 1:  Sort all the edges in non-decreasing order of their
        // weight.  If we are not allowed to change the given graph, we
        // can create a copy of array of edges
        Arrays.sort(edge);
        // Allocate memory for creating V ssubsets
        subset subsets[] = new subset[V];
        for(i=0; i<V; ++i)
            subsets[i]=new subset();
        for (int v = 0; v < V; ++v)
        {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
        i = 0;  // Index used to pick next edge

        // Number of edges to be taken is equal to V-1
        while (e < V - 1)
        {
            // Step 2: Pick the smallest edge. And increment
            // the index for next iteration
            Edge next_edge = new Edge();
            next_edge = edge[i++];

            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);

            // If including this edge does't cause cycle,
            // include it in result and increment the index
            // of result for next edge
            if (x != y)
            {
                result[e++] = next_edge;
                Union(subsets, x, y);
            }
            // Else discard the next_edge
        }

        // print the contents of result[] to display
        // the built MST
        System.out.println("Following are the edges in " +
                "the constructed MST");
        for (i = 0; i < e; ++i)
            System.out.println(result[i].src+" -- " +
                    result[i].dest+" == " + result[i].weight);
    }

}

