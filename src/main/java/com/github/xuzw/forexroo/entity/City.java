package com.github.xuzw.forexroo.entity;

import java.util.List;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月5日 下午12:16:11
 */
public class City {
    private String name;
    private List<String> descriptions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<String> descriptions) {
        this.descriptions = descriptions;
    }
}
