package com.itcast.service;

import java.util.List;

import com.itcast.pojo.Invigilate;

public interface InvigilateService {
	List<Invigilate> selinvigilateByid(int id);
	List<Invigilate> selByinvigilateid(int invigilateid);
	int insInvigilate(Invigilate invigilate);
	List<Invigilate> show();
}
