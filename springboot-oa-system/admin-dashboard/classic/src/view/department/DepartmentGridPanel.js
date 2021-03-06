Ext.define('Admin.view.department.DepartmentGridPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'departmentGridPanel',

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
            title: 'DepartmentGrid Results',
            bind: '{departmentLists}',
            scrollable: false,
            columns: [
                {xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: '#',hidden:true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'departmentNumber',text: '部门编号',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'departmentName',text: '部门名称',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'introduction',text: '部门简介'
                	,flex: 1,sortable:true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'duties',text: '部门职责',flex: 1
                		,sortable:false},
                {xtype: 'datecolumn',cls: 'content-column',dataIndex: 'createTime',text: '创建时间'
                	,formatter: 'date("Y/m/d")',flex: 1,sortable:false},
                {xtype: 'actioncolumn',cls: 'content-column', width: 120,dataIndex: 'bool',text: 'Actions'
                	,tooltip: 'edit ',
                    items: [
                        {xtype: 'button', iconCls: 'x-fa fa-pencil' ,handler: 'openEditWindow'},
                        {xtype: 'button',iconCls: 'x-fa fa-close'	,handler: 'onDeleteOneRow'}
                    ]
                }
            ],
            tbar: [{
                xtype: 'combobox',
                hideLabel: true,
                reference:'searchFieldName',
                store:Ext.create("Ext.data.Store", {
                    fields: ["name", "value"],
                    data: [
                        { name: '部门名称', value: 'departmentName' },
                        { name: '部门编号', value: 'departmentNumber' },
                        { name: '创建时间', value: 'createTime' }
                    ]
                }),
                displayField: 'name',
                valueField:'value',
                value:'departmentName',
                editable: false,
                queryMode: 'local',
                triggerAction: 'all',
                emptyText: 'Select a state...',
                width: 135,
                listeners:{
                    select: 'searchComboboxSelectChange'
                }
            }, '-',{
                xtype:'textfield',
                reference:'searchFieldValue',
                name:'orderPanelSearchField'
            }, '-',{
                xtype: 'datefield',
                hideLabel: true,
                hidden:true,
                format: 'Y/m/d',
                reference:'searchDataFieldValue',
                fieldLabel: 'From',
                name: 'from_date'
            }, '-',{
                xtype: 'datefield',
                hideLabel: true,
                hidden:true,
                format: 'Y/m/d',
                reference:'searchDataFieldValue2',
                fieldLabel: 'To',
                name: 'to_date'
            }, '-',{
                text: 'Search',
                iconCls: 'fa fa-search',
                handler: 'quickSearch'
            }, '-',{
                text: 'Search More',
                iconCls: 'fa fa-search-plus',
                handler: 'openSearchWindow' 
            }, '->',{
                text: 'Add',
                tooltip: 'Add a new row',
                iconCls: 'fa fa-plus',
                handler: 'openAddWindow'    
            }],
            dockedItems: [{
                xtype: 'pagingtoolbar',
                dock: 'bottom',
                itemId: 'userPaginationToolbar',
                displayInfo: true,
                bind: '{departmentLists}'
            }]
        }]
});
