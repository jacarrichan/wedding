package com.wedding.tools.service.impl;

import com.wedding.tool.constants.ToolsNoteTypeEnum;
import com.wedding.tool.dto.ToolsNoteDto;
import com.wedding.tool.dto.ToolsWeddingGovDto;
import com.wedding.tool.service.IToolsNoteService;
import com.wedding.tools.dao.ToolsNoteDao;
import com.wedding.tools.pojo.ToolsNote;
import com.wedding.tools.pojo.ToolsWeddingGov;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tank on 14-9-30.
 */
@Service
public class ToolsNoteServiceImpl implements IToolsNoteService {

    @Autowired
    private ToolsNoteDao toolsNoteDao;

    @Override
    public List<ToolsNoteDto> getAllWeddingImprove() {
        List<ToolsNote> listToolsNote= toolsNoteDao.findToolsNoteByType(ToolsNoteTypeEnum.WEDDING_IMPROVE.getIndex());
        List<ToolsNoteDto> listToolsNoteDto=new ArrayList<ToolsNoteDto>();
        for(ToolsNote toolsNote:listToolsNote){
            listToolsNoteDto.add(changToDto(toolsNote));
        }
        return listToolsNoteDto;
    }

    @Override
    public List<ToolsNoteDto> getAllWeddingFlow() {
        List<ToolsNote> listToolsNote= toolsNoteDao.findToolsNoteByType(ToolsNoteTypeEnum.WEDDING_FLOW.getIndex());
        List<ToolsNoteDto> listToolsNoteDto=new ArrayList<ToolsNoteDto>();
        for(ToolsNote toolsNote:listToolsNote){
            listToolsNoteDto.add(changToDto(toolsNote));
        }
        return listToolsNoteDto;
    }

    private ToolsNoteDto changToDto(ToolsNote toolsNote) {
        if(toolsNote == null){
            return null;
        }
        ToolsNoteDto toolsNoteDto = new ToolsNoteDto();
        BeanUtils.copyProperties(toolsNote, toolsNoteDto);
        return toolsNoteDto;
    }
}
