Ext.define('Admin.view.department.DepartmentEditWindow',{
	extend:'Ext.window.Window',
	alias:'widget.departmentEditWindow',
	autoShow: true,
	modal: true,
	layout:'fit',
	width:500,
	height:300,
	title:'修改部门信息',

	items:[{
		xtype:'form',
		layout:'form',
		bodyPadding: 20,
		items:[{
            xtype: 'textfield',
            fieldLabel: 'id',
            name:'id',
            hidden: true,
            readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '部门名称',
            name:'departmentName'
        }, {
            xtype: 'textfield',
            fieldLabel: '部门简介',
            name:'introduction'
        }, {
            xtype: 'textfield',
            fieldLabel: '部门职责',
            name:'duties'
        }],
		buttons: ["->", 
			{
				xtype: 'button',
				text: 'Submit',
				handler: 'submitEditForm'
			}
			,{
				xtype: 'button',
				text: 'Close',
				handler: function(btn) {
					btn.up('window').close();
				}
			},
			"->"
		]
	}],
});