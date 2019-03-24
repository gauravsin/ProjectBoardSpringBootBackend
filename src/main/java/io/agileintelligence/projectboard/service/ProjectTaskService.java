package io.agileintelligence.projectboard.service;

import io.agileintelligence.projectboard.domain.ProjectTask;
import io.agileintelligence.projectboard.repository.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskService
{
    @Autowired
    private ProjectTaskRepository projectTaskRepository;

    // Call the project task repo so we can save it.
    public ProjectTask saveOrUpdateProjectTask(ProjectTask projectTask)
    {
        if(projectTask.getStatus() == null || projectTask.getStatus() =="")
        {
            projectTask.setStatus("TO_DO");
        }

        // Method comes out-of-the-box with the CRUD extension.
        return projectTaskRepository.save(projectTask);
    }

    public Iterable<ProjectTask> findAll()
    {
        return projectTaskRepository.findAll();
    }

    public ProjectTask findById(Long id)
    {
        return projectTaskRepository.getById(id);
    }

}
