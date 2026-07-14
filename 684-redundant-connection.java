class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int [] parent = new int[edges.length + 1]; // from 1 to n 
        for(int i = 0;i<=edges.length; i++){
                parent[i] = i; // initial parent is itself
        }

        for(int i = 0 ;i< edges.length;i++){
            int x = edges[i][0];
            int y = edges[i][1];
            int parentX = find(parent,x); // find parent
            int parentY = find(parent,y);
            if(parentX == parentY) return edges[i]; // if same, it is redundant
            parent[parentX] = parentY; // group them if not same parent
        }

        return new int[0];
    }

    int find(int[] parent, int x){
        if(parent[x] == x) return x; // return parent
        parent[x] = find(parent, parent[x]);  // path compression
        return parent[x];
    }
}
