package com.github.xuzw.forexroo.crm.ui.main.dealer.table.paging;

import com.github.xuzw.ui_engine_runtime.annotation.StyleAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleBlockAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleDeclarationAnnotation;
import com.github.xuzw.ui_engine_runtime.div.container.XList;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月30日 下午5:00:06
 */
@StyleAnnotation({ //
        @StyleBlockAnnotation({ //
                @StyleDeclarationAnnotation(property = "margin-top", value = "16px"), //
                @StyleDeclarationAnnotation(property = "margin-left", value = "16px"), //
                @StyleDeclarationAnnotation(property = "margin-right", value = "16px"), //
        }), })
public class PagingContainer extends XList {
    public PagingContainer() {
        add(new PagingTip());
        add(new GotoFirstPageButton());
        add(new PagingButtonGroup().add(0).add(1).add(2).add(3).add(4));
        add(new GotoLastPageButton());
    }
}
