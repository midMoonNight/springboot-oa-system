Ext.define('Admin.model.department.DepartmentModel', {
    extend: 'Ext.data.Model',
	requires: [
		'Ext.data.proxy.Rest'
	],
    fields: [
		 {type: 'int' ,name: 'id'}
        ,{type: 'string' ,name: 'department_name'}
		,{type: 'string' ,name: 'department_number'}
		,{type: 'string' ,name: 'introduction'}
        ,{type: 'string' ,name: 'duties'}
        ,{type: 'date' ,name: 'create_time',dateFormat:'Y/m/d'}
    ],
	proxy: {
		type: 'rest',
		url: '/department',
	}
});