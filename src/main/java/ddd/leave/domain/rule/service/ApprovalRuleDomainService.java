package ddd.leave.domain.rule.service;

import ddd.leave.domain.rule.entity.ApprovalRule;
import ddd.leave.domain.rule.repository.facade.ApprovalRuleRepositoryInterface;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ApprovalRuleDomainService {

    @Resource
    private ApprovalRuleRepositoryInterface repositoryInterface;

    public int getLeaderMaxLevel(String personType, String leaveType, long duration) {
        ApprovalRule rule = new ApprovalRule();
        rule.setPersonType(personType);
        rule.setLeaveType(leaveType);
        rule.setDuration(duration);
        return repositoryInterface.getLeaderMaxLevel(rule);
    }

}
