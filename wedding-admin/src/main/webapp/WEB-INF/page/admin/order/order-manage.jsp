<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/manager/inc/headroot.jsp" %>
<script type="text/javascript" src="${contextPath}/js/dateutil.js"></script>
<script type="text/javascript" src="${contextPath}/app/order-constants.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
Ext.onReady(function() {
    Ext.QuickTips.init();
    // setup the state provider, all state information will be saved to a cookie
    Ext.state.Manager.setProvider(Ext.create('Ext.state.CookieProvider'));
    
    var orderStore = Ext.create('Ext.data.ArrayStore', {
        fields : ['id', 'orderNo', 'orderTypeName', 'orderTotal', 'orderBuyer', 'orderStatus', 'orderType',
                  'paymentStatus', 'appointId', 'orderIsOnline', 'shopName', 'sellerName', 'buyerMobileNo', 
                  'createTime'
                  //{name:'createTime',type:'date',mapping:'createTime.time',dateFormat : 'Y-m-d'}
                  ],
       	pageSize : 20,
        proxy : {
            type : 'ajax',
            api : {
                read : '${contextPath}/order/order-manage/find.do'
            },
            reader : {
                type : 'json',
                root : 'results',
                successProperty : 'success',
                totalProperty : 'total'
            },
            timeout : 180000,
    		actionMethods : {
    			read : 'POST'
    		}
        }
    });
    
    var bbar =  Ext.create('Ext.Toolbar', {
    	width : Ext.get('order-grid').getWidth(),
    	border : 0,
    	layout : {
    		type : 'table',
    		columns : 4
    	},   	
	    items: [
	       {
				xtype : 'datefield',
				fieldLabel : '创建时间',
				format : 'Y-m-d',
				labelWidth : 60,
				width : 160,
				id : 'begin_date',
				value : new Date()
		    },
		    {
				xtype : 'datefield',
				fieldLabel : '至',
				format : 'Y-m-d',
				labelWidth : 30,
				width : 130,
				id : 'end_date',
				value : new Date()
		    },
		    {
		    	id : 'orderNum',
		    	xtype : 'textfield',
		    	width : 160,
		    	fieldLabel : '订单号',
		    	labelWidth : 50
		    },
		    {
		    	id : 'orderBuyer',
		    	xtype : 'textfield',
		    	width : 160,
		    	fieldLabel : '订单人',
		    	labelWidth : 50
		    },
		    {
		    	id : 'beginAmount',
				xtype : 'numberfield',
				fieldLabel : '订单金额',		
				minValue : 0,	
				labelWidth : 60,
				width : 160							
		    },
		    {
		    	id : 'endAmount',
				xtype : 'numberfield',
				fieldLabel : '至',	
				minValue : 0,			
				labelWidth : 30,
				width : 130			
		    },
		    {
		    	id : 'shopName',
		    	xtype : 'textfield',
		    	width : 160,
		    	fieldLabel : '店铺名称',
		    	labelWidth : 50
		    },
		    {
		    	id : 'appointId',
		    	xtype : 'textfield',
		    	width : 160,
		    	fieldLabel : '预约编号',
		    	labelWidth : 50
		    },
		    {	      
		    	id : 'orderType',     
		    	xtype : 'combo', 
            	store : App.store.order.orderTypeStore,
            	emptyText : '请选择',
            	mode : 'local',	            	
            	valueField : 'key',
            	displayField : 'value',
            	editable : false,                   	
                triggerAction: 'all',
                width : 160,
		    	fieldLabel : '订单类型',
		    	labelWidth : 50
	        },
		    {	      
		    	id : 'orderPaymentStatus',    
		    	xtype : 'combo',   
            	store : App.store.order.orderPaymentStatusStore,
            	emptyText : '请选择',
            	mode : 'local',	            	
            	valueField : 'key',
            	displayField : 'value',
            	editable : false,           	          	
                triggerAction: 'all',
                width : 160,
		    	fieldLabel : '订单支付状态',
		    	labelWidth : 50
	        },
		    {
				text : '查询',
				handler : function() {
					orderStore.proxy.extraParams.beginDate=Ext.getCmp('begin_date').value.format("yyyy-MM-dd");
					orderStore.proxy.extraParams.endDate=Ext.getCmp('end_date').value.format("yyyy-MM-dd");
					orderStore.proxy.extraParams.orderNum=Ext.getCmp('orderNum').value;
					orderStore.proxy.extraParams.orderBuyer=Ext.getCmp('orderBuyer').value;				
					orderStore.proxy.extraParams.beginAmount=Ext.getCmp('beginAmount').value;
					orderStore.proxy.extraParams.endAmount=Ext.getCmp('endAmount').value;
					orderStore.proxy.extraParams.shopName=Ext.getCmp('shopName').value;
					orderStore.proxy.extraParams.appointId=Ext.getCmp('appointId').value;
					orderStore.proxy.extraParams.orderType=Ext.getCmp('orderType').value;
					orderStore.proxy.extraParams.orderPaymentStatus=Ext.getCmp('orderPaymentStatus').value;
					orderStore.load();
				}
		    } 
	    ]
	}); 
	
	
    
    var grid = Ext.create('Ext.grid.GridPanel', {	          
    	id : 'grid',   
        store: orderStore,
        defaultType : 'textfield',
        tbar : [      
        	bbar
    		],
        columns: [
		{
		    text: '订单号',
		    width: 100,
		    sortable: false,
		    dataIndex: 'orderNo'
		}, {
            text: '订单类型',
            width: 100,
            sortable: true,
            dataIndex: 'orderType'
        }, {
            text: '订单总额',
            width: 100,
            sortable: false,
            dataIndex: 'orderTotal'
        }, {
            text: '订单拥有者',
            width: 100,
            sortable: false,
            dataIndex: 'orderBuyer'
        }, {
            text: '订单状态',
            width: 100,
            sortable: false,
            dataIndex: 'orderStatus'
        }, {
            text: '支付状态',
            width: 100,
            sortable: false,
            dataIndex: 'paymentStatus'
        }, {
            text: '预约编号',
            width: 100,
            sortable: false,
            dataIndex: 'appointId'
        }, {
            text: '是否在线订单',
            width: 100,
            sortable: false,
            dataIndex: 'orderIsOnline'
        }, {
            text: '店铺名称',
            width: 100,
            sortable: false,
            dataIndex: 'shopName'
        }, {
            text: '卖家编号',
            width: 100,
            sortable: false,
            dataIndex: 'sellerName'
        }, {
            text: '买家手机号',
            width: 100,
            sortable: false,
            dataIndex: 'buyerMobileNo'
        }, {
            text: '创建日期',
            width: 100,
            sortable: false,
            dataIndex: 'createTime',
            renderer : function(value) {
            	if(value != null){
            		return Ext.util.Format.date(new Date(value), 'Y-m-d');
            	}
            }
        }
        ],
    	bbar : Ext.create('Ext.PagingToolbar', {
			store : orderStore,
			displayInfo : true,
			displayMsg : '显示条数 {0} - {1} of {2}',
			emptyMsg : "无数据"
		})
    });
    
    Ext.create('Ext.container.Viewport', {
		layout : 'fit',
		renderTo: 'order-grid',
		items : [grid]		 
	});
});

</script>
</head>
<body>
<div id="order-grid"></div>
</body>
</html>