/*
  Design a simplified version of Twitter where users can post tweets, follow/
un-follow another user and is able to see the 10 most recent tweets in the
user's news feed. Your design should support the following methods:
  1. postTweet(userId, tweetId): Compose a new tweet.
  2. getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's
  news feed. Each item in the news feed must be posted by users who the user
  followed or by the user herself. Tweets must be ordered from most recent to
  least recent.
  3. follow(followerId, followeeId): Follower follows a followee.
  4. unfollow(followerId, followeeId): Follower unfollows a followee.

Example:

        Twitter twitter = new Twitter();

        // User 1 posts a new tweet (id = 5).
        twitter.postTweet(1, 5);

        // User 1's news feed should return a list with 1 tweet id -> [5].
        twitter.getNewsFeed(1);

        // User 1 follows user 2.
        twitter.follow(1, 2);

        // User 2 posts a new tweet (id = 6).
        twitter.postTweet(2, 6);

        // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
        // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        twitter.getNewsFeed(1);

        // User 1 unfollows user 2.
        twitter.unfollow(1, 2);

        // User 1's news feed should return a list with 1 tweet id -> [5],
        // since user 1 is no longer following user 2.
        twitter.getNewsFeed(1);
*/

import java.util.*;

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */

class Twitter {

    public static void main(String[] args) {

        Twitter twitter = new Twitter();

        twitter.follow(1, 5);
        System.out.println(twitter.getNewsFeed(1));
    }

    class Node implements Comparable<Node> {
        int tweetId;
        int sequenceNumber;

        Node(int tweetId, int sequenceNumber) {
            this.tweetId = tweetId;
            this.sequenceNumber = sequenceNumber;
        }

        @Override
        public int compareTo(Node o) {

            return -Integer.compare(this.sequenceNumber, o.sequenceNumber);
        }
    }

    private Map<Integer, List<Node>> tweets = new HashMap<>();
    private Map<Integer, Set<Integer>> follows = new HashMap<>();
    private int sequenceNumber = Integer.MIN_VALUE;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {

        List<Node> tweetsList = this.tweets.getOrDefault(
                userId, new ArrayList<>());

        Node node = new Node(tweetId, this.sequenceNumber);
        tweetsList.add(node);
        this.tweets.put(userId, tweetsList);

        this.sequenceNumber++;
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item
     * in the news feed must be posted by users who the user followed or by the
     * user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {

        List<Node> userTweets = this.tweets.getOrDefault(userId, new ArrayList<>());
        Set<Integer> follows = this.follows.getOrDefault(userId, new HashSet<>());

        List<Node> nodes = new ArrayList<>(userTweets);
        for (int followeeId : follows) {
            if (!this.tweets.containsKey(followeeId)) {
                continue;
            }

            nodes.addAll(this.tweets.get(followeeId));
        }

        Collections.sort(nodes);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < Math.min(10, nodes.size()); i++) {
            result.add(nodes.get(i).tweetId);
        }
        return result;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a
     * no-op.
     */
    public void follow(int followerId, int followeeId) {

        if (followerId == followeeId) {
            return;
        }

        Set<Integer> followList = this.follows.getOrDefault(
                followerId, new HashSet<>());
        followList.add(followeeId);
        this.follows.put(followerId, followList);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be
     * a no-op.
     */
    public void unfollow(int followerId, int followeeId) {

        if (!this.follows.containsKey(followerId)) {
            return;
        }

        Set<Integer> followList = this.follows.get(followerId);
        followList.remove(followeeId);
        if (followList.isEmpty()) {
            this.follows.remove(followerId);
        } else {
            this.follows.put(followerId, followList);
        }
    }
}
