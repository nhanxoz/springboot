/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stackjava.com.sbrestful.request;

/**
 *
 * @author ADMIN
 */
public class CommentRequest {
    private Long idfood;
    private String Author;
    private String Content;

    public Long getIdfood() {
        return idfood;
    }

    public void setIdfood(Long idfood) {
        this.idfood = idfood;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }
    
}
