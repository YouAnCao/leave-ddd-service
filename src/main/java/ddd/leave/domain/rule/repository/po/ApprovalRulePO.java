package ddd.leave.domain.rule.repository.po;

import ddd.leave.domain.leave.entity.valueobject.LeaveType;
import ddd.leave.domain.person.entity.valueobject.PersonType;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "`approval_rule`")
public class ApprovalRulePO {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "`_id`")
    private String id;

    @Enumerated(EnumType.STRING)
    @Column(name = "`leave_type`")
    private LeaveType leaveType;

    @Enumerated(EnumType.STRING)
    @Column(name = "`person_type`")
    private PersonType personType;

    @Column(name = "`duration`")
    private long duration;

    @Column(name = "`applicant_role_id`")
    private String applicantRoleId;

}
