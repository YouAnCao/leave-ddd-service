package ddd.leave.domain.person.repository.po;

import ddd.leave.domain.person.entity.valueobject.PersonStatus;
import ddd.leave.domain.person.entity.valueobject.PersonType;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "`person`")
public class PersonPO {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "`_id`")
    private String personId;

    @Column(name = "`person_name`")
    private String personName;

    @Column(name = "`department_id`")
    private String departmentId;

    @Enumerated(EnumType.STRING)
    @Column(name = "`person_type`")
    private PersonType personType;

    @Transient
    private String leaderId;

    @Column(name = "`role_level`")
    private int roleLevel;

    @Column(name = "`create_time`")
    private Date createTime;

    @Column(name = "`last_modify_time`")
    private Date lastModifyTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "`status`")
    private PersonStatus status;

    @OneToOne
    private RelationshipPO relationshipPO;

    //    @Column(name = "`relation_ship_id`")
//    private String RelationshipId;
//
//    @Column(name = "`relation_person_id`")
//    private String RelationPersonId;

}
