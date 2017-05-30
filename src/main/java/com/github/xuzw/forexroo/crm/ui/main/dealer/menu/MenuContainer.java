package com.github.xuzw.forexroo.crm.ui.main.dealer.menu;

import com.github.xuzw.html_builder.HtmlBuilder;
import com.github.xuzw.ui_engine_runtime.annotation.StyleAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleBlockAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleDeclarationAnnotation;
import com.github.xuzw.ui_engine_runtime.div.Div;
import com.github.xuzw.ui_engine_runtime.div.container.XList;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月30日 下午1:35:12
 */
@StyleAnnotation({ //
        @StyleBlockAnnotation({ //
                @StyleDeclarationAnnotation(property = "height", value = "56px"), //
                @StyleDeclarationAnnotation(property = "background-color", value = "#ffffff"), //
        }), })
public class MenuContainer extends XList {
    public MenuContainer() {
        add(new StatusSelect());
        add(new CategorySelect());
        add(new SearchButton());
        add(new ResetButton());
        add(new QuickSearch());
    }

    @Override
    protected void onBuildElement(HtmlBuilder li, Div element, int index) {
        if (element instanceof QuickSearch) {
            li.attr("style", "float:right");
        }
    }
}
