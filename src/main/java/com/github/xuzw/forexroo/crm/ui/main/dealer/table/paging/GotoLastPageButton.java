package com.github.xuzw.forexroo.crm.ui.main.dealer.table.paging;

import com.github.xuzw.html_builder.HtmlBuilder;
import com.github.xuzw.ui_engine_runtime.annotation.StyleAnnotation;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月31日 下午2:24:24
 */
@StyleAnnotation()
public class GotoLastPageButton extends ControlButton {
    @Override
    protected void build(HtmlBuilder div) {
        div.button().value("末页");
    }
}
