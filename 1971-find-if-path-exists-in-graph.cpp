class Solution {
public:
    bool validPath(int n, vector<vector<int>>& edges, int source, int destination) {
        vector<vector<int>> adj(n);
        if(source==destination)return true;
        for(auto& edge: edges){
            int u = edge[0];
            int v = edge[1];
            adj[u].push_back(v);
            adj[v].push_back(u);
        }

        queue<int> q;
        vector<bool> visited(n,false);
        q.push(source);
        visited[source] = true;
        while(!q.empty()){
            int current = q.front();
            q.pop();
            for(auto & neighbour: adj[current]){
                if(neighbour == destination) return true;
                if(!visited[neighbour]){q.push(neighbour); visited[neighbour]= true;}
            }
           
        }
        return false;
    }
};