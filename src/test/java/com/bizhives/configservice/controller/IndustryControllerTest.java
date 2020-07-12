package com.bizhives.configservice.controller;

import java.util.List;

import static org.assertj.core.api.Assertions.setRemoveAssertJRelatedElementsFromStackTrace;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.bizhives.configservice.Service.IndustryService;
import com.bizhives.configservice.VO.IndustryVO;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(IndustryController.class)
public class IndustryControllerTest {
	
	@Autowired private MockMvc mvc;
	@MockBean
	private IndustryService industryService;

	@org.junit.jupiter.api.Test
	public void testController() throws Exception {
		IndustryVO industryVO = new IndustryVO();
		industryVO.setIndustryDesc("junit TEst industry");
		industryVO.setIndustryName("junit test indus name");
		industryVO.setId(99);
		
		
		List<IndustryVO> industries = Arrays.asList(industryVO);
		
		when(industryService.search()).thenReturn(industries);

	mvc.perform(get("/v1/Industries").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1)));
	
	mvc.perform(MockMvcRequestBuilders.post("/v1/Industries")
            .content(asJsonString(industryVO))
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
