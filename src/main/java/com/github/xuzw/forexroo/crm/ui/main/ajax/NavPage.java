package com.github.xuzw.forexroo.crm.ui.main.ajax;

import com.github.xuzw.ui_engine_runtime.page.AjaxPage;
import com.github.xuzw.ui_engine_runtime.page.PageName;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月18日 下午4:47:45
 */
public class NavPage extends AjaxPage {

    public NavPage() {
        super(PageName.of(NavPage.class));
        div(new NavContainer());
    }
}
