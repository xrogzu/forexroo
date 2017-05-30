package com.github.xuzw.forexroo.crm.ui.main.nav.nav_group;

import com.github.xuzw.html_builder.HtmlBuilder;
import com.github.xuzw.ui_engine_runtime.annotation.StyleAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleBlockAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleDeclarationAnnotation;
import com.github.xuzw.ui_engine_runtime.div.container.YList;
import com.github.xuzw.ui_engine_runtime.div.wrapper.Label;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月18日 下午5:31:19
 */
@StyleAnnotation({ //
        @StyleBlockAnnotation({ //
        }), @StyleBlockAnnotation(selector = "input", value = { //
                @StyleDeclarationAnnotation(property = "display", value = "none"), //
        }), @StyleBlockAnnotation(selector = "input:checked ~ ul .com-github-xuzw-forexroo-crm-ui-main-nav-nav_group-SubNavSwitch", value = { //
                @StyleDeclarationAnnotation(property = "background-image", value = "url(/forexroo/icon/down-arrow.svg)"), //
        }), @StyleBlockAnnotation(selector = "input:checked ~ ul .com-github-xuzw-forexroo-crm-ui-main-nav-nav_group-SubNav", value = { //
                @StyleDeclarationAnnotation(property = "display", value = "block"), //
        }), })
public class NavGroup extends YList {
    private String radioId = "nav-radio-" + getId();

    public NavGroup(NavFolder navFolder) {
        add(new Label(radioId, navFolder));
    }

    public NavGroup add(SubNav subNav) {
        return (NavGroup) super.add(subNav);
    }

    @Override
    protected void beforeBuild(HtmlBuilder div) {
        div.input().attr("type", "radio").id(radioId).attr("name", "nav").cssClass("toggle");
    }
}
