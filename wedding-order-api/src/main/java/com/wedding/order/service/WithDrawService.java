package com.wedding.order.service;

import com.wedding.common.model.PageQuery;
import com.wedding.common.model.PageResult;
import com.wedding.order.dto.OrdersDto;
import com.wedding.order.dto.WithDrawDto;
import org.springframework.stereotype.Service;

/**
 * Created by chuweifeng on 14-9-29.
 */
@Service
public interface WithDrawService {
    /**
     * 保存提现单
     * @param withDrawDto
     */
    public boolean saveWithDraw(WithDrawDto withDrawDto);

    PageResult<WithDrawDto> query(WithDrawDto withDrawDto, PageQuery pageQuery);
}
