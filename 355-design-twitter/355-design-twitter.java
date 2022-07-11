class Twitter {
    
    Map<Integer, Set<Integer>> fans; // key - follower, value - list of followees
    Map<Integer, LinkedList<Tweet>> tweets; // userId - key, List of tweets - value
    static int time = 0; // timestamp of tweet
    
    public Twitter() {
        this.fans = new HashMap<>();
        this.tweets = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!this.fans.containsKey(userId)) this.fans.put(userId, new HashSet<>());
        this.fans.get(userId).add(userId);
        
        if(!this.tweets.containsKey(userId))  this.tweets.put(userId, new LinkedList<>());
        this.tweets.get(userId).addFirst(new Tweet(tweetId, time++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if(!this.fans.containsKey(userId)) return new LinkedList<>();
        
        PriorityQueue<Tweet> newsFeeds = new PriorityQueue<>((o1, o2) -> {
            return o2.time - o1.time;
        });
        
        this.fans.get(userId).stream().
            filter(f -> tweets.containsKey(f)) 
            .forEach(f -> tweets.get(f).forEach(newsFeeds::add));
        
        List<Integer> top10Feeds = new LinkedList<>();
        int limit = 10;
        while(!newsFeeds.isEmpty() && top10Feeds.size() < 10) {
            top10Feeds.add(newsFeeds.poll().id);
            
        }
        
        return top10Feeds;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!this.fans.containsKey(followerId)) this.fans.put(followerId, new HashSet<>());
        this.fans.get(followerId).add(followeeId); // subscribe to the person you want to follow, so add yourself
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(this.fans.containsKey(followerId) && followerId != followeeId) 
            this.fans.get(followerId).remove(followeeId); // unnsubscribe to the person you want to unfollow, so remove yourself
    }
    
    class Tweet {
        int id;
        int time;
        
        public Tweet(int id, int time) {
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