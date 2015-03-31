package com.wedding.domain.service;

import com.wedding.common.model.Result;
import com.wedding.domain.dto.DomainDto;

/**
 * Created by Peter on 14-10-15.
 */
public interface DomainService {
    /**
     * 保存域名
     * @param domainDto
     */
    void saveDomain(DomainDto domainDto);

    DomainDto getDomain(String domain);
    
    Result<DomainDto> findDomainById(String domainId);

	void updateDomin(DomainDto domainDto);

}
