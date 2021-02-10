package g43256.webg5.pae.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor // Obligatoire pour une entité

public class Program {

    @EmbeddedId
    private ProgramId programId;

    @CreationTimestamp
    @Column(name = "created_date", updatable = false)
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    @Column(name = "updated_date")
    private LocalDateTime updateDateTime;
}