Ext.namespace('App.autocomplete.items');

App.autocomplete.items.itemsNameStore = Ext.create('Ext.data.Store', {
        fields : ['result'],
       	pageSize : 20,
        proxy : {
            type : 'ajax',
            url : '../../items/items-search/findLikeItemName.do',
            reader : {
                type : 'json',
                root : 'results',
                successProperty : 'success',
                totalProperty : 'total'
            },
            timeout : 180000
        }
    });