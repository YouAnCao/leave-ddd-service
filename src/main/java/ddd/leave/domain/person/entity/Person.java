package ddd.leave.domain.person.entity;

import ddd.leave.domain.person.entity.valueobject.PersonStatus;
import ddd.leave.domain.person.entity.valueobject.PersonType;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Person {

    private String personId;

    private String personName;

    private PersonType personType;

    private List<Relationship> relationships;

    private int roleLevel;

    private Date createTime;

    private Date lastModifyTime;

    private PersonStatus status;

    public Person create() {
        this.createTime = new Date();
        this.status = PersonStatus.ENABLE;
        return this;
    }

    public Person enable() {
        this.lastModifyTime = new Date();
        this.status = PersonStatus.ENABLE;
        return this;
    }

    public Person disable() {
        this.lastModifyTime = new Date();
        this.status = PersonStatus.DISABLE;
        return this;
    }

}
