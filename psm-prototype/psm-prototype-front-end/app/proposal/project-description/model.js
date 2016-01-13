/*
* project-description/model.js
*/

import DS from 'ember-data';

export default DS.Model.extend({

  metaData: DS.belongsTo('proposal/document-meta-data'),

  // file: DS.<>('', {async: true}),

  proposal: DS.belongsTo('proposal')

});
