package com.tinkoff.edu.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.tinkoff.edu.IntegrationTest;
import com.tinkoff.edu.domain.Department;
import com.tinkoff.edu.domain.Employee;
import com.tinkoff.edu.domain.Job;
import com.tinkoff.edu.domain.JobHistory;
import com.tinkoff.edu.domain.enumeration.Language;
import com.tinkoff.edu.repository.JobHistoryRepository;
import com.tinkoff.edu.service.criteria.JobHistoryCriteria;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
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

/**
 * Integration tests for the {@link JobHistoryResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class JobHistoryResourceIT {

    private static final Instant DEFAULT_START_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_START_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_END_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_END_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Language DEFAULT_LANGUAGE = Language.RU;
    private static final Language UPDATED_LANGUAGE = Language.EN;

    private static final String ENTITY_API_URL = "/api/job-histories";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private JobHistoryRepository jobHistoryRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restJobHistoryMockMvc;

    private JobHistory jobHistory;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static JobHistory createEntity(EntityManager em) {
        JobHistory jobHistory = new JobHistory().startDate(DEFAULT_START_DATE).endDate(DEFAULT_END_DATE).language(DEFAULT_LANGUAGE);
        // Add required entity
        Job job;
        if (TestUtil.findAll(em, Job.class).isEmpty()) {
            job = JobResourceIT.createEntity(em);
            em.persist(job);
            em.flush();
        } else {
            job = TestUtil.findAll(em, Job.class).get(0);
        }
        jobHistory.setJob(job);
        // Add required entity
        Department department;
        if (TestUtil.findAll(em, Department.class).isEmpty()) {
            department = DepartmentResourceIT.createEntity(em);
            em.persist(department);
            em.flush();
        } else {
            department = TestUtil.findAll(em, Department.class).get(0);
        }
        jobHistory.setDepartment(department);
        // Add required entity
        Employee employee;
        if (TestUtil.findAll(em, Employee.class).isEmpty()) {
            employee = EmployeeResourceIT.createEntity(em);
            em.persist(employee);
            em.flush();
        } else {
            employee = TestUtil.findAll(em, Employee.class).get(0);
        }
        jobHistory.setEmployee(employee);
        return jobHistory;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static JobHistory createUpdatedEntity(EntityManager em) {
        JobHistory jobHistory = new JobHistory().startDate(UPDATED_START_DATE).endDate(UPDATED_END_DATE).language(UPDATED_LANGUAGE);
        // Add required entity
        Job job;
        if (TestUtil.findAll(em, Job.class).isEmpty()) {
            job = JobResourceIT.createUpdatedEntity(em);
            em.persist(job);
            em.flush();
        } else {
            job = TestUtil.findAll(em, Job.class).get(0);
        }
        jobHistory.setJob(job);
        // Add required entity
        Department department;
        if (TestUtil.findAll(em, Department.class).isEmpty()) {
            department = DepartmentResourceIT.createUpdatedEntity(em);
            em.persist(department);
            em.flush();
        } else {
            department = TestUtil.findAll(em, Department.class).get(0);
        }
        jobHistory.setDepartment(department);
        // Add required entity
        Employee employee;
        if (TestUtil.findAll(em, Employee.class).isEmpty()) {
            employee = EmployeeResourceIT.createUpdatedEntity(em);
            em.persist(employee);
            em.flush();
        } else {
            employee = TestUtil.findAll(em, Employee.class).get(0);
        }
        jobHistory.setEmployee(employee);
        return jobHistory;
    }

    @BeforeEach
    public void initTest() {
        jobHistory = createEntity(em);
    }

    @Test
    @Transactional
    void createJobHistory() throws Exception {
        int databaseSizeBeforeCreate = jobHistoryRepository.findAll().size();
        // Create the JobHistory
        restJobHistoryMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(jobHistory)))
            .andExpect(status().isCreated());

        // Validate the JobHistory in the database
        List<JobHistory> jobHistoryList = jobHistoryRepository.findAll();
        assertThat(jobHistoryList).hasSize(databaseSizeBeforeCreate + 1);
        JobHistory testJobHistory = jobHistoryList.get(jobHistoryList.size() - 1);
        assertThat(testJobHistory.getStartDate()).isEqualTo(DEFAULT_START_DATE);
        assertThat(testJobHistory.getEndDate()).isEqualTo(DEFAULT_END_DATE);
        assertThat(testJobHistory.getLanguage()).isEqualTo(DEFAULT_LANGUAGE);
    }

    @Test
    @Transactional
    void createJobHistoryWithExistingId() throws Exception {
        // Create the JobHistory with an existing ID
        jobHistory.setId(1L);

        int databaseSizeBeforeCreate = jobHistoryRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restJobHistoryMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(jobHistory)))
            .andExpect(status().isBadRequest());

        // Validate the JobHistory in the database
        List<JobHistory> jobHistoryList = jobHistoryRepository.findAll();
        assertThat(jobHistoryList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkStartDateIsRequired() throws Exception {
        int databaseSizeBeforeTest = jobHistoryRepository.findAll().size();
        // set the field null
        jobHistory.setStartDate(null);

        // Create the JobHistory, which fails.

        restJobHistoryMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(jobHistory)))
            .andExpect(status().isBadRequest());

        List<JobHistory> jobHistoryList = jobHistoryRepository.findAll();
        assertThat(jobHistoryList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllJobHistories() throws Exception {
        // Initialize the database
        jobHistoryRepository.saveAndFlush(jobHistory);

        // Get all the jobHistoryList
        restJobHistoryMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(jobHistory.getId().intValue())))
            .andExpect(jsonPath("$.[*].startDate").value(hasItem(DEFAULT_START_DATE.toString())))
            .andExpect(jsonPath("$.[*].endDate").value(hasItem(DEFAULT_END_DATE.toString())))
            .andExpect(jsonPath("$.[*].language").value(hasItem(DEFAULT_LANGUAGE.toString())));
    }

    @Test
    @Transactional
    void getJobHistory() throws Exception {
        // Initialize the database
        jobHistoryRepository.saveAndFlush(jobHistory);

        // Get the jobHistory
        restJobHistoryMockMvc
            .perform(get(ENTITY_API_URL_ID, jobHistory.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(jobHistory.getId().intValue()))
            .andExpect(jsonPath("$.startDate").value(DEFAULT_START_DATE.toString()))
            .andExpect(jsonPath("$.endDate").value(DEFAULT_END_DATE.toString()))
            .andExpect(jsonPath("$.language").value(DEFAULT_LANGUAGE.toString()));
    }

    @Test
    @Transactional
    void getJobHistoriesByIdFiltering() throws Exception {
        // Initialize the database
        jobHistoryRepository.saveAndFlush(jobHistory);

        Long id = jobHistory.getId();

        defaultJobHistoryShouldBeFound("id.equals=" + id);
        defaultJobHistoryShouldNotBeFound("id.notEquals=" + id);

        defaultJobHistoryShouldBeFound("id.greaterThanOrEqual=" + id);
        defaultJobHistoryShouldNotBeFound("id.greaterThan=" + id);

        defaultJobHistoryShouldBeFound("id.lessThanOrEqual=" + id);
        defaultJobHistoryShouldNotBeFound("id.lessThan=" + id);
    }

    @Test
    @Transactional
    void getAllJobHistoriesByStartDateIsEqualToSomething() throws Exception {
        // Initialize the database
        jobHistoryRepository.saveAndFlush(jobHistory);

        // Get all the jobHistoryList where startDate equals to DEFAULT_START_DATE
        defaultJobHistoryShouldBeFound("startDate.equals=" + DEFAULT_START_DATE);

        // Get all the jobHistoryList where startDate equals to UPDATED_START_DATE
        defaultJobHistoryShouldNotBeFound("startDate.equals=" + UPDATED_START_DATE);
    }

    @Test
    @Transactional
    void getAllJobHistoriesByStartDateIsNotEqualToSomething() throws Exception {
        // Initialize the database
        jobHistoryRepository.saveAndFlush(jobHistory);

        // Get all the jobHistoryList where startDate not equals to DEFAULT_START_DATE
        defaultJobHistoryShouldNotBeFound("startDate.notEquals=" + DEFAULT_START_DATE);

        // Get all the jobHistoryList where startDate not equals to UPDATED_START_DATE
        defaultJobHistoryShouldBeFound("startDate.notEquals=" + UPDATED_START_DATE);
    }

    @Test
    @Transactional
    void getAllJobHistoriesByStartDateIsInShouldWork() throws Exception {
        // Initialize the database
        jobHistoryRepository.saveAndFlush(jobHistory);

        // Get all the jobHistoryList where startDate in DEFAULT_START_DATE or UPDATED_START_DATE
        defaultJobHistoryShouldBeFound("startDate.in=" + DEFAULT_START_DATE + "," + UPDATED_START_DATE);

        // Get all the jobHistoryList where startDate equals to UPDATED_START_DATE
        defaultJobHistoryShouldNotBeFound("startDate.in=" + UPDATED_START_DATE);
    }

    @Test
    @Transactional
    void getAllJobHistoriesByStartDateIsNullOrNotNull() throws Exception {
        // Initialize the database
        jobHistoryRepository.saveAndFlush(jobHistory);

        // Get all the jobHistoryList where startDate is not null
        defaultJobHistoryShouldBeFound("startDate.specified=true");

        // Get all the jobHistoryList where startDate is null
        defaultJobHistoryShouldNotBeFound("startDate.specified=false");
    }

    @Test
    @Transactional
    void getAllJobHistoriesByEndDateIsEqualToSomething() throws Exception {
        // Initialize the database
        jobHistoryRepository.saveAndFlush(jobHistory);

        // Get all the jobHistoryList where endDate equals to DEFAULT_END_DATE
        defaultJobHistoryShouldBeFound("endDate.equals=" + DEFAULT_END_DATE);

        // Get all the jobHistoryList where endDate equals to UPDATED_END_DATE
        defaultJobHistoryShouldNotBeFound("endDate.equals=" + UPDATED_END_DATE);
    }

    @Test
    @Transactional
    void getAllJobHistoriesByEndDateIsNotEqualToSomething() throws Exception {
        // Initialize the database
        jobHistoryRepository.saveAndFlush(jobHistory);

        // Get all the jobHistoryList where endDate not equals to DEFAULT_END_DATE
        defaultJobHistoryShouldNotBeFound("endDate.notEquals=" + DEFAULT_END_DATE);

        // Get all the jobHistoryList where endDate not equals to UPDATED_END_DATE
        defaultJobHistoryShouldBeFound("endDate.notEquals=" + UPDATED_END_DATE);
    }

    @Test
    @Transactional
    void getAllJobHistoriesByEndDateIsInShouldWork() throws Exception {
        // Initialize the database
        jobHistoryRepository.saveAndFlush(jobHistory);

        // Get all the jobHistoryList where endDate in DEFAULT_END_DATE or UPDATED_END_DATE
        defaultJobHistoryShouldBeFound("endDate.in=" + DEFAULT_END_DATE + "," + UPDATED_END_DATE);

        // Get all the jobHistoryList where endDate equals to UPDATED_END_DATE
        defaultJobHistoryShouldNotBeFound("endDate.in=" + UPDATED_END_DATE);
    }

    @Test
    @Transactional
    void getAllJobHistoriesByEndDateIsNullOrNotNull() throws Exception {
        // Initialize the database
        jobHistoryRepository.saveAndFlush(jobHistory);

        // Get all the jobHistoryList where endDate is not null
        defaultJobHistoryShouldBeFound("endDate.specified=true");

        // Get all the jobHistoryList where endDate is null
        defaultJobHistoryShouldNotBeFound("endDate.specified=false");
    }

    @Test
    @Transactional
    void getAllJobHistoriesByLanguageIsEqualToSomething() throws Exception {
        // Initialize the database
        jobHistoryRepository.saveAndFlush(jobHistory);

        // Get all the jobHistoryList where language equals to DEFAULT_LANGUAGE
        defaultJobHistoryShouldBeFound("language.equals=" + DEFAULT_LANGUAGE);

        // Get all the jobHistoryList where language equals to UPDATED_LANGUAGE
        defaultJobHistoryShouldNotBeFound("language.equals=" + UPDATED_LANGUAGE);
    }

    @Test
    @Transactional
    void getAllJobHistoriesByLanguageIsNotEqualToSomething() throws Exception {
        // Initialize the database
        jobHistoryRepository.saveAndFlush(jobHistory);

        // Get all the jobHistoryList where language not equals to DEFAULT_LANGUAGE
        defaultJobHistoryShouldNotBeFound("language.notEquals=" + DEFAULT_LANGUAGE);

        // Get all the jobHistoryList where language not equals to UPDATED_LANGUAGE
        defaultJobHistoryShouldBeFound("language.notEquals=" + UPDATED_LANGUAGE);
    }

    @Test
    @Transactional
    void getAllJobHistoriesByLanguageIsInShouldWork() throws Exception {
        // Initialize the database
        jobHistoryRepository.saveAndFlush(jobHistory);

        // Get all the jobHistoryList where language in DEFAULT_LANGUAGE or UPDATED_LANGUAGE
        defaultJobHistoryShouldBeFound("language.in=" + DEFAULT_LANGUAGE + "," + UPDATED_LANGUAGE);

        // Get all the jobHistoryList where language equals to UPDATED_LANGUAGE
        defaultJobHistoryShouldNotBeFound("language.in=" + UPDATED_LANGUAGE);
    }

    @Test
    @Transactional
    void getAllJobHistoriesByLanguageIsNullOrNotNull() throws Exception {
        // Initialize the database
        jobHistoryRepository.saveAndFlush(jobHistory);

        // Get all the jobHistoryList where language is not null
        defaultJobHistoryShouldBeFound("language.specified=true");

        // Get all the jobHistoryList where language is null
        defaultJobHistoryShouldNotBeFound("language.specified=false");
    }

    @Test
    @Transactional
    void getAllJobHistoriesByJobIsEqualToSomething() throws Exception {
        // Get already existing entity
        Job job = jobHistory.getJob();
        jobHistoryRepository.saveAndFlush(jobHistory);
        Long jobId = job.getId();

        // Get all the jobHistoryList where job equals to jobId
        defaultJobHistoryShouldBeFound("jobId.equals=" + jobId);

        // Get all the jobHistoryList where job equals to (jobId + 1)
        defaultJobHistoryShouldNotBeFound("jobId.equals=" + (jobId + 1));
    }

    @Test
    @Transactional
    void getAllJobHistoriesByDepartmentIsEqualToSomething() throws Exception {
        // Get already existing entity
        Department department = jobHistory.getDepartment();
        jobHistoryRepository.saveAndFlush(jobHistory);
        Long departmentId = department.getId();

        // Get all the jobHistoryList where department equals to departmentId
        defaultJobHistoryShouldBeFound("departmentId.equals=" + departmentId);

        // Get all the jobHistoryList where department equals to (departmentId + 1)
        defaultJobHistoryShouldNotBeFound("departmentId.equals=" + (departmentId + 1));
    }

    @Test
    @Transactional
    void getAllJobHistoriesByEmployeeIsEqualToSomething() throws Exception {
        // Get already existing entity
        Employee employee = jobHistory.getEmployee();
        jobHistoryRepository.saveAndFlush(jobHistory);
        Long employeeId = employee.getId();

        // Get all the jobHistoryList where employee equals to employeeId
        defaultJobHistoryShouldBeFound("employeeId.equals=" + employeeId);

        // Get all the jobHistoryList where employee equals to (employeeId + 1)
        defaultJobHistoryShouldNotBeFound("employeeId.equals=" + (employeeId + 1));
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultJobHistoryShouldBeFound(String filter) throws Exception {
        restJobHistoryMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(jobHistory.getId().intValue())))
            .andExpect(jsonPath("$.[*].startDate").value(hasItem(DEFAULT_START_DATE.toString())))
            .andExpect(jsonPath("$.[*].endDate").value(hasItem(DEFAULT_END_DATE.toString())))
            .andExpect(jsonPath("$.[*].language").value(hasItem(DEFAULT_LANGUAGE.toString())));

        // Check, that the count call also returns 1
        restJobHistoryMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultJobHistoryShouldNotBeFound(String filter) throws Exception {
        restJobHistoryMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restJobHistoryMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("0"));
    }

    @Test
    @Transactional
    void getNonExistingJobHistory() throws Exception {
        // Get the jobHistory
        restJobHistoryMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putNewJobHistory() throws Exception {
        // Initialize the database
        jobHistoryRepository.saveAndFlush(jobHistory);

        int databaseSizeBeforeUpdate = jobHistoryRepository.findAll().size();

        // Update the jobHistory
        JobHistory updatedJobHistory = jobHistoryRepository.findById(jobHistory.getId()).get();
        // Disconnect from session so that the updates on updatedJobHistory are not directly saved in db
        em.detach(updatedJobHistory);
        updatedJobHistory.startDate(UPDATED_START_DATE).endDate(UPDATED_END_DATE).language(UPDATED_LANGUAGE);

        restJobHistoryMockMvc
            .perform(
                put(ENTITY_API_URL_ID, updatedJobHistory.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(updatedJobHistory))
            )
            .andExpect(status().isOk());

        // Validate the JobHistory in the database
        List<JobHistory> jobHistoryList = jobHistoryRepository.findAll();
        assertThat(jobHistoryList).hasSize(databaseSizeBeforeUpdate);
        JobHistory testJobHistory = jobHistoryList.get(jobHistoryList.size() - 1);
        assertThat(testJobHistory.getStartDate()).isEqualTo(UPDATED_START_DATE);
        assertThat(testJobHistory.getEndDate()).isEqualTo(UPDATED_END_DATE);
        assertThat(testJobHistory.getLanguage()).isEqualTo(UPDATED_LANGUAGE);
    }

    @Test
    @Transactional
    void putNonExistingJobHistory() throws Exception {
        int databaseSizeBeforeUpdate = jobHistoryRepository.findAll().size();
        jobHistory.setId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restJobHistoryMockMvc
            .perform(
                put(ENTITY_API_URL_ID, jobHistory.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(jobHistory))
            )
            .andExpect(status().isBadRequest());

        // Validate the JobHistory in the database
        List<JobHistory> jobHistoryList = jobHistoryRepository.findAll();
        assertThat(jobHistoryList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchJobHistory() throws Exception {
        int databaseSizeBeforeUpdate = jobHistoryRepository.findAll().size();
        jobHistory.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restJobHistoryMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(jobHistory))
            )
            .andExpect(status().isBadRequest());

        // Validate the JobHistory in the database
        List<JobHistory> jobHistoryList = jobHistoryRepository.findAll();
        assertThat(jobHistoryList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamJobHistory() throws Exception {
        int databaseSizeBeforeUpdate = jobHistoryRepository.findAll().size();
        jobHistory.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restJobHistoryMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(jobHistory)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the JobHistory in the database
        List<JobHistory> jobHistoryList = jobHistoryRepository.findAll();
        assertThat(jobHistoryList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateJobHistoryWithPatch() throws Exception {
        // Initialize the database
        jobHistoryRepository.saveAndFlush(jobHistory);

        int databaseSizeBeforeUpdate = jobHistoryRepository.findAll().size();

        // Update the jobHistory using partial update
        JobHistory partialUpdatedJobHistory = new JobHistory();
        partialUpdatedJobHistory.setId(jobHistory.getId());

        restJobHistoryMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedJobHistory.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedJobHistory))
            )
            .andExpect(status().isOk());

        // Validate the JobHistory in the database
        List<JobHistory> jobHistoryList = jobHistoryRepository.findAll();
        assertThat(jobHistoryList).hasSize(databaseSizeBeforeUpdate);
        JobHistory testJobHistory = jobHistoryList.get(jobHistoryList.size() - 1);
        assertThat(testJobHistory.getStartDate()).isEqualTo(DEFAULT_START_DATE);
        assertThat(testJobHistory.getEndDate()).isEqualTo(DEFAULT_END_DATE);
        assertThat(testJobHistory.getLanguage()).isEqualTo(DEFAULT_LANGUAGE);
    }

    @Test
    @Transactional
    void fullUpdateJobHistoryWithPatch() throws Exception {
        // Initialize the database
        jobHistoryRepository.saveAndFlush(jobHistory);

        int databaseSizeBeforeUpdate = jobHistoryRepository.findAll().size();

        // Update the jobHistory using partial update
        JobHistory partialUpdatedJobHistory = new JobHistory();
        partialUpdatedJobHistory.setId(jobHistory.getId());

        partialUpdatedJobHistory.startDate(UPDATED_START_DATE).endDate(UPDATED_END_DATE).language(UPDATED_LANGUAGE);

        restJobHistoryMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedJobHistory.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedJobHistory))
            )
            .andExpect(status().isOk());

        // Validate the JobHistory in the database
        List<JobHistory> jobHistoryList = jobHistoryRepository.findAll();
        assertThat(jobHistoryList).hasSize(databaseSizeBeforeUpdate);
        JobHistory testJobHistory = jobHistoryList.get(jobHistoryList.size() - 1);
        assertThat(testJobHistory.getStartDate()).isEqualTo(UPDATED_START_DATE);
        assertThat(testJobHistory.getEndDate()).isEqualTo(UPDATED_END_DATE);
        assertThat(testJobHistory.getLanguage()).isEqualTo(UPDATED_LANGUAGE);
    }

    @Test
    @Transactional
    void patchNonExistingJobHistory() throws Exception {
        int databaseSizeBeforeUpdate = jobHistoryRepository.findAll().size();
        jobHistory.setId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restJobHistoryMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, jobHistory.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(jobHistory))
            )
            .andExpect(status().isBadRequest());

        // Validate the JobHistory in the database
        List<JobHistory> jobHistoryList = jobHistoryRepository.findAll();
        assertThat(jobHistoryList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchJobHistory() throws Exception {
        int databaseSizeBeforeUpdate = jobHistoryRepository.findAll().size();
        jobHistory.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restJobHistoryMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(jobHistory))
            )
            .andExpect(status().isBadRequest());

        // Validate the JobHistory in the database
        List<JobHistory> jobHistoryList = jobHistoryRepository.findAll();
        assertThat(jobHistoryList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamJobHistory() throws Exception {
        int databaseSizeBeforeUpdate = jobHistoryRepository.findAll().size();
        jobHistory.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restJobHistoryMockMvc
            .perform(
                patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(TestUtil.convertObjectToJsonBytes(jobHistory))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the JobHistory in the database
        List<JobHistory> jobHistoryList = jobHistoryRepository.findAll();
        assertThat(jobHistoryList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteJobHistory() throws Exception {
        // Initialize the database
        jobHistoryRepository.saveAndFlush(jobHistory);

        int databaseSizeBeforeDelete = jobHistoryRepository.findAll().size();

        // Delete the jobHistory
        restJobHistoryMockMvc
            .perform(delete(ENTITY_API_URL_ID, jobHistory.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<JobHistory> jobHistoryList = jobHistoryRepository.findAll();
        assertThat(jobHistoryList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
