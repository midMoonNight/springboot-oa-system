Ext.define('Admin.store.NavigationTree', {
    extend: 'Ext.data.TreeStore',

    storeId: 'NavigationTree',

    fields: [{
        name: 'text'
    }],

    root: {
        expanded: true,
        children: [
            {
                text: 'Dashboard',
                iconCls: 'x-fa fa-desktop',
                rowCls: 'nav-tree-badge nav-tree-badge-new',
                viewType: 'admindashboard',
                routeId: 'dashboard', // routeId defaults to viewType
                leaf: true
            },{
                text: '部门管理模块',
                iconCls: 'x-fa fa-address-card',
                //rowCls: 'nav-tree-badge nav-tree-badge-new',
                viewType: 'departmentCenterPanel',
                leaf: true
            },{
                text: '订单管理',
                iconCls: 'x-fa fa-address-card',
                //rowCls: 'nav-tree-badge nav-tree-badge-new',
                //viewType: 'order',
                expanded: true,
                children:[{
                    text: '订单管理模块',
                    iconCls: 'x-fa fa-address-card',
                    //rowCls: 'nav-tree-badge nav-tree-badge-new',
                    viewType: 'order',
                    leaf: true
                }]
            }
        ]
    }
});
