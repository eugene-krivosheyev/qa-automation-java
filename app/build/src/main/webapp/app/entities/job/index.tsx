import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import Job from './job';
import JobDetail from './job-detail';
import JobUpdate from './job-update';
import JobDeleteDialog from './job-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={JobUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={JobUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={JobDetail} />
      <ErrorBoundaryRoute path={match.url} component={Job} />
    </Switch>
    <ErrorBoundaryRoute exact path={`${match.url}/:id/delete`} component={JobDeleteDialog} />
  </>
);

export default Routes;
