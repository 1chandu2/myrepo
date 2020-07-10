package com.bizhives.configservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bizhives.configservice.Service.IndustryService;
import com.bizhives.configservice.Service.SubIndustryService;
import com.bizhives.configservice.VO.IndustryVO;
import com.bizhives.configservice.VO.SubIndustryDTO;
import com.bizhives.configservice.VO.SubIndustryVO;

@RestController
@RequestMapping("/v1")
public class SubIndustryController {

	@Autowired
	private SubIndustryService subIndustryService;
	
	@PostMapping(value = "/Industry/subindustries")
	public ResponseEntity<?> insert(@RequestBody SubIndustryDTO subIndustryDTO) {
		
		IndustryVO industryVO = new IndustryVO();
		industryVO.setId(subIndustryDTO.getIndustryId());
		
		SubIndustryVO subIndustryVO = new SubIndustryVO();
		subIndustryVO.setSubIndustryDesc(subIndustryDTO.getSubIndustryDesc());
		subIndustryVO.setSubIndustryName(subIndustryDTO.getSubIndustryName());
		subIndustryVO.setIndustryVO(industryVO);
		this.subIndustryService.insertSubIndustry(subIndustryVO);
		return (ResponseEntity<?>) ResponseEntity.ok("SubIndustry Insert Successs!");
	}
	
	@GetMapping(value = "/Industry/subindustries/{id}")
	public List<SubIndustryVO> search(@PathVariable int id) {
		List<SubIndustryVO> subIndustryList = this.subIndustryService.findSubIndustryById(id);
		return subIndustryList;
	}
}