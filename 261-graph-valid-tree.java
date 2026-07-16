import java.util.*;

public class Main {

    static class Solution {
        public boolean validTree(int n, int[][] edges) {
            if(edges.length != n-1) return false;

            int[] parent = new int[n];
           for(int i =0 ; i<n; i++){
               parent[i] = i;
           }

            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                
                int rootU = find(parent,u);
                int rootV = find(parent,v);
                if(rootU == rootV) return false;
                parent[rootU] = rootV;
               
            }

           
            return true;
        }

        int find(int[] parent, int x) {
            if (parent[x] == x) return x;
            parent[x] = find(parent, parent[x]);
            return parent[x];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test case 1: valid tree
        int n1 = 5;
        int[][] edges1 = {{0,1},{0,2},{0,3},{1,4}};
        System.out.println("Test 1 (expect true): " + sol.validTree(n1, edges1));

        // Test case 2: has a cycle
        int n2 = 5;
        int[][] edges2 = {{0,1},{1,2},{2,3},{1,3},{1,4}};
        System.out.println("Test 2 (expect false): " + sol.validTree(n2, edges2));

        // Test case 3: disconnected (two components)
        int n3 = 4;
        int[][] edges3 = {{0,1},{2,3}};
        System.out.println("Test 3 (expect false): " + sol.validTree(n3, edges3));

        // Test case 4: single node, no edges (trivially a valid tree)
        int n4 = 1;
        int[][] edges4 = {};
        System.out.println("Test 4 (expect true): " + sol.validTree(n4, edges4));

        // Test case 5: two nodes, one edge (valid tree)
        int n5 = 2;
        int[][] edges5 = {{0,1}};
        System.out.println("Test 5 (expect true): " + sol.validTree(n5, edges5));
    }
}
