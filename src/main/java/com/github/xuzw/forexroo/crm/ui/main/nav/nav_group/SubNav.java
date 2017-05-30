package com.github.xuzw.forexroo.crm.ui.main.nav.nav_group;

import com.github.xuzw.forexroo.crm.engine.script.AjaxLoad;
import com.github.xuzw.forexroo.crm.ui.main.Workspace;
import com.github.xuzw.html_builder.HtmlBuilder;
import com.github.xuzw.ui_engine_runtime.annotation.StyleAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleBlockAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleDeclarationAnnotation;
import com.github.xuzw.ui_engine_runtime.div.container.XList;
import com.github.xuzw.ui_engine_runtime.div.location.Id;

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
    private String segmentPage;

    public SubNav(String title, String segmentPage) {
        add(new SubNavTitle(title));
        this.segmentPage = segmentPage;
    }

    @Override
    protected void beforeBuild(HtmlBuilder div) {
        div.onClick(new AjaxLoad("#" + Id.of(Workspace.class), segmentPage).toString());
    }
}
