requirejs.config({
    baseUrl: 'js',
    paths: {
        jquery: 'lib/jquery-2.1.3.min',
        underscore: 'lib/underscore-min',
        handlebars:'lib/handlebars-v3.0.1',
        backbone: 'lib/backbone-min',
        text:'lib/text'
    },
    shim: {
        backbone: {
            deps: ['jquery', 'underscore','handlebars'],
            exports: 'Backbone'
        },
        underscore: {
            exports: '_'
        },
        jquery: {
            exports: '$'
        }
    }
});

require(['underscore', 'backbone','scripts/apps/app'],
function(_, Backbone, app) {
    app.start();
});