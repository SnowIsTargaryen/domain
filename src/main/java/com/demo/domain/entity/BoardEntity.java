package com.demo.domain.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="jpa_notice")
@NoArgsConstructor
@Data
//@Getter
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String title;

//    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private int hitcnt=0;

    @Column(name="create_id")
    private long createId;

    private LocalDateTime createDateTime = LocalDateTime.now();

//    @ManyToOne
//    @JoinColumn(name = "create_id",foreignKey = @ForeignKey(name = "fk_id" ))
//    private UserEntity userEntity;

    @Builder
    public BoardEntity(String title, String content, long createId,int hitcnt){
        this.title = title;
        this.content = content;
        this.createId = createId;
        this.hitcnt =  hitcnt;
    }


}
