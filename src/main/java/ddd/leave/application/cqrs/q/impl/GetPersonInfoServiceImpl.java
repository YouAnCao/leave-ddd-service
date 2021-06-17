package ddd.leave.application.cqrs.q.impl;

import ddd.leave.application.cqrs.q.GetPersonInfoService;
import ddd.leave.application.service.PersonApplicationService;
import ddd.leave.domain.person.entity.Person;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GetPersonInfoServiceImpl implements GetPersonInfoService {

    @Resource
    private PersonApplicationService personApplicationService;

    @Override
    public Person findById(String personId) {
        return personApplicationService.findById(personId);
    }

    @Override
    public Person findFirstApprover(String applicantId, int leaderMaxLevel) {
        return personApplicationService.findFirstApprover(applicantId, leaderMaxLevel);
    }

}
