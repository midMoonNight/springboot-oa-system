Ext.define('Admin.model.department.DepartmentModel', {
    extend: 'Ext.data.Model',
	requires: [
		'Ext.data.proxy.Rest'
	],
    fields: [
		 {type: 'int' ,name: 'id'}
        ,{type: 'string' ,name: 'departmentName'}
		,{type: 'string' ,name: 'departmentNumber'}
		,{type: 'string' ,name: 'introduction'}
        ,{type: 'string' ,name: 'duties'}
        ,{type: 'date' ,name: 'createTime',dateFormat:'Y/m/d'}
    ],
	proxy: {
		type: 'rest',
		url: '/department',
	}
});