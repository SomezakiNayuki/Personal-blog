package com.somezaki.blogbackend.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "t_blog")
public class Blog {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;
    private String blogPicture;
    private String flag;
    private Integer viewTimes;
    private boolean appreciation;
    private boolean sharing;
    private boolean comment;
    private boolean publish;
    private boolean recommendation;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    @ManyToOne
    private Type type;

    @ManyToMany(cascade = { CascadeType.PERSIST })
    private List<Tag> tags = new ArrayList<>();

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "blog")
    private List<Comment> comments = new ArrayList<>();

    public Blog() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBlogPicture() {
        return this.blogPicture;
    }

    public void setBlogPicture(String blogPicture) {
        this.blogPicture = blogPicture;
    }

    public String getFlag() {
        return this.flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getViewTimes() {
        return this.viewTimes;
    }

    public void setViewTimes(Integer viewTimes) {
        this.viewTimes = viewTimes;
    }

    public boolean isAppreciation() {
        return this.appreciation;
    }

    public boolean getAppreciation() {
        return this.appreciation;
    }

    public void setAppreciation(boolean appreciation) {
        this.appreciation = appreciation;
    }

    public boolean isSharing() {
        return this.sharing;
    }

    public boolean getSharing() {
        return this.sharing;
    }

    public void setSharing(boolean sharing) {
        this.sharing = sharing;
    }

    public boolean isComment() {
        return this.comment;
    }

    public boolean getComment() {
        return this.comment;
    }

    public void setComment(boolean comment) {
        this.comment = comment;
    }

    public boolean isPublish() {
        return this.publish;
    }

    public boolean getPublish() {
        return this.publish;
    }

    public void setPublish(boolean publish) {
        this.publish = publish;
    }

    public boolean isRecommendation() {
        return this.recommendation;
    }

    public boolean getRecommendation() {
        return this.recommendation;
    }

    public void setRecommendation(boolean recommendation) {
        this.recommendation = recommendation;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Type getType() {
        return this.type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Tag> getTags() {
        return this.tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return this.comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", title='" + getTitle() + "'" +
                ", content='" + getContent() + "'" +
                ", blogPicture='" + getBlogPicture() + "'" +
                ", flag='" + getFlag() + "'" +
                ", viewTimes='" + getViewTimes() + "'" +
                ", appreciation='" + isAppreciation() + "'" +
                ", sharing='" + isSharing() + "'" +
                ", comment='" + isComment() + "'" +
                ", publish='" + isPublish() + "'" +
                ", recommendation='" + isRecommendation() + "'" +
                ", createTime='" + getCreateTime() + "'" +
                ", updateTime='" + getUpdateTime() + "'" +
                "}";
    }

}
