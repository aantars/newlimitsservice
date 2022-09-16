package com.adolfo.microcloud.newlimitsservice.controller;

import com.adolfo.microcloud.newlimitsservice.configuration.LimitsConfiguration;
import com.adolfo.microcloud.newlimitsservice.entity.Limits;
import com.adolfo.microcloud.newlimitsservice.service.LimitsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.accessibility.AccessibleTable;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class LimitsControllerTest {

    @Autowired
    MockMvc mockMvc;

/*    @Autowired
    private LimitsConfiguration limitsConfiguration;*/

    @MockBean
    private LimitsService limitsService;

    @MockBean
    private LimitsConfiguration limitsConfiguration;

   // @Test
    public void retrieveLimitsTest() throws Exception {
        //Arrange
        List<Limits> limitsListDummy= new ArrayList<Limits>();
        limitsListDummy.add(new Limits(2,8));
        limitsListDummy.add(new Limits(1,9));
        when(limitsService.getAll()).thenReturn(limitsListDummy);

        //Act + assert
        mockMvc.perform(MockMvcRequestBuilders.get("/limits").contentType(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$",hasSize(2))).andDo(print());
    }

    @Test
    public void retrieveLimits_Configuration_Mocked_Test() throws Exception {
        //Arrange
        List<Limits> limitsListDummy= new ArrayList<Limits>();
        limitsListDummy.add(new Limits(2,8));
        //limitsListDummy.add(new Limits(1,9));
        when(limitsConfiguration.getMaximum()).thenReturn(2);
        when(limitsConfiguration.getMinimum()).thenReturn(8);

        //Act + assert
        mockMvc.perform(MockMvcRequestBuilders.get("/limits")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$",hasSize(1)))
                .andDo(print());
    }

   /* @Test
    public void retrieveHardCodedLimits_test(){
        Limits dummyLimits = new Limits(5,9);
        LimitsController limitsController = new LimitsController(new LimitsConfiguration());
        Limits retrievedLimits = limitsController.getAllLimits();

        assertEquals(5,retrievedLimits.getMinimum());
        assertEquals(9, retrievedLimits.getMaximum());
    }*/
}
