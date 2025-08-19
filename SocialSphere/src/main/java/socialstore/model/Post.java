package socialstore.model;

import java.sql.Timestamp;

public class Post {
    private int postId;
    private int userId;
    private Timestamp timeStamp;
    private String content;

    public Post(int postId, int userId, Timestamp timeStamp, String content) {
        this.postId = postId;
        this.userId = userId;
        this.timeStamp = timeStamp;
        this.content = content;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
