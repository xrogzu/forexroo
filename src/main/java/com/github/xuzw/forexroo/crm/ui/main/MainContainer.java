package com.github.xuzw.forexroo.crm.ui.main;

import com.github.xuzw.forexroo.crm.ui.main.nav.NavContainer;
import com.github.xuzw.html_builder.HtmlBuilder;
import com.github.xuzw.ui_engine_runtime.div.Div;
import com.github.xuzw.ui_engine_runtime.div.container.XList;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月30日 上午11:19:17
 */
public class MainContainer extends XList {
    public MainContainer() {
        add(new NavContainer());
        add(new ContentContainer());
    }

    @Override
    protected void onBuildElement(HtmlBuilder li, Div element, int index) {
        if (element instanceof ContentContainer) {
            li.attr("style", "width:calc(100% - 200px)");
        }
    }
}
