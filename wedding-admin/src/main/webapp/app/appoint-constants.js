Ext.namespace('App.store.appoint');

App.store.appoint.appointStatusStore = Ext.create('Ext.data.Store', {
        fields : ['key', 'value'],
       	pageSize : 20,
        proxy : {
            type : 'ajax',
            url : '../../appoint/constants/appointStatus.do',
            reader : {
                type : 'json',
                root : 'results',
                successProperty : 'success',
                totalProperty : 'total'
            },
            timeout : 180000
        }
    });