package com.github.xuzw.forexroo.crm.ui.main;

import com.github.xuzw.ui_engine_runtime.page.Page;
import com.github.xuzw.ui_engine_runtime.page.PageName;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月18日 下午4:43:25
 */
public class MainPage extends Page {
    public MainPage() {
        super(PageName.of(MainPage.class));
        body(new MainContainer());
    }
}
