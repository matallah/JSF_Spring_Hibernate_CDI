/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbs.forntend.converter;

import com.sbs.backend.main.entity.Dept;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.util.List;

/**
 * @author mohamed.attalah
 */
public class DepartmentConverter implements Converter {

    private List<Dept> objectList;

    public DepartmentConverter(List<Dept> converter) {
        this.objectList = converter;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        for (Dept codeGenerator : objectList) {
            try {
                Long.parseLong(value);
            } catch (Exception e) {
                return null;
            }
            if (!value.equals("") && !value.equals(" ") && codeGenerator.getDeptno().longValue() == Long.parseLong(value)) {
                return codeGenerator;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        try {
            if (value != null && !value.equals("") && !value.equals(" ")) {
                if (((Dept) value).getDeptno() != null && ((Dept) value).getDeptno().longValue() != 0) {
                    Dept object = (Dept) value;
                    return object.getDeptno().longValue() + "";
                } else {
                    return "";
                }
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

}
