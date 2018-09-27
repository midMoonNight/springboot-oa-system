Ext.define('Admin.view.department.DepartmentCenterPanel', {
    extend: 'Ext.container.Container',
    xtype: 'departmentCenterPanel',
    controller: 'departmentViewController',
    viewModel: {type: 'departmentViewModel'},
    layout: 'fit',
    items: [{xtype:'departmentGridPanel'}]
});