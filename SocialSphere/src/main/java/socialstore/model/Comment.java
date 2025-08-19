package socialstore.model;

import java.sql.Timestamp;
public class Comment {
    private int commentId;
    private int postId;
    private int userId;
    private Timestamp timestamp;
    private String content;

    public Comment(int commentId, int postId, int userId, Timestamp timestamp, String content) {
        this.commentId = commentId;
        this.postId = postId;
        this.userId = userId;
        this.timestamp = timestamp;
        this.content = content;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
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

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
