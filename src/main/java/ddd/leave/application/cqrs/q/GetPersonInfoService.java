package ddd.leave.application.cqrs.q;

import ddd.leave.domain.person.entity.Person;

public interface GetPersonInfoService {

    Person findById(String personId);

    Person findFirstApprover(String applicantId, int leaderMaxLevel);

}
