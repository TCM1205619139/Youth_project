package com.itcast.service.impl;

import java.util.List;

import com.itcast.mapper.InvigilateMapper;
import com.itcast.pojo.Invigilate;
import com.itcast.service.InvigilateService;

public class InvigilateServiceImpl implements InvigilateService{
	private InvigilateMapper invigilateMapper;

	public InvigilateMapper getInvigilateMapper() {
		return invigilateMapper;
	}
	public void setInvigilateMapper(InvigilateMapper invigilateMapper) {
		this.invigilateMapper = invigilateMapper;
	}
	
	
	public List<Invigilate> selinvigilateByid(int id) {
		return invigilateMapper.selinvigilateByid(id);
	}
	public List<Invigilate> selByinvigilateid(int invigilateid) {
		return invigilateMapper.selByinvigilateid(invigilateid);
	}
	public int insInvigilate(Invigilate invigilate) {
        return invigilateMapper.insMeeting(invigilate);
    }
	public List<Invigilate> show() {
		return invigilateMapper.selAll();
	}

}
