package com.example.androidtest.data.mapper;

import com.example.androidtest.data.bo.FruitBo;
import com.example.androidtest.data.dbo.FruitDbo;
import com.example.androidtest.data.dbo.LocationDbo;
import com.example.androidtest.data.dto.FruitDto;

import java.util.ArrayList;
import java.util.List;

public class FruitMapper {

    public static FruitBo dtoToBo(FruitDto fruitDto) {

        FruitBo fruitBo = null;

        if (fruitDto != null) {

            fruitBo = new FruitBo();
            fruitBo.setId(fruitDto.getId());
            fruitBo.setCategory(fruitDto.getCategory());
            fruitBo.setFarmName(fruitDto.getFarmName());
            fruitBo.setItem(fruitDto.getItem());
            fruitBo.setPhone(fruitDto.getPhone());

        }

        return fruitBo;
    }

    public static List<FruitBo> dtoToBo(List<FruitDto> fruitDtoList) {

        List<FruitBo> fruitBoList = null;

        if (fruitDtoList != null) {

            fruitBoList = new ArrayList<>();

            for (FruitDto fruitDTO : fruitDtoList) {

                fruitBoList.add(FruitMapper.dtoToBo(fruitDTO));

            }

        }

        return fruitBoList;
    }

    public static FruitBo dboToBo(FruitDbo fruitDbo) {

        FruitBo fruitBo = null;

        if (fruitDbo != null) {

            fruitBo = new FruitBo();
            fruitBo.setId(fruitDbo.getId());
            fruitBo.setCategory(fruitDbo.getCategory());
            fruitBo.setFarmName(fruitDbo.getFarmName());
            fruitBo.setItem(fruitDbo.getItem());
            fruitBo.setPhone(fruitDbo.getPhone());

        }

        return fruitBo;
    }

    public static List<FruitBo> dboToBo(List<FruitDbo> fruitDboList) {

        List<FruitBo> fruitBoList = null;

        if (fruitDboList != null) {

            fruitBoList = new ArrayList<>();

            for (FruitDbo fruitDbo : fruitDboList) {

                fruitBoList.add(FruitMapper.dboToBo(fruitDbo));

            }

        }

        return fruitBoList;
    }


    public static FruitDbo boToDbo(FruitBo fruitBo) {

        FruitDbo fruitDbo = null;

        if (fruitBo != null) {

            fruitDbo = new FruitDbo(fruitBo.getId(), fruitBo.getItem(), fruitBo.getCategory(), fruitBo.getFarmName(), fruitBo.getPhone(), LocationDbo.getDefaultInstance(), fruitBo.getCountryId());

        }
        return fruitDbo;
    }


    public static List<FruitDbo> boToDbo(List<FruitBo> fruitBoList, int countryId) {

        List<FruitDbo> fruitDboList = null;

        if (fruitBoList != null) {

            fruitDboList = new ArrayList<>();

            for (FruitBo fruitBo : fruitBoList) {

                FruitDbo fruitDbo = FruitMapper.boToDbo(fruitBo);
                fruitDbo.setCountryId(countryId);
                fruitDboList.add(fruitDbo);

            }

        }

        return fruitDboList;
    }
}
