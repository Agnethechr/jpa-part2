package app.entities;
import app.enums.CourseName;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamicUpdate
@EqualsAndHashCode
@Entity
@Table(name = "courses")

public class Course {
    @Id //Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private CourseName courseName;
    private String description;
    private LocalDate endDate;
    private LocalDate startDate;

    @EqualsAndHashCode.Exclude
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Student> students = new HashSet<>();

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teacher;

    public void addStudent(Student student)
    {
        this.students.add(student);
        if (student != null)
        {
            student.setCourse(this);
        }
    }
}