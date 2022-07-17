package com.txt.eshopperboot.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("commonService")
@Transactional
public class CommonService {

	public Map<String, String> getListContry() {
		Map<String, String> mapCountry = new HashMap<>();
		mapCountry.put("VietNam", "VietNam");
		mapCountry.put("Japan", "Japan");
		mapCountry.put("USA", "USA");
		return mapCountry;
	}

	public Map<String, String> getListCity() {
		Map<String, String> mapCity = new HashMap<>();
		mapCity.put("HoChiMinh", "HoChiMinh");
		mapCity.put("DaNang", "DaNang");
		mapCity.put("HaNoi", "HaNoi");
		mapCity.put("OanSinhTon", "OanSinhTon");
		mapCity.put("NewYork", "NewYork");
		mapCity.put("Califonia", "Califonia");
		mapCity.put("Tokio", "Tokio");
		mapCity.put("Kobe", "Kobe");
		mapCity.put("Hirosima", "Hirosima");
		
		return mapCity;
	}
}
