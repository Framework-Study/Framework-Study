package hanghae.board.domain.post.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hanghae.board.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = false, length = 255)
    private String description;

    @Column(nullable = true, length = 255)
    private String mainImageUrl;

    @Column(nullable = true, length = 255)
    private String videoUrl;

    @Column(nullable = false)
    private Integer view;

    @Column(nullable = false)
    private Integer serving;

    @Column(nullable = false)
    private Integer cookTime;

    @Column(nullable = false, precision = 2, scale = 1)
    private BigDecimal difficulty;

    @Column(nullable = false, length = 255)
    private String tip;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Builder
    public Post(User user, String title, String description, String mainImageUrl, String videoUrl,
                Integer view, Integer serving, Integer cookTime, BigDecimal difficulty, String tip) {
        this.user = Objects.requireNonNull(user, "User cannot be null");
        this.title = Objects.requireNonNull(title, "Title cannot be null");
        this.description = Objects.requireNonNull(description, "Description cannot be null");
        this.mainImageUrl = mainImageUrl;
        this.videoUrl = videoUrl;
        this.view = Objects.requireNonNull(view, "View cannot be null");
        this.serving = Objects.requireNonNull(serving, "Serving cannot be null");
        this.cookTime = Objects.requireNonNull(cookTime, "Cook time cannot be null");
        this.difficulty = Objects.requireNonNull(difficulty, "Difficulty cannot be null");
        this.tip = Objects.requireNonNull(tip, "Tip cannot be null");
    }

}
