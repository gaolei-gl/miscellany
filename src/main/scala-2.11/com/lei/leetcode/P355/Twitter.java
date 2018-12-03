package com.lei.leetcode.P355;

import java.util.*;

public class Twitter {

    /**
     * Initialize your data structure here.
     */

    private class Tweet implements Comparable<Tweet> {
        public int tweetId;
        private long ts;

        @Override
        public int compareTo(Tweet o) {
            return (int) (this.ts - o.ts);
        }

        public Tweet(int tweetId) {
            this.tweetId = tweetId;
            this.ts = cnt++;
        }
    }

    Map<Integer, Set<Integer>> followRelationship;
    Map<Integer, List<Tweet>> tweets;
    private int cnt;


    public Twitter() {
        followRelationship = new HashMap<>();
        tweets = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        if (!tweets.containsKey(userId)) tweets.put(userId, new ArrayList<>());
        tweets.get(userId).add(new Tweet(tweetId));
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Tweet> all = new ArrayList<>();
        all.addAll(take10Tweets(userId));
        for (int uid : followRelationship.getOrDefault(userId, new HashSet<>())) {
            all.addAll(take10Tweets(uid));
        }
        Collections.sort(all, (o1, o2) -> (int) (o2.ts - o1.ts));
        int len = all.size() > 10 ? 10 : all.size();
        List<Tweet> resTweet = all.subList(0, len);
        List<Integer> res = new ArrayList<>(resTweet.size());
        for (Tweet t : resTweet) {
            res.add(t.tweetId);
        }
        return res;
    }

    private List<Tweet> take10Tweets(int userId) {
        List<Tweet> list = new ArrayList<>();
        List<Tweet> l = tweets.get(userId);
//        if (l.size() > 10) {
//            list.subList(l.size() - 10, l.size());
//        } else list.addAll(l);
        if (l != null)
            list.addAll(l);
        return list;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        if (!followRelationship.containsKey(followerId)) followRelationship.put(followerId, new HashSet<>());
        followRelationship.get(followerId).add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        if (!followRelationship.containsKey(followerId)) followRelationship.put(followerId, new HashSet<>());
        followRelationship.get(followerId).remove(followeeId);
    }

    public static void main(String[] args) {
        Twitter obj = new Twitter();
        obj.postTweet(1, 5);
        obj.postTweet(1, 3);
        obj.getNewsFeed(1);
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
