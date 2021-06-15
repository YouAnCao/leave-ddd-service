package ddd.leave.domain.rule.repository.po;

import ddd.leave.domain.leave.entity.valueobject.LeaveType;
import ddd.leave.domain.person.entity.valueobject.PersonType;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
public class ApprovalRulePO {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;

    @Enumerated(EnumType.STRING)
    private LeaveType leaveType;

    @Enumerated(EnumType.STRING)
    private PersonType personType;

    private long duration;

    private String applicantRoleId;

}
