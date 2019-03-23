package io.agileintelligence.projectboard.web;

import io.agileintelligence.projectboard.service.ProjectTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/board")
@CrossOrigin // For React app to reach this.
public class ProjectTaskController
{
    @Autowired
    ProjectTaskService projectTaskService;
}
