Ext.define('Admin.view.department.DepartmentGridPanel2', {
    extend: 'Ext.panel.Panel',
    xtype: 'departmentGridPanel2',

    requires: [
        'Ext.grid.Panel',
        'Ext.toolbar.Paging',
        'Ext.form.field.ComboBox',
        'Ext.form.field.Date',
        'Ext.grid.column.Date'
    ],

    layout: 'fit',
    items: [{
            xtype: 'gridpanel',
            cls: 'user-grid',
            title: 'DepartmentGrid2 Results2',
            bind: '{departmentLists}',
            scrollable: false,
            columns: [
                {xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: '#'},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'name',text: 'Name',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'number',text: 'Number',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'introduction',text: 'Introduction',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'duties',text: 'Duties',flex: 1},
                {xtype: 'datecolumn',cls: 'content-column',dataIndex: 'createTime',text: 'CreateTime',formatter: 'date("Y/m/d")',flex: 1},
                {xtype: 'actioncolumn',cls: 'content-column', width: 120,dataIndex: 'bool',text: 'Actions',tooltip: 'edit ',
                    items: [
                        {xtype: 'button', iconCls: 'x-fa fa-pencil' ,handler: 'onEditButton'},
                        {xtype: 'button',iconCls: 'x-fa fa-close'   ,handler: 'onDeleteButton'},
                        {xtype: 'button',iconCls: 'x-fa fa-ban'     ,handler: 'onDisableButton'}
                    ]
                }
            ],
            dockedItems: [{
                xtype: 'pagingtoolbar',
                dock: 'bottom',
                itemId: 'userPaginationToolbar',
                displayInfo: true,
                bind: '{departmentLists}'
            }]
        }]
});