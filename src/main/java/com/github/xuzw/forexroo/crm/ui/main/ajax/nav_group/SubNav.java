package com.github.xuzw.forexroo.crm.ui.main.ajax.nav_group;

import com.github.xuzw.ui_engine_runtime.annotation.StyleAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleBlockAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleDeclarationAnnotation;
import com.github.xuzw.ui_engine_runtime.div.container.XList;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月18日 下午6:44:55
 */
@StyleAnnotation({ //
        @StyleBlockAnnotation({ //
                @StyleDeclarationAnnotation(property = "height", value = "40px"), //
                @StyleDeclarationAnnotation(property = "display", value = "none"), //
        }), @StyleBlockAnnotation(selector = ":hover", value = { //
                @StyleDeclarationAnnotation(property = "background-color", value = "#313a46"), //
        }), })
public class SubNav extends XList {
    public SubNav(String title) {
        add(new SubNavTitle(title));
    }
}
