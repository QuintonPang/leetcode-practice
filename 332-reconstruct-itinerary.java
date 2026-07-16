class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {

        Map<String, Queue<String>> graph= new HashMap<>();
        for(List<String> ticket: tickets){
            if(!graph.containsKey(ticket.get(0)))graph.put(ticket.get(0), new PriorityQueue<>());

            graph.get(ticket.get(0)).add(ticket.get(1));
            
        }   

        LinkedList<String> result = new LinkedList<>();
        dfs("JFK",result,graph);
        return result;
    }

    void dfs(String from, LinkedList<String> result, Map<String, Queue<String>>graph){
        Queue<String> destinations = graph.get(from);

        while(destinations!=null && !destinations.isEmpty()){
                dfs(destinations.poll(), result, graph);
        }

        result.addFirst(from);

        
    }
}
