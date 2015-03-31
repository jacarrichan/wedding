package com.wedding.user.service;

import com.wedding.user.dto.UserFavoriteDto;

/**
 * Created by Peter on 14-10-4.
 */
public interface UserFavoriteService {

    /**
     * 收藏店铺
     * @param userFavoriteDto
     */
    void save(UserFavoriteDto userFavoriteDto);

    /**
     * 移除店铺
     * @param id
     */
    void delete(String id);

}
