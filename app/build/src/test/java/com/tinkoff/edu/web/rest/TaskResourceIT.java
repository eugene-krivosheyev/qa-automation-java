package com.tinkoff.edu.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.tinkoff.edu.IntegrationTest;
import com.tinkoff.edu.domain.Job;
import com.tinkoff.edu.domain.Task;
import com.tinkoff.edu.repository.TaskRepository;
import com.tinkoff.edu.service.criteria.TaskCriteria;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Base64Utils;

/**
 * Integration tests for the {@link TaskResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class TaskResourceIT {

    private static final String DEFAULT_TITLE = "AAAAAAAAAA";
    private static final String UPDATED_TITLE = "BBBBBBBBBB";

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    private static final String DEFAULT_ATTACH = "AAAAAAAAAA";
    private static final String UPDATED_ATTACH = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/tasks";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restTaskMockMvc;

    private Task task;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Task createEntity(EntityManager em) {
        Task task = new Task().title(DEFAULT_TITLE).description(DEFAULT_DESCRIPTION).attach(DEFAULT_ATTACH);
        // Add required entity
        Job job;
        if (TestUtil.findAll(em, Job.class).isEmpty()) {
            job = JobResourceIT.createEntity(em);
            em.persist(job);
            em.flush();
        } else {
            job = TestUtil.findAll(em, Job.class).get(0);
        }
        task.getJobs().add(job);
        return task;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Task createUpdatedEntity(EntityManager em) {
        Task task = new Task().title(UPDATED_TITLE).description(UPDATED_DESCRIPTION).attach(UPDATED_ATTACH);
        // Add required entity
        Job job;
        if (TestUtil.findAll(em, Job.class).isEmpty()) {
            job = JobResourceIT.createUpdatedEntity(em);
            em.persist(job);
            em.flush();
        } else {
            job = TestUtil.findAll(em, Job.class).get(0);
        }
        task.getJobs().add(job);
        return task;
    }

    @BeforeEach
    public void initTest() {
        task = createEntity(em);
    }

    @Test
    @Transactional
    void createTask() throws Exception {
        int databaseSizeBeforeCreate = taskRepository.findAll().size();
        // Create the Task
        restTaskMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(task)))
            .andExpect(status().isCreated());

        // Validate the Task in the database
        List<Task> taskList = taskRepository.findAll();
        assertThat(taskList).hasSize(databaseSizeBeforeCreate + 1);
        Task testTask = taskList.get(taskList.size() - 1);
        assertThat(testTask.getTitle()).isEqualTo(DEFAULT_TITLE);
        assertThat(testTask.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(testTask.getAttach()).isEqualTo(DEFAULT_ATTACH);
    }

    @Test
    @Transactional
    void createTaskWithExistingId() throws Exception {
        // Create the Task with an existing ID
        task.setId(1L);

        int databaseSizeBeforeCreate = taskRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restTaskMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(task)))
            .andExpect(status().isBadRequest());

        // Validate the Task in the database
        List<Task> taskList = taskRepository.findAll();
        assertThat(taskList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkTitleIsRequired() throws Exception {
        int databaseSizeBeforeTest = taskRepository.findAll().size();
        // set the field null
        task.setTitle(null);

        // Create the Task, which fails.

        restTaskMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(task)))
            .andExpect(status().isBadRequest());

        List<Task> taskList = taskRepository.findAll();
        assertThat(taskList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllTasks() throws Exception {
        // Initialize the database
        taskRepository.saveAndFlush(task);

        // Get all the taskList
        restTaskMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(task.getId().intValue())))
            .andExpect(jsonPath("$.[*].title").value(hasItem(DEFAULT_TITLE)))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION)))
            .andExpect(jsonPath("$.[*].attach").value(hasItem(DEFAULT_ATTACH.toString())));
    }

    @Test
    @Transactional
    void getTask() throws Exception {
        // Initialize the database
        taskRepository.saveAndFlush(task);

        // Get the task
        restTaskMockMvc
            .perform(get(ENTITY_API_URL_ID, task.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(task.getId().intValue()))
            .andExpect(jsonPath("$.title").value(DEFAULT_TITLE))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION))
            .andExpect(jsonPath("$.attach").value(DEFAULT_ATTACH.toString()));
    }

    @Test
    @Transactional
    void getTasksByIdFiltering() throws Exception {
        // Initialize the database
        taskRepository.saveAndFlush(task);

        Long id = task.getId();

        defaultTaskShouldBeFound("id.equals=" + id);
        defaultTaskShouldNotBeFound("id.notEquals=" + id);

        defaultTaskShouldBeFound("id.greaterThanOrEqual=" + id);
        defaultTaskShouldNotBeFound("id.greaterThan=" + id);

        defaultTaskShouldBeFound("id.lessThanOrEqual=" + id);
        defaultTaskShouldNotBeFound("id.lessThan=" + id);
    }

    @Test
    @Transactional
    void getAllTasksByTitleIsEqualToSomething() throws Exception {
        // Initialize the database
        taskRepository.saveAndFlush(task);

        // Get all the taskList where title equals to DEFAULT_TITLE
        defaultTaskShouldBeFound("title.equals=" + DEFAULT_TITLE);

        // Get all the taskList where title equals to UPDATED_TITLE
        defaultTaskShouldNotBeFound("title.equals=" + UPDATED_TITLE);
    }

    @Test
    @Transactional
    void getAllTasksByTitleIsNotEqualToSomething() throws Exception {
        // Initialize the database
        taskRepository.saveAndFlush(task);

        // Get all the taskList where title not equals to DEFAULT_TITLE
        defaultTaskShouldNotBeFound("title.notEquals=" + DEFAULT_TITLE);

        // Get all the taskList where title not equals to UPDATED_TITLE
        defaultTaskShouldBeFound("title.notEquals=" + UPDATED_TITLE);
    }

    @Test
    @Transactional
    void getAllTasksByTitleIsInShouldWork() throws Exception {
        // Initialize the database
        taskRepository.saveAndFlush(task);

        // Get all the taskList where title in DEFAULT_TITLE or UPDATED_TITLE
        defaultTaskShouldBeFound("title.in=" + DEFAULT_TITLE + "," + UPDATED_TITLE);

        // Get all the taskList where title equals to UPDATED_TITLE
        defaultTaskShouldNotBeFound("title.in=" + UPDATED_TITLE);
    }

    @Test
    @Transactional
    void getAllTasksByTitleIsNullOrNotNull() throws Exception {
        // Initialize the database
        taskRepository.saveAndFlush(task);

        // Get all the taskList where title is not null
        defaultTaskShouldBeFound("title.specified=true");

        // Get all the taskList where title is null
        defaultTaskShouldNotBeFound("title.specified=false");
    }

    @Test
    @Transactional
    void getAllTasksByTitleContainsSomething() throws Exception {
        // Initialize the database
        taskRepository.saveAndFlush(task);

        // Get all the taskList where title contains DEFAULT_TITLE
        defaultTaskShouldBeFound("title.contains=" + DEFAULT_TITLE);

        // Get all the taskList where title contains UPDATED_TITLE
        defaultTaskShouldNotBeFound("title.contains=" + UPDATED_TITLE);
    }

    @Test
    @Transactional
    void getAllTasksByTitleNotContainsSomething() throws Exception {
        // Initialize the database
        taskRepository.saveAndFlush(task);

        // Get all the taskList where title does not contain DEFAULT_TITLE
        defaultTaskShouldNotBeFound("title.doesNotContain=" + DEFAULT_TITLE);

        // Get all the taskList where title does not contain UPDATED_TITLE
        defaultTaskShouldBeFound("title.doesNotContain=" + UPDATED_TITLE);
    }

    @Test
    @Transactional
    void getAllTasksByDescriptionIsEqualToSomething() throws Exception {
        // Initialize the database
        taskRepository.saveAndFlush(task);

        // Get all the taskList where description equals to DEFAULT_DESCRIPTION
        defaultTaskShouldBeFound("description.equals=" + DEFAULT_DESCRIPTION);

        // Get all the taskList where description equals to UPDATED_DESCRIPTION
        defaultTaskShouldNotBeFound("description.equals=" + UPDATED_DESCRIPTION);
    }

    @Test
    @Transactional
    void getAllTasksByDescriptionIsNotEqualToSomething() throws Exception {
        // Initialize the database
        taskRepository.saveAndFlush(task);

        // Get all the taskList where description not equals to DEFAULT_DESCRIPTION
        defaultTaskShouldNotBeFound("description.notEquals=" + DEFAULT_DESCRIPTION);

        // Get all the taskList where description not equals to UPDATED_DESCRIPTION
        defaultTaskShouldBeFound("description.notEquals=" + UPDATED_DESCRIPTION);
    }

    @Test
    @Transactional
    void getAllTasksByDescriptionIsInShouldWork() throws Exception {
        // Initialize the database
        taskRepository.saveAndFlush(task);

        // Get all the taskList where description in DEFAULT_DESCRIPTION or UPDATED_DESCRIPTION
        defaultTaskShouldBeFound("description.in=" + DEFAULT_DESCRIPTION + "," + UPDATED_DESCRIPTION);

        // Get all the taskList where description equals to UPDATED_DESCRIPTION
        defaultTaskShouldNotBeFound("description.in=" + UPDATED_DESCRIPTION);
    }

    @Test
    @Transactional
    void getAllTasksByDescriptionIsNullOrNotNull() throws Exception {
        // Initialize the database
        taskRepository.saveAndFlush(task);

        // Get all the taskList where description is not null
        defaultTaskShouldBeFound("description.specified=true");

        // Get all the taskList where description is null
        defaultTaskShouldNotBeFound("description.specified=false");
    }

    @Test
    @Transactional
    void getAllTasksByDescriptionContainsSomething() throws Exception {
        // Initialize the database
        taskRepository.saveAndFlush(task);

        // Get all the taskList where description contains DEFAULT_DESCRIPTION
        defaultTaskShouldBeFound("description.contains=" + DEFAULT_DESCRIPTION);

        // Get all the taskList where description contains UPDATED_DESCRIPTION
        defaultTaskShouldNotBeFound("description.contains=" + UPDATED_DESCRIPTION);
    }

    @Test
    @Transactional
    void getAllTasksByDescriptionNotContainsSomething() throws Exception {
        // Initialize the database
        taskRepository.saveAndFlush(task);

        // Get all the taskList where description does not contain DEFAULT_DESCRIPTION
        defaultTaskShouldNotBeFound("description.doesNotContain=" + DEFAULT_DESCRIPTION);

        // Get all the taskList where description does not contain UPDATED_DESCRIPTION
        defaultTaskShouldBeFound("description.doesNotContain=" + UPDATED_DESCRIPTION);
    }

    @Test
    @Transactional
    void getAllTasksByJobIsEqualToSomething() throws Exception {
        // Initialize the database
        taskRepository.saveAndFlush(task);
        Job job;
        if (TestUtil.findAll(em, Job.class).isEmpty()) {
            job = JobResourceIT.createEntity(em);
            em.persist(job);
            em.flush();
        } else {
            job = TestUtil.findAll(em, Job.class).get(0);
        }
        em.persist(job);
        em.flush();
        task.addJob(job);
        taskRepository.saveAndFlush(task);
        Long jobId = job.getId();

        // Get all the taskList where job equals to jobId
        defaultTaskShouldBeFound("jobId.equals=" + jobId);

        // Get all the taskList where job equals to (jobId + 1)
        defaultTaskShouldNotBeFound("jobId.equals=" + (jobId + 1));
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultTaskShouldBeFound(String filter) throws Exception {
        restTaskMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(task.getId().intValue())))
            .andExpect(jsonPath("$.[*].title").value(hasItem(DEFAULT_TITLE)))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION)))
            .andExpect(jsonPath("$.[*].attach").value(hasItem(DEFAULT_ATTACH.toString())));

        // Check, that the count call also returns 1
        restTaskMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultTaskShouldNotBeFound(String filter) throws Exception {
        restTaskMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restTaskMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("0"));
    }

    @Test
    @Transactional
    void getNonExistingTask() throws Exception {
        // Get the task
        restTaskMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putNewTask() throws Exception {
        // Initialize the database
        taskRepository.saveAndFlush(task);

        int databaseSizeBeforeUpdate = taskRepository.findAll().size();

        // Update the task
        Task updatedTask = taskRepository.findById(task.getId()).get();
        // Disconnect from session so that the updates on updatedTask are not directly saved in db
        em.detach(updatedTask);
        updatedTask.title(UPDATED_TITLE).description(UPDATED_DESCRIPTION).attach(UPDATED_ATTACH);

        restTaskMockMvc
            .perform(
                put(ENTITY_API_URL_ID, updatedTask.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(updatedTask))
            )
            .andExpect(status().isOk());

        // Validate the Task in the database
        List<Task> taskList = taskRepository.findAll();
        assertThat(taskList).hasSize(databaseSizeBeforeUpdate);
        Task testTask = taskList.get(taskList.size() - 1);
        assertThat(testTask.getTitle()).isEqualTo(UPDATED_TITLE);
        assertThat(testTask.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testTask.getAttach()).isEqualTo(UPDATED_ATTACH);
    }

    @Test
    @Transactional
    void putNonExistingTask() throws Exception {
        int databaseSizeBeforeUpdate = taskRepository.findAll().size();
        task.setId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restTaskMockMvc
            .perform(
                put(ENTITY_API_URL_ID, task.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(task))
            )
            .andExpect(status().isBadRequest());

        // Validate the Task in the database
        List<Task> taskList = taskRepository.findAll();
        assertThat(taskList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchTask() throws Exception {
        int databaseSizeBeforeUpdate = taskRepository.findAll().size();
        task.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTaskMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(task))
            )
            .andExpect(status().isBadRequest());

        // Validate the Task in the database
        List<Task> taskList = taskRepository.findAll();
        assertThat(taskList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamTask() throws Exception {
        int databaseSizeBeforeUpdate = taskRepository.findAll().size();
        task.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTaskMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(task)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Task in the database
        List<Task> taskList = taskRepository.findAll();
        assertThat(taskList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateTaskWithPatch() throws Exception {
        // Initialize the database
        taskRepository.saveAndFlush(task);

        int databaseSizeBeforeUpdate = taskRepository.findAll().size();

        // Update the task using partial update
        Task partialUpdatedTask = new Task();
        partialUpdatedTask.setId(task.getId());

        partialUpdatedTask.description(UPDATED_DESCRIPTION);

        restTaskMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedTask.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedTask))
            )
            .andExpect(status().isOk());

        // Validate the Task in the database
        List<Task> taskList = taskRepository.findAll();
        assertThat(taskList).hasSize(databaseSizeBeforeUpdate);
        Task testTask = taskList.get(taskList.size() - 1);
        assertThat(testTask.getTitle()).isEqualTo(DEFAULT_TITLE);
        assertThat(testTask.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testTask.getAttach()).isEqualTo(DEFAULT_ATTACH);
    }

    @Test
    @Transactional
    void fullUpdateTaskWithPatch() throws Exception {
        // Initialize the database
        taskRepository.saveAndFlush(task);

        int databaseSizeBeforeUpdate = taskRepository.findAll().size();

        // Update the task using partial update
        Task partialUpdatedTask = new Task();
        partialUpdatedTask.setId(task.getId());

        partialUpdatedTask.title(UPDATED_TITLE).description(UPDATED_DESCRIPTION).attach(UPDATED_ATTACH);

        restTaskMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedTask.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedTask))
            )
            .andExpect(status().isOk());

        // Validate the Task in the database
        List<Task> taskList = taskRepository.findAll();
        assertThat(taskList).hasSize(databaseSizeBeforeUpdate);
        Task testTask = taskList.get(taskList.size() - 1);
        assertThat(testTask.getTitle()).isEqualTo(UPDATED_TITLE);
        assertThat(testTask.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testTask.getAttach()).isEqualTo(UPDATED_ATTACH);
    }

    @Test
    @Transactional
    void patchNonExistingTask() throws Exception {
        int databaseSizeBeforeUpdate = taskRepository.findAll().size();
        task.setId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restTaskMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, task.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(task))
            )
            .andExpect(status().isBadRequest());

        // Validate the Task in the database
        List<Task> taskList = taskRepository.findAll();
        assertThat(taskList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchTask() throws Exception {
        int databaseSizeBeforeUpdate = taskRepository.findAll().size();
        task.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTaskMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(task))
            )
            .andExpect(status().isBadRequest());

        // Validate the Task in the database
        List<Task> taskList = taskRepository.findAll();
        assertThat(taskList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamTask() throws Exception {
        int databaseSizeBeforeUpdate = taskRepository.findAll().size();
        task.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTaskMockMvc
            .perform(patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(TestUtil.convertObjectToJsonBytes(task)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Task in the database
        List<Task> taskList = taskRepository.findAll();
        assertThat(taskList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteTask() throws Exception {
        // Initialize the database
        taskRepository.saveAndFlush(task);

        int databaseSizeBeforeDelete = taskRepository.findAll().size();

        // Delete the task
        restTaskMockMvc
            .perform(delete(ENTITY_API_URL_ID, task.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Task> taskList = taskRepository.findAll();
        assertThat(taskList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
