package ddd.leave.domain.person.repository.po;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class RelationshipPO {

    @Id
    private String id;

    private String personId;

    private String leaderId;

}
