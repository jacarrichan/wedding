package com.wedding.domain.service;

import com.wedding.common.model.Result;
import com.wedding.common.util.BeanUtils;
import com.wedding.domain.dao.DomainDao;
import com.wedding.domain.dto.DomainDto;
import com.wedding.domain.pojo.Domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Peter on 14-10-15.
 */
@Service
public class DomainServiceImpl implements DomainService {

    @Autowired
    private DomainDao domainDao;

    @Override
    public void saveDomain(DomainDto domainDto) {
        Domain domain = BeanUtils.createBeanByTarget(domainDto,Domain.class);
        this.domainDao.insert(domain);
    }

    @Override
    public DomainDto getDomain(String domain) {
        Domain d =  this.domainDao.getDomain(domain);
        return BeanUtils.createBeanByTarget(d,DomainDto.class);
    }
    
    public Result<DomainDto> findDomainById(String domainId) {
    	Domain domain = domainDao.selectByPrimaryKey(domainId);
    	if(domain == null){
    		return new Result<DomainDto>(null);
    	}
    	DomainDto dto = BeanUtils.createBeanByTarget(domain, DomainDto.class);
    	return new Result<DomainDto>(dto);
    }

	@Override
	public void updateDomin(DomainDto domainDto) {
		Domain domain = BeanUtils.createBeanByTarget(domainDto, Domain.class);
		domainDao.updateByPrimaryKey(domain);
		
	}
}
