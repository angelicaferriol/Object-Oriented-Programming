public class FloydWarshall {
    static final int INF = Integer.MAX_VALUE; // Represents infinity for unreachable paths
    static final int V = 4; // Number of vertices

    public static void main(String[] args) {
        // Initialize the distance matrix for a directed graph
        int[][] dist = new int[V][V];

        // Initialize all distances as infinity
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j) {
                    dist[i][j] = 0;  // Distance to self is 0
                } else {
                    dist[i][j] = INF; // No direct path initially
                }
            }
        }

        // Add the directed edges (one-way connections)
        // A=0, B=1, C=2, D=3
        dist[0][1] = 3;  // A → B
        dist[1][2] = -2; // B → C
        dist[2][3] = 2;  // C → D
        dist[3][0] = 1;  // D → A
        dist[0][2] = 4;  // A → C
        dist[1][3] = 5;  // B → D

        // Apply the Floyd-Warshall algorithm
        floydWarshall(dist);

        // Calculate total of shortest distances
        int total = calculateTotal(dist);
        System.out.println("\nTotal of all shortest distances (excluding unreachable paths): " + total);

        // Print unreachable vertex pairs
        printUnreachablePairs(dist);
    }

    static void floydWarshall(int[][] dist) {
        // Iterate through each vertex as an intermediate vertex
        for (int k = 0; k < V; k++) {
            System.out.println("Matrix after considering vertex " + getVertexName(k) + " as intermediate:");
            printMatrix(dist);
            System.out.println();

            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    // Avoid overflow when summing INF values
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        // Print the final shortest distances matrix
        System.out.println("Final shortest distances matrix (∞ means no path exists):");
        printMatrix(dist);
    }

    static void printMatrix(int[][] dist) {
        System.out.println("    A   B   C   D");
        for (int i = 0; i < V; i++) {
            System.out.print(getVertexName(i) + "  ");
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF) {
                    System.out.printf("∞   ");
                } else {
                    System.out.printf("%-3d ", dist[i][j]);
                }
            }
            System.out.println();
        }
    }

    static String getVertexName(int index) {
        return String.valueOf((char) ('A' + index));
    }

    static int calculateTotal(int[][] dist) {
        int total = 0;
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i != j && dist[i][j] != INF) {
                    total += dist[i][j];
                }
            }
        }
        return total;
    }

    static void printUnreachablePairs(int[][] dist) {
        System.out.println("\nUnreachable vertex pairs (due to graph being directed):");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i != j && dist[i][j] == INF) {
                    System.out.println(getVertexName(i) + " → " + getVertexName(j));
                }
            }
        }
    }
}