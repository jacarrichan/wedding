package com.wedding.items.mapper;

import java.util.List;

import com.wedding.items.pojo.search.ItemsSearch;

public interface ItemsExMapper {

	List<ItemsSearch> findById(String itemId);
}
