package io.agileintelligence.projectboard.web;

import io.agileintelligence.projectboard.domain.ProjectTask;
import io.agileintelligence.projectboard.service.ProjectTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/board")
@CrossOrigin // For React app to reach this.
public class ProjectTaskController
{
    @Autowired
    ProjectTaskService projectTaskService;

    // Use same url as request mapping.
    // Valid to get more descriptive message if not all reqd fields sent in json.
    @PostMapping("")
    public ResponseEntity<?> addPTToBoard(@Valid @RequestBody ProjectTask projectTask, BindingResult result)
    {
        // To customize json response as seen on postman if errors occur.
        if(result.hasErrors())
        {
            Map<String, String> errorMap = new HashMap<>();

            for(FieldError error: result.getFieldErrors())
            {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }

            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        ProjectTask newPT = projectTaskService.saveOrUpdateProjectTask(projectTask);

        return new ResponseEntity<ProjectTask>(newPT, HttpStatus.CREATED);

    }

}
