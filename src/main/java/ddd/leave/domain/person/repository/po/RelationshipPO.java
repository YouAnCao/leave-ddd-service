package ddd.leave.domain.person.repository.po;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "`relation_ship`")
public class RelationshipPO {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "`_id`")
    private String id;

    @Column(name = "`person_id`")
    private String personId;

    @Column(name = "`leader_id`")
    private String leaderId;

}
