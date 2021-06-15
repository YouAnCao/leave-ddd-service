package ddd.leave.domain.person.repository.po;

import ddd.leave.domain.person.entity.valueobject.PersonStatus;
import ddd.leave.domain.person.entity.valueobject.PersonType;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "person")
public class PersonPO {

    @Id
    private String personId;

    private String personName;

    private String departmentId;

    @Enumerated(EnumType.STRING)
    private PersonType personType;

    @Transient
    private String leaderId;

    private int roleLevel;

    private Date createTime;

    private Date lastModifyTime;

    @Enumerated(EnumType.STRING)
    private PersonStatus status;

    @OneToOne
    private RelationshipPO relationshipPO;

}
