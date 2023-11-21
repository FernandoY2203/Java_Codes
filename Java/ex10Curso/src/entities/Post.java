
package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Post {
    private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"); 
    // private static faz com que não seja criado varios DateTimeFormatter para cada Post instanciado e sim só um
    
    private LocalDateTime date;
    private String title;
    private String content;
    private Integer likes;

    private List<Comment> comments = new ArrayList<>();
    
    
    public Post(LocalDateTime date, String title, String content, Integer likes) {
        this.date = date;
        this.title = title;
        this.content = content;
        this.likes = likes;
    }
    

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }
    
    
    public void addComment(Comment comment){
        comments.add(comment);
    }
    
    public void removeComment(Comment comment){
        comments.remove(comment);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append(title + "\n");
        sb.append(likes + " Likes - " + fmt.format(date) + "\n");
        sb.append(content + "\n");
        sb.append("Comments: \n");
        for(Comment c : comments){
            sb.append(c.getText() + "\n");
        }
        
        return sb.toString();
    }
}
