
package application;

import entities.Comment;
import entities.Post;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Program {
    public static void main(String[] args) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        
        Post p1 = new Post(LocalDateTime.parse("21/06/2018 13:05:44", fmt), "Traveling to New Zealand", "I'm going to visit this wonderful country!", 12);
        Post p2 = new Post(LocalDateTime.parse("28/07/2018 23:14:19", fmt), "Good night guys", "See you tomorrow", 5);
        
        p1.addComment(new Comment("Have a nice trip"));
        p1.addComment(new Comment("Wow that's awesome!"));
        p2.addComment(new Comment("Good night"));
        p2.addComment(new Comment("May the Force be with you"));
        
        System.out.println(p1);
        System.out.println(p2);
    }
    
}
