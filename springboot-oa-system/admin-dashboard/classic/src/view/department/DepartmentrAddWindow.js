Ext.define('Admin.view.department.DepartmentAddWindow',{
	extend:'Ext.window.Window',
	alias:'widget.departmentAddWindow',
	autoShow: true,
	modal: true,
	layout:'fit',
	width:600,
	height:400,
	title:'添加部门',
	requires:[
		'Ext.grid.column.Date'
	],
	items:[{
		xtype:'form',
		layout:'form',
		bodyPadding: 20,
		scrollable: true,
		items:[{
            xtype: 'textfield',
            fieldLabel: 'id',
            name:'id',
            hidden: true,
            readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '部门名称',
            name:'department_name'
        }, {
            xtype: 'textfield',
            fieldLabel: '部门编号',
            name:'department_number'
        }, {
            xtype: 'textfield',
            fieldLabel: '部门简介',
            name:'introduction'
        }, {
            xtype: 'textfield',
            fieldLabel: '部门职责',
            name:'duties'
        }, {
            xtype: 'datefield',
            fieldLabel: '创建时间',
            name:'create_time',
            format: 'Y/m/d'
        }],
		buttons: [ 
			{
            	xtype: 'button',
            	text: 'Submit',
            	handler: 'submitAddForm'
	        },{
	            xtype: 'button',
	            text: 'Close',
	            handler: function(btn) {
	                btn.up('window').close();
	            }
	        }
		]
	}]
});