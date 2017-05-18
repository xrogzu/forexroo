package com.github.xuzw.forexroo.crm.ui.main.ajax;

import com.github.xuzw.ui_engine_runtime.annotation.StyleAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleBlockAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleDeclarationAnnotation;
import com.github.xuzw.ui_engine_runtime.div.container.YList;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月18日 下午6:55:28
 */
@StyleAnnotation({ //
        @StyleBlockAnnotation({ //
                @StyleDeclarationAnnotation(property = "width", value = "200px"), //
                @StyleDeclarationAnnotation(property = "background-color", value = "#252834"), //
        }), })
public class NavContainer extends YList {
    public NavContainer() {
        add(new Nav("/icon/home.svg", "首页"));
        add(new NavGroup(new Nav("/icon/user.svg", "用户管理")).add(new SubNav("综合类会员")).add(new SubNav("经纪商会员")).add(new SubNav("经纪人会员")).add(new SubNav("交易商会员")));
    }
}
