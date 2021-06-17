package ddd.leave.interfaces.facade;

import ddd.leave.application.service.LeaveApplicationService;
import ddd.leave.domain.leave.entity.Leave;
import ddd.leave.infrastructure.common.api.Response;
import ddd.leave.interfaces.assembler.LeaveAssembler;
import ddd.leave.interfaces.dto.LeaveDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 请假 用户接口层
 * 传统DDD 实现案例
 */
@RestController
@Slf4j
public class LeaveApi {

    @Resource
    private LeaveApplicationService leaveApplicationService;

    @PostMapping("/leave.json")
    public Response createLeaveInfo(@RequestBody LeaveDTO leaveDTO) {
        Leave leave = LeaveAssembler.toDO(leaveDTO);
        leaveApplicationService.createLeaveInfo(leave);
        return Response.ok();
    }

    @PutMapping("/leave.json")
    public Response updateLeaveInfo(@RequestBody LeaveDTO leaveDTO) {
        Leave leave = LeaveAssembler.toDO(leaveDTO);
        leaveApplicationService.updateLeaveInfo(leave);
        return Response.ok();
    }

    @PostMapping("/leave/submit.json")
    public Response submitApproval(@RequestBody LeaveDTO leaveDTO) {
        Leave leave = LeaveAssembler.toDO(leaveDTO);
        leaveApplicationService.submitApproval(leave);
        return Response.ok();
    }

    @PostMapping("/leave/{leaveId}")
    public Response findById(@PathVariable String leaveId) {
        Leave leave = leaveApplicationService.getLeaveInfo(leaveId);
        return Response.ok(LeaveAssembler.toDTO(leave));
    }

    @PostMapping("/leave/query/applicant/{applicantId}")
    public Response queryByApplicant(@PathVariable String applicantId) {
        List<Leave> leaveList = leaveApplicationService.queryLeaveInfosByApplicant(applicantId);
        List<LeaveDTO> leaveDTOList = leaveList.stream().map(leave -> LeaveAssembler.toDTO(leave)).collect(Collectors.toList());
        return Response.ok(leaveDTOList);
    }

    @PostMapping("/leave/query/approver/{approverId}")
    public Response queryByApprover(@PathVariable String approverId) {
        List<Leave> leaveList = leaveApplicationService.queryLeaveInfosByApprover(approverId);
        List<LeaveDTO> leaveDTOList = leaveList.stream().map(leave -> LeaveAssembler.toDTO(leave)).collect(Collectors.toList());
        return Response.ok(leaveDTOList);
    }

}
