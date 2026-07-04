class Twitter {

int time;
    Map<Integer,Set<Integer>> followMap ;
Map <Integer, List<Tweet>> tweetMap;

    Twitter() {
        followMap = new HashMap<> ();
        tweetMap = new HashMap<>();
        time =0;
    }
    
    void postTweet(int userId, int tweetId) { 
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new Tweet(tweetId, time));
        time ++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Queue <Tweet> maxHeap = new PriorityQueue<>((a,b)-> b.time - a.time);
        if(tweetMap.containsKey(userId)){       List<Tweet> tweets = tweetMap.get(userId);
        maxHeap.addAll(tweets);
    }    
        if(followMap.containsKey(userId)){
            
          Set<Integer> followees = followMap.get(userId) ;
          for(int followee: followees)
          if(tweetMap.containsKey(followee)) maxHeap.addAll(tweetMap.get(followee))  
  ;      }
        List<Integer> res = new ArrayList<>();
         while(!maxHeap.isEmpty()&& res.size()<10){
             res.add(maxHeap.poll().id);
         }
         
         return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId==followeeId)
       return; followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId))
        followMap.get(followerId).remove(followeeId);
    }
    
    static class Tweet{
        int time;
        int id;
        
        Tweet(int id, int time){
            this.id = id;
            this.time = time;
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */