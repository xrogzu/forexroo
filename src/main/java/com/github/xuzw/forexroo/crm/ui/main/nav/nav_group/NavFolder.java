package com.github.xuzw.forexroo.crm.ui.main.nav.nav_group;

import com.github.xuzw.forexroo.crm.ui.main.nav.NavIcon;
import com.github.xuzw.forexroo.crm.ui.main.nav.NavTitle;
import com.github.xuzw.html_builder.HtmlBuilder;
import com.github.xuzw.ui_engine_runtime.annotation.StyleAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleBlockAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleDeclarationAnnotation;
import com.github.xuzw.ui_engine_runtime.div.Div;
import com.github.xuzw.ui_engine_runtime.div.container.XList;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月26日 下午12:15:41
 */
@StyleAnnotation({ //
        @StyleBlockAnnotation({ //
                @StyleDeclarationAnnotation(property = "height", value = "40px"), //
        }), @StyleBlockAnnotation(selector = ":hover", value = { //
                @StyleDeclarationAnnotation(property = "background-color", value = "#313a46"), //
        }), })
public class NavFolder extends XList {
    public NavFolder(String iconPath, String title) {
        add(new NavIcon(iconPath));
        add(new NavTitle(title));
        add(new SubNavSwitch());
    }

    @Override
    protected void onBuildElement(HtmlBuilder li, Div element, int index) {
        if (element instanceof SubNavSwitch) {
            li.attr("style", "float:right");
        }
    }
}
