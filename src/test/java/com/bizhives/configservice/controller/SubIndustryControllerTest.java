package com.bizhives.configservice.controller;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.bizhives.configservice.Service.IndustryService;
import com.bizhives.configservice.Service.SubIndustryService;
import com.bizhives.configservice.VO.IndustryVO;
import com.bizhives.configservice.VO.SubIndustryVO;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(SubIndustryController.class)
public class SubIndustryControllerTest {
	@Autowired private MockMvc mvc;
	@MockBean
	private SubIndustryService subIndustryService;
	
	@Test
	public void testSubController() throws Exception {
		
		SubIndustryVO subIndustryVO = new SubIndustryVO();
		
		subIndustryVO.setId(67);
		subIndustryVO.setSubIndustryDesc("nothing");
		subIndustryVO.setSubIndustryName("testsub");
		
		IndustryVO industryVO = new IndustryVO();
		industryVO.setId(3);
		
		List<SubIndustryVO> subindustries = Arrays.asList(subIndustryVO);
		
		when(subIndustryService.searchSubIndustry()).thenReturn(subindustries);

		mvc.perform(get("/v1/Industry/subindustries/3").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

		mvc.perform(MockMvcRequestBuilders.post("/v1/Industry/subindustries")
	            .content(asJsonString(subIndustryVO))
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isCreated());
		
		
		
		
	}
	
public static String asJsonString(final Object obj) {
    try {
        return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
        throw new RuntimeException(e);
    }

}
}