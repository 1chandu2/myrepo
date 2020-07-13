package com.bizhives.configservice.controller;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bizhives.configservice.Service.IndustryService;
import com.bizhives.configservice.VO.IndustryVO;

@RestController
@RequestMapping("/v1")
public class IndustryController {
	@Autowired
	private IndustryService industryService;
	
	@PostMapping(value = "/Industry")
	public ResponseEntity<?> insert(@RequestBody IndustryVO industryVO) {
		this.industryService.insert(industryVO);
		 return new ResponseEntity<>(industryVO.getId(), HttpStatus.CREATED);
	}
	@GetMapping(value = "/Industry")
	public List<IndustryVO> search() {
		List<IndustryVO> industryList = this.industryService.search();
		return industryList;
	}

}
