class Solution {
    static class Edge{
        int src,dest,cost;
        Edge(int src, int dest, int cost){
            this.src = src;
            this.dest = dest;
            this.cost = cost;
        }
    }
    static class Pair{
        int  src,cost,stops;
        Pair(int src,int cost, int stops){
            this.src = src;
            this.cost = cost;
            this.stops = stops;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Edge>[]graph = new ArrayList[n];
        for(int i = 0 ; i < graph.length ; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < flights.length ; i++){
            int source = flights[i][0];
            int dest = flights[i][1];
            int cost = flights[i][2];
            graph[source].add(new Edge(source,dest,cost));
        }
        Queue<Pair>q = new LinkedList<>();
        int[]dist = new int[n];
        for(int i = 0 ; i < dist.length; i++){
            if(i!=src){
                dist[i]= Integer.MAX_VALUE;
            }
        }
        q.add(new Pair(src,0,0));
        while(!q.isEmpty()){
            Pair curr = q.remove();
            if(curr.stops>k){
                continue;
            }
            for(Edge e : graph[curr.src]){
                int newCost = curr.cost+e.cost;
                if( newCost < dist[e.dest]){
                    dist[e.dest] = newCost;
                    q.add(new Pair(e.dest,newCost,curr.stops+1));
                }
            }
        }
        if(dist[dst] == Integer.MAX_VALUE){
            return -1;
        }
        return dist[dst];
    }
}