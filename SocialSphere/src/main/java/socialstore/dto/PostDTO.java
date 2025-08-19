package socialstore.dto;

import java.sql.Timestamp;

public class PostDTO{
    private int userId;
    private int postId;
    private String name;
    private Timestamp timestamp;
    private String content;

    public PostDTO(int userId, int postId, String name, Timestamp timestamp, String content){
        this.userId = userId;
        this.postId = postId;
        this.name = name;
        this.timestamp = timestamp;
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public int getPostId() {
        return postId;
    }

    public String getName() {
        return name;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public String getContent() {
        return content;
    }
}