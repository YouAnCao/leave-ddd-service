package ddd.leave.domain.rule.repository.persistence;

import ddd.leave.domain.rule.entity.ApprovalRule;
import ddd.leave.domain.rule.repository.facade.ApprovalRuleRepositoryInterface;
import ddd.leave.domain.rule.repository.mapper.ApprovalRuleDao;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class ApprovalRuleRepositoryImpl implements ApprovalRuleRepositoryInterface {

    @Resource
    private ApprovalRuleDao ruleDao;

    @Override
    public int getLeaderMaxLevel(ApprovalRule rule) {
        String personType = rule.getPersonType();
        String leaveType = rule.getLeaveType();
        rule = ruleDao.findRule(personType, leaveType, rule.getDuration());
        return rule.getMaxLeaderLevel();
    }

}
