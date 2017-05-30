package com.github.xuzw.forexroo.crm.ui.main;

import com.github.xuzw.html_builder.HtmlBuilder;
import com.github.xuzw.ui_engine_runtime.annotation.StyleAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleBlockAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleDeclarationAnnotation;
import com.github.xuzw.ui_engine_runtime.div.Div;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月30日 下午12:32:45
 */
@StyleAnnotation({ //
        @StyleBlockAnnotation({ //
                @StyleDeclarationAnnotation(property = "min-height", value = "844px"), //
                @StyleDeclarationAnnotation(property = "background-color", value = "rgb(244,246,246)"), //
        }), })
public class Workspace extends Div {

    @Override
    protected void build(HtmlBuilder div) {
    }
}
