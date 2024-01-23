package net.ausiasmarch.foxforumserver.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "thread")
public class ThreadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 2048)
    private String title;

    private Boolean active = true;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserEntity user;

    @OneToMany(mappedBy = "thread", fetch = jakarta.persistence.FetchType.LAZY)
    private List<ReplyEntity> replies;

    public ThreadEntity() {
        replies = new java.util.ArrayList<>();
    }

    public ThreadEntity(Long id, String title, Boolean active) {
        this.id = id;
        this.title = title;
        this.active = active;
    }

    public ThreadEntity(String title, Boolean active) {
        this.title = title;
        this.active = active;
    }

    public ThreadEntity(String title, Boolean active, UserEntity user) {
        this.title = title;
        this.active = active;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public int getReplies() {
        return replies.size();
    }

}
