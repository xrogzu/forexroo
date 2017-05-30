package com.github.xuzw.forexroo.crm.ui.main.header;

import com.github.xuzw.html_builder.HtmlBuilder;
import com.github.xuzw.ui_engine_runtime.annotation.StyleAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleBlockAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleDeclarationAnnotation;
import com.github.xuzw.ui_engine_runtime.div.Div;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月30日 上午11:16:44
 */
@StyleAnnotation({ //
        @StyleBlockAnnotation({ //
                @StyleDeclarationAnnotation(property = "height", value = "56px"), //
                @StyleDeclarationAnnotation(property = "background-color", value = "#313a46"), //
        }), })
public class Header extends Div {
    @Override
    protected void build(HtmlBuilder div) {
    }
}
