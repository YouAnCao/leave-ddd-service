package ddd.leave.domain.person.entity;

import lombok.Data;

@Data
public class Relationship {

    private String id;

    private String personId;

    private String leaderId;

    private int leaderLevel;

}
