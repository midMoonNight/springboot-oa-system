Ext.define('Admin.view.department.DepartmentViewController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.departmentViewController',
 
    /*--------------------- 增 ---------------------------*/

    /*Add*/
    openAddWindow:function(btn){
        btn.up('container').add(Ext.widget('departmentAddWindow')).show();
    },
    /*Add Submit*/ 
    submitAddForm:function(btn){
      var win = btn.up('window');
      var form = win.down('form');
      var store = btn.up('gridpanel').getStore();
      var record = Ext.create('Admin.model.department.DepartmentModel');
      //获取form数据
      var values = form.getValues();
      //console.log(values);
      //console.log(values.department_name);
      if(values.departmentName != null && values.departmentNumber && values.createTime != null){
    	  record.set(values);
          record.save();          
          //Ext.apply(store.proxy.extraParams, {departmentName:"",departmentNumber:"",createTimeStart:"",createTimeEnd:""});
          //Ext.data.StoreManager.lookup('departmentStroe').load();
          store.load();
          win.close();
      }else{
    	  Ext.Msg.alert("Title","部门编号、部门名称和创建时间不能为空！！！");
      }
      
    },

    /*--------------------- 删 ---------------------------*/
    /*Delete*/
    onDeleteOneRow:function(grid, rowIndex, colIndex){
        Ext.MessageBox.confirm('提示', '确定要进行删除操作吗？数据将无法还原！',
            function(btn, text){
                if(btn=='yes'){
                    //获取stroe
                    var store = grid.getStore();
                    //获取选中的行的信息
                    var record = store.getAt(rowIndex);
                    //DELETE//http://localhost:8080/department/id
                    store.remove(record);
                    //重新加载数据
                    Ext.data.StoreManager.lookup('departmentStroe').load();
                    //store.sync();
                }
            }
        , this);
    },

    /*--------------------- 改 ---------------------------*/
    /*Edit*/
    openEditWindow:function(grid, rowIndex, colIndex){
        var record = grid.getStore().getAt(rowIndex);
        //获取选中数据的字段值：console.log(record.get('id')); 或者 console.log(record.data.id);
        if (record) {
            var win = grid.up('container').add(Ext.widget('departmentEditWindow'));
            win.show();
            win.down('form').getForm().loadRecord(record);
            //console.log(record.get('id'));
        }
    },
    /*Edit Submit*/
    submitEditForm:function(btn){
        //获取当前window
        var win = btn.up('window');
        //获取stroe
        var store = Ext.data.StoreManager.lookup('departmentStroe');
        //获取form数据
        var values  = win.down('form').getValues();
        //获取id获取store中的数据
        var record = store.getById(values.id);
        record.set(values);
        //store.load();
        win.close();
    },
    
    /*--------------------- 查 ---------------------------*/
    /*combobox选中后控制对应输入（文本框和日期框）框显示隐藏*/
    searchComboboxSelectChange:function(combo,record,index){
        //根据reference获取combobox的值
        var searchField = this.lookupReference('searchFieldName').getValue();
        //根据combobox的值来控制文本框和日期框的显示和隐藏
        if(searchField ==='createTime'){
            this.lookupReference('searchFieldValue').hide();
            this.lookupReference('searchDataFieldValue').show();
            this.lookupReference('searchDataFieldValue2').show();
        }else{
            this.lookupReference('searchFieldValue').show();
            this.lookupReference('searchDataFieldValue').hide();
            this.lookupReference('searchDataFieldValue2').hide();
        }        
    },
    /*Quick Search*/    
    quickSearch:function(btn){
        //根据reference获取值
        var searchField = this.lookupReference('searchFieldName').getValue();
        var searchValue = this.lookupReference('searchFieldValue').getValue();
        var searchDataFieldValue = this.lookupReference('searchDataFieldValue').getValue();
        var searchDataFieldValue2 = this.lookupReference('searchDataFieldValue2').getValue();
        //获取stroe
        var store = btn.up('gridpanel').getStore();
        //var store = Ext.getCmp('userGridPanel').getStore();// Ext.getCmp(）需要在OrderPanel设置id属性
        
        //设置参数，默认为空
        Ext.apply(store.proxy.extraParams, {departmentName:"",departmentNumber:"",createTimeStart:"",createTimeEnd:""});
        //根据查询的对象，动态修改参数的值
        if(searchField==='departmentName'){
            Ext.apply(store.proxy.extraParams, {departmentName:searchValue});
            this.lookupReference('searchFieldValue').setValue("");
        }
        if(searchField==='departmentNumber'){
            Ext.apply(store.proxy.extraParams, {departmentNumber:searchValue});
            this.lookupReference('searchFieldValue').setValue("");
        }
        if(searchField==='createTime'){
        	if(searchDataFieldValue2 != null && searchDataFieldValue != null){
        		if(searchDataFieldValue2 >= searchDataFieldValue){
            		Ext.apply(store.proxy.extraParams,{
                        createTimeStart:Ext.util.Format.date(searchDataFieldValue, 'Y/m/d'),
                        createTimeEnd:Ext.util.Format.date(searchDataFieldValue2, 'Y/m/d')
                    });           		
            	}else{
            		Ext.Msg.alert("Title","后面的时间不能小于前面的时间");
            		return;
            	}
        	}else{
        		Ext.apply(store.proxy.extraParams,{
                    createTimeStart:Ext.util.Format.date(searchDataFieldValue, 'Y/m/d'),
                    createTimeEnd:Ext.util.Format.date(searchDataFieldValue2, 'Y/m/d')
                });
        	}
        	this.lookupReference('searchDataFieldValue').setValue("");
    		this.lookupReference('searchDataFieldValue2').setValue("");
        }
        //发送请求
        store.load(function(records, operation, success) {
        	Ext.apply(store.proxy.extraParams, {departmentName:"",departmentNumber:"",createTimeStart:"",createTimeEnd:""});
        });
    },

    /*Search More*/ 
    openSearchWindow:function(btn){
        btn.up('grid').up('container').add(Ext.widget('departmentSearchWindow')).show();
        //Ext.Msg.alert("Title","openSearchWindow");
    },
    /*Search Submit*/
    submitSearchForm:function(btn){
        //获取stroe
        var store = Ext.data.StoreManager.lookup('departmentStroe');
        //获取Window
        var win = btn.up('window');
        //获取form表单
        var form = win.down('form');
        //获取表单的数据
        var values  = form.getValues();
        //设置参数，默认为空
        Ext.apply(store.proxy.extraParams, {departmentName:"",departmentNumber:"",createTimeStart:"",createTimeEnd:""});
        //动态修改参数的值
        Ext.apply(store.proxy.extraParams,{
            departmentName:values.departmentName,
            departmentNumber:values.departmentNumber
        });
        if(searchDataFieldValue2 >= searchDataFieldValue){
        	Ext.apply(store.proxy.extraParams,{
                //将日期数据格式化
                createTimeStart:Ext.util.Format.date(searchDataFieldValue, 'Y/m/d'),
                createTimeEnd:Ext.util.Format.date(searchDataFieldValue2, 'Y/m/d')

            });
        }else{
    		Ext.Msg.alert("Title","后面的时间不能小于前面的时间");
    		return;
    	}
        
        //发送请求
        store.load(function(records, operation, success) {
        	Ext.apply(store.proxy.extraParams, {departmentName:"",departmentNumber:"",createTimeStart:"",createTimeEnd:""});
        });
        //关闭Windos
        win.close();
    }   
});
