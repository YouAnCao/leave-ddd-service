package ddd.leave.interfaces.facade;

import ddd.leave.application.service.PersonApplicationService;
import ddd.leave.domain.person.entity.Person;
import ddd.leave.infrastructure.common.api.Response;
import ddd.leave.interfaces.assembler.PersonAssembler;
import ddd.leave.interfaces.dto.PersonDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;

@RestController
@Slf4j
public class PersonApi {

    @Resource
    PersonApplicationService personApplicationService;

    @PostMapping("/person.json")
    public Response create(@RequestBody PersonDTO personDTO) {
        try {
            personApplicationService.create(PersonAssembler.toDO(personDTO));
            return Response.ok();
        } catch (ParseException e) {
            log.error("", e);
            return Response.failed(e.getMessage());
        }
    }

    @PutMapping("/person.json")
    public Response update(@RequestBody PersonDTO personDTO) {
        try {
            personApplicationService.update(PersonAssembler.toDO(personDTO));
        } catch (ParseException e) {
            log.error("", e);
            return Response.failed(e.getMessage());
        }
        return Response.ok();
    }

    @DeleteMapping("/person/{personId}")
    public Response delete(@PathVariable String personId) {
        personApplicationService.deleteById(personId);
        return Response.ok();
    }

    @GetMapping("/person/{personId}")
    public Response get(@PathVariable String personId) {
        Person person = personApplicationService.findById(personId);
        return Response.ok(PersonAssembler.toDTO(person));
    }

    @GetMapping("/person/findFirstApprover.json")
    public Response findFirstApprover(@RequestParam String applicantId, @RequestParam int leaderMaxLevel) {
        Person person = personApplicationService.findFirstApprover(applicantId, leaderMaxLevel);
        return Response.ok(PersonAssembler.toDTO(person));
    }

}
