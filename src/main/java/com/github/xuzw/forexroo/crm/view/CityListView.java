package com.github.xuzw.forexroo.crm.view;

import com.github.xuzw.forexroo.entity.City;
import com.github.xuzw.html_layout.structure.XList;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月5日 下午12:59:30
 */
public class CityListView extends XList {

    public void add(City city) {
        add(new CityView(city));
    }
}
