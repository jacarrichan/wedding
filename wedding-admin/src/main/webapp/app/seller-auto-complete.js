Ext.namespace('App.autocomplete.seller');

App.autocomplete.seller.sellerNameStoreTpl = new Ext.XTemplate(
	'<tpl for="."><div class="seller-search-item">',
		'<h4><br/>{result}</h4>',
	'</div></tpl>'
);

App.autocomplete.seller.sellerNameStore = Ext.create('Ext.data.Store', {
        fields : ['result'],
       	pageSize : 20,
        proxy : {
            type : 'ajax',
            url : '../../seller/seller-manage/findLikeName.do',
            reader : {
                type : 'json',
                root : 'results',
                successProperty : 'success',
                totalProperty : 'total'
            },
            timeout : 180000
        }
    });
    
App.autocomplete.seller.shopNameStore = Ext.create('Ext.data.Store', {
        fields : ['result'],
       	pageSize : 20,
        proxy : {
            type : 'ajax',
            url : '../../shop/shop-search/findLikeShopName.do',
            reader : {
                type : 'json',
                root : 'results',
                successProperty : 'success',
                totalProperty : 'total'
            },
            timeout : 180000
        }
    });