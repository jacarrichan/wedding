package com.wedding.order.service.impl;

import com.wedding.common.model.PageQuery;
import com.wedding.common.model.PageResult;
import com.wedding.common.util.BeanUtils;
import com.wedding.order.dao.WithDrawDao;
import com.wedding.order.dto.OrdersDto;
import com.wedding.order.dto.WithDrawDto;
import com.wedding.order.pojo.Orders;
import com.wedding.order.pojo.WithDraw;
import com.wedding.order.service.WithDrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chuweifeng on 14-9-29.
 */
@Service
public class WithDrawServiceImpl implements WithDrawService{

    @Autowired
    private WithDrawDao withDrawDao;

    @Override
    public boolean saveWithDraw(WithDrawDto withDrawDto) {
        // 保存单头
        WithDraw withDraw = new WithDraw();
        BeanUtils.copyProperties(withDrawDto, withDraw);
        return (this.withDrawDao.insert(withDraw)>0) ? true:false ;
    }

    @Override
    public PageResult<WithDrawDto> query(WithDrawDto withDrawDto, PageQuery pageQuery) {
        List<WithDraw> resultList = this.withDrawDao.query(withDrawDto,pageQuery);
        List<WithDrawDto> withDrawDtoList = new ArrayList<WithDrawDto>();
        for(WithDraw withDraw : resultList){
            WithDrawDto objDto = new WithDrawDto();
            BeanUtils.copyProperties(withDraw,objDto);
            withDrawDtoList.add(objDto);
        }
        return new PageResult<WithDrawDto>(pageQuery,withDrawDtoList);
    }
}
