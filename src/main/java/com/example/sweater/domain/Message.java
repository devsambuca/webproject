package com.example.sweater.domain;


import javax.persistence.*;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String text;
    private String tag;

    @ManyToOne(fetch = FetchType.EAGER) //указываем связь что пользователь может иметь много сообщений
    // (каждый раз, когда мы хотим получать сообщение, мы также хотем
    // получать информацию об авторе
    @JoinColumn(name = "user_id")       // это нужно чтобы в базе данных это поле называлось user_id а не author_id
    private User author;

    private String filename;



    public Message() {
    }

    public Message(String text, String tag, User user) {
        this.text = text;
        this.tag = tag;
        this.author = user;
    }

    public String getAuthorName() { // добавляем доп поле есть ли автор или нет
        return author != null ? author.getUsername() : "<none>";
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
