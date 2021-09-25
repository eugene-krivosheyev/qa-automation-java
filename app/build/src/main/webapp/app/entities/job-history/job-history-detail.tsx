import React, { useEffect } from 'react';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { getEntity } from './job-history.reducer';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

export const JobHistoryDetail = (props: RouteComponentProps<{ id: string }>) => {
  const dispatch = useAppDispatch();

  useEffect(() => {
    dispatch(getEntity(props.match.params.id));
  }, []);

  const jobHistoryEntity = useAppSelector(state => state.jobHistory.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="jobHistoryDetailsHeading">
          <Translate contentKey="appApp.jobHistory.detail.title">JobHistory</Translate>
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">
              <Translate contentKey="global.field.id">ID</Translate>
            </span>
          </dt>
          <dd>{jobHistoryEntity.id}</dd>
          <dt>
            <span id="startDate">
              <Translate contentKey="appApp.jobHistory.startDate">Start Date</Translate>
            </span>
          </dt>
          <dd>
            {jobHistoryEntity.startDate ? <TextFormat value={jobHistoryEntity.startDate} type="date" format={APP_DATE_FORMAT} /> : null}
          </dd>
          <dt>
            <span id="endDate">
              <Translate contentKey="appApp.jobHistory.endDate">End Date</Translate>
            </span>
          </dt>
          <dd>{jobHistoryEntity.endDate ? <TextFormat value={jobHistoryEntity.endDate} type="date" format={APP_DATE_FORMAT} /> : null}</dd>
          <dt>
            <span id="language">
              <Translate contentKey="appApp.jobHistory.language">Language</Translate>
            </span>
          </dt>
          <dd>{jobHistoryEntity.language}</dd>
          <dt>
            <Translate contentKey="appApp.jobHistory.job">Job</Translate>
          </dt>
          <dd>{jobHistoryEntity.job ? jobHistoryEntity.job.id : ''}</dd>
          <dt>
            <Translate contentKey="appApp.jobHistory.department">Department</Translate>
          </dt>
          <dd>{jobHistoryEntity.department ? jobHistoryEntity.department.id : ''}</dd>
          <dt>
            <Translate contentKey="appApp.jobHistory.employee">Employee</Translate>
          </dt>
          <dd>{jobHistoryEntity.employee ? jobHistoryEntity.employee.id : ''}</dd>
        </dl>
        <Button tag={Link} to="/job-history" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/job-history/${jobHistoryEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

export default JobHistoryDetail;
