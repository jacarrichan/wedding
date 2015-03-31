Ext.namespace('App.store.items');

App.store.items.itemsTypeStore = Ext.create('Ext.data.Store', {
        fields : ['key', 'value'],
       	pageSize : 20,
        proxy : {
            type : 'ajax',
            url : '../../items/constants/itemsType.do',
            reader : {
                type : 'json',
                root : 'results',
                successProperty : 'success',
                totalProperty : 'total'
            },
            timeout : 180000
        }
    });