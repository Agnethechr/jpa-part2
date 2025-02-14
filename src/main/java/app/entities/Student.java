package app.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "students")

public class Student {
    @Id //Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    private String email;
    private String name;

    private LocalDateTime updatedAt;

    @ManyToOne
    private Course course;

    @PrePersist
    protected void created(){
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void update(){
        updatedAt = LocalDateTime.now();
    }
}