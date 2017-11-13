package leet.problem_355;

//https://leetcode.com/problems/design-twitter/description/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
class Twitter {
    int counter;
    HashMap<Integer, User> users;
    
    class Tweet {
        int uid;
        int id;
        int time;
        public Tweet (int uid, int id, int time) {
            this.uid = uid;
            this.id = id;
            this.time = time;
        }
    }
    class User {
        int id;
        List<Tweet> tweets;
        HashSet<Integer> followees;
        public User(int id){
            this.id = id;
            tweets = new ArrayList<>();
            followees = new HashSet<>();
        }
    }
    /** Initialize your data structure here. */
    public Twitter() {
        users = new HashMap<>();
        counter = 0;
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!users.containsKey(userId)) {
            users.put(userId, new User(userId));
        }
        users.get(userId).tweets.add(new Tweet(userId, tweetId, counter));
        counter++;
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if (!users.containsKey(userId)) {
            return res;
        }
        HashSet<Integer> followeeIds = users.get(userId).followees;
        List<Tweet> utweets = users.get(userId).tweets;
        HashMap<Integer, Integer> map = new HashMap();
        PriorityQueue<Tweet> heap = new PriorityQueue<>((a, b) -> b.time - a.time);
        int usize = utweets.size();
        if (usize != 0) {
            heap.offer(utweets.get(utweets.size() - 1));
            map.put(userId, utweets.size() - 1);
        }
        for (int u: followeeIds) {
            List<Tweet> tweets = users.get(u).tweets;
            int size = tweets.size();
            if (size != 0) {
                heap.offer(tweets.get(size - 1));
                map.put(u, size - 1);
            }
        }
        if (heap.isEmpty()) {
            return res;
        }
        for (int i = 0; i < 10 && !heap.isEmpty(); i++) {
            Tweet t = heap.poll();
            res.add(t.id);
            if (map.get(t.uid) > 0) {
                int index = map.get(t.uid) - 1;
                heap.offer(users.get(t.uid).tweets.get(index));
                map.put(t.uid, index);
            }
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        if (!users.containsKey(followerId)) {
            users.put(followerId, new User(followerId));
        }
        if (!users.containsKey(followeeId)) {
            users.put(followeeId, new User(followeeId));
        }
        users.get(followerId).followees.add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (!users.containsKey(followerId) || !users.containsKey(followeeId)) {
            return;
        }
        users.get(followerId).followees.remove(followeeId);
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