package com.example.androidtest.data.mapper;

import com.example.androidtest.data.bo.FruitBO;
import com.example.androidtest.data.dto.FruitDTO;

import java.util.ArrayList;
import java.util.List;

public class FruitMapper {

    public static FruitBO dtoToBO(FruitDTO fruitDTO) {

        FruitBO fruitBO = null;

        if (fruitDTO != null) {

            fruitBO = new FruitBO();
            fruitBO.setCategory(fruitDTO.getCategory());
            fruitBO.setFarmName(fruitDTO.getFarmName());
            fruitBO.setItem(fruitDTO.getItem());
            fruitBO.setPhone(fruitDTO.getPhone());

        }

        return fruitBO;
    }

    public static List<FruitBO> dtoToBO(List<FruitDTO> fruitDTOList) {

        List<FruitBO> fruitBOList = null;

        if (fruitDTOList != null) {

            fruitBOList = new ArrayList<>();

            for (FruitDTO fruitDTO : fruitDTOList) {

                fruitBOList.add(FruitMapper.dtoToBO(fruitDTO));

            }

        }

        return fruitBOList;
    }
}
