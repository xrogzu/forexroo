package com.github.xuzw.forexroo.crm.view;

import com.github.xuzw.forexroo.entity.City;
import com.github.xuzw.html_builder.HtmlBuilder;
import com.github.xuzw.html_layout.element.Div;
import com.github.xuzw.html_layout.style.Style;
import com.github.xuzw.html_layout.style.builder.StyleBuilder;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月5日 下午12:16:42
 */
public class CityView extends Div {
    private City city;
    public static final Style style = new StyleBuilder(CityView.class).selector() //
            .set("float", "left") //
            .set("margin", "5px") //
            .set("width", "300px") //
            .set("height", "300px") //
            .set("outline-style", "solid") //
            .set("outline-width", "1px") //
            .back().build();

    public CityView(City city) {
        this.city = city;
    }

    @Override
    protected void buildHtml(HtmlBuilder div) {
        div.child("h2").text(city.getName());
        for (String desc : city.getDescriptions()) {
            div.child("p").text(desc);
        }
    }

    public static Style getStyle() {
        return style;
    }

    public static String getScript() {
        return null;
    }
}
