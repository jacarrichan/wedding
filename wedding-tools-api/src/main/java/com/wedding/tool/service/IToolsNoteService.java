package com.wedding.tool.service;


import com.wedding.tool.dto.ToolsNoteDto;

import java.util.List;

/**
 * Created by Tank on 14-9-30.
 */
public interface IToolsNoteService {

    /**
     * 查询所有结婚美容形成
     * @return      结婚记事录
     */
    public List<ToolsNoteDto> getAllWeddingImprove();

    /**
     * 查询所有结婚流程
     * @return      结婚记事录
     */
    public List<ToolsNoteDto> getAllWeddingFlow();
}
