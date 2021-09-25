import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import JobHistory from './job-history';
import JobHistoryDetail from './job-history-detail';
import JobHistoryUpdate from './job-history-update';
import JobHistoryDeleteDialog from './job-history-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={JobHistoryUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={JobHistoryUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={JobHistoryDetail} />
      <ErrorBoundaryRoute path={match.url} component={JobHistory} />
    </Switch>
    <ErrorBoundaryRoute exact path={`${match.url}/:id/delete`} component={JobHistoryDeleteDialog} />
  </>
);

export default Routes;
