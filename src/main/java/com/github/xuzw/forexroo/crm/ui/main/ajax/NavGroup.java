package com.github.xuzw.forexroo.crm.ui.main.ajax;

import com.github.xuzw.ui_engine_runtime.div.container.YList;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月18日 下午5:31:19
 */
public class NavGroup extends YList {

    public NavGroup(Nav nav) {
        nav.add(new SubNavSwitch());
        add(nav);
    }

    public NavGroup add(SubNav subNav) {
        return (NavGroup) super.add(subNav);
    }
}
