package com.Aqualife.Aqualife.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.Aqualife.Aqualife.model.param;
import com.Aqualife.Aqualife.service.ParamService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {ParamController.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class ParamControllerTest {
    @Autowired
    private ParamController paramController;

    @MockBean
    private ParamService paramService;

    /**
     * Method under test: {@link ParamController#getParamById(String)}
     */
    @Test
    void testGetParamById() throws Exception {
        // Arrange
        param param = new param();
        param.setBehaviour("Behaviour");
        param.setDiet("Diet");
        param.setId(1);
        param.setName("Name");
        param.setPh_level("6");
        param.setTank_size("2");
        param.setWater_temp("30");
        when(paramService.getParamById(Mockito.<String>any())).thenReturn(param);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/survival/{name}", "Name");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(paramController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"name\":\"Name\",\"water_temp\":\"30\",\"ph_level\":\"6\",\"tank_size\":\"2\",\"behaviour"
                                        + "\":\"Behaviour\",\"diet\":\"Diet\"}"));
    }

    /**
     * Method under test: {@link ParamController#getAllParams()}
     */
    @Test
    void testGetAllParams() throws Exception {
        // Arrange
        when(paramService.getAllParams()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/survival/getAll");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(paramController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link ParamController#updateParam(param, String)}
     */
    @Test
    void testUpdateParam() throws Exception {
        // Arrange
        param param = new param();
        param.setBehaviour("Behaviour");
        param.setDiet("Diet");
        param.setId(1);
        param.setName("Name");
        param.setPh_level("6.0-7.5");
        param.setTank_size("3.5");
        param.setWater_temp("25-28");
        when(paramService.updateParam(Mockito.<param>any(), Mockito.<String>any())).thenReturn(param);

        param param2 = new param();
        param2.setBehaviour("Behaviour");
        param2.setDiet("Diet");
        param2.setId(1);
        param2.setName("Name");
        param2.setPh_level("6.0-7.5");
        param2.setTank_size("3.5");
        param2.setWater_temp("25-28");
        String content = (new ObjectMapper()).writeValueAsString(param2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/survival/update/{name}", "Name")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(paramController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"name\":\"Name\",\"water_temp\":\"25-28\",\"ph_level\":\"6.0-7.5\",\"tank_size\":\"3.5\",\"behaviour"
                                        + "\":\"Behaviour\",\"diet\":\"Diet\"}"));
    }

    /**
     * Method under test: {@link ParamController#add(param)}
     */
    @Test
    void testAdd() throws Exception {
        // Arrange
        param param = new param();
        param.setBehaviour("Behaviour");
        param.setDiet("Diet");
        param.setId(1);
        param.setName("Name");
        param.setPh_level("6.0");
        param.setTank_size("3.0");
        param.setWater_temp("27");
        when(paramService.SaveParam(Mockito.<param>any())).thenReturn(param);

        param param2 = new param();
        param2.setBehaviour("Behaviour");
        param2.setDiet("Diet");
        param2.setId(1);
        param2.setName("Name");
        param2.setPh_level("6.0");
        param2.setTank_size("3.0");
        param2.setWater_temp("27");
        String content = (new ObjectMapper()).writeValueAsString(param2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/survival/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(paramController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("New Species added"));
    }

    /**
     * Method under test: {@link ParamController#deleteParam(String)}
     */
    @Test
    void testDeleteParam() throws Exception {
        // Arrange
        doNothing().when(paramService).deleteParam(Mockito.<String>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/survival/delete/{name}", "Name");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(paramController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link ParamController#deleteParam(String)}
     */

}
