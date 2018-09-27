Ext.define('Admin.view.department.DepartmentViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.departmentViewModel',

    requires: [
        'Ext.data.Store',
        'Ext.data.proxy.Memory',
        'Ext.data.field.Integer',
        'Ext.data.field.String',
        'Ext.data.reader.Json'
    ],

    stores: {
		departmentLists: {type: 'departmentStroe'}
    }
});
