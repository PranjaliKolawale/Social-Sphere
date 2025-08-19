package socialstore.dto;

import java.sql.Timestamp;

public class CommentDTO {
    private int commentId;
    private int postId;
    private int userId;
    private String username;
    private Timestamp timestamp;
    private String content;

    public CommentDTO(int commentId, int postId, int userId, String username, Timestamp timestamp, String content) {
        this.commentId = commentId;
        this.postId = postId;
        this.userId = userId;
        this.username = username;
        this.timestamp = timestamp;
        this.content = content;
    }

    public int getCommentId() {
        return commentId;
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

    public String getUsername() {
        return username;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public String getContent() {
        return content;
    }
}
