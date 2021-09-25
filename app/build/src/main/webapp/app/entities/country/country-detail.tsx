import React, { useEffect } from 'react';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { getEntity } from './country.reducer';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

export const CountryDetail = (props: RouteComponentProps<{ id: string }>) => {
  const dispatch = useAppDispatch();

  useEffect(() => {
    dispatch(getEntity(props.match.params.id));
  }, []);

  const countryEntity = useAppSelector(state => state.country.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="countryDetailsHeading">
          <Translate contentKey="appApp.country.detail.title">Country</Translate>
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">
              <Translate contentKey="global.field.id">ID</Translate>
            </span>
          </dt>
          <dd>{countryEntity.id}</dd>
          <dt>
            <span id="countryName">
              <Translate contentKey="appApp.country.countryName">Country Name</Translate>
            </span>
          </dt>
          <dd>{countryEntity.countryName}</dd>
          <dt>
            <Translate contentKey="appApp.country.region">Region</Translate>
          </dt>
          <dd>{countryEntity.region ? countryEntity.region.id : ''}</dd>
        </dl>
        <Button tag={Link} to="/country" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/country/${countryEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

export default CountryDetail;
