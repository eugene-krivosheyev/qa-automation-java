import React, { useState, useEffect } from 'react';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col, FormText } from 'reactstrap';
import { isNumber, Translate, translate, ValidatedField, ValidatedForm } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IJob } from 'app/shared/model/job.model';
import { getEntities as getJobs } from 'app/entities/job/job.reducer';
import { IDepartment } from 'app/shared/model/department.model';
import { getEntities as getDepartments } from 'app/entities/department/department.reducer';
import { IEmployee } from 'app/shared/model/employee.model';
import { getEntities as getEmployees } from 'app/entities/employee/employee.reducer';
import { getEntity, updateEntity, createEntity, reset } from './job-history.reducer';
import { IJobHistory } from 'app/shared/model/job-history.model';
import { convertDateTimeFromServer, convertDateTimeToServer, displayDefaultDateTime } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';
import { useAppDispatch, useAppSelector } from 'app/config/store';

export const JobHistoryUpdate = (props: RouteComponentProps<{ id: string }>) => {
  const dispatch = useAppDispatch();

  const [isNew] = useState(!props.match.params || !props.match.params.id);

  const jobs = useAppSelector(state => state.job.entities);
  const departments = useAppSelector(state => state.department.entities);
  const employees = useAppSelector(state => state.employee.entities);
  const jobHistoryEntity = useAppSelector(state => state.jobHistory.entity);
  const loading = useAppSelector(state => state.jobHistory.loading);
  const updating = useAppSelector(state => state.jobHistory.updating);
  const updateSuccess = useAppSelector(state => state.jobHistory.updateSuccess);

  const handleClose = () => {
    props.history.push('/job-history');
  };

  useEffect(() => {
    if (!isNew) {
      dispatch(getEntity(props.match.params.id));
    }

    dispatch(getJobs({}));
    dispatch(getDepartments({}));
    dispatch(getEmployees({}));
  }, []);

  useEffect(() => {
    if (updateSuccess) {
      handleClose();
    }
  }, [updateSuccess]);

  const saveEntity = values => {
    values.startDate = convertDateTimeToServer(values.startDate);
    values.endDate = convertDateTimeToServer(values.endDate);

    const entity = {
      ...jobHistoryEntity,
      ...values,
      job: jobs.find(it => it.id.toString() === values.jobId.toString()),
      department: departments.find(it => it.id.toString() === values.departmentId.toString()),
      employee: employees.find(it => it.id.toString() === values.employeeId.toString()),
    };

    if (isNew) {
      dispatch(createEntity(entity));
    } else {
      dispatch(updateEntity(entity));
    }
  };

  const defaultValues = () =>
    isNew
      ? {
          startDate: displayDefaultDateTime(),
          endDate: displayDefaultDateTime(),
        }
      : {
          language: 'RU',
          ...jobHistoryEntity,
          startDate: convertDateTimeFromServer(jobHistoryEntity.startDate),
          endDate: convertDateTimeFromServer(jobHistoryEntity.endDate),
          jobId: jobHistoryEntity?.job?.id,
          departmentId: jobHistoryEntity?.department?.id,
          employeeId: jobHistoryEntity?.employee?.id,
        };

  return (
    <div>
      <Row className="justify-content-center">
        <Col md="8">
          <h2 id="appApp.jobHistory.home.createOrEditLabel" data-cy="JobHistoryCreateUpdateHeading">
            <Translate contentKey="appApp.jobHistory.home.createOrEditLabel">Create or edit a JobHistory</Translate>
          </h2>
        </Col>
      </Row>
      <Row className="justify-content-center">
        <Col md="8">
          {loading ? (
            <p>Loading...</p>
          ) : (
            <ValidatedForm defaultValues={defaultValues()} onSubmit={saveEntity}>
              {!isNew ? (
                <ValidatedField
                  name="id"
                  required
                  readOnly
                  id="job-history-id"
                  label={translate('global.field.id')}
                  validate={{ required: true }}
                />
              ) : null}
              <ValidatedField
                label={translate('appApp.jobHistory.startDate')}
                id="job-history-startDate"
                name="startDate"
                data-cy="startDate"
                type="datetime-local"
                placeholder="YYYY-MM-DD HH:mm"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('appApp.jobHistory.endDate')}
                id="job-history-endDate"
                name="endDate"
                data-cy="endDate"
                type="datetime-local"
                placeholder="YYYY-MM-DD HH:mm"
              />
              <ValidatedField
                label={translate('appApp.jobHistory.language')}
                id="job-history-language"
                name="language"
                data-cy="language"
                type="select"
              >
                <option value="RU">{translate('appApp.Language.RU')}</option>
                <option value="EN">{translate('appApp.Language.EN')}</option>
                <option value="ES">{translate('appApp.Language.ES')}</option>
              </ValidatedField>
              <ValidatedField
                id="job-history-job"
                name="jobId"
                data-cy="job"
                label={translate('appApp.jobHistory.job')}
                type="select"
                required
              >
                <option value="" key="0" />
                {jobs
                  ? jobs.map(otherEntity => (
                      <option value={otherEntity.id} key={otherEntity.id}>
                        {otherEntity.id}
                      </option>
                    ))
                  : null}
              </ValidatedField>
              <FormText>
                <Translate contentKey="entity.validation.required">This field is required.</Translate>
              </FormText>
              <ValidatedField
                id="job-history-department"
                name="departmentId"
                data-cy="department"
                label={translate('appApp.jobHistory.department')}
                type="select"
                required
              >
                <option value="" key="0" />
                {departments
                  ? departments.map(otherEntity => (
                      <option value={otherEntity.id} key={otherEntity.id}>
                        {otherEntity.id}
                      </option>
                    ))
                  : null}
              </ValidatedField>
              <FormText>
                <Translate contentKey="entity.validation.required">This field is required.</Translate>
              </FormText>
              <ValidatedField
                id="job-history-employee"
                name="employeeId"
                data-cy="employee"
                label={translate('appApp.jobHistory.employee')}
                type="select"
                required
              >
                <option value="" key="0" />
                {employees
                  ? employees.map(otherEntity => (
                      <option value={otherEntity.id} key={otherEntity.id}>
                        {otherEntity.id}
                      </option>
                    ))
                  : null}
              </ValidatedField>
              <FormText>
                <Translate contentKey="entity.validation.required">This field is required.</Translate>
              </FormText>
              <Button tag={Link} id="cancel-save" data-cy="entityCreateCancelButton" to="/job-history" replace color="info">
                <FontAwesomeIcon icon="arrow-left" />
                &nbsp;
                <span className="d-none d-md-inline">
                  <Translate contentKey="entity.action.back">Back</Translate>
                </span>
              </Button>
              &nbsp;
              <Button color="primary" id="save-entity" data-cy="entityCreateSaveButton" type="submit" disabled={updating}>
                <FontAwesomeIcon icon="save" />
                &nbsp;
                <Translate contentKey="entity.action.save">Save</Translate>
              </Button>
            </ValidatedForm>
          )}
        </Col>
      </Row>
    </div>
  );
};

export default JobHistoryUpdate;
