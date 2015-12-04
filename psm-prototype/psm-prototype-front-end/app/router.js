import Ember from 'ember';
import config from './config/environment';

const Router = Ember.Router.extend({
  location: config.locationType
});

Router.map(function() {

  /*
  *
  * You can leave off the path if it is the same as the route name.
  * When the user visits /cover-sheet, Ember.js will render the cover-sheet template.
  *
  * When the user visits /dmp, Ember.js will render the data-management-plan template.
  *
  */

  this.route('cover-sheet');
  this.route('project-description');
  this.route('data-management-plan', { path: '/dmp'});

  /*
  //dynamic segment -- SHOULD PROBABLY USE NESTED ROUTES (BELOW)
  this.route('proposal', { path: '/proposal/:proposal-id'});

  //if proposal has an id, the other paths must also be dynamic
  this.route('cover-sheet', { path: '/proposal/:proposal-id'/cover-sheet} );
  this.route('project-description', { path: '/proposal/:proposal-id/project-description'});
  this.route('data-management-plan', { path: '/proposal/:proposal-id/dmp'});
  */

  /*
  //Nested Routes
  this.route('proposal', { path: '/proposal/:proposal-id'}, function () {
    //path: /proposal/:proposal-id/cover-sheet,
    //loads the cover-sheet.hbs template not the proposal/cover-sheet.hbs template
    //
    this.route('cover-sheet', { resetNamespace: true });
    this.route('project-description', { resetNamespace: true });
    //path: /proposal/:proposal-id/dmp,
    loads the data-management-plan.hbs template not the proposal/data-management-plan.hbs template
    //
    this.route('data-management-plan', { path: '/dmp', resetNamespace: true });
  });
  */


  //Page Not Found
  //this.route('page-not-found', { path: '/*wildcard' });

});

export default Router;
