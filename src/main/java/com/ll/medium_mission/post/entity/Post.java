package com.ll.medium_mission.post.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ll.medium_mission.global.entity.BaseEntity;
import com.ll.medium_mission.member.entity.Member;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity @Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Post extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column(columnDefinition = "text")
    private String content;

    @Column
    private Long viewCount;

    @Column
    private Boolean isPaid;

    @ManyToOne
    @JoinColumn
    private Member author;

    @JsonManagedReference
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<PostRecommend> postRecommends;

    @Builder
    public Post(String title, String content, Member author, Long viewCount, Boolean isPaid) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.viewCount = viewCount == null ? 0L : viewCount;
        this.isPaid = isPaid;
    }

    public void modifyPost(String title, String content, Boolean isPaid) {
        this.title = title;
        this.content = content;
        this.isPaid = isPaid;
    }

    public void cancelMembership() {
        isPaid = false;
    }

    public void increaseViewCount() {
        this.viewCount ++;
    }

}
